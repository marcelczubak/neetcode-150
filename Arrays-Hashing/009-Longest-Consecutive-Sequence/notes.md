# 📝 Notes

---

## 🏷️ Pattern

HashSet + Sequence Expansion

---

## 🧠 Core Idea

We want to find the longest chain of consecutive numbers.

Instead of sorting, we use a HashSet for O(1) lookup.

---

## 🚀 Optimal Strategy

### Step 1: Insert all numbers into a HashSet

This allows fast checking of existence.

---

### Step 2: Find sequence starting points

A number is the start of a sequence if:

👉 `num - 1` is NOT in the set

This ensures we only begin counting once per sequence.

---

### Step 3: Expand forward

From each starting point:

- check `num + 1`
- continue while consecutive numbers exist
- track length

---

## ⚠️ Common Mistakes

- Sorting the array (O(n log n), unnecessary)
- Starting sequences from every number (causes O(n²))
- Not using a HashSet (slower lookups)
- Forgetting the `num - 1` start condition

---

## 🔄 Alternative Approaches

### ❌ Sorting approach
- Sort array
- Count consecutive runs
- O(n log n)

### ✅ Optimal HashSet approach
- O(n) time
- No ordering required

---

## 🎯 Pattern Recognition

If you see:

- Longest streak
- Consecutive sequence
- Chain formation

Think:

✔ HashSet  
✔ Start condition filtering  
✔ Linear expansion  

---

## 🧩 Key Insight

The optimization comes from avoiding duplicate work:

> Each sequence is only built once, starting from its true beginning.`