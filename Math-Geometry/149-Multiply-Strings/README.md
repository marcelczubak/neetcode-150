# Multiply Strings

## Problem

Given two non-negative integers represented as strings `num1` and `num2`, return their product as a string.

You **may not**:

- convert the strings directly to integers
- use any built-in BigInteger library

The multiplication must be performed manually.

---

## Example

### Input

```text
num1 = "123"
num2 = "45"
```

### Output

```text
5535
```

Explanation:

```text
      123
   ×   45
   -------
      615
     4920
   -------
     5535
```

---

# Approach

## Simulate Grade-School Multiplication

Perform multiplication exactly as done by hand.

For every digit in `num1`:

- Multiply it with every digit in `num2`
- Add the product into the correct position
- Handle carries immediately

Instead of building partial strings, maintain an integer array that represents the final number.

---

# Key Observation

If:

```
num1.length() = m

num2.length() = n
```

the largest possible answer contains:

```
m + n
```

digits.

Example:

```text
999 × 999 = 998001
```

3-digit × 3-digit produces at most 6 digits.

Therefore allocate:

```java
int[] result = new int[m + n];
```

---

# Digit Positions

Suppose:

```text
num1 index = i

num2 index = j
```

The product contributes to two positions:

```java
int p2 = i + j + 1;
int p1 = i + j;
```

where:

- `p2` stores the current digit
- `p1` stores the carry

---

# Algorithm

### Step 1

Iterate through both numbers from right to left.

```java
for (int i = num1.length() - 1; i >= 0; i--)
```

```java
for (int j = num2.length() - 1; j >= 0; j--)
```

---

### Step 2

Convert characters into digits.

```java
digit = char - '0'
```

---

### Step 3

Multiply the digits.

```java
product = digit1 * digit2;
```

---

### Step 4

Add any value already stored at that position.

```java
product += result[p2];
```

Multiple digit multiplications may contribute to the same decimal place.

---

### Step 5

Split into carry and ones digit.

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

### Step 6

Convert the result array into a string.

Skip only the leading zeros.

If every digit is zero:

```text
return "0"
```

---

# Example Walkthrough

Multiply:

```text
123 × 45
```

Result array:

```text
_ _ _ _ _
```

Multiply:

```text
3 × 5 = 15
```

Store:

```text
carry -> previous position

5 -> current position
```

Later:

```text
2 × 5
```

adds to the same decimal place.

Instead of overwriting:

```java
product += result[p2];
```

accumulates the previous value.

Continue until every digit pair has been processed.

Final array:

```text
0 5 5 3 5
```

Ignoring the leading zero:

```text
5535
```

---

# Why This Works

Every pair of digits contributes to exactly one decimal place.

The carry naturally propagates one position to the left.

Because every multiplication updates the shared result array, overlapping contributions are accumulated correctly.

This perfectly simulates manual multiplication.

---

# Complexity

Let:

```
m = num1.length()

n = num2.length()
```

## Time Complexity

Every pair of digits is multiplied once.

```
O(m × n)
```

---

## Space Complexity

The result array stores at most:

```
m + n
```

digits.

```
O(m + n)
```

---

# Pattern Recognition

When you see:

- multiplication of huge numbers
- strings instead of integers
- no BigInteger allowed

Think:

```
Grade-School Multiplication

+

Digit Simulation
```

---

# Related Problems

- Add Strings
- Plus One
- Reverse Integer
- String to Integer (atoi)