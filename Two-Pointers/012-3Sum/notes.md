# 📝 Notes

---

## 🏷️ Pattern

Sorting + Two Pointers (3Sum Reduction)

---

## 🧠 Core Idea

We transform a 3-element sum problem into a 2Sum problem:

For each index i:

nums[i] + nums[left] + nums[right] = 0

⇨ nums[left] + nums[right] = -nums[i]

---

## 🚀 Algorithm

### Step 1: Sort the array

Sorting enables directional pointer movement.

---

### Step 2: Fix one element

For each i:
- treat nums[i] as anchor
- solve remaining 2Sum problem

---

### Step 3: Two pointers

Initialize:

left = i + 1  
right = n - 1  

Then:

- If sum < target → left++
- If sum > target → right--
- If sum == target → record result

---

## ⚠️ Common Mistakes

- Not sorting first
- Forgetting to skip duplicate i values
- Forgetting to skip duplicate left/right values
- Recomputing sum inconsistently after pointer movement
- Not moving both pointers after finding a valid triplet
- Treating it as a HashSet problem (inefficient)

---

## 🔄 Alternative Approaches

### ❌ Brute force
O(n³)

### ❌ HashSet-based approach
Still leads to duplicates and inefficient pair search

### ✅ Optimal approach
Sort + Two pointers → O(n²)

---

## 🎯 Pattern Recognition

If you see:

- “Find triplets”
- “Sum to zero”
- “Unique combinations”

Think:

✔ Sort first  
✔ Fix one element  
✔ Reduce to Two Sum  
✔ Two-pointer scanning  

---

## 🧩 Key Insight

The power of this problem is not in searching combinations — it is in:

> reducing dimensionality (3Sum → 2Sum)