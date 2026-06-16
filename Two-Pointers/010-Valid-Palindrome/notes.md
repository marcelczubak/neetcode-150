# 📝 Notes

---

## 🏷️ Pattern

Two Pointers

---

## 🧠 Core Idea

A palindrome reads the same forward and backward.

Instead of reversing the string or creating a cleaned version, compare characters directly from both ends.

---

## 🚀 Optimal Strategy

### Step 1: Initialize pointers

```text
left = 0
right = s.length() - 1
```

### Step 2: Skip invalid characters

Ignore anything that is not:

* a letter
* a digit

---

### Step 3: Compare characters

Convert both characters to lowercase and compare.

If they differ:

```text
return false
```

---

### Step 4: Move inward

```text
left++
right--
```

Continue until pointers cross.

---

## ⚠️ Common Mistakes

* Forgetting to ignore punctuation
* Forgetting case-insensitive comparison
* Creating a cleaned string unnecessarily
* Not checking bounds when skipping characters
* Using extra space when two pointers are sufficient

---

## 🔄 Alternative Approach

### Clean String + Reverse

1. Build a filtered lowercase string
2. Reverse it
3. Compare

Works, but uses O(n) extra space.

---

### Two Pointers (Optimal)

Compare directly while traversing.

O(1) extra space.

---

## 🎯 Pattern Recognition

If you see:

* Palindrome validation
* Symmetric comparison
* Front vs back checking

Think:

✔ Two Pointers
✔ Skip irrelevant characters
✔ Move inward

---

## 🧩 Key Insight

The optimization comes from processing the string in-place:

> Compare only the characters that matter, and ignore everything else during traversal.
