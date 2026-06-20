# 📝 Notes

---

## 🏷️ Pattern

Binary Search on Rotated Sorted Array

---

## 🧠 Core Idea

The array is rotated, but not completely random.

At every iteration:

```text
At least one half is sorted.
```

We use that information to determine where the target can exist.

---

## Example

```text
[4,5,6,7,0,1,2]
```

Target:

```text
0
```

---

## 🚀 Strategy

### Step 1: Compute midpoint

```java
mid = left + (right - left) / 2;
```

---

### Step 2: Check for target

```java
if (nums[mid] == target)
```

Return immediately.

---

### Step 3: Determine sorted side

If:

```java
nums[left] <= nums[mid]
```

Then:

```text
Left half is sorted
```

Otherwise:

```text
Right half is sorted
```

---

### Step 4: Check if target belongs there

For a sorted left half:

```java
target >= nums[left]
&&
target < nums[mid]
```

If true:

```java
right = mid - 1;
```

Else:

```java
left = mid + 1;
```

---

For a sorted right half:

```java
target > nums[mid]
&&
target <= nums[right]
```

If true:

```java
left = mid + 1;
```

Else:

```java
right = mid - 1;
```

---

## ⚠️ Common Mistakes

### Using:

```java
left = mid;
```

or

```java
right = mid;
```

Can create infinite loops.

Always use:

```java
left = mid + 1;
right = mid - 1;
```

---

### Forgetting which side is sorted

Use:

```java
nums[left] <= nums[mid]
```

to identify a sorted left half.

---

### Mixing up inequalities

Pay close attention to:

```java
>=
<=
<
>
```

Boundary errors are common.

---

## 🔄 Alternative Approaches

### ❌ Linear Search

Time:

```text
O(n)
```

---

### ✅ Modified Binary Search

Time:

```text
O(log n)
```

Space:

```text
O(1)
```

---

## 🎯 Pattern Recognition

If you see:

- Rotated sorted array
- Logarithmic requirement
- Search problem

Think:

✔ Binary Search  
✔ One half is sorted  
✔ Range checking

---

## 🧩 Key Insight

You do not need to find the rotation pivot first.

Simply determine which half is sorted at each step and use that information to eliminate half of the search space.
