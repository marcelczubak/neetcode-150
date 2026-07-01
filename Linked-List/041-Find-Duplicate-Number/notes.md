# 📝 Notes

---

# 🏷️ Pattern

Index Marking (In-Place)

---

# 🧠 Core Idea

Every number in the array belongs to the range:

```
1 ... n
```

That means every value corresponds to a valid array index.

We use that index to record whether the value has been seen before.

---

# 📌 Mapping Values to Indices

```
value: 1 2 3 4 5

index: 0 1 2 3 4
```

Formula:

```java
int index = num - 1;
```

---

# 📌 Why `Math.abs()`?

As we mark elements negative, later iterations may encounter negative values.

We still need the original value.

```java
int num = Math.abs(nums[i]);
```

---

# 📌 Mark as Visited

If the index has not been visited:

```java
nums[index] *= -1;
```

Negative means:

```
Visited
```

---

# 📌 Detect Duplicate

If the mapped index is already negative:

```java
if (nums[index] < 0)
```

then we've already seen this number.

Return it.

---

# 🧪 Example

```
nums = [1,3,4,2,2]
```

Iteration:

```
1

Index = 0

[-1,3,4,2,2]
```

---

```
3

Index = 2

[-1,3,-4,2,2]
```

---

```
4

Index = 3

[-1,3,-4,-2,2]
```

---

```
2

Index = 1

[-1,-3,-4,-2,2]
```

---

```
2

Index = 1

Already negative

Duplicate = 2
```

---

# ⚠️ Common Mistakes

## ❌ Forgetting `Math.abs()`

Wrong:

```java
int num = nums[i];
```

Previously marked elements become negative, producing invalid indices.

---

## ❌ Using value as index

Wrong:

```java
nums[num]
```

Correct:

```java
nums[num - 1]
```

Arrays are zero-indexed.

---

## ❌ Forgetting that the array is modified

After running the algorithm, some elements will be negative.

Do not expect the original array to remain unchanged.

---

# 🎯 Pattern Recognition

If a problem guarantees:

- values are from `1` to `n`
- duplicate detection
- constant extra space

Think:

✔ Map values to indices

✔ Use the array itself as the visited structure

---

# 💭 Mental Model

Imagine every value points to its own "mailbox" (its corresponding index).

The first time you visit a value, you put a flag in its mailbox by making the number at that index negative.

If you ever return to a mailbox that already has a flag, you've found the duplicate.