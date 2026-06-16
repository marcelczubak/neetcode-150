# 🌧️ Trapping Rain Water

## 🎯 Difficulty
Hard

## 🏷️ Pattern
Prefix/Suffix Arrays, Two Pointers, Dynamic Boundary Tracking

---

## ❓ Problem

Given an array `height` representing elevation map where the width of each bar is 1, compute how much water it can trap after raining.

---

## 💡 Approach (Prefix + Suffix Max)

For each index, the water trapped depends on the tallest bars to the left and right.

We compute:

- `prefix[i]` = maximum height to the left (including i)
- `suffix[i]` = maximum height to the right (including i)

Then:

water at i = min(prefix[i], suffix[i]) - height[i]

---

## 🧠 Key Insight

Water at any index is limited by the **shorter boundary** between left max and right max.

So the water level is:

👉 min(maxLeft, maxRight)

---

## 🚀 Algorithm

### Step 1: Build prefix max array

For each index, store the maximum height seen so far from the left.

---

### Step 2: Build suffix max array

For each index, store the maximum height seen so far from the right.

---

### Step 3: Compute trapped water

For each index:

- water = min(prefix[i], suffix[i]) - height[i]
- add to result if positive

---

## ⏱️ Time Complexity

O(n)

We traverse the array a constant number of times.

---

## 💾 Space Complexity

O(n)

Two extra arrays are used for prefix and suffix maxima.

---

## 🔑 Why This Works

Each position is treated independently:

- Left boundary defines max possible water level
- Right boundary defines max possible water level
- The lower of the two determines actual water height

---

## 📚 What I Learned

- Water trapping depends on local boundaries, not global structure
- Prefix/suffix max transforms global problem into local computation
- Care must be taken when copying arrays (avoid reference aliasing)
- This problem is a precursor to the optimal two-pointer solution

---

## 🧠 Pattern Recognition

If you see:

- Water trapped between bars
- Histogram elevation problems
- “bounded by both sides”

Think:

✔ Prefix max  
✔ Suffix max  
✔ Or two-pointer boundary tracking  

---

## 🔄 Similar Problems

- Container With Most Water
- Largest Rectangle in Histogram
- Skyline problems