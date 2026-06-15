# 🧩 Valid Sudoku

## 🎯 Difficulty
Medium

## 🏷️ Pattern
HashSet, Matrix Traversal, Constraint Checking

---

## ❓ Problem

Determine if a 9×9 Sudoku board is valid.

A valid board must satisfy:

- Each row contains no duplicate digits (1–9)
- Each column contains no duplicate digits (1–9)
- Each of the 9 sub-boxes (3×3) contains no duplicates

Empty cells are represented by '.'

---

## 💡 Approach

We validate the board in three independent passes:

### 1️⃣ Rows
Check each row using a HashSet.

### 2️⃣ Columns
Check each column using a HashSet.

### 3️⃣ Sub-grids (3×3 boxes)
Divide the board into 9 sub-boxes and validate each one separately.

---

## 🧠 Key Insight

Each constraint (row, column, sub-grid) behaves independently.

So we use a fresh HashSet for each structure.

---

## 🧱 Sub-grid Traversal Idea

Each 3×3 box starts at:

(0,0), (0,3), (0,6)  
(3,0), (3,3), (3,6)  
(6,0), (6,3), (6,6)

We iterate:

- boxRow = 0..2
- boxCol = 0..2

Then map inside each box:

row = boxRow * 3 + i  
col = boxCol * 3 + j  

---

## ⏱️ Time Complexity

O(1)

The board size is fixed (9×9), so operations are constant time.

---

## 💾 Space Complexity

O(1)

We use a fixed number of HashSets (max 27 total checks).

---

## 📚 What I Learned

- Matrix problems often require multi-level indexing
- Sub-grids can be handled using offset multiplication
- Always separate constraints into independent validation sets
- Clean iteration is more important than clever shortcuts

---

## 🧠 Pattern Recognition

If you see:

- Grid validation
- Constraints on rows/columns/boxes
- Matrix with fixed structure

Think:

✔ HashSet per constraint  
✔ Multi-pass validation  
✔ Sub-grid decomposition  

---

## 🔄 Similar Problems

- Sudoku Solver
- Matrix Region Validation
- Tic-Tac-Toe validation
- Latin Square checks