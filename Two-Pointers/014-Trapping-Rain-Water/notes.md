# 📝 Notes

---

## 🏷️ Pattern

Prefix / Suffix Maximum Arrays

---

## 🧠 Core Idea

At each index, water trapped depends on the tallest walls on both sides:

water[i] = min(maxLeft[i], maxRight[i]) - height[i]

---

## 🚀 Strategy

### Step 1: Prefix maximum

Compute running max from left to right.

---

### Step 2: Suffix maximum

Compute running max from right to left.

---

### Step 3: Compute water

For each index:

- find limiting height = min(prefix[i], suffix[i])
- subtract current height
- add if positive

---

## ⚠️ Common Mistakes

- Using references instead of copying arrays (aliasing bug)
- Forgetting that prefix/suffix arrays must preserve original height logic
- Incorrect max propagation logic
- Negative water values not handled properly
- Assuming local comparisons are enough (they are not)

---

## 🔄 Alternative Approaches

### 1️⃣ Prefix/Suffix Arrays (this solution)
- Simple
- Easy to understand
- O(n) space

---

### 2️⃣ Two Pointers (Optimal)

- Maintain leftMax and rightMax dynamically
- O(1) space
- Same logic, but no extra arrays

---

## 🎯 Pattern Recognition

If you see:

- Water trapped between bars
- Need to compute contribution at each index
- “bounded by left and right”

Think:

✔ Prefix/suffix max  
✔ Or two-pointer boundary tracking  

---

## 🧩 Key Insight

Each index behaves independently:

> The water level is determined entirely by the weakest boundary on either side