import java.nio.charset.StandardCharsets;

public class Hash {
    public int Hash32(String toHashBy32) {
        final int OFFSET_BASIS = 0x811c9dc5; // 2166136261 in hex
        final int FNV_PRIME = 0x01000193; // 16777619 in hex
        byte[] data = toHashBy32.getBytes(StandardCharsets.US_ASCII);
        int hash = OFFSET_BASIS;
        for (byte b : data) {
            hash = hash ^= OFFSET_BASIS;
            hash = hash * FNV_PRIME;
        }
        return hash;
    }
    public long hash64(String toHashBy32) {
        final long OFFSET_BASIS = 0xcbf29ce484222325L; // 14695981039346656037 in hex
        final long FNV_PRIME = 0x100000001b3L; // 1099511628211 in hex
        byte[] data = toHashBy32.getBytes(StandardCharsets.US_ASCII);
        long hash = OFFSET_BASIS;
        for (byte b : data) {
            hash = hash ^= OFFSET_BASIS;
            hash = hash * FNV_PRIME;
        }
        return hash;
    }
}

/*
 * Class Diagram =>
 * 1] Hash class:
 * (2) Methods
 * 1. <+> Hash32(toHashBy32:String):Integer.toUnsignedLong(int)
 * 1. <+> Hash64(toHashBy64:String):Integer.toUnsignedLong(long)
 */

// public:
// // Compute 32-bit FNV-1 hash
// uint32_t Hash32(std::string str) {
// // Constants used for FNV-1 hash algorithm
// uint32_t OffsetBasis = 2166136261;
// uint32_t FNVPrime = 16777619;

// // Convert string to byte array
// const char *data = str.c_str();
// size_t len = str.length();
// uint8_t *bytes = new uint8_t[len];
// memcpy(bytes, data, len);

// // Compute hash using FNV-1 algorithm
// uint32_t hash = OffsetBasis;
// for (size_t i = 0; i < len; i++) {
// hash = hash ^ bytes[i];
// hash = hash * FNVPrime;
// }

// // Print result to console
// std::cout << str << ", " << hash << ", " << std::hex << hash << std::endl;

// // Clean up allocated memory
// delete[] bytes;

// return hash;
// }
