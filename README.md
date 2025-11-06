# Data Structures & Algorithms in Java

A comprehensive collection of custom data structure implementations and algorithm solutions in Java, designed for educational purposes and practical application.

## 📁 Project Structure

```
src/
├── DataStructure/
│   ├── Dictionary.java
│   ├── Hash.java
│   └── HashTable.java
└── knownAlgorithms/
    ├── InsertionSort.java
    ├── activitySelectionProblem.java
    ├── sortedCharactersFrequenciesProblem.java
    └── validAnagramProblem.java
```

## 🔧 Data Structures

### Dictionary

A generic key-value pair data structure with dynamic resizing capabilities.

**Features:**
- Generic type support for both keys and values
- Dynamic array resizing
- O(n) search complexity
- Basic CRUD operations (set, get, remove)

**Usage:**
```java
Dictionary<String, String> contacts = new Dictionary<>();
contacts.set("John", "555-1234");
contacts.set("Jane", "555-5678");
String phone = contacts.get("John");
contacts.remove("Jane");
contacts.print();
```

**Methods:**
- `set(TKey key, TValue value)` - Add or update a key-value pair
- `get(TKey key)` - Retrieve value by key
- `remove(TKey key)` - Remove a key-value pair
- `Size()` - Get the number of entries
- `print()` - Display all entries

### HashTable

A generic hash table implementation using FNV-1 hash algorithm with linear probing for collision resolution.

**Features:**
- FNV-1 32-bit hash function
- Linear probing collision handling
- Automatic resizing (doubles capacity when full)
- Generic type support

**Usage:**
```java
HashTable<Integer, String> users = new HashTable<>();
users.Set(1, "Alice");
users.Set(2, "Bob");
String user = users.get(1);
users.print();
```

**Methods:**
- `Set(TKey key, TValue value)` - Add or update entry
- `get(TKey key)` - Retrieve value by key
- `Size()` - Get the number of entries
- `print()` - Display all entries

### Hash

Utility class implementing FNV-1 hash algorithms.

**Features:**
- FNV-1 32-bit hash implementation
- FNV-1 64-bit hash implementation
- ASCII string input support

**Usage:**
```java
Hash hasher = new Hash();
int hash32 = hasher.Hash32("example");
long hash64 = hasher.hash64("example");
```

## 📊 Algorithms

### Insertion Sort

Classic sorting algorithm with O(n²) time complexity.

**Complexity:**
- Time: O(n²) worst case, O(n) best case
- Space: O(1)

**Usage:**
```java
int[] nums = {9, 3, 7, 6, 2, 5, 4};
InsertionSort.sort(nums);
```

### Activity Selection Problem

Greedy algorithm to select the maximum number of non-overlapping activities.

**Complexity:**
- Time: O(n log n) due to sorting
- Space: O(n) for result storage

**Usage:**
```java
int[] start = {9, 10, 11, 12, 13, 15};
int[] end = {11, 11, 12, 14, 15, 16};
ArrayList<Integer> selected = activitySelection(start, end);
```

### Character Frequency Counter

Two implementations for counting character frequencies in a string.

**Methods:**
- `ASCIIMethod(String message)` - Uses array indexing with ASCII values (O(n) time, O(1) space)
- `hashMethod(String message)` - Uses HashMap (O(n) time, O(k) space where k is unique characters)
- `sortWith2DArray()` - Converts frequency map to 2D array
- `sort()` - Merge sort implementation for 2D arrays

**Usage:**
```java
String message = "hello world";
ASCIIMethod(message);
hashMethod(message);
```

### Valid Anagram Problem

LeetCode problem solution with two approaches to check if two strings are anagrams.

**Problem Link:** [LeetCode - Valid Anagram](https://leetcode.com/problems/valid-anagram/)

**Methods:**
1. `isAnagramBySort(String s, String t)`
   - Time: O(n log n + m log m)
   - Space: O(1) or O(n + m) depending on sort implementation

2. `isAnagramByHashMap(String s, String t)`
   - Time: O(n + m)
   - Space: O(1) (at most 26 characters for English alphabet)

**Usage:**
```java
boolean result = isAnagramByHashMap("anagram", "nagaram"); // true
boolean result2 = isAnagramBySort("rat", "car"); // false
```

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code)

### Compilation
```bash
javac src/DataStructure/*.java
javac src/knownAlgorithms/*.java
```

### Running Examples
```bash
java -cp src knownAlgorithms.InsertionSort
java -cp src knownAlgorithms.validAnagramProblem
```

## 📝 Notes

- The Dictionary implementation uses linear search with O(n) complexity. For better performance with large datasets, consider using the HashTable implementation.
- The HashTable uses linear probing for collision resolution, which may lead to clustering issues with high load factors.
- All data structures support generic types for flexibility.
- The Activity Selection Problem assumes the end times array needs to be sorted.

## 🎯 Future Enhancements

- Implement remove operation for HashTable
- Add support for custom hash functions
- Implement additional collision resolution strategies (quadratic probing, double hashing)
- Add unit tests for all implementations
- Implement iterators for data structures
- Add more algorithm solutions

## 📄 License

This project is created for educational purposes and is free to use and modify.

## 👤 Author

Mohamed Mostafa

## 🤝 Contributing

Contributions, issues, and feature requests are welcome! Feel free to check the issues page or submit a pull request.