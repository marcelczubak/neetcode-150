# 📝 Notes

---

## 🏷️ Pattern

Binary Search on a Virtual Array

---

## 🧠 Core Idea

The matrix satisfies:

- Rows sorted
- First element of next row > last element of previous row

Therefore:

```text
2D Matrix ≡ Sorted 1D Array
```

without actually flattening it.

---

## 🚀 Strategy

### Step 1: Treat matrix as array

Total elements:

```java
m * n
```

Indices range from:

```java
0 → m*n - 1
```

---

### Step 2: Binary Search

Standard binary search:

```java
while (left <= right)
```

---

### Step 3: Convert index

For any virtual index:

```java
row = mid / n
col = mid % n
```

Access value:

```java
matrix[row][col]
```

---

### Example

Matrix:

```text
1  3  5  7
10 11 16 20
23 30 34 60
```

n = 4

Virtual index:

```text
mid = 5
```

Coordinates:

```java
row = 5 / 4 = 1
col = 5 % 4 = 1
```

Value:

```java
matrix[1][1] = 11
```

---

## ⚠️ Common Mistakes

- Using m instead of n in division/modulo
- Forgetting matrix is zero-indexed
- Flattening matrix unnecessarily
- Using O(m*n) scan instead of binary search
- Incorrect binary search boundaries

---

## 🔄 Alternative Approaches

### ❌ Linear Scan

Check every element.

Time:

```text
O(m*n)
```

---

### ❌ Binary Search Each Row

Search rows individually.

Time:

```text
O(m log n)
```

---

### ✅ Virtual Flattening (Optimal)

Single binary search.

Time:

```text
O(log(m*n))
```

Space:

```text
O(1)
```

---

## 🎯 Pattern Recognition

If you see:

- Sorted rows
- Ordered rows
- Matrix behaves globally sorted
- Logarithmic requirement

Think:

✔ Binary Search  
✔ Virtual array  
✔ Index mapping  

---

## 🧩 Key Insight

The matrix never needs to be flattened.

Simply pretend it is a sorted array and convert:

```java
index → (row, col)
```

when accessing elements.