# Task Scheduler

## Problem

You are given an array of CPU tasks represented by capital letters and a non-negative cooling interval `n`.

Rules:

* Each task takes **1 unit of time**.
* The same task must be separated by at least `n` intervals.
* During the cooling period, the CPU may execute other tasks or remain idle.

Return the minimum number of time units required to complete all tasks.

---

# Example

## Input

```text
tasks = ["A","A","A","B","B","B"]
n = 2
```

## One Optimal Schedule

```text
A B idle A B idle A B
```

Time:

```text
8
```

---

# Approach

## Key Idea

At every unit of time:

1. Execute the task with the **highest remaining frequency**.
2. Place it into a cooldown queue if it still has remaining occurrences.
3. When its cooldown expires, move it back into the max heap.

The algorithm simulates the CPU one time unit at a time.

---

# Data Structures

## Frequency Array

Count how many times each task appears.

```java
int[] frequencies = new int[26];
```

Example:

```text
A A A B B C
```

becomes:

```text
A -> 3
B -> 2
C -> 1
```

---

## Max Heap

Store task frequencies.

```java
PriorityQueue<Integer> maxHeap =
    new PriorityQueue<>(Collections.reverseOrder());
```

The task with the highest remaining count is always executed first.

---

## Cooldown Queue

Each entry stores:

```text
[
 remainingFrequency,
 timeWhenAvailableAgain
]
```

Example:

```text
[2,7]
```

means:

* task still needs to run twice
* cannot be scheduled again until time 7

---

# Algorithm

## Step 1

Count task frequencies.

---

## Step 2

Insert all frequencies into the max heap.

---

## Step 3

Repeat while work remains.

Continue while:

```java
!maxHeap.isEmpty() || !queue.isEmpty()
```

---

### Release Cooled Tasks

If the first task in the cooldown queue becomes available:

```java
queue.peek()[1] == totalTime
```

move it back into the heap.

---

### Execute Task

If the heap is not empty:

Remove the task with the highest frequency.

Decrease its remaining count.

If more occurrences remain:

```java
queue.offer(
    new int[]{
        remainingFrequency,
        totalTime + n + 1
    }
);
```

The task can only return after `n` cooling intervals.

---

### Advance Time

Every iteration represents exactly one CPU time unit.

```java
totalTime++;
```

Even if no task executes, this models an idle interval.

---

# Example Walkthrough

Input:

```text
AAA BBB
n = 2
```

Initial heap:

```text
[3,3]
```

---

Time 0

Run:

```text
A
```

Cooldown:

```text
A -> available at 3
```

Heap:

```text
[3]
```

---

Time 1

Run:

```text
B
```

Cooldown:

```text
B -> available at 4
```

Heap:

```text
[]
```

---

Time 2

Heap empty.

CPU:

```text
idle
```

---

Time 3

A returns.

Run:

```text
A
```

Continue until all tasks finish.

---

# Complexity Analysis

Let:

```text
T = number of tasks
```

There are only 26 possible task types.

---

## Time Complexity

Building frequency array:

```text
O(T)
```

Each task enters and leaves the heap once.

Heap operations cost:

```text
O(log 26)
```

which is constant.

Overall:

```text
O(T)
```

---

## Space Complexity

Frequency array:

```text
O(26)
```

Heap:

```text
O(26)
```

Cooldown queue:

```text
O(26)
```

Overall:

```text
O(1)
```

since the alphabet size is fixed.

---

# Key Takeaway

This problem combines two patterns:

* **Greedy scheduling** (always execute the task with the highest remaining frequency)
* **Priority Queue + Cooldown Queue simulation**

The max heap chooses the best task to execute, while the queue tracks when tasks become available again.
