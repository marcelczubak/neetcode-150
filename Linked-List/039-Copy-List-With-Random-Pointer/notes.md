# 📝 Notes

---

# 🏷️ Pattern

Linked List

HashMap

Deep Copy

---

# 🧠 Core Idea

Every original node must have exactly one copied node.

Store this relationship in a HashMap.

```
Original Node
        │
        ▼
Copied Node
```

This allows any pointer to be recreated instantly.

---

# 📌 Pass 1 — Create Every Node

Traverse once.

For every node:

```java
Node copy = new Node(curr.val);
map.put(curr, copy);
```

At the end:

```
Original A → Copy A

Original B → Copy B

Original C → Copy C
```

No pointers have been connected yet.

---

# 📌 Pass 2 — Connect Pointers

Traverse again.

For every original node:

```
copy.next
```

should point to

```
copy of original.next
```

Similarly,

```
copy.random
```

should point to

```
copy of original.random
```

Code

```java
copy.next = map.get(curr.next);
copy.random = map.get(curr.random);
```

---

# 🌊 Example

Original

```
A → B → C
 \   |
  \__|
```

HashMap

```
A → A'

B → B'

C → C'
```

Pointers become

```
A'.next = B'

A'.random = C'

B'.next = C'

B'.random = A'
```

Everything now references copied nodes.

---

# ⚠️ Common Mistakes

## ❌ Pointing to original nodes

Wrong

```java
copy.random = curr.random;
```

Correct

```java
copy.random = map.get(curr.random);
```

---

## ❌ Forgetting to copy next pointers

Need both

```java
copy.next
```

and

```java
copy.random
```

---

## ❌ Trying to build pointers before all copies exist

Create every node first.

Only then connect pointers.

---

# 🎯 Pattern Recognition

Whenever a problem asks you to:

- clone a graph
- deep copy a structure
- duplicate nodes with arbitrary references

Think:

```
Original Object
      ↓
Copied Object
```

Store the mapping in a HashMap.

---

# 🚀 Interview Tip

Notice that:

```java
map.get(null)
```

returns

```java
null
```

So these work naturally:

```java
copy.next = map.get(curr.next);

copy.random = map.get(curr.random);
```

No special handling for `null` pointers is required.

---

# 📌 Complexity

Time

```
O(n)
```

Space

```
O(n)
```

This is the standard interview solution.

There is also an advanced **O(1) extra space** solution that interweaves copied nodes with the original list before separating them, but the HashMap approach is much simpler and is the one most candidates implement first.