# 📝 Notes

---

## 🏷️ Pattern

Greedy + Monotonic Stack (or max tracking)

---

## 🧠 Core Idea

We convert each car into:

time = (target - position) / speed

Then process cars from closest to farthest.

---

## 🚀 Strategy

### Step 1: Compute time to target

Each car is represented as:

(position, time)

---

### Step 2: Sort by position descending

So we process cars from front to back.

---

### Step 3: Maintain stack of fleet times

For each car:

- If its time is greater than the current stack top:
  - it forms a new fleet → push it
- Else:
  - it joins the fleet in front → ignore

---

## ⚠️ Common Mistakes

- Not sorting by position descending
- Using integer division for time (precision loss)
- Trying to simulate movement step-by-step
- Thinking speed alone determines fleets
- Using position instead of time for comparisons

---

## 🔄 Alternative Approaches

### 1️⃣ Stack approach (conceptual)
- Stores fleet arrival times
- O(n log n)

---

### 2️⃣ Greedy (optimal simplification)
- Track only maximum time so far
- Same logic, O(n log n)

---

## 🎯 Pattern Recognition

If you see:

- objects moving toward a target
- merging behavior
- “cannot pass slower object ahead”
- interactions only with forward elements

Think:

✔ sort by position  
✔ convert to time  
✔ greedy merging / monotonic stack  

---

## 🧩 Key Insight

Each car either:

- becomes a new fleet
- or merges into an existing one

Decision depends only on:

> whether it arrives later than the fleet in front