# 📝 Notes

---

## 🏷️ Pattern

Linked List Merge (Two Pointers + Dummy Node)

---

## 🧠 Core Idea

We maintain:

- `p1` → pointer for list1
- `p2` → pointer for list2
- `curr` → tail of merged list

We always attach the smaller node to:

```java
curr.next
```

---

## 🚀 Algorithm Steps

### Step 1: Create dummy node

```java
ListNode dummy = new ListNode();
ListNode curr = dummy;
```

---

### Step 2: Traverse both lists

```java
while (p1 != null && p2 != null)
```

---

### Step 3: Compare values

```java
if (p1.val < p2.val)
```

Attach `p1`, else attach `p2`.

---

### Step 4: Move pointers

After attaching:

```java
curr = curr.next;
p1 = p1.next OR p2 = p2.next;
```

---

### Step 5: Attach remaining nodes

```java
curr.next = (p1 != null) ? p1 : p2;
```

---

### Step 6: Return result

```java
return dummy.next;
```

---

## 🧪 Example

```text
list1 = 1 → 3 → 5
list2 = 2 → 4 → 6
```

Merge process:

```text
1 → 2 → 3 → 4 → 5 → 6
```

---

## ⚠️ Common Mistakes

- Not using a dummy node
- Losing reference to head of merged list
- Returning `curr` instead of `dummy.next`
- Forgetting to attach remaining nodes

---

## 🔄 Alternative Approaches

### ❌ Creating new nodes
Extra space and unnecessary.

### ❌ Recursive merge
Cleaner but uses O(n) call stack.

### ✅ Iterative dummy node (optimal)
Preferred in interviews.

---

## 🎯 Pattern Recognition

If you see:

- merging sorted lists
- combining sequences
- two sorted inputs

Think:

✔ Dummy node  
✔ Two pointers  
✔ Greedy merge  

---

## 🧩 Key Insight

You are not creating a new list from scratch.

You are:

```text
relinking existing nodes in sorted order
```