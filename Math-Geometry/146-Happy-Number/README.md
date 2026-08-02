# Happy Number

## Problem

A **happy number** is defined by the following process:

1. Replace the number with the sum of the squares of its digits.
2. Repeat the process.
3. If the number eventually becomes `1`, it is a happy number.
4. If the process enters a cycle that never reaches `1`, it is not happy.

Return `true` if the given integer is happy, otherwise return `false`.

---

## Example

### Input

```text
n = 19
```

### Output

```text
true
```

### Explanation

```
19

↓

1² + 9² = 82

↓

8² + 2² = 68

↓

6² + 8² = 100

↓

1² + 0² + 0² = 1
```

Since the sequence reaches `1`, the number is happy.

---

# Approach

## Simulation + HashSet

Repeatedly transform the number into the sum of the squares of its digits.

Two outcomes are possible:

- The sequence reaches `1`.
- The sequence enters a cycle.

To detect cycles efficiently, store every previously seen number in a `HashSet`.

If the same number appears again, the sequence will repeat forever.

---

# Algorithm

### Step 1

Create a set to store visited numbers.

```java
Set<Integer> visited = new HashSet<>();
```

---

### Step 2

While:

- the current number is not `1`
- the current number has not already been seen

continue the simulation.

```java
while (n != 1 && !visited.contains(n))
```

---

### Step 3

Record the current number.

```java
visited.add(n);
```

---

### Step 4

Replace the number with the sum of the squares of its digits.

```java
n = sumSquareDigits(n);
```

---

### Step 5

After the loop:

```java
return n == 1;
```

If the sequence ended because it reached `1`, the number is happy.

Otherwise, a cycle was detected.

---

# Computing the Sum of Squared Digits

Extract each digit from right to left.

For every digit:

```
digit²
```

is added to the running total.

Example:

```
82

↓

8² + 2²

↓

64 + 4

↓

68
```

---

# Example Walkthrough

Input:

```text
19
```

Visited:

```
{}
```

Process:

```
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

The sequence reaches `1`.

Answer:

```text
true
```

---

Another example:

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

The value `4` repeats.

A cycle has been detected.

Answer:

```text
false
```

---

# Why This Works

There are only finitely many possible sums of squared digits.

Eventually the sequence must either:

- reach `1`, or
- revisit a previously seen number.

The HashSet detects the repeated value immediately.

---

# Complexity

Let:

```
d = number of digits
```

Each transformation processes every digit once.

The number of distinct states is bounded, so the sequence length is effectively constant.

## Time Complexity

```
O(log n)
```

per transformation.

Overall, the algorithm runs in constant time for 32-bit integers.

---

## Space Complexity

The HashSet stores previously visited values.

```
O(log n)
```

in theory, though effectively constant for fixed-size integers.

---

# Pattern Recognition

When you see:

- repeatedly transform a value
- stop when reaching a target
- detect repeated states

Think:

```
Simulation

+

HashSet Cycle Detection
```

---

# Related Problems

- Linked List Cycle
- Floyd's Cycle Detection
- Add Digits
- Palindrome Number