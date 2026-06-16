# 📝 Notes

---

## 🏷️ Pattern

Two Pointers + Greedy

---

## 🧠 Core Idea

We want to maximize:

area = width × min(height[left], height[right])

Width decreases every step, so we must maximize the height component.

---

## 🚀 Optimal Strategy

### Step 1: Initialize pointers

left = 0  
right = n - 1  

---

### Step 2: Compute area

At each step:

- width = right - left
- height = min(height[left], height[right])
- update max area

---

### Step 3: Move pointers greedily

Always move the pointer with the smaller height:

- If height[left] < height[right] → left++
- Else → right--

---

## 🧠 Why moving the larger pointer is useless

If we move the taller side:

- width decreases
- limiting height stays the same
- result is always worse or equal

So it never helps improve the answer.

---

## ⚠️ Common Mistakes

- Trying all pairs (O(n²))
- Moving both pointers at once
- Using next element comparisons instead of current boundaries
- Not recognizing the role of the limiting height
- Starting max at Integer.MIN_VALUE instead of 0

---

## 🔄 Alternative Approach

### Brute force

Check all pairs:

O(n²) time, O(1) space

---

### Optimal approach

Two pointers:

O(n) time, O(1) space

---

## 🎯 Pattern Recognition

If you see:

- Maximum area between two boundaries
- Optimization with shrinking interval
- “Choose two elements”

Think:

✔ Two pointers from ends  
✔ Greedy move smaller boundary  
✔ Eliminate worse choices  

---

## 🧩 Key Insight

The solution is not about finding the best pair directly:

> It is about eliminating pairs that cannot possibly improve the result