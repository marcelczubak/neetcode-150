# 🗄️ LRU Cache

## 🎯 Difficulty
Medium

## 🏷️ Pattern
HashMap + Doubly Linked List

---

## ❓ Problem

Design a data structure that follows the **Least Recently Used (LRU)** cache policy.

Implement:

### `get(key)`

- Return the value of the key if it exists.
- Otherwise return `-1`.
- Accessing a key makes it the **most recently used** item.

### `put(key, value)`

- Insert or update the value.
- If the cache exceeds its capacity, remove the **least recently used** item.

All operations must run in:

```
O(1)
```

time.

---

# 💡 Approach

An LRU cache requires two things:

## 1. HashMap

Used for instant lookup.

Stores:

```
key → Node
```

This allows:

```
get(key)
```

to be performed in:

```
O(1)
```

---

## 2. Doubly Linked List

Used to maintain usage order.

The list represents:

```
Least Recently Used              Most Recently Used

head <-------------------------> tail
```

Whenever a node is accessed:

- Remove it from its current position.
- Move it to the tail.

The tail always represents the newest item.

The head always represents the item to remove when capacity is exceeded.

---

# 🚀 Algorithm

## get(key)

1. Check if key exists in HashMap.
2. If not:
   - return `-1`
3. If yes:
   - retrieve node.
   - remove node from linked list.
   - insert node at tail.
   - return value.

---

## put(key, value)

### If key already exists:

1. Remove existing node.
2. Create/update node.
3. Move it to the tail.

---

### If key is new:

1. Create node.
2. Add it to HashMap.
3. Insert it at the tail.

---

### If capacity exceeded:

1. Remove the node after the dummy head.
2. Remove it from the HashMap.

This node is the least recently used item.

---

# 🧠 Why use Dummy Head and Tail Nodes?

Instead of:

```
head = null
tail = null
```

use:

```
dummyHead <-> nodes <-> dummyTail
```

This removes edge cases.

Every node always has:

```
previous
next
```

So removal is always:

```
node.prev.next = node.next

node.next.prev = node.prev
```

No special handling for:

- first node
- last node
- empty list

---

# 🔄 Example

Capacity = 2

```
put(1,1)

List:
1

put(2,2)

List:
1 <-> 2

get(1)

1 becomes most recently used:

2 <-> 1

put(3,3)

Capacity exceeded.

Remove LRU:

2 removed

Final:

1 <-> 3
```

---

# ⏱️ Complexity

## Time

```
get(): O(1)

put(): O(1)
```

HashMap lookup + linked list pointer updates.

---

## Space

```
O(capacity)
```

Stores one node per cached item.

---

# 📚 Key Lessons

- HashMap gives fast access.
- Doubly linked list gives fast removal and insertion.
- Combining both creates an O(1) LRU cache.

---

# 🔗 Related Problems

- Design Twitter
- LFU Cache
- Copy List with Random Pointer
- Clone Graph