package DataStructure;

import DataStructure.Dictionary.KeyValuePair;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class HashTable<TKey, TValue> {
    private KeyValuePair<TKey, TValue>[] entries;
    private int initialSize;
    private int entriesCount;

    public HashTable() {
        initialSize = 3;
        entries = new KeyValuePair[initialSize];
        entriesCount = 0;
    }

    public int getHash(TKey key) {
        final int OFFSET_BASIS = 0x811c9dc5; // 2166136261 in hex
        final int FNV_PRIME = 0x01000193; // 16777619 in hex
        byte[] data = key.toString().getBytes(StandardCharsets.US_ASCII);
        int hash = OFFSET_BASIS;
        for (int i = 0; i < data.length; i++) {
            hash = hash ^ data[i];
            hash = hash * FNV_PRIME;
        }
        return (hash & 0x7FFFFFFF) % this.entries.length;
    }

    public int collisionHandling(TKey key, Boolean Set, int Hash) {
        int newHash;
        for (int i = 0; i < entries.length; i++) {
            newHash = (Hash + i) % entries.length;
            System.out.println("[coll] " + key.toString() + " " + Hash + ", new hash: " + newHash);
            if (Set && (this.entries[newHash] == null || this.entries[newHash].key == key)) {
                return newHash;
            } else if (!Set && this.entries[newHash].key == key) {
                return newHash;
            }
        }

        throw new RuntimeException("HashTable is full! Cannot resolve collision.");
    }

    public void addToEntries(TKey key, TValue value) {
        int hash = this.getHash(key);
        if (this.entries[hash] != null && this.entries[hash].key != key) {
            hash = this.collisionHandling(key, true, hash);
        }
        if (hash == -1) {
            System.out.println("invalid HashTable");
        }
        if (this.entries[hash] == null) {
            KeyValuePair<TKey, TValue> newPair = new KeyValuePair<>(key, value);
            this.entries[hash] = newPair;
            this.entriesCount++;
        } else if (this.entries[hash].key == key) {
            this.entries[hash].value = value;
        } else {
            System.out.println("invalid HashTable");
        }
    }

    public void reSizeOrNot() {
        if (this.entriesCount < this.entries.length) {
            return; // No need to resize yet
        }

        int newSize = this.entries.length * 2;

        KeyValuePair<TKey, TValue>[] entriesCopy = Arrays.copyOf(this.entries, this.entries.length);

        this.entries = new KeyValuePair[newSize];
        int oldCount = this.entriesCount;
        this.entriesCount = 0;

        for (int i = 0; i < oldCount; i++) {
            if (entriesCopy[i] == null)
                continue;
            this.addToEntries(entriesCopy[i].key, entriesCopy[i].value);
        }
    }

    public int Size() {
        return this.entriesCount;
    }

    public void Set(TKey key, TValue value) {
        this.reSizeOrNot();
        this.addToEntries(key, value);
    }

    public TValue get(TKey key) {
        int hash = this.getHash(key);
        if (this.entries[hash] != null && !this.entries[hash].key.equals(key)) {
            hash = this.collisionHandling(key, false, hash);
        }
        if (hash == -1 || this.entries[hash] == null) {
            return null;
        }
        if (this.entries[hash].key.equals(key)) {
            return this.entries[hash].value;
        } else {
            return null;
        }
    }

    public void print() {
        System.out.println("============================");
        System.out.println("Length Of HashTable: " + this.entries.length);
        System.out.println("Size Of HashTable: " + this.Size());
        System.out.println("--------------------------------");
        if (this.entriesCount != 0) {
            for (int i = 0; i < this.Size(); i++) {
                if (this.entries[i] != null) {
                    System.out.println(" The Key of index [" + i + "] = " + this.entries[i].key);
                    System.out.println(" The Value of index [" + i + "] = " + this.entries[i].value);
                    System.out.println("_____________________");
                }
            }
        }
    }
}
