# Reverse Integer

## Problem

Given a signed 32-bit integer `x`, reverse its digits.

If reversing the integer causes it to overflow the signed 32-bit integer range:

```
[-2³¹, 2³¹ - 1]
```

return:

```
0
```

You may not use a 64-bit integer (`long`) to solve the problem.

---

## Example

### Input

```text
123
```

### Output

```text
321
```

---

### Input

```text
-123
```

### Output

```text
-321
```

---

### Input

```text
120
```

### Output

```text
21
```

Leading zeros disappear naturally.

---

# Approach

## Digit Extraction

Build the reversed number one digit at a time.

Repeatedly:

1. Extract the last digit.
2. Append it to the result.
3. Remove the last digit from the original number.

---

# Algorithm

### Step 1

Extract the last digit.

```java
int digit = x % 10;
```

Example:

```
123

↓

3
```

For negative numbers:

```
-123 % 10

↓

-3
```

Java handles negative modulo correctly.

---

### Step 2

Check for overflow.

Before computing:

```java
result = result * 10 + digit;
```

verify that multiplying by 10 would still remain within the 32-bit integer range.

If not:

```
return 0;
```

---

### Step 3

Append the digit.

```java
result = result * 10 + digit;
```

Example:

```
result = 43

digit = 2

↓

432
```

---

### Step 4

Remove the processed digit.

```java
x /= 10;
```

Example:

```
123

↓

12
```

Repeat until:

```java
x == 0
```

---

# Overflow Detection

Overflow must be detected **before** multiplication.

Maximum integer:

```
2147483647
```

Minimum integer:

```
-2147483648
```

If:

```
result > MAX / 10
```

then:

```
result * 10
```

would already overflow.

When:

```
result == MAX / 10
```

the final digit may not exceed:

```
7
```

Likewise:

```
result == MIN / 10
```

requires:

```
digit >= -8
```

Otherwise overflow occurs.

---

# Example Walkthrough

Input:

```
1234
```

Iteration 1:

```
digit = 4

result = 4

x = 123
```

Iteration 2:

```
digit = 3

result = 43

x = 12
```

Iteration 3:

```
digit = 2

result = 432

x = 1
```

Iteration 4:

```
digit = 1

result = 4321

x = 0
```

Return:

```
4321
```

---

# Why This Works

Each iteration removes one digit from the original number and appends it to the reversed result.

The overflow check guarantees that the multiplication by 10 is always safe before it is performed.

Negative numbers require no special handling because Java's `%` and `/` operators naturally preserve the sign.

---

# Complexity

Let:

```
d = number of digits
```

## Time Complexity

One iteration per digit.

```
O(d)
```

Since:

```
d = log₁₀(n)
```

the complexity is:

```
O(log n)
```

---

## Space Complexity

Only a few integer variables are used.

```
O(1)
```

---

# Pattern Recognition

When you see:

- reverse digits
- repeated digit extraction
- overflow constraints

Think:

```
Modulo

+

Integer Division

+

Overflow Detection Before Arithmetic
```

---

# Related Problems

- Palindrome Number
- String to Integer (atoi)
- Plus One
- Add Two Numbers