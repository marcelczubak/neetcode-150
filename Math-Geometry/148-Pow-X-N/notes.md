# Pow(x, n) Notes

## Pattern

- Divide and Conquer
- Recursion
- Exponentiation by Squaring

---

# Core Insight

Rather than multiplying:

```
x

×

x

×

...

n times
```

split the exponent in half.

Example:

```
2¹⁶

↓

(2⁸)²

↓

((2⁴)²)²
```

Each recursive call halves the remaining work.

---

# Recurrence

Even exponent:

```
xⁿ

=

(x^(n/2))²
```

Odd exponent:

```
xⁿ

=

x × (x^(n/2))²
```

The recursive call computes:

```java
half = myPow(x, n / 2);
```

Then:

```java
result = half * half;
```

If:

```java
n % 2 != 0
```

multiply once more by:

```java
x
```

---

# Example

Compute:

```
3⁵
```

```
3⁵

↓

3²

↓

3¹
```

Recursive returns:

```
3

↓

9

↓

81

↓

243
```

---

# Base Cases

If:

```java
n == 0
```

Return:

```
1
```

If:

```java
x == 0
```

Return:

```
0
```

---

# Negative Exponents

Remember:

```
x⁻ⁿ

=

1 / xⁿ
```

Compute the positive exponent first.

Invert the answer afterwards.

---

# Common Mistakes

## Linear Multiplication

Wrong:

```java
power(x, n-1)
```

This gives:

```
O(n)
```

Instead halve the exponent every recursion.

---

## Forgetting Odd Powers

Example:

```
2⁵
```

Squaring:

```
2²
```

only gives:

```
16
```

Need one additional multiplication:

```
16 × 2 = 32
```

---

## Integer.MIN_VALUE

This is the classic bug.

```java
Math.abs(Integer.MIN_VALUE)
```

still returns:

```
-2147483648
```

Convert to a `long` before taking the absolute value.

---

# Interview Explanation

"I use exponentiation by squaring. Instead of multiplying the base repeatedly, I recursively compute the power for half the exponent and square the result. If the exponent is odd, I multiply by the base one additional time. Each recursive call halves the exponent, giving a logarithmic time complexity. For negative exponents, I compute the positive power and return its reciprocal."

---

# Complexity

Time:

```
O(log n)
```

Space:

```
O(log n)
```

because of the recursive call stack.

---

# Key Takeaway

The important identity is:

```
xⁿ

=

(x^(n/2))²
```

Every recursive call halves the exponent, reducing the number of multiplications from:

```
O(n)

↓

O(log n)
```

This divide-and-conquer strategy is the optimal solution expected in coding interviews.