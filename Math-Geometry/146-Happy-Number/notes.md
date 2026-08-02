# Happy Number Notes

## Pattern

- Simulation
- HashSet
- Cycle Detection

---

# Core Idea

Repeatedly replace the number with:

```
sum of the squares of its digits
```

Eventually one of two things happens:

```
Reach 1

or

Enter a cycle
```

---

# Cycle Detection

Maintain:

```java
Set<Integer> visited;
```

Before computing the next number:

```java
visited.add(n);
```

If:

```java
visited.contains(n)
```

becomes true, the sequence has already been seen.

The process will repeat forever.

---

# Main Loop

Continue while:

```java
n != 1
```

and

```java
!visited.contains(n)
```

When the loop finishes:

```java
return n == 1;
```

---

# Computing the Next Number

Extract every digit.

Square it.

Accumulate the total.

Example:

```text
82
```

Digits:

```text
8

2
```

Squares:

```text
64

4
```

Result:

```text
68
```

---

# Example

```
19
```

Sequence:

```text
19

↓

82

↓

68

↓

100

↓

1
```

Answer:

```
true
```

---

Example of a cycle:

```
2

↓

4

↓

16

↓

37

↓

58

↓

89

↓

145

↓

42

↓

20

↓

4
```

The value:

```
4
```

appears again.

The sequence will repeat forever.

---

# Why a HashSet?

Without remembering previous values:

```text
4

↓

16

↓

37

↓

58

↓

89

↓

145

↓

42

↓

20

↓

4
```

the algorithm would never terminate.

The HashSet detects the first repeated value immediately.

---

# Your Digit Extraction

Your helper repeatedly removes the last digit using integer arithmetic.

Conceptually:

```text
digit = n % 10

↓

result += digit²

↓

n /= 10
```

Your implementation achieves the same using:

```java
Math.floorDiv()
```

and subtraction to obtain the remainder.

Although correct, using `%` and `/` is more common and easier to read in interviews.

---

# Common Mistakes

## Forgetting Cycle Detection

Without a HashSet:

```java
while(n != 1)
```

may loop forever.

---

## Using Strings

Converting the number into a string works, but integer arithmetic is more efficient and is generally preferred.

---

## Assuming Every Number Reaches 1

Many numbers enter a repeating cycle instead.

Cycle detection is required.

---

# Interview Explanation

"I repeatedly replace the number with the sum of the squares of its digits. Since the sequence can either reach 1 or enter a cycle, I store every previously seen value in a HashSet. If the current number has already been visited, I know the process will repeat forever and return false. If the sequence reaches 1, I return true."

---

# Complexity

Time:

```
O(log n)
```

per digit-sum computation.

Overall effectively constant for 32-bit integers.

Space:

```
O(log n)
```

for the visited values, though also effectively constant.

---

# Possible Optimisation

Instead of using a `HashSet`, cycle detection can be performed with **Floyd's Tortoise and Hare Algorithm**.

Maintain:

- a slow pointer (one transformation)
- a fast pointer (two transformations)

If they ever meet before reaching `1`, a cycle exists.

This reduces the extra space to:

```
O(1)
```

---

# Key Takeaway

The important insight is not computing the digit squares.

The key observation is that the process forms a sequence of states:

```
Current Number

↓

Next Number

↓

Next Number
```

Since a state can repeat, the problem becomes one of **cycle detection**, making a `HashSet` (or Floyd's algorithm) the natural solution.