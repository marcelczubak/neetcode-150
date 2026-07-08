# 📝 Notes

---

# 🏷️ Pattern

HashMap + Doubly Linked List

---

# 🧠 Core Idea

LRU Cache needs two operations:

1. Find a key quickly.
2. Move nodes quickly.

A single data structure cannot do both.

Therefore:

```
HashMap
+
Doubly Linked List
```

---

# HashMap Role

Stores:

```
key → node reference
```

Example:

```
5 → Node(5,100)
```

Allows:

```java
map.get(key)
```

in:

```
O(1)
```

---

# Doubly Linked List Role

Maintains order of usage.

Structure:

```
LRU                         MRU

head <-> A <-> B <-> C <-> tail
```

When a node is used:

```
A <-> B <-> C

get(B)

A <-> C <-> B
```

B becomes most recently used.

---

# Dummy Nodes

Use:

```
dummyHead <-> dummyTail
```

Initial state:

```
head <-> tail
```

Real nodes are always inserted between them.

Example:

```
head <-> A <-> B <-> tail
```

---

# Removing a Node

Given:

```
A <-> B <-> C
```

Remove B:

```java
B.prev.next = B.next;

B.next.prev = B.prev;
```

Result:

```
A <-> C
```

---

# Inserting at Tail

Before:

```
A <-> tail
```

Insert B:

```
A <-> B <-> tail
```

Steps:

```java
Node prev = tail.prev;

prev.next = node;
node.prev = prev;

node.next = tail;
tail.prev = node;
```

---

# get()

Process:

```
Find node
      ↓
Remove node
      ↓
Insert at tail
      ↓
Return value
```

Accessing a node makes it recently used.

---

# put()

Process:

```
Does key exist?

YES:
    remove old node

Create node

Insert at tail

If capacity exceeded:
    remove head.next
```

---

# Common Mistakes

## ❌ Only using HashMap

Fast lookup:

```
O(1)
```

but cannot know:

```
least recently used
```

---

## ❌ Only using Linked List

Can maintain order, but searching takes:

```
O(n)
```

---

## ❌ Forgetting to remove from map

When evicting:

```java
map.remove(node.key);
```

must happen.

Otherwise the map contains stale references.

---

## ❌ Not storing the key in Node

Nodes need:

```java
int key;
int value;
```

because when removing the LRU node, you need its key to delete it from the HashMap.

---

# Interview Pattern Recognition

If a problem asks:

- cache
- most/least recently used
- O(1) operations

Think:

```
HashMap + Doubly Linked List
```

---

# Complexity

Time:

```
O(1)
```

Space:

```
O(capacity)
```

---

# Final Mental Model

HashMap answers:

"Where is this item?"

Linked List answers:

"How recently was this item used?"

Together:

```
Fast lookup + Fast ordering
```