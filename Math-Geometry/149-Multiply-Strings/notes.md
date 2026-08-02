# Multiply Strings Notes

## Pattern

- Simulation
- Math
- Arrays

---

# Core Idea

Treat each string as a sequence of digits.

Perform multiplication exactly as done on paper.

For every digit:

```
Multiply

↓

Add existing value

↓

Store ones digit

↓

Carry left
```

---

# Result Array

Allocate:

```java
int[] result = new int[m + n];
```

Maximum possible digits:

```
m + n
```

Example:

```text
999 × 999

↓

998001
```

---

# Digit Extraction

Characters become integers using:

```java
digit = num.charAt(i) - '0';
```

Example:

```text
'7' - '0'

↓

7
```

---

# Position Mapping

For:

```java
num1[i]

num2[j]
```

the product belongs to:

```java
p2 = i + j + 1;
```

The carry belongs to:

```java
p1 = i + j;
```

Visualisation:

```text
      1 2 3
        ↑

        4 5
          ↑

Result:

_ _ _ _ _
```

Each multiplication contributes to two adjacent positions.

---

# Existing Value

Different digit pairs may contribute to the same position.

Always accumulate:

```java
product += result[p2];
```

Never overwrite.

Example:

```text
123

×

45
```

Both:

```text
2 × 5
```

and

```text
3 × 4
```

contribute to the tens place.

---

# Carry

Split the product:

```java
carry = product / 10;

digit = product % 10;
```

Store:

```java
result[p2] = digit;

result[p1] += carry;
```

---

# Building the Answer

Skip only the leading zeros.

Wrong:

```java
if(num != 0)
```

This removes zeros inside the answer.

Correct approach:

- Ignore zeros until the first non-zero digit.
- Append every digit afterwards.

Special case:

```text
0 × anything

↓

"0"
```

---

# Why m + n Digits?

Largest possible product:

```text
99 × 99

↓

9801
```

2 digits × 2 digits produces 4 digits.

In general:

```
m + n
```

is always sufficient.

---

# Common Mistakes

## Converting to Integer

Fails for very large numbers.

The strings may exceed any primitive numeric type.

---

## Forgetting Existing Values

Wrong:

```java
product = digit1 * digit2;
```

Correct:

```java
product += result[p2];
```

because several multiplications share the same position.

---

## Incorrect Position Formula

Remember:

```java
p2 = i + j + 1;

p1 = i + j;
```

These are the standard mappings for grade-school multiplication.

---

## Removing Every Zero

Only leading zeros should be skipped.

Zeros inside the answer are significant.

Example:

```text
105
```

must remain:

```text
105
```

not:

```text
15
```

---

# Interview Explanation

"I simulate the same multiplication process used by hand. I iterate over every pair of digits from right to left, multiply them, and place the result into an integer array representing the final product. Each multiplication contributes to two adjacent positions: one for the current digit and one for the carry. Since multiple digit pairs may contribute to the same position, I first add any existing value before computing the carry and remainder. Finally, I convert the result array into a string while skipping only the leading zeros."

---

# Complexity

Time:

```
O(m × n)
```

Space:

```
O(m + n)
```

---

# Key Takeaway

The most important insight is the position mapping:

```java
p2 = i + j + 1;

p1 = i + j;
```

Every digit multiplication contributes to these two positions. Once this mapping is understood, the remainder of the algorithm is simply a direct simulation of manual multiplication.