# Meeting Rooms Notes

## Pattern

Intervals

Sorting

---

# Main Insight

The meetings are initially unordered.

Sort them by starting time.

Once sorted:

```
Only neighbouring meetings can overlap.
```

There is no need to compare every pair of meetings.

---

# Why Sorting Works

Before sorting:

```
[7,10]

[2,4]

[5,8]
```

Hard to determine overlaps.

After sorting:

```
[2,4]

[5,8]

[7,10]
```

Now every possible overlap occurs between adjacent meetings.

---

# Overlap Condition

Suppose:

```
previous

[a,b]

current

[c,d]
```

There is an overlap when:

```java
current.start < previous.end
```

Example:

```
[2,6]

[4,8]
```

Since:

```
4 < 6
```

they overlap.

---

# No Overlap

Condition:

```java
current.start >= previous.end
```

Example:

```
[2,4]

[5,8]
```

Since:

```
5 >= 4
```

they do not overlap.

---

# Algorithm

Sort:

```java
intervals.sort(
    (a, b) -> Integer.compare(a.start, b.start)
);
```

Loop:

```java
for (int i = 1; i < intervals.size(); i++)
```

Compare:

```java
intervals.get(i).start
```

against

```java
intervals.get(i - 1).end
```

Return `false` immediately if they overlap.

Otherwise continue.

---

# Complexity

Sorting:

```
O(n log n)
```

Traversal:

```
O(n)
```

Overall:

```
O(n log n)
```

Space:

```
O(1)
```

---

# Java Syntax

Sort custom objects:

```java
intervals.sort(
    (a, b) -> Integer.compare(a.start, b.start)
);
```

Access fields:

```java
interval.start
interval.end
```

---

# Common Mistakes

### Forgetting to sort

Without sorting, adjacent meetings may not represent chronological order.

---

### Using `<=`

The condition should be:

```java
current.start < previous.end
```

because meetings that touch are allowed.

Example:

```
[2,4]

[4,6]
```

These do **not** overlap.

---

### Comparing every pair

Nested loops lead to:

```
O(n²)
```

Sorting reduces this to:

```
O(n log n)
```

---

# Interview Explanation

"I first sort the meetings by their starting time. After sorting, I only need to compare each meeting with the one immediately before it. If any meeting starts before the previous meeting ends, there is an overlap and it's impossible to attend every meeting."

---

# Pattern Recognition

When you see:

- meeting schedules
- overlapping intervals
- calendar conflicts

think:

```
Sort by start time

↓

Compare adjacent intervals
```
```