# 📝 Notes

---

# 🏷️ Pattern

Monotonic Queue

Sliding Window

Deque

---

# 🧠 Core Idea

Need the maximum of every window.

Instead of recalculating:

```
max(window)
```

every time, maintain a deque containing possible maximum candidates.

---

# Why Store Indices?

The deque stores:

```java
Deque<Integer>
```

not values.

Example:

```
nums = [4,2,5]
```

Deque:

```
index 2
```

instead of:

```
5
```

because we need to know when an element leaves the window.

---

# Monotonic Property

The deque is always decreasing:

```
largest
  |
  v
smaller
  |
  v
smallest
```

Therefore:

```java
deque.peekFirst()
```

is always the maximum.

---

# Adding New Elements

When adding index `i`:

Remove smaller elements from the back:

```java
while (!deque.isEmpty() &&
       nums[deque.peekLast()] < nums[i]) {

    deque.pollLast();

}
```

Reason:

If a larger element arrives, smaller elements behind it are useless.

Example:

```
Before:

5
3
1

Add 6

6
```

5,3,1 can never be the maximum again.

---

# Removing Expired Elements

When the window moves:

```
window = [i-k+1 ... i]
```

Anything before:

```
i-k+1
```

is invalid.

Remove:

```java
deque.peekFirst() <= i-k
```

---

# Window Process

For every index:

```
1. Remove expired indices

2. Remove smaller elements from back

3. Add current index

4. Maximum = deque front
```

---

# Example

nums:

```
[1,3,-1,-3,5]
```

k:

```
3
```

Deque evolution:

```
1

3

3,-1

3,-1,-3

5
```

Maximum values:

```
3,3,5
```

---

# Common Mistakes

## ❌ Storing values instead of indices

Wrong:

```java
Deque<Integer> deque
```

containing:

```
[5,3]
```

Problem:

Cannot know when they leave the window.

---

## ❌ Using increasing deque

Need:

```
decreasing
```

because we need the maximum.

---

## ❌ Forgetting to remove expired indices

The deque may contain elements no longer inside the window.

---

# Pattern Recognition

When you see:

- "maximum/minimum in every window"
- "sliding window"
- "efficient O(n)"

Think:

```
Monotonic Deque
```

---

# Complexity

Time:

```
O(n)
```

Space:

```
O(k)
```

---

# Mental Model

The deque is not storing all elements.

It stores only:

```
elements that could become the maximum
```

Everything else is discarded.