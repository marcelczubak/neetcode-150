# Meeting Rooms II

## Problem

Given an array of meeting intervals:

```
[start, end]
```

return the **minimum number of conference rooms required** so that all meetings can take place without conflicts.

A room cannot host two meetings at the same time.

---

## Example 1

### Input

```text
intervals = [[0,30],[5,10],[15,20]]
```

### Output

```text
2
```

### Explanation

Timeline:

```
Room 1:
0----------------30

Room 2:
    5----10
          15----20
```

The maximum number of simultaneous meetings is 2.

---

## Example 2

### Input

```text
intervals = [[7,10],[2,4]]
```

### Output

```text
1
```

### Explanation

The meetings do not overlap, so only one room is required.

---

# Key Observation

The challenge is not storing meetings — it is tracking:

```
When does each room become available?
```

For this, we only need the **end times** of meetings currently using rooms.

---

# Approach

## Step 1 — Sort Meetings

Sort intervals by their starting time.

Example:

Before:

```
[15,20]
[0,30]
[5,10]
```

After:

```
[0,30]
[5,10]
[15,20]
```

This allows us to process meetings chronologically.

---

## Step 2 — Use a Min Heap

Maintain a min heap containing:

```
end times of meetings currently occupying rooms
```

The smallest end time is the room that becomes available first.

Java:

```java
PriorityQueue<Integer> rooms = new PriorityQueue<>();
```

---

## Step 3 — Process Each Meeting

For every interval:

### Case 1: A room is available

Condition:

```java
rooms.peek() <= interval.start
```

Example:

```
Existing meeting:

[2,10]

New meeting:

          [10,15]
```

The room can be reused.

Remove the old meeting:

```java
rooms.poll();
```

---

### Case 2: No room available

The earliest ending meeting has not finished.

Example:

```
Existing:

[2,12]

New:

     [5,10]
```

Need another room.

---

## Step 4 — Add Current Meeting

Every meeting occupies a room:

```java
rooms.add(interval.end);
```

At the end:

```
heap size = number of rooms required
```

---

# Algorithm

1. Sort meetings by start time.
2. Create a min heap of end times.
3. Iterate through meetings:
   - If earliest ending meeting has finished:
     - Remove it.
   - Add current meeting's end time.
4. Return heap size.

---

# Complexity

Sorting:

```
O(n log n)
```

Heap operations:

```
O(n log n)
```

Overall:

```
O(n log n)
```

---

Space:

```
O(n)
```

The heap can contain all meetings.

---

# Key Takeaway

Whenever a problem asks:

> "How many resources are needed simultaneously?"

Think:

```
Sort by start time

+

Min Heap of end times
```

The heap tracks the resources currently in use.

---

# Related Problems

- Meeting Rooms
- Merge Intervals
- Insert Interval
- Non-overlapping Intervals
- Car Pooling