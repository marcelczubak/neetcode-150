# Partition Labels

## Problem

You are given a string `s`.

Partition the string into as many parts as possible such that each letter appears in **at most one partition**.

Return a list containing the size of each partition.

---

## Example

### Input

```text
s = "ababcbacadefegdehijhklij"
```

### Output

```text
[9,7,8]
```

### Explanation

The partitions are:

```text
ababcbaca
defegde
hijhklij
```

Every character appears in exactly one partition.

---

# Approach

## Greedy + Last Occurrence

The key observation is:

> Every partition must contain the **last occurrence** of every character inside it.

Therefore:

1. Record the last index of every character.
2. Traverse the string from left to right.
3. Continuously extend the current partition until every character seen so far has had its final occurrence included.

---

# Algorithm

### Step 1

Record the last occurrence of every character.

Example:

```
s = "abac"
```

Store:

```
a -> 2
b -> 1
c -> 3
```

Using:

```java
int[] lastIndex = new int[26];
```

---

### Step 2

Maintain two pointers:

```
start
```

Beginning of current partition.

```
end
```

Furthest index the current partition must reach.

Initially:

```
start = 0
end = 0
```

---

### Step 3

Iterate through the string.

For each character:

```java
end = Math.max(end, lastIndex[currentChar]);
```

If a character appears later in the string, the partition must be extended.

---

### Step 4

Whenever:

```java
i == end
```

all characters seen so far have had their final occurrence included.

The current partition is complete.

Partition size:

```java
end - start + 1
```

Then begin the next partition:

```java
start = end + 1;
```

---

# Example Walkthrough

Input:

```
ababcbacadefegdehijhklij
```

Last occurrences:

```
a -> 8
b -> 5
c -> 7
...
```

Traverse:

```
i = 0

end = 8
```

Continue scanning.

Indices:

```
1
2
3
...
8
```

When:

```
i == 8
```

the first partition is complete.

Size:

```
8 - 0 + 1 = 9
```

Start next partition:

```
start = 9
```

Repeat until the end of the string.

Result:

```
[9,7,8]
```

---

# Why Greedy Works

Whenever we encounter a character, we know exactly where its final occurrence is.

If a character appears again later, the partition **must** extend to include it.

Therefore the earliest valid place to cut is exactly when:

```
current index == furthest last occurrence
```

Cutting earlier would split a character across partitions.

Cutting later only creates fewer partitions.

Thus this greedy strategy always produces the maximum number of valid partitions.

---

# Complexity

Let:

```
n = length of string
```

## Time Complexity

Building last occurrence array:

```
O(n)
```

Traversing the string:

```
O(n)
```

Total:

```
O(n)
```

---

## Space Complexity

Last occurrence array:

```
26 integers
```

Therefore:

```
O(1)
```

(extra space)

---

# Pattern Recognition

When you see:

- last occurrence of elements
- partitioning
- maximize number of segments
- greedy boundary expansion

Think:

```
Greedy + Last Occurrence Tracking
```

---

# Related Problems

- Merge Intervals
- Jump Game
- Gas Station
- Hand of Straights
- Merge Triplets to Form Target Triplet