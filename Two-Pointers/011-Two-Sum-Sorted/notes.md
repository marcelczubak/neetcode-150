# 📝 Notes

---

## 🏷️ Pattern

Two Pointers (Sorted Array)

---

## 🧠 Core Idea

We take advantage of the sorted property of the array.

Instead of checking all pairs, we use two pointers:

- `left` starts at index 0
- `right` starts at last index

---

## 🚀 Algorithm

While `left < right`:

1. Compute sum = numbers[left] + numbers[right]
2. If sum == target → return result
3. If sum > target → decrement right pointer
4. If sum < target → increment left pointer

---

## ⚠️ Common Mistakes

- Using HashMap unnecessarily (not needed for sorted input)
- Forgetting the array is 1-indexed in output
- Recomputing sum multiple times instead of storing it
- Moving both pointers at once (wrong logic)
- Not understanding why sorting enables pointer movement

---

## 🔄 Alternative Approach

### HashMap Approach (not optimal here)

- Store value → index
- Check complement existence
- Time: O(n)
- Space: O(n)

---

### Optimal Approach (Two Pointers)

- Use sorted property
- Move inward based on sum
- Time: O(n), Space: O(1)

---

## 🎯 Pattern Recognition

If you see:

- Sorted array
- Pair sum problem
- Target sum / closest sum

Think:

✔ Two pointers  
✔ Left + right scanning  
✔ Directional movement logic  

---

## 🧩 Key Insight

Sorting gives structure:

> You don’t need to search — you can *navigate*