# 🍌 Koko Eating Bananas

## 🎯 Difficulty
Medium

## 🏷️ Pattern
Binary Search on Answer

---

## ❓ Problem

Koko loves bananas.

There are `n` piles of bananas, where `piles[i]` is the number of bananas in the ith pile.

Koko can choose an integer eating speed `k` (bananas per hour).

Each hour she chooses one pile and eats up to `k` bananas from it.

Return the minimum integer eating speed `k` such that Koko can finish all bananas within `h` hours.

---

## 💡 Approach

Instead of searching through the piles, we search through the possible eating speeds.

The answer must lie between:

```text
1 and max(piles)
```

For each candidate speed:

```text
Can Koko finish within h hours?
```

If yes:

```text
Try a smaller speed
```

If no:

```text
Need a larger speed
```

This creates a monotonic search space that can be solved using binary search.

---

## 🧠 Key Insight

The helper function:

```java
canEatInTime(speed)
```

returns:

```text
false false false false true true true true
```

Once a speed works, every larger speed also works.

That monotonic property makes binary search possible.

---

## 🚀 Algorithm

1. Find the largest pile.
2. Set:
   - left = 1
   - right = largest pile
3. Binary search:
   - Compute middle speed
   - Check if Koko can finish in h hours
4. If she can:
   - search left half
5. Otherwise:
   - search right half
6. Return the smallest valid speed.

---

## ⏱️ Time Complexity

O(n log m)

Where:

- n = number of piles
- m = maximum pile size

---

## 💾 Space Complexity

O(1)

Only a few variables are used.

---

## 🔑 Why This Works

We are searching for the smallest valid speed.

Since validity changes only once:

```text
invalid → valid
```

binary search efficiently finds the first valid answer.

---

## 📚 What I Learned

- Binary search can be applied to answer spaces
- A monotonic condition is enough for binary search
- Helper functions often convert optimization problems into decision problems
- Ceiling division is useful for counting required work

---

## 🧠 Pattern Recognition

If you see:

- Minimum value satisfying a condition
- Maximum value satisfying a condition
- Integer answer range
- True/False helper function

Think:

✔ Binary Search on Answer

---

## 🔄 Similar Problems

- Capacity To Ship Packages Within D Days
- Split Array Largest Sum
- Minimum Days to Make Bouquets
- Magnetic Force Between Two Balls
- Search a 2D Matrix