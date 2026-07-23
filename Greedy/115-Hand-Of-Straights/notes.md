# Hand of Straights Notes

## Pattern

- Greedy
- Sorting
- Frequency Counting
- HashMap

---

## Core Idea

Always start a group with the smallest unused card.

Why?

Because if the smallest card is not used now, there is no future group it can belong to.

---

## Data Structures

### Frequency Map

Stores how many copies of each card remain.

Example:

```
hand:

[1,2,2,3,3,4]
```

Map:

```
1 -> 1
2 -> 2
3 -> 2
4 -> 1
```

When a card is used:

```java
freqMap.put(card, freqMap.get(card)-1);
```

---

### Sorted Array

Sorting gives cards in increasing order:

```
1 2 2 3 3 4
```

This allows us to always find the smallest available card.

---

## Algorithm

1. Sort hand.

2. Build frequency map.

3. Iterate through sorted cards.

For every card:

```java
if(freqMap.get(card) == 0)
    continue;
```

It has already been used.

---

4. Start a group:

Example:

```
card = 2
groupSize = 3
```

Need:

```
2,3,4
```

Loop:

```java
for(int i = card; i < card + groupSize; i++)
```

---

5. Validate every required card.

If:

```java
!freqMap.containsKey(i)
```

or:

```java
freqMap.get(i) == 0
```

then a valid group cannot be formed.

Return:

```
false
```

---

6. Decrement frequencies.

After using:

```
2,3,4
```

reduce:

```
2 -> 0
3 -> 0
4 -> 0
```

---

## Example

Input:

```
[1,2,2,3,3,4]
groupSize = 3
```

Start:

```
1
```

Create:

```
1,2,3
```

Remaining:

```
2,3,4
```

Create:

```
2,3,4
```

Remaining:

```
none
```

Return:

```
true
```

---

## Important Invariant

The frequency map represents:

```
number of unused cards remaining
```

Not:

```
number of cards originally present
```

---

## Why We Don't Need a Used Array

A boolean array would track individual cards:

```
used[0] = true
```

but duplicates make this inefficient.

The frequency map naturally handles duplicates:

```
2 -> 3
```

means three copies of card `2` remain.

---

## Greedy Proof

Suppose:

```
smallest available card = x
```

Every group must contain consecutive values.

If we don't use `x` now:

- another group must start with a larger value
- there is no way to insert `x` later without breaking consecutiveness

Therefore:

```
smallest available card must start the next group
```

---

## Common Mistakes

### Forgetting duplicates

Wrong:

```text
Use a Set
```

because:

```
[1,2,2,3]
```

contains duplicate cards.

Need:

```
HashMap<Integer,Integer>
```

---

### Starting groups randomly

Wrong:

```
Start with any card
```

Correct:

```
Always start with smallest unused card
```

---

### Not decrementing frequencies

Without:

```java
freqMap.put(card, freqMap.get(card)-1);
```

cards would be reused multiple times.

---

## Complexity

Sorting:

```
O(n log n)
```

Grouping:

```
O(n * groupSize)
```

Space:

```
O(n)
```

---

## Interview Explanation

"I sort the cards so I can always process the smallest available card first. I maintain a frequency map representing how many copies remain. For every unused card, I greedily make it the start of a group and decrement the frequencies of the required consecutive cards. If any required card is missing, the grouping is impossible. Sorting dominates the runtime, and the algorithm uses O(n) extra space for the frequency map."

---

## Key Takeaway

The trick is:

```
Sorted order tells us WHERE to start.
Frequency map tells us WHAT is still available.
```

Together they avoid needing to explicitly track individual cards.