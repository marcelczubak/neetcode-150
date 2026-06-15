# 📝 Notes

---

## 🏷️ Pattern

Prefix / Suffix Array Decomposition

---

## 🧠 Core Idea

We want:

result[i] = product of all elements except nums[i]

Instead of computing total product and dividing (not allowed), we split computation:

- Left side product (prefix)
- Right side product (suffix)

---

## 🚀 Optimal Strategy

### Step 1: Prefix pass

Build result array such that:

result[i] = product of all elements before i

---

### Step 2: Suffix pass

Traverse from right:

Multiply result[i] by product of all elements after i

---

## ⚠️ Common Mistakes

- Using division (not allowed)
- Recomputing products for every index (O(n²))
- Not initializing prefix properly (should start with 1)
- Forgetting suffix accumulation order
- Using extra arrays unnecessarily

---

## 🔄 Alternative Approach (Not allowed in interview)

- Compute total product
- Divide by nums[i]

Fails when zeros exist and violates constraints.

---

## 🎯 Pattern Recognition

If you see:

- “all elements except current”
- “without using current index”
- “range excluding self”

Think immediately:

✔ Prefix product  
✔ Suffix product  
✔ Two-pass array traversal  

---

## 🧩 Key Insight

The trick is not multiplication.

It is:

> separating influence from left and right sides of each index