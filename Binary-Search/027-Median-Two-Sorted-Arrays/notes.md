# 📝 Notes

---

## 🏷️ Pattern

Binary Search on Partition

---

## 🧠 Core Idea

Instead of finding the median directly:

```text
Find a partition.
```

The partition must satisfy:

```text
All left elements <= All right elements
```

---

## Step 1: Binary Search Smaller Array

Always ensure:

```java
nums1.length <= nums2.length
```

This gives:

```text
O(log(min(m,n)))
```

---

## Step 2: Define Left Half Size

```java
int total = nums1.length + nums2.length;
int half = (total + 1) / 2;
```

The left partition should contain:

```text
half elements
```

---

## Step 3: Choose Partitions

```java
partition1 = mid;
partition2 = half - partition1;
```

If we take more elements from nums1:

```text
take fewer from nums2
```

and vice versa.

---

## Step 4: Boundary Elements

For nums1:

```java
ALeft
ARight
```

For nums2:

```java
BLeft
BRight
```

Example:

```text
A = [1,3 | 8,9]
```

```text
ALeft = 3
ARight = 8
```

---

## Step 5: Check Partition Validity

Correct partition:

```java
ALeft <= BRight
&&
BLeft <= ARight
```

If true:

```text
Median found
```

---

## Step 6: Move Partition

### Too many elements from nums1

```java
ALeft > BRight
```

Move left:

```java
right = partition1 - 1;
```

---

### Need more elements from nums1

```java
BLeft > ARight
```

Move right:

```java
left = partition1 + 1;
```

---

## Median Calculation

### Odd length

```java
median = Math.max(ALeft, BLeft);
```

Reason:

```text
Left partition contains one extra element.
```

---

### Even length

```java
(
    Math.max(ALeft, BLeft)
    +
    Math.min(ARight, BRight)
) / 2.0
```

---

## Sentinel Values

When partition is at an edge:

```java
Integer.MIN_VALUE
Integer.MAX_VALUE
```

Examples:

```text
|1,3,5
```

No left value:

```java
ALeft = Integer.MIN_VALUE;
```

---

```text
1,3,5|
```

No right value:

```java
ARight = Integer.MAX_VALUE;
```

---

## ⚠️ Common Mistakes

### Binary searching values

Wrong.

Binary search the partition.

---

### Searching the larger array

Leads to unnecessary complexity.

Always search the smaller array.

---

### Incorrect partition calculation

Wrong:

```java
partition2 = nums1.length - partition1;
```

Correct:

```java
partition2 = half - partition1;
```

---

### Forgetting edge cases

Use sentinel values for:

```text
empty left side
empty right side
```

---

## 🎯 Pattern Recognition

If you see:

- Median
- Two sorted arrays
- Logarithmic requirement

Think:

✔ Partition the arrays  
✔ Compare boundaries  
✔ Binary search the partition position  

---

## 🧩 Key Insight

The median is determined entirely by:

```java
max(ALeft, BLeft)
min(ARight, BRight)
```

You never need to merge the arrays.