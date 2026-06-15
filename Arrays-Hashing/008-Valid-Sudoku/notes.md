# 📝 Notes

---

## 🏷️ Pattern

Matrix Constraint Validation

---

## 🧠 Core Idea

A Sudoku board has 3 independent constraints:

1. Rows must contain unique digits
2. Columns must contain unique digits
3. 3×3 sub-grids must contain unique digits

Each constraint is checked independently using a HashSet.

---

## 🚀 Strategy Breakdown

### Step 1: Row Check

For each row:
- iterate left → right
- use a HashSet to detect duplicates
- ignore '.'

---

### Step 2: Column Check

For each column:
- iterate top → bottom
- use a HashSet per column

---

### Step 3: Sub-grid Check

Divide board into 9 boxes:

boxRow = 0..2  
boxCol = 0..2  

Inside each box:

row = boxRow * 3 + i  
col = boxCol * 3 + j  

---

## ⚠️ Common Mistakes

- Mixing row/column indices in sub-grid traversal
- Forgetting to reset HashSet per row/column/box
- Not skipping '.' cells
- Trying to validate everything in one messy loop
- Incorrect 3×3 indexing logic

---

## 🔄 Alternative Approaches

### 1️⃣ Single-pass Hashing (Optimized)
Use sets like:
- "row i uses value x"
- "col j uses value x"
- "box k uses value x"

This reduces to one pass over board.

---

## 🎯 Pattern Recognition

If you see:

- Grid-based constraints
- Repeated validation rules
- Fixed-size matrix problems

Think:

✔ Separate constraint sets  
✔ Sub-grid decomposition  
✔ Multi-level indexing  

---

## 🧩 Key Insight

The hardest part is NOT checking duplicates.

It is correctly mapping:

> global matrix → local sub-grid coordinates