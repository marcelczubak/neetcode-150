# Reverse Bits

## Problem

Reverse the bits of a given 32-bit unsigned integer.

The bit at position:

```
0
```

becomes:

```
31
```

The bit at position:

```
1
```

becomes:

```
30
```

and so on.

Return the reversed 32-bit integer.

---

## Example

### Input

```text
00000010100101000001111010011100
```

### Output

```text
00111001011110000010100101000000
```

---

# Approach

## Bit-by-Bit Construction

Construct the reversed number one bit at a time.

For every bit position:

1. Extract the current bit.
2. Move it to its reversed position.
3. Insert it into the result.

Repeat for all 32 bits.

---

# Algorithm

### Step 1

Initialize:

```java
int res = 0;
```

---

### Step 2

Loop through every bit position.

```java
for (int i = 0; i < 32; i++)
```

---

### Step 3

Extract bit `i`.

```java
int bit = (n >> i) & 1;
```

The right shift moves bit `i` into the least significant position.

The mask:

```java
& 1
```

isolates that single bit.

---

### Step 4

Move the bit to its reversed position.

Original position:

```
i
```

Reversed position:

```
31 - i
```

Shift:

```java
bit << (31 - i)
```

---

### Step 5

Insert the bit into the answer.

```java
res |= shiftedBit;
```

Bitwise OR sets the appropriate bit while leaving previously written bits unchanged.

---

# Example Walkthrough

Suppose:

```text
n = 1011
```

(illustrated using only four bits)

```
Bit 0:

1

↓

Position 3
```

```
Bit 1:

1

↓

Position 2
```

```
Bit 2:

0

↓

Position 1
```

```
Bit 3:

1

↓

Position 0
```

Result:

```text
1101
```

---

# Why This Works

Each iteration processes exactly one bit.

The extracted bit is copied into its mirrored position:

```
i

↓

31 - i
```

Since every position is visited exactly once, every bit is reversed correctly.

---

# Complexity

A Java integer always contains exactly:

```
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

Only two integer variables are used.

```
O(1)
```

---

# Pattern Recognition

When you see:

- reverse binary digits
- manipulate individual bits
- bit positions

Think:

```
Shift

+

Mask

+

Bitwise OR
```

---

# Related Problems

- Number of 1 Bits
- Counting Bits
- Single Number
- Power of Two