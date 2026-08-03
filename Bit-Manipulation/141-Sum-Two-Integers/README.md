# Sum of Two Integers

## Problem

Given two integers `a` and `b`, return their sum **without using** the operators:

- `+`
- `-`

The solution must rely only on bit manipulation.

---

## Example

### Input

```text
a = 1

b = 2
```

### Output

```text
3
```

---

### Input

```text
a = 2

b = 3
```

### Output

```text
5
```

---

### Input

```text
a = -2

b = 3
```

### Output

```text
1
```

---

# Approach

## Simulate Binary Addition

Instead of adding decimal digits, perform addition one binary bit at a time.

For every bit position:

1. Read the corresponding bit from both numbers.
2. Compute the resulting bit using XOR.
3. Compute the carry using bitwise AND.
4. Repeat for all 32 bits.

This is exactly how hardware performs binary addition.

---

# Binary Addition

Consider adding two bits:

```text
0 + 0 = 0

0 + 1 = 1

1 + 0 = 1

1 + 1 = 10
```

Notice:

- XOR produces the sum bit.
- AND determines whether a carry is generated.

When an incoming carry already exists, it must also be considered.

---

# Algorithm

### Step 1

Initialize:

```java
int result = 0;
int carry = 0;
```

---

### Step 2

Iterate through every bit.

```java
for (int i = 0; i < 32; i++)
```

---

### Step 3

Extract bit `i` from both numbers.

```java
bitA = (a >> i) & 1;

bitB = (b >> i) & 1;
```

---

### Step 4

Compute the current sum bit.

```java
xor = bitA ^ bitB ^ carry;
```

The XOR operation represents binary addition without carry.

---

### Step 5

Compute the next carry.

```java
carry =
(bitA & bitB)
|
(bitA & carry)
|
(bitB & carry);
```

A carry exists whenever at least two of the three bits are `1`.

---

### Step 6

Place the computed bit into the answer.

```java
result |= (xor << i);
```

---

# Example Walkthrough

Suppose:

```text
a = 5

↓

0101
```

```text
b = 3

↓

0011
```

Bit-by-bit:

```
Bit 0

1 + 1

↓

0

carry = 1
```

```
Bit 1

0 + 1 + carry

↓

0

carry = 1
```

```
Bit 2

1 + 0 + carry

↓

0

carry = 1
```

```
Bit 3

0 + 0 + carry

↓

1
```

Result:

```text
1000

↓

8
```

---

# Why This Works

Binary addition follows exactly the same rules regardless of the bit position.

Each iteration computes:

- one result bit
- one outgoing carry

Processing all 32 bits constructs the final integer.

---

# Complexity

A Java integer always contains exactly:

```text
32 bits
```

## Time Complexity

```
O(32)
```

which simplifies to:

```
O(1)
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

- addition without `+`
- binary arithmetic
- bit manipulation

Think:

```text
Bit-by-Bit Simulation

+

XOR

+

Carry
```

---

# Related Problems

- Reverse Bits
- Number of 1 Bits
- Single Number
- Missing Number