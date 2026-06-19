# 📝 Notes

---

## 🏷️ Pattern

Binary Search on Answer

---

## 🧠 Core Idea

We are not searching the piles.

We are searching:

```text
possible eating speeds
```

from:

```text
1 → maxPile
```

---

## 🚀 Strategy

### Step 1: Define search range

Smallest possible speed:

```java
1
```

Largest possible speed:

```java
max(piles)
```

---

### Step 2: Binary Search

Choose:

```java
midSpeed
```

and ask:

```text
Can Koko finish within h hours?
```

---

### Step 3: Calculate required hours

For each pile:

```java
hours += ceil(pile / speed)
```

Example:

```text
pile = 7
speed = 3
```

Needs:

```text
3 hours
```

because:

```text
3 + 3 + 1
```

---

### Step 4: Adjust search space

If:

```text
hours <= h
```

Current speed works.

Try slower speed:

```java
right = mid
```

Otherwise:

```java
left = mid + 1
```

---

## ⚠️ Common Mistakes

### Wrong midpoint

Incorrect:

```java
(mid = (left + (right-left)) / 2)
```

Correct:

```java
mid = left + (right - left) / 2
```

---

### Forgetting ceiling division

Incorrect:

```java
hours += pile / speed
```

Correct:

```java
hours += Math.ceil((double)pile / speed)
```

---

### Binary searching piles

We are not searching values in the array.

We are searching possible answers.

---

## 🔄 Alternative Approaches

### ❌ Brute Force

Try every speed.

Time:

```text
O(n * maxPile)
```

Too slow.

---

### ✅ Binary Search on Answer

Time:

```text
O(n log maxPile)
```

Optimal.

---

## 🎯 Pattern Recognition

If you see:

- Minimum X
- Maximum X
- Feasibility check
- Monotonic true/false condition

Think:

✔ Binary Search on Answer

---

## 🧩 Key Insight

Transform:

```text
Find the minimum valid speed
```

into:

```text
Can this speed work?
```

Then binary search the answer space.