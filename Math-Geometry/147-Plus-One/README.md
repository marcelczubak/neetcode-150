# Plus One

## Problem

You are given a large non-negative integer represented as an array of digits.

Each element contains a single digit:

```text
[1,2,3]
```

represents:

```text
123
```

Return the array after adding **one** to the integer.

The most significant digit appears first, and the array contains no leading zeros.

---

## Example

### Input

```text
digits = [1,2,3]
```

### Output

```text
[1,2,4]
```

---

### Input

```text
digits = [4,3,2,1]
```

### Output

```text
[4,3,2,2]
```

---

### Input

```text
digits = [9,9,9]
```

### Output

```text
[1,0,0,0]
```

---

# Approach

## Simulate Addition

Adding one follows exactly the same process as manual addition.

Starting from the least significant digit:

- If the digit is less than `9`, increment it and finish.
- If the digit is `9`, it becomes `0` and the carry continues to the next digit.

If every digit is `9`, an additional digit is required at the front.

---

# Algorithm

### Step 1

Start from the last digit.

```java
for (int i = digits.length - 1; i >= 0; i--)
```

---

### Step 2

If the digit is less than `9`:

```java
digits[i]++;
```

The carry stops immediately.

Return the modified array.

---

### Step 3

Otherwise:

```java
digits[i] = 0;
```

Carry the addition to the next digit.

---

### Step 4

If every digit became `0`, the original number consisted entirely of `9`s.

Create a new array one digit longer.

Set:

```java
result[0] = 1;
```

The remaining digits are already initialized to `0`.

---

# Example Walkthrough

Input:

```text
[1,2,9]
```

Start at the last digit:

```
9

↓

0
```

Carry continues.

Next digit:

```
2

↓

3
```

Carry ends.

Answer:

```text
[1,3,0]
```

---

Another example:

```text
[9,9,9]
```

Every digit becomes:

```text
0
```

Carry reaches beyond the most significant digit.

Create:

```text
[1,0,0,0]
```

---

# Why This Works

The carry only propagates while digits equal `9`.

As soon as a digit smaller than `9` is found:

- increment it
- stop immediately

Only the special case where every digit is `9` requires allocating a new array.

---

# Complexity

Let:

```
n = number of digits
```

## Time Complexity

Worst case:

```
O(n)
```

when every digit is `9`.

Best case:

```
O(1)
```

when the last digit is less than `9`.

---

## Space Complexity

Usually:

```
O(1)
```

Only one special case allocates a new array:

```
O(n)
```

for the returned result.

---

# Pattern Recognition

When you see:

- digit array
- arithmetic simulation
- carry propagation

Think:

```
Manual Addition

+

Carry
```

---

# Related Problems

- Add Strings
- Multiply Strings
- Add Binary
- Reverse Integer