# Task Scheduler - Notes

## Pattern

This is a classic:

> Greedy + Priority Queue Simulation

At every time unit, choose the task that leaves the most flexibility for the future.

That means:

```text
Execute the task with the highest remaining frequency.
```

---

# Why A Max Heap?

Suppose:

```text
A -> 5
B -> 2
C -> 1
```

Running:

```text
A
```

first is always safest.

Delaying the most frequent task increases the chance of future idle time.

The max heap always provides:

```java
maxHeap.poll();
```

which returns the task with the greatest remaining count.

---

# Why A Queue?

After executing:

```text
A
```

it cannot immediately return.

It must wait:

```text
n
```

intervals.

Instead of checking every task repeatedly, store:

```text
[
remainingCount,
availableTime
]
```

Example:

```text
[3,8]
```

means:

* task still needs 3 executions
* becomes available again at time 8

---

# Simulation Timeline

Example:

```text
AAA BBB
n = 2
```

Time:

```text
0
```

Heap:

```text
A3 B3
```

Run:

```text
A
```

Queue:

```text
A2 available at 3
```

---

Time:

```text
1
```

Run:

```text
B
```

Queue:

```text
A2@3
B2@4
```

---

Time:

```text
2
```

Heap empty.

CPU:

```text
idle
```

---

Time:

```text
3
```

A returns.

Run:

```text
A
```

Continue until all tasks complete.

---

# Why `totalTime + n + 1`?

Suppose:

```text
n = 2
```

Run task at:

```text
time = 5
```

Need:

```text
6
7
```

as cooldown.

Task becomes available again at:

```text
8
```

Formula:

```java
time + n + 1
```

---

# Common Mistakes

## Forgetting Idle Time

Wrong:

Increase time only when a task executes.

Correct:

Every loop iteration represents one unit of CPU time.

Always:

```java
totalTime++;
```

---

## Using FIFO Instead Of Max Heap

Running tasks in insertion order can create unnecessary idle periods.

Always prioritise:

```text
Highest remaining frequency.
```

---

## Releasing Tasks Too Early

Task becomes available at:

```java
currentTime + n + 1
```

not:

```java
currentTime + n
```

---

## Forgetting To Decrease Frequency

After executing:

```text
A -> 5
```

it becomes:

```text
A -> 4
```

before entering cooldown.

---

# Related Problems

This scheduling pattern appears in:

* Design Twitter
* CPU Scheduling
* Process Scheduling
* Meeting Rooms
* Single-Threaded CPU

---

# Interview Explanation

> "I count the frequency of every task and store the remaining frequencies in a max heap so I can always execute the most frequent available task. After execution, if the task still has remaining occurrences, I place it into a cooldown queue along with the time it becomes available again. Every iteration represents one unit of CPU time, allowing idle intervals naturally. This greedy simulation produces the minimum schedule length while running in O(T) time because there are only 26 task types."
