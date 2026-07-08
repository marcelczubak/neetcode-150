# 🪟 Sliding Window Maximum

## 🎯 Difficulty
Hard

## 🏷️ Pattern
Monotonic Queue / Deque
- Sliding Window
- Two Pointers
- Queue Optimization

---

## ❓ Problem

Given an integer array `nums` and an integer `k`, return the maximum value in each sliding window of size `k`.

Example:

```
Input:
nums = [1,3,-1,-3,5,3,6,7]
k = 3

Output:
[3,3,5,5,6,7]
```

Each window moves one position to the right:

```
[1,3,-1] → max = 3

[3,-1,-3] → max = 3

[-1,-3,5] → max = 5
```

---

# 💡 Key Idea

A brute force solution checks every window:

```
O(n*k)
```

because each window requires scanning `k` elements.

Instead, maintain a **monotonic decreasing deque**.

The deque stores:

```
indices of useful candidates for the maximum
```

The largest element in the current window is always at:

```
deque.peekFirst()
```

---

# 🧠 Monotonic Deque

The deque maintains decreasing values:

Example:

```
nums = [1,3,-1]
```

Deque:

```
3
-1
```

The front always contains the maximum.

---

# 🚀 Algorithm

## Step 1 — Build First Window

For every index:

1. Remove smaller elements from the back.

Why?

If a new element is larger:

```
[5,3]
```

The `3` can never become the maximum again.

2. Add the new index.

3. After the first window:

```
deque.front = maximum
```

---

## Step 2 — Slide Window

For every new element:

### 1. Remove expired indices

If an index is outside the window:

```
index <= i-k
```

remove it from the front.

---

### 2. Maintain decreasing order

Remove smaller elements:

```
while nums[last] < nums[current]
```

because they can never become the maximum.

---

### 3. Add current index

The deque now contains only useful candidates.

The maximum is:

```
nums[deque.peekFirst()]
```

---

# 🔄 Example

Input:

```
nums = [1,3,-1,-3,5]
k = 3
```

First window:

```
[1,3,-1]
```

Process:

```
1
```

Add 3:

```
remove 1

3
```

Add -1:

```
3
-1
```

Maximum:

```
3
```

---

Next window:

```
[3,-1,-3]
```

3 remains the largest.

Output:

```
[3]
```

---

Next:

```
[-1,-3,5]
```

5 arrives:

Remove:

```
-3
-1
```

Deque:

```
5
```

Maximum:

```
5
```

---

# ⏱️ Complexity

## Time

```
O(n)
```

Each element:

- enters deque once
- leaves deque once

---

## Space

```
O(k)
```

Deque stores at most `k` indices.

---

# 🧩 Important Implementation Detail

The deque stores **indices**, not values.

Why?

Because we need to know when elements leave the sliding window.

Example:

```
index <= i-k
```

allows us to remove expired values.

---

# 📚 Related Problems

- Longest Substring Without Repeating Characters
- Minimum Window Substring
- Daily Temperatures
- Largest Rectangle in Histogram
- Sliding Window Problems