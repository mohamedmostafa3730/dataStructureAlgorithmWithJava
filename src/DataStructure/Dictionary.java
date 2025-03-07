package DataStructure;

import java.util.Arrays;

public class Dictionary<TKey, TValue> {

    private KeyValuePair[] entries;
    private int initialSize;
    private int entriesCount;

    public Dictionary() {
        this.initialSize = 3;
        this.entries = new KeyValuePair[this.initialSize];
    }

    private void reSizeOrNot() {
        if (this.entriesCount < this.entries.length - 1) {
            return;
        }
        int newSize = this.entries.length + initialSize;
        KeyValuePair[] newArray = new KeyValuePair[newSize];
        newArray = Arrays.copyOf(this.entries, newSize);
        this.entries = newArray;
    }

    private int Search(TKey key) {
        for (int i = 0; i < entriesCount; i++) {
            if (this.entries[i] != null && this.entries[i].key.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public int Size() {
        return this.entriesCount;
    }

    public void set(TKey key, TValue value) {
        reSizeOrNot();
        if (Search(key) != -1) {
            this.entries[Search(key)].value = value;
            return;
        } else {
            KeyValuePair<TKey, TValue> newPair = new KeyValuePair<>(key, value);
            this.entries[this.entriesCount++] = newPair;
        }
    }

    public TValue get(TKey key) {
        if (Search(key) != -1)
            return (TValue) this.entries[Search(key)].value;
        return null;
    }

    public boolean remove(TKey key) {
        if (Search(key) != -1) {
            this.entries[Search(key)] = this.entries[this.entriesCount - 1];
            this.entries[this.entriesCount - 1] = null;
            this.entriesCount--;
            return true;
        } else
            return false;
    }

    public void print() {
        System.out.println("============================");
        System.out.println("Length Of Dictionary: " + this.entries.length);
        System.out.println("Size Of Dictionary: " + this.Size());
        System.out.println("--------------------------------");
        if (this.entriesCount != 0) {
            for (int i = 0; i < this.Size(); i++) {
                System.out.println(" the Key of index [" + i + "] = " + this.entries[i].key);
                System.out.println(" the value of index [" + i + "] = " + this.entries[i].value);
                System.out.println("_____________________");
            }
        }

    }

    class KeyValuePair<TKey, Tvalue> {
        TKey key;
        Tvalue value;

        public KeyValuePair(TKey key, Tvalue value) {
            this.key = key;
            this.value = value;
        }

        public Tvalue getValue() {
            return value;
        }

        public void setValue(Tvalue value) {
            this.value = value;
        }

        public TKey getKey() {
            return key;
        }

    }

}
/*
 * Class Diagram =>
 * 2] KeyValuePair class:
 * (1) properties
 * 1. <+> Key: TKey [readOnly]
 * 2. <+> value: Tvalue
 * (2) Methods
 * 1. <+> KeyValuePair(Key:TKey, Value:TValue):void
 * 
 * 1] Dictionary class:
 * (1) properties
 * 1. <-> entries: KeyValuePair[]
 * 2. <-> initialSize: int
 * 3. <-> entriesCount: int
 * (2) Methods
 * 1. <+> Dictionary()
 * 2. <+> set(Key:TKey, Value:TValue):void
 * 3. <+> getOrUpdateValue(Key:TKey):TValue
 * 1. <-> Search(Key:TKey):boolean
 * 4. <+> remove(Key:TKey):boolean
 * 5. <+> size():int
 * 6. <+> print():void
 * 7. <-> reSizeOrNot():void
 */
