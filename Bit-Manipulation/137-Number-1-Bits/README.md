# Number of 1 Bits (Hamming Weight)

## Problem

Given a 32-bit integer `n`, return the number of bits that are set to `1` in its binary representation.

This count is known as the **Hamming Weight**.

---

## Example

### Input

```text
n = 11
```

Binary:

```text
1011
```

### Output

```text
3
```

---

### Input

```text
n = 128
```

Binary:

```text
10000000
```

### Output

```text
1
```

---

# Approach

## Check Every Bit

A 32-bit integer contains exactly 32 bits.

For each bit position:

1. Shift the number right.
2. Isolate the least significant bit.
3. Count it if it equals `1`.

Repeat for all 32 bit positions.

---

# Algorithm

### Step 1

Initialize:

```java
int count = 0;
```

---

### Step 2

Iterate through every bit position.

```java
for (int i = 0; i < 32; i++)
```

---

### Step 3

Move the desired bit into the least significant position.

```java
n >> i
```

Example:

```
101100

>>

2

=

001011
```

---

### Step 4

Extract the least significant bit.

```java
(n >> i) & 1
```

The bitwise AND removes every other bit.

Possible results:

```
0

or

1
```

---

### Step 5

If the extracted bit equals `1`, increment the count.

```java
count++;
```

---

# Example Walkthrough

Input:

```text
n = 11
```

Binary:

```text
1011
```

Check each bit:

```
Bit 0:

1

count = 1
```

```
Bit 1:

1

count = 2
```

```
Bit 2:

0
```

```
Bit 3:

1

count = 3
```

Remaining bits:

```
0
```

Return:

```
3
```

---

# Why This Works

Right shifting moves the desired bit into the least significant position.

Applying:

```java
& 1
```

keeps only that bit.

Repeating this for every bit position guarantees every `1` bit is counted exactly once.

---

# Complexity

A 32-bit integer always contains exactly 32 bits.

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

Only one counter is used.

```
O(1)
```

---

# Pattern Recognition

When you see:

- binary representation
- count bits
- bit manipulation

Think:

```
Shift

+

Bit Mask
```

---

# Related Problems

- Counting Bits
- Reverse Bits
- Single Number
- Missing Number
- Power of Two