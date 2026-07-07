# 📋 Copy List with Random Pointer

## 🎯 Difficulty
Medium

## 🏷️ Pattern
Linked List + HashMap

---

## ❓ Problem

You are given the head of a linked list where each node contains:

- `next` → points to the next node.
- `random` → points to any node in the list or `null`.

Create a **deep copy** of the entire list.

A deep copy means:

- Every node is newly created.
- The copied nodes must have the same values.
- The `next` and `random` pointers in the copied list must point to copied nodes, **not** the original nodes.

---

## 💡 Approach

This solution uses a **HashMap** to maintain a mapping between every original node and its copy.

```
Original Node  →  Copied Node
```

The algorithm is completed in two passes.

### Pass 1

Traverse the original list and create a copy of every node.

Store the mapping:

```
original → copy
```

At this point, no pointers are connected.

---

### Pass 2

Traverse the original list again.

For every original node:

- Set the copied node's `next`
- Set the copied node's `random`

Both pointers are obtained directly from the HashMap.

```
copy.next = map.get(original.next)

copy.random = map.get(original.random)
```

Finally, return the copied version of the head.

---

## 🚀 Algorithm

1. Create an empty HashMap.
2. Traverse the list and create a copy of every node.
3. Store:

```
original → copied
```

4. Traverse the list again.
5. Connect every copied node's `next` and `random` pointers.
6. Return the copied head.

---

## 🧠 Key Insight

The difficult part is the `random` pointer.

Instead of trying to search for where it should point, we already know the copied version of every node because of the HashMap.

Every pointer assignment becomes a constant-time lookup.

---

## ⏱️ Complexity

### Time

```
O(n)
```

Two linear traversals.

### Space

```
O(n)
```

HashMap stores one entry for every node.

---

## 🔄 Example

Original list

```
7 → 13 → 11
↓     ↘
null   7
```

HashMap after first pass

```
7(original)  → 7(copy)

13(original) → 13(copy)

11(original) → 11(copy)
```

Second pass connects all pointers.

---

## 📚 What I Learned

- Deep copying linked structures
- Using HashMaps to preserve relationships
- Separating node creation from pointer assignment
- Building graph-like structures using mappings

---

## 🔗 Similar Problems

- Clone Graph
- Linked List Cycle
- Merge Two Sorted Lists
- Reverse Linked List