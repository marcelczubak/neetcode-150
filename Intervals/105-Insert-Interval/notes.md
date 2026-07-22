# Insert Interval Notes

## Pattern

Intervals

Common interview pattern:

```
Sorted intervals
```

---

# Main Insight

Because the intervals are already:

- sorted
- non-overlapping

there are only **three possibilities** for every interval.

```
                newInterval

        BEFORE
            |
            |
      OVERLAP
            |
            |
         AFTER
```

Thinking in these three cases greatly simplifies the problem.

---

# Three Cases

## 1. Before

Condition

```java
currentEnd < newInterval[0]
```

Example

```text
current      [1,2]

new               [5,7]
```

Action

```java
result.add(current);
```

---

## 2. After

Condition

```java
currentStart > newInterval[1]
```

Example

```text
new          [2,4]

current             [6,8]
```

Action

```java
result.add(newInterval);

add remaining intervals

break;
```

Once we reach an interval after the new one, every later interval is also after it because the input is sorted.

---

## 3. Overlap

Otherwise:

```
current overlaps newInterval
```

Example

```text
current

      [3,6]

new

         [5,8]
```

Merge

```java
newInterval[0] =
    Math.min(newInterval[0], currentStart);

newInterval[1] =
    Math.max(newInterval[1], currentEnd);
```

Notice that we **expand** the interval rather than creating a new one.

---

# Why update newInterval directly?

Instead of

```java
newStart
newEnd
```

you can simply modify

```java
newInterval[0]

newInterval[1]
```

This keeps the merge logic concise.

---

# Why only one pass?

Suppose we've reached:

```
currentStart > newInterval[1]
```

Because the intervals are sorted:

```
every remaining interval is also after newInterval
```

Therefore:

```
insert new interval

append remaining intervals

stop
```

---

# Common Mistakes

## Forgetting the final insertion

Example

```text
intervals = [[1,2]]

new = [5,6]
```

Loop finishes without inserting.

Need

```java
if (!inserted)
    result.add(newInterval);
```

---

## Comparing neighbours

Don't compare

```
current
next
```

The problem only asks about the relationship between

```
current

and

newInterval
```

---

## Creating merged intervals repeatedly

Avoid

```java
new int[]{...}
```

every merge.

Simply expand

```java
newInterval
```

until all overlaps have been processed.

---

# Complexity

Time

```
O(n)
```

Space

```
O(n)
```

---

# Interview Explanation

"The intervals are already sorted and non-overlapping, so each interval must either come before the new interval, overlap it, or come after it. I iterate once, merge any overlapping intervals into the new interval, insert it at the correct position, and then append the remaining intervals."

---

# Pattern Recognition

When you see:

- sorted intervals
- merge intervals
- insert interval
- meeting rooms

think:

```
Single pass over sorted intervals
```

with the three-case approach:

```
Before

Overlap

After
```