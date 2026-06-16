# 🪣 Container With Most Water

## 🎯 Difficulty
Medium

## 🏷️ Pattern
Two Pointers, Greedy

---

## ❓ Problem

Given an array `height`, where each element represents a vertical line on the x-axis, find two lines that together with the x-axis form a container that holds the maximum amount of water.

Return the maximum water the container can store.

---

## 💡 Approach

We use a two-pointer strategy:

- One pointer starts at the beginning (`left`)
- One pointer starts at the end (`right`)

At each step, we calculate the area formed and move inward strategically.

---

## 🧠 Key Insight

The container area is limited by the shorter of the two lines:

area = min(height[left], height[right]) × width

Since width always decreases, the only way to potentially increase area is to increase the limiting height.

👉 Therefore, we always move the pointer with the smaller height.

---

## 🚀 Algorithm

1. Initialize two pointers at both ends
2. Compute area at each step
3. Update maximum area
4. Move the pointer pointing to the smaller height inward

---

## ⏱️ Time Complexity

O(n)

Each pointer moves at most once across the array.

---

## 💾 Space Complexity

O(1)

No extra data structures are used.

---

## 🔑 Why This Works

Moving the taller pointer never improves the limiting height, while moving the shorter pointer gives a chance to find a taller boundary.

This is a greedy elimination strategy.

---

## 📚 What I Learned

- The limiting factor dominates area calculation
- Shrinking width forces greedy decisions
- Only the smaller height can potentially improve future results
- Two pointers can replace brute force O(n²) checking

---

## 🧠 Pattern Recognition

If you see:

- Max area between two points
- Container / walls / boundaries
- Optimization with shrinking window

Think:

✔ Two pointers from ends  
✔ Move smaller boundary  
✔ Greedy elimination  

---

## 🔄 Similar Problems

- Trapping Rain Water
- Largest Rectangle in Histogram
- 3Sum Closest