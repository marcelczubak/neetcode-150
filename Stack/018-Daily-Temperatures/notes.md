# 📝 Notes

---

## 🏷️ Pattern

Monotonic Stack (Decreasing)

---

## 🧠 Core Idea

We maintain a stack of indices representing days that have not yet found a warmer future day.

The stack is strictly decreasing in temperature order.

---

## 🚀 Strategy

### Step 1: Iterate through array

For each day i:

---

### Step 2: Resolve previous days

While current temperature is greater than the temperature at stack top:

- pop index j
- result[j] = i - j

---

### Step 3: Push current index

Current day becomes a "waiting state".

---

## ⚠️ Common Mistakes

- Using `if` instead of `while` (misses multiple resolutions)
- Storing temperatures instead of indices
- Forgetting to initialize result array with zeros
- Trying brute force O(n²) solution
- Updating result at wrong index

---

## 🔄 Alternative Approaches

### ❌ Brute Force

Check all future days for each index:

O(n²)

---

### ✅ Monotonic Stack (Optimal)

Each element is pushed and popped once:

O(n)

---

## 🎯 Pattern Recognition

If you see:

- Next greater/smaller element
- “How many steps until condition changes”
- Future dependency problems

Think:

✔ Monotonic stack  
✔ Store indices  
✔ Resolve on violation of order  

---

## 🧩 Key Insight

The stack represents:

> all unresolved indices waiting for a warmer temperature

Each new element "clears" as many waiting elements as possible in one step.