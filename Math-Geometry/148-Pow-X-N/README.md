# Pow(x, n)

## Problem

Implement the function:

```text
pow(x, n)
```

which computes:

```
xⁿ
```

where:

- `x` is a floating-point number.
- `n` is a signed integer.

If `n` is negative:

```
x⁻ⁿ = 1 / xⁿ
```

The algorithm should run in logarithmic time.

---

## Example

### Input

```text
x = 2.0

n = 10
```

### Output

```text
1024.0
```

---

### Input

```text
x = 2.0

n = -2
```

### Output

```text
0.25
```

because:

```
2⁻² = 1 / 4
```

---

# Approach

## Exponentiation by Squaring

Instead of multiplying:

```
x

×

x

×

x

...

n times
```

observe:

```
x⁸

=

(x⁴)²
```

Similarly:

```
x⁴

=

(x²)²
```

Each recursive call halves the exponent.

---

# Key Observation

If:

```
n
```

is even:

```
xⁿ

=

(x^(n/2))²
```

If:

```
n
```

is odd:

```
xⁿ

=

x × (x^((n-1)/2))²
```

Only one additional multiplication by `x` is needed.

---

# Algorithm

### Step 1

Handle base cases.

```java
n == 0
```

Return:

```
1
```

because:

```
x⁰ = 1
```

---

### Step 2

Compute:

```java
half = myPow(x, n / 2);
```

---

### Step 3

Square the result.

```java
half * half
```

---

### Step 4

If the exponent is odd:

```java
result *= x;
```

---

### Step 5

If the original exponent was negative:

```java
1 / result
```

Otherwise:

```
result
```

---

# Example Walkthrough

Compute:

```
2¹⁰
```

```
2¹⁰

↓

(2⁵)²
```

```
2⁵

↓

2 × (2²)²
```

```
2²

↓

(2¹)²
```

```
2¹

↓

2
```

Build back up:

```
2

↓

4

↓

32

↓

1024
```

Only four recursive calls are required.

---

# Why This Works

Each recursive call halves the exponent.

Instead of performing:

```
n
```

multiplications,

the algorithm performs only:

```
log₂ n
```

recursive calls.

This makes exponentiation dramatically faster.

---

# Complexity

Let:

```
n = exponent
```

## Time Complexity

Each recursive call halves the exponent.

```
O(log n)
```

---

## Space Complexity

Recursive depth:

```
O(log n)
```

---

# Pattern Recognition

When you see:

- exponentiation
- repeated multiplication
- divide by two

Think:

```
Divide and Conquer

+

Exponentiation by Squaring
```

---

# Related Problems

- Sqrt(x)
- Reverse Integer
- Multiply Strings
- Fast Fibonacci