# 🚗 Car Fleet

## 🎯 Difficulty
Medium

## 🏷️ Pattern
Greedy, Monotonic Stack (Conceptual)

---

## ❓ Problem

There are cars driving toward a target. Each car has a position and speed.

A car fleet is formed when a faster car catches up to a slower car ahead. Once cars meet, they move together at the slower speed.

Return the number of car fleets that arrive at the target.

---

## 💡 Approach (Stack)

We process cars from closest to the target to farthest.

Each car is converted into:

- position
- time to reach target

We use a stack to track fleet arrival times.

---

## 🧠 Key Insight

A new fleet is created only if a car takes longer to reach the target than the fleet in front.

Otherwise, it merges into that fleet.

---

## 🚀 Algorithm

### Step 1: Compute arrival times

For each car:

time = (target - position) / speed

---

### Step 2: Sort cars by position (descending)

Process cars from closest to target first.

---

### Step 3: Use stack

For each car:

- If stack is empty OR current time > stack top:
  - push time (new fleet)
- Else:
  - merge into existing fleet (do nothing)

---

## ⏱️ Time Complexity

O(n log n)

Due to sorting.

---

## 💾 Space Complexity

O(n)

Stack stores fleet times.

---

## 🔑 Why This Works

Cars only interact with cars ahead of them.

So processing from front to back allows us to determine whether a car forms a new fleet or merges.

---

## 📚 What I Learned

- Convert movement problems into time-to-event problems
- Sorting by position simplifies interactions
- Stack represents active “fleet leaders”
- Greedy decisions depend only on current maximum time

---

## 🧠 Pattern Recognition

If you see:

- merging entities
- movement toward a target
- “who catches whom”
- dominance / absorption problems

Think:

✔ sort by position  
✔ greedy merge  
✔ stack or max-tracking  

---

## 🔄 Similar Problems

- Daily Temperatures
- Next Greater Element
- Asteroid Collision
- Largest Rectangle in Histogram