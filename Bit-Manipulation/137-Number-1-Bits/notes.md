# Number of 1 Bits Notes

## Pattern

- Bit Manipulation
- Bit Masking

---

# Core Idea

Check every bit individually.

There are exactly:

```
32 bits
```

in a Java `int`.

---

# Right Shift

```java
n >> i
```

moves the desired bit to the least significant position.

Example:

```
101100
```

Shift:

```
>> 2
```

Result:

```
001011
```

---

# Bit Mask

Apply:

```java
& 1
```

Example:

```
001011

&

000001

=

000001
```

Only the last bit remains.

Possible values:

```
0

or

1
```

---

# Algorithm

Loop:

```java
for(int i = 0; i < 32; i++)
```

Extract:

```java
(n >> i) & 1
```

If:

```
1
```

increment:

```java
count++;
```

---

# Example

Binary:

```text
1011
```

Check:

```
i=0

1

count=1
```

```
i=1

1

count=2
```

```
i=2

0
```

```
i=3

1

count=3
```

Answer:

```
3
```

---

# Why `& 1`?

The mask:

```text
000...0001
```

keeps only the least significant bit.

Everything else becomes zero.

---

# Why Loop 32 Times?

A Java `int` always contains:

```
32 bits
```

regardless of the numerical value.

Negative numbers are stored using **two's complement**, but the same algorithm still works because every bit is examined individually.

---

# Common Mistakes

## Loop Until n == 0

Using:

```java
while(n > 0)
```

fails for negative numbers.

Always process all 32 bits.

---

## Forgetting the Mask

Simply shifting:

```java
n >> i
```

does not isolate one bit.

Always use:

```java
& 1
```

after shifting.

---

## Confusing `>>` and `>>>`

This solution works with:

```java
>>
```

because every bit position is explicitly examined.

Another common implementation repeatedly shifts the number itself, which usually uses:

```java
>>>
```

(unsigned right shift) to correctly handle negative numbers.

---

# Interview Explanation

"I examine each of the 32 bit positions. For each position, I shift the number right so that the target bit becomes the least significant bit. I then mask it with `1` using bitwise AND to determine whether that bit is set. If it is, I increment the counter. Since a Java integer always has 32 bits, the algorithm runs in constant time."

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

# Optimisation

A more efficient bit manipulation technique is:

```java
n &= (n - 1);
```

Each iteration removes the **lowest set bit**, so the loop runs only once per `1` bit.

Complexity:

```
O(number of set bits)
```

instead of checking all 32 positions.

---

# Key Takeaway

The standard pattern for checking a single bit is:

```java
(n >> i) & 1
```

- `>> i` moves the desired bit into the least significant position.
- `& 1` isolates that bit.

This is one of the most fundamental techniques in bit manipulation problems.