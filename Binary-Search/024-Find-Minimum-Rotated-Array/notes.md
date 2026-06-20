# 📝 Notes

---

## 🏷️ Pattern

Binary Search on Rotated Array

---

## 🧠 Core Idea

A rotated sorted array contains:

```text
sorted left half
sorted right half
```

The minimum lies at the rotation point.

---

## Example

```text
[4,5,6,7,0,1,2]
```

Minimum:

```text
0
```

---

## 🚀 Strategy

### Compare mid and right

If:

```java
nums[mid] > nums[right]
```

Example:

```text
[4,5,6,7,0,1,2]
      ^
```

Mid is in the left sorted portion.

Minimum must be to the right.

Move:

```java
left = mid + 1;
```

---

If:

```java
nums[mid] <= nums[right]
```

Example:

```text
[0,1,2,3,4]
    ^
```

Minimum is at mid or left of mid.

Move:

```java
right = mid;
```

---

## 🎯 Pattern Recognition

If you see:

- Rotated sorted array
- Need minimum/pivot
- Logarithmic time requirement

Think:

✔ Binary Search  
✔ Compare against right boundary  
✔ Shrink search space toward rotation point  

---

## 🧩 Key Insight

The minimum is the only point where:

```text
sorted order "breaks"
```

Binary search efficiently locates that break.