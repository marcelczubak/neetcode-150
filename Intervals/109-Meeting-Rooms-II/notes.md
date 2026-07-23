# Meeting Rooms II Notes

## Pattern

Intervals

Greedy

Priority Queue

---

# Main Insight

We need to know:

```
How many meetings overlap at the same time?
```

Each overlapping meeting needs its own room.

Instead of storing rooms, store:

```
when each room becomes free
```

---

# Why Min Heap?

Suppose rooms currently finish at:

```
10
15
20
```

The next meeting only cares about:

```
10
```

because it is the first room that may become available.

A min heap gives:

```java
rooms.peek()
```

in:

```
O(1)
```

---

# Algorithm

## 1. Sort by start time

```java
intervals.sort(
    (a,b) -> Integer.compare(a.start,b.start)
);
```

Example:

```
[10,20]

[0,5]

[6,15]
```

becomes:

```
[0,5]

[6,15]

[10,20]
```

---

## 2. Add meetings to heap

Heap stores:

```
meeting end times
```

Example:

```
[0,30]

heap:

30
```

---

# Processing Logic

For every meeting:

## Check if room available

```java
rooms.peek() <= interval.start
```

Meaning:

```
previous meeting finished
before this meeting begins
```

Reuse:

```java
rooms.poll();
```

---

## Add current meeting

```java
rooms.add(interval.end);
```

---

# Example Walkthrough

Meetings:

```
[0,30]

[5,10]

[15,20]
```

---

First:

```
heap:

30
```

---

Second:

```
peek = 30

30 <= 5? false
```

Need new room.

```
heap:

10
30
```

---

Third:

```
peek = 10

10 <= 15? true
```

Reuse room.

Remove:

```
30
```

Add:

```
20
```

Heap:

```
20
30
```

Answer:

```
2 rooms
```

---

# Java Syntax

Create min heap:

```java
PriorityQueue<Integer> heap =
    new PriorityQueue<>();
```

Get minimum:

```java
heap.peek();
```

Remove minimum:

```java
heap.poll();
```

Insert:

```java
heap.add(value);
```

---

# Common Mistakes

## Using a normal queue

A normal queue does not guarantee the earliest finishing room.

Need:

```
PriorityQueue
```

---

## Sorting by end time

Wrong.

We process meetings chronologically.

Sort by:

```java
interval.start
```

---

## Forgetting touching intervals

These do not overlap:

```
[1,5]

[5,10]
```

Condition:

```java
rooms.peek() <= interval.start
```

allows reuse.

---

## Counting rooms manually

Do not maintain a counter.

The heap size already represents:

```
currently occupied rooms
```

---

# Interview Explanation

"I sort meetings by their start time so I can process them chronologically. I maintain a min heap containing the end times of meetings currently using rooms. Before assigning a room, I check whether the earliest ending meeting has finished. If so, I reuse that room. Otherwise, I add another room. The heap size at the end gives the minimum number of rooms required."

---

# Pattern Recognition

When you see:

- meeting rooms
- CPU scheduling
- minimum resources required
- overlapping intervals

think:

```
Sort start times

+

Min heap of ending times
```