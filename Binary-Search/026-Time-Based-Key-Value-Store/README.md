# ⏱️ Time Based Key-Value Store

## 🎯 Difficulty
Medium

## 🏷️ Pattern
Design + Ordered Map (TreeMap) (Binary Search intended ** )

---

## ❓ Problem

Design a data structure that supports:

### set(key, value, timestamp)
Stores the value at the given timestamp.

### get(key, timestamp)
Returns the value with the largest timestamp ≤ given timestamp.
If no such timestamp exists, return "".

---

## 💡 Approach

For each key, store a **sorted map of timestamps → values**.

Since timestamps must be queried in order, we use a `TreeMap` which keeps keys sorted automatically.

---

## 🧠 Key Insight

We need to efficiently find:

> the closest timestamp less than or equal to the given timestamp

TreeMap provides this directly using:

```java
floorKey(timestamp)
```

---

## 🚀 Algorithm

### set(key, value, timestamp)

- If key does not exist, create a new TreeMap
- Insert (timestamp → value)

### get(key, timestamp)

- Retrieve TreeMap for key
- Use floorKey(timestamp)
- Return corresponding value

---

## ⏱️ Time Complexity

### set:
O(log n)

### get:
O(log n)

Where n is number of timestamps per key.

---

## 💾 Space Complexity

O(n)

All timestamped values are stored.

---

## 🔑 Why This Works

TreeMap maintains sorted order of timestamps internally.

This allows efficient “nearest value ≤ target” queries without manual binary search.

---

## 📚 What I Learned

- Ordered maps can replace manual binary search
- floorKey is a powerful query operation
- Design problems often combine hashing + sorted structures
- Java TreeMap is a built-in balanced BST

---

## 🧠 Pattern Recognition

If you see:

- time-based queries
- “latest value before X”
- versioned data
- nearest ≤ target search

Think:

✔ HashMap + TreeMap  
✔ floor/ceiling queries  
✔ ordered key-value design  

---

## 🔄 Similar Problems

- LRU Cache (design + ordering)
- Snapshot Array
- Binary Search on Sorted Data
- Insert Interval (ordered structure reasoning)