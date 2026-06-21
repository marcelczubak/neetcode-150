# 📝 Notes

---

## 🏷️ Pattern

Greedy / Single Pass

---

## 🧠 Core Idea

At each day, assume:

```text
I sell today.
```

Then compute:

```text
profit = current price - minimum price so far
```

---

## 🚀 Algorithm Logic

Initialize:

```java
minPrice = +∞
maxProfit = 0
```

Loop through prices:

### Step 1: Update minimum buy price

```java
minPrice = Math.min(minPrice, price);
```

---

### Step 2: Compute profit if selling today

```java
price - minPrice
```

---

### Step 3: Update answer

```java
maxProfit = Math.max(maxProfit, price - minPrice);
```

---

## 🧪 Example

```text
prices = [7,1,5,3,6,4]
```

| Day | Price | Min Price | Profit | Max Profit |
|-----|-------|----------|--------|------------|
| 0   | 7     | 7        | 0      | 0          |
| 1   | 1     | 1        | 0      | 0          |
| 2   | 5     | 1        | 4      | 4          |
| 3   | 3     | 1        | 2      | 4          |
| 4   | 6     | 1        | 5      | 5          |
| 5   | 4     | 1        | 3      | 5          |

Answer = 5

---

## ⚠️ Common Mistakes

- Trying all pairs (O(n²))
- Updating maxProfit before minPrice
- Forgetting profit can be 0 (never negative)

---

## 🔄 Alternative Approaches

### ❌ Brute force
Try all buy/sell pairs → O(n²)

### ❌ DP approach
Not needed here

### ✅ Greedy (optimal)
Track min price and best profit in one pass

---

## 🎯 Pattern Recognition

If you see:

- Single transaction stock problem
- Max profit
- “Buy before sell”

Think:

✔ Track minimum so far  
✔ Compute running profit  
✔ Greedy update  

---

## 🧩 Key Insight

The optimal sell day always pairs with:

```text
the lowest price before it
```

So the problem reduces to tracking:

```text
min so far + best difference so far
```