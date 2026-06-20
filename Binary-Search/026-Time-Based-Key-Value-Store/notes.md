# 📝 Notes

---

## 🏷️ Pattern

Design + Ordered Map

---

## 🧠 Core Idea

We need to store values over time and query:

```text
latest value with timestamp ≤ target
```

---

## 🚀 Data Structure

Use:

```java
Map<String, TreeMap<Integer, String>>
```

Meaning:

```text
key → sorted map of (timestamp → value)
```

---

## 🧱 Why TreeMap?

Because it maintains sorted order of keys automatically:

```text
1 → 4 → 8 → 10
```

---

## 🔍 Query Logic

For a given timestamp:

```java
floorKey(timestamp)
```

returns:

> largest key ≤ timestamp

---

## 🧪 Example

### Stored:

```text
foo:
1 → bar
4 → bar2
8 → bar3
```

### Query:

```text
get(foo, 6)
```

### Steps:

- floorKey(6) = 4
- return "bar2"

---

## ⚠️ Common Mistakes

- Using HashMap instead of TreeMap
- Trying to binary search unsorted keys
- Forgetting to handle null from floorKey
- Not initializing map per key

---

## 🔄 Alternative Approaches

### ❌ HashMap only

Requires sorting keys manually → O(n log n) per query

---

### ❌ Manual binary search

Need list of timestamps + extra code

---

### ✅ TreeMap (optimal in Java)

- Built-in ordering
- Efficient floor queries
- Clean implementation

---

## 🎯 Pattern Recognition

If you see:

- time-based storage
- versioned values
- “closest previous value”
- ≤ timestamp queries

Think:

✔ TreeMap  
✔ ordered key-value structure  
✔ floor/ceiling operations

---

## 🧩 Key Insight

This problem is not about binary search directly.

It is about:

> maintaining sorted structure so binary search becomes unnecessary
