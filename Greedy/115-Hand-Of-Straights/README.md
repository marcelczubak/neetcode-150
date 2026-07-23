# Hand of Straights

## Problem

You are given an integer array `hand`, where each value represents a card.

Return `true` if the cards can be rearranged into groups of consecutive cards of size `groupSize`.

Each card must be used exactly once.

---

## Example

### Input

```text
hand = [1,2,3,6,2,3,4,7,8]
groupSize = 3
```

### Output

```text
true
```

### Explanation

The cards can be split into:

```text
[1,2,3]

[2,3,4]

[6,7,8]
```

Each group contains consecutive values of length `3`.

---

## Approach

### Greedy + Sorting + Frequency Map

The key observation:

> The smallest available card must always be the start of the next group.

Because groups must contain consecutive cards, we cannot skip a smaller unused card and start a group later.

To efficiently track which cards are still available:

- Sort the hand.
- Store frequencies of each card using a HashMap.
- Iterate through cards in sorted order.
- Whenever a card still has remaining copies, use it as the start of a new group.

---

## Algorithm

1. Sort the cards:

```java
Arrays.sort(hand);
```

This allows us to process cards from smallest to largest.

---

2. Count card frequencies:

Example:

```
hand = [1,2,2,3,3,4]
```

Frequency map:

```
1 -> 1
2 -> 2
3 -> 2
4 -> 1
```

---

3. Iterate through the sorted cards.

If:

```java
freqMap.get(card) == 0
```

the card has already been used in previous groups.

Skip it.

---

4. Start a new group.

For every required consecutive card:

```
card
card + 1
card + 2
...
card + groupSize - 1
```

check that the card exists.

Example:

Starting from:

```
2
```

with:

```
groupSize = 3
```

we need:

```
2,3,4
```

---

5. Decrease frequencies after using cards.

Example:

Before:

```
2 -> 2
3 -> 2
4 -> 1
```

After creating:

```
[2,3,4]
```

we get:

```
2 -> 1
3 -> 1
4 -> 0
```

A frequency of zero means all copies have already been assigned.

---

## Example Walkthrough

Input:

```
[1,2,2,3,3,4]
groupSize = 3
```

Frequency:

```
1:1
2:2
3:2
4:1
```

Start at `1`:

Need:

```
1,2,3
```

Update:

```
1:0
2:1
3:1
4:1
```

---

Next available card:

```
2
```

Need:

```
2,3,4
```

Update:

```
1:0
2:0
3:0
4:0
```

All cards used.

Return:

```
true
```

---

## Why Greedy Works

The smallest available card cannot belong to a later group.

Example:

Remaining cards:

```
[2,3,4,5]
```

If we ignore `2` and start with `3`, then `2` can never be placed because every group requires consecutive ordering.

Therefore the smallest unused card must start the next group.

---

## Complexity

### Sorting

```
O(n log n)
```

---

### Processing

Each card is processed once, and each card is removed from the frequency map:

```
O(n * groupSize)
```

In the worst case:

```
O(n²)
```

when `groupSize` is large.

---

### Total Complexity

```
Time: O(n log n + n * groupSize)
```

### Space:

```
O(n)
```

for the frequency map.

---

## Pattern Recognition

When you see:

- grouping consecutive values
- duplicates
- every element must be used
- need smallest valid ordering

Think:

```
Greedy + Sorting + Frequency Map
```

---

## Related Problems

- Merge Intervals
- Task Scheduler
- Partition Labels
- Top K Frequent Elements