# Meeting Rooms

## Problem

Given an array of meeting time intervals:

```
[start, end]
```

determine whether a person can attend **all meetings**.

A person can only attend every meeting if **no two meetings overlap**.

Return:

- `true` if every meeting can be attended.
- `false` otherwise.

---

## Example 1

### Input

```text
intervals = [[0,30],[5,10],[15,20]]
```

### Output

```text
false
```

### Explanation

```
0────────────30
     5────10
```

The meetings overlap, so both cannot be attended.

---

## Example 2

### Input

```text
intervals = [[7,10],[2,4]]
```

### Output

```text
true
```

### Explanation

After sorting:

```
[2,4]

       [7,10]
```

No meetings overlap.

---

# Key Observation

The meetings are **not guaranteed to be sorted**.

If we first sort by **starting time**, then each meeting only needs to be compared with the meeting immediately before it.

---

# Approach

## Step 1

Sort meetings by starting time.

```java
intervals.sort((a, b) -> Integer.compare(a.start, b.start));
```

Example:

Before:

```
[7,10]
[2,4]
[5,8]
```

After:

```
[2,4]
[5,8]
[7,10]
```

---

## Step 2

Traverse the sorted meetings.

For every meeting, compare it against the previous one.

---

### No Overlap

```
current.start >= previous.end
```

Example:

```
previous

[2,4]

current

      [5,8]
```

Continue.

---

### Overlap

```
current.start < previous.end
```

Example:

```
previous

[2,6]

current

    [4,8]
```

Return:

```
false
```

---

# Algorithm

1. Sort meetings by start time.
2. Iterate from the second meeting onwards.
3. Compare each meeting with the previous one.
4. If an overlap exists:
   - Return `false`.
5. If the loop finishes:
   - Return `true`.

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

---

Space:

```
O(1)
```

Ignoring the sorting implementation.

---

# Key Takeaway

After sorting, detecting overlaps is simple.

Each meeting only needs to be compared against the meeting immediately before it.

---

# Related Problems

- Meeting Rooms II
- Merge Intervals
- Insert Interval
- Non-overlapping Intervals
- Interval List Intersections