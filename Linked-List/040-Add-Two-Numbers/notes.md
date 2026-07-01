# 📝 Notes

---

# 🏷️ Pattern

Linked List Simulation

---

# 🧠 Core Idea

Think exactly like elementary school addition.

For every digit:

```
digit1
+ digit2
+ carry
---------
new digit
new carry
```

Each iteration creates one node in the answer.

---

# 🌊 Visualization

```
2 → 4 → 3
5 → 6 → 4
```

Iteration 1

```
2 + 5 = 7

Answer:

7
```

Iteration 2

```
4 + 6 = 10

Store:

0

Carry:

1
```

Iteration 3

```
3 + 4 + 1 = 8
```

Final answer:

```
7 → 0 → 8
```

---

# 📌 Dummy Node

Instead of treating the first node specially:

```java
ListNode dummy = new ListNode();
ListNode curr = dummy;
```

Every new node is attached using:

```java
curr.next = new ListNode(...);
curr = curr.next;
```

Finally:

```java
return dummy.next;
```

---

# 📌 Reading Digits

One list may finish before the other.

Treat missing nodes as zero.

```java
int val1 = (l1 != null) ? l1.val : 0;
int val2 = (l2 != null) ? l2.val : 0;
```

---

# 📌 Computing the Sum

Using an integer carry:

```java
sum = val1 + val2 + carry;
```

---

# 📌 Current Digit

The current node stores:

```java
sum % 10
```

Example:

```
17

↓

Digit = 7
```

---

# 📌 Carry

The carry becomes:

```java
carry = sum / 10;
```

Example:

```
17

↓

Carry = 1
```

---

# 📌 Final Carry

After processing every node:

```
carry = 1
```

Append:

```java
curr.next = new ListNode(1);
```

---

# 🧪 Example

```
9 → 9 → 9

1
```

Step 1

```
9 + 1 = 10

Store:

0

Carry:

1
```

Step 2

```
9 + 0 + 1 = 10

Store:

0

Carry:

1
```

Step 3

```
9 + 0 + 1 = 10

Store:

0

Carry:

1
```

End of lists

Carry still exists

Append:

```
1
```

Answer:

```
0 → 0 → 0 → 1
```

---

# ⚠️ Common Mistakes

## ❌ Using `&&` instead of `||`

Wrong:

```java
while (l1 != null && l2 != null)
```

Stops when one list finishes.

Correct:

```java
while (l1 != null || l2 != null)
```

---

## ❌ Forgetting the final carry

Example:

```
5 + 5
```

Without adding the final carry:

```
0
```

Correct:

```
0 → 1
```

---

## ❌ Losing the head of the answer list

Always use a dummy node.

Return:

```java
dummy.next
```

---

## ❌ Not handling different list lengths

Missing nodes should contribute:

```
0
```

not cause a `NullPointerException`.

---

# 🎯 Pattern Recognition

If a linked list problem involves:

- building a new list
- digit-by-digit operations
- carrying information between iterations

Think:

✔ Dummy Node

✔ Simulation

✔ Pointer Traversal

---

# 💭 Mental Model

Imagine adding two numbers on paper.

For each column:

1. Read the two digits.
2. Add the carry.
3. Write down the current digit.
4. Carry the tens digit to the next column.

The linked list is simply storing each column of the addition in reverse order.