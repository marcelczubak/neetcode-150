# Partition Labels Notes

## Pattern

- Greedy
- Last Occurrence
- Boundary Expansion

---

# Core Insight

A partition cannot end until **every character inside it has appeared for the last time**.

Therefore we first compute:

```
last occurrence of every character
```

---

# Data Structure

```java
int[] lastIndex = new int[26];
```

Maps:

```
character

↓

last index
```

Example:

```
abac
```

Produces:

```
a -> 2
b -> 1
c -> 3
```

---

# Greedy Boundary

Maintain:

```
start
```

Beginning of current partition.

```
end
```

Furthest position that must be included.

Initially:

```
start = 0
end = 0
```

---

# Updating the Boundary

For every character:

```java
end = Math.max(end, lastIndex[currentChar]);
```

The partition expands whenever a character appears later.

---

# When Can We Cut?

Whenever:

```java
i == end
```

every character seen so far has had its final occurrence included.

Partition size:

```java
end - start + 1
```

Move to next partition:

```java
start = end + 1;
```

---

# Example

```
ababcbaca
```

Last occurrences:

```
a -> 8
b -> 5
c -> 7
```

Process:

```
i=0

end=8
```

Continue until:

```
i=8
```

Partition:

```
ababcbaca
```

Size:

```
9
```

---

# Why Greedy Works

Suppose a character's last occurrence is at index:

```
15
```

The partition **must** include index 15.

Ending before 15 would place the same character into two different partitions.

Therefore:

```
end always equals the furthest last occurrence seen so far
```

---

# Common Mistakes

## Forgetting last occurrences

Knowing only the first occurrence is not enough.

The partition depends entirely on the last occurrence.

---

## Cutting too early

Wrong:

```
Current character finished
```

Correct:

```
All characters seen so far have finished.
```

---

## Using a HashMap

Characters are limited to:

```
'a' to 'z'
```

An array is faster:

```java
int[] lastIndex = new int[26];
```

---

# Complexity

Time:

```
O(n)
```

Space:

```
O(1)
```

---

# Interview Explanation

"I first record the last occurrence of every character. Then I scan the string while maintaining the furthest last occurrence among all characters seen so far. This determines the earliest point where the current partition can end. Whenever the current index reaches that boundary, all characters in the partition are complete, so I record its length and begin a new partition."

---

# Key Takeaway

The partition boundary is determined by:

```
the furthest last occurrence
```

not by the current character.

Every character extends the current partition only if its final occurrence lies further to the right.