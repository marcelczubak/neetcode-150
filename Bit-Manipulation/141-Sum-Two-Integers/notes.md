# Sum of Two Integers Notes

## Pattern

- Bit Manipulation
- Binary Addition

---

# Core Idea

Perform addition exactly as a processor does.

For every bit:

```text
Read Bits

↓

Compute Sum Bit

↓

Compute Carry

↓

Write Result Bit
```

No arithmetic operators are required.

---

# Extracting Bits

For bit position:

```java
i
```

Use:

```java
(bit >> i) & 1
```

Example:

```text
101100
```

Shift:

```text
>> 2
```

Result:

```text
001011
```

Mask:

```java
& 1
```

Leaves only the least significant bit.

---

# Sum Bit

The current bit of the answer is:

```java
bitA ^ bitB ^ carry
```

XOR behaves exactly like binary addition without carrying.

Truth table:

```text
0 ^ 0 = 0

0 ^ 1 = 1

1 ^ 0 = 1

1 ^ 1 = 0
```

---

# Carry

A carry is generated whenever at least **two** of the three inputs are `1`.

Formula:

```java
(bitA & bitB)

|

(bitA & carry)

|

(bitB & carry)
```

This is the binary equivalent of checking whether the majority of inputs are `1`.

---

# Writing the Bit

Move the computed bit back into position:

```java
xor << i
```

Insert it:

```java
result |= (xor << i);
```

Previously written bits remain unchanged.

---

# Example

Add:

```text
5 + 3
```

Binary:

```text
0101

0011
```

Bit 0:

```text
1 ^ 1 = 0

carry = 1
```

Bit 1:

```text
0 ^ 1 ^ 1 = 0

carry = 1
```

Continue until every bit has been processed.

Answer:

```text
1000

↓

8
```

---

# Why Iterate 32 Times?

A Java `int` always contains:

```text
32 bits
```

This naturally handles:

- positive numbers
- negative numbers
- two's complement representation

No special handling is required.

---

# Common Mistakes

## Ignoring Carry

Using only:

```java
bitA ^ bitB
```

fails whenever:

```text
1 + 1
```

produces:

```text
10
```

Carry must be propagated.

---

## Using Arithmetic Operators

The challenge specifically forbids:

```text
+

-
```

The solution must rely entirely on bit operations.

---

## Forgetting to Shift the Result Bit

The computed XOR belongs at position:

```java
i
```

Remember:

```java
xor << i
```

before inserting it into the result.

---

# Interview Explanation

"I simulate binary addition one bit at a time. For each bit position, I extract the corresponding bits from both integers, compute the sum bit using XOR, and compute the carry using bitwise AND. I then place the sum bit into the result and continue propagating the carry across all 32 bits. This mirrors exactly how binary addition is implemented in hardware."

---

# Complexity

Time:

```text
O(32)

=

O(1)
```

Space:

```text
O(1)
```

---

# Alternative Solution

A more common iterative solution repeatedly computes:

```java
sum = a ^ b;
carry = (a & b) << 1;
```

Then updates:

```java
a = sum;
b = carry;
```

until:

```java
carry == 0
```

Both approaches have:

```text
O(1)
```

time complexity.

---

# Key Takeaway

Binary addition consists of two completely independent operations:

```text
Sum Bit

↓

XOR
```

and

```text
Carry

↓

AND
```

By processing all 32 bits individually, the algorithm reconstructs integer addition without ever using the `+` operator.