# Reverse Bits Notes

## Pattern

- Bit Manipulation
- Bit Masking

---

# Core Idea

Process every bit independently.

For each bit:

1. Read it.
2. Move it to its mirrored position.
3. Store it in the result.

---

# Extract a Bit

Use:

```java
(n >> i) & 1
```

The shift moves bit `i` to the least significant position.

The mask:

```java
& 1
```

removes every other bit.

Possible values:

```
0

or

1
```

---

# Reverse Position

Original position:

```
i
```

New position:

```
31 - i
```

Example:

```
Bit 0

↓

Bit 31
```

```
Bit 5

↓

Bit 26
```

```
Bit 31

↓

Bit 0
```

---

# Insert into Result

Use:

```java
res |= (bit << (31 - i));
```

The left shift moves the bit into its destination.

The bitwise OR inserts it without affecting previously written bits.

---

# Example

Suppose:

```text
000...0101
```

Extract:

```
Bit 0 = 1
```

Move:

```
↓

Bit 31
```

Result:

```
1000...0000
```

Continue for every remaining bit.

---

# Why OR?

Suppose:

```
Result:

10010000
```

New bit:

```
00000100
```

Applying:

```java
result |= newBit;
```

produces:

```
10010100
```

Previously written bits remain unchanged.

---

# Why Iterate 32 Times?

A Java `int` always contains:

```
32 bits
```

Even if the value is small.

Negative numbers also work because their two's complement representation still consists of 32 bits.

---

# Common Mistakes

## Forgetting the Mask

Wrong:

```java
n >> i
```

This leaves all higher bits.

Always isolate the target bit:

```java
(n >> i) & 1
```

---

## Using Addition Instead of OR

Bitwise OR is the natural way to place bits.

```java
res |= shiftedBit;
```

clearly expresses the intent of setting a bit.

---

## Incorrect Destination

Remember:

```
0

↓

31
```

The destination index is:

```java
31 - i
```

not:

```java
32 - i
```

---

# Interview Explanation

"I iterate through all 32 bit positions. For each position, I extract the corresponding bit by right shifting and masking with 1. I then shift that bit into its mirrored position in the result and use bitwise OR to set it. After processing all 32 bits, the result contains the reversed bit pattern."

---

# Complexity

Time:

```
O(32)

=

O(1)
```

Space:

```
O(1)
```

---

# Alternative Approach

Another common solution builds the answer from left to right:

```java
for (int i = 0; i < 32; i++) {
    res <<= 1;
    res |= (n & 1);
    n >>>= 1;
}
```

This repeatedly takes the least significant bit from `n` and appends it to the end of the result.

Both methods run in:

```
O(32)
```

---

# Key Takeaway

The fundamental mapping is:

```
Bit i

↓

Bit (31 - i)
```

The implementation naturally follows three simple operations:

```
Extract

↓

Shift

↓

OR
```

This is a classic bit manipulation pattern for rearranging bits within a fixed-width integer.