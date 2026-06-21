# 📈 Best Time to Buy and Sell Stock

## 🎯 Difficulty
Easy

## 🏷️ Pattern
Greedy / Single Pass

---

## ❓ Problem

You are given an array `prices` where `prices[i]` is the price of a stock on day `i`.

You want to maximize your profit by choosing **one day to buy** and **one later day to sell**.

Return the maximum profit possible. If no profit is possible, return `0`.

---

## 💡 Approach

We track two things while iterating:

- The **minimum price seen so far**
- The **maximum profit possible so far**

At each day:
- Treat current price as a potential sell price
- Compute profit using the minimum price seen so far

---

## 🧠 Key Insight

You do NOT need to try all pairs.

Instead:

> The best sell price for any day is always paired with the lowest price before it.

---

## 🚀 Algorithm

1. Initialize:
   - `minPrice = +∞`
   - `maxProfit = 0`

2. For each price:
   - Update minimum price
   - Compute profit = price - minPrice
   - Update maximum profit

3. Return `maxProfit`

---

## ⏱️ Time Complexity

```text
O(n)
```

Single pass through the array.

---

## 💾 Space Complexity

```text
O(1)
```

Only two variables used.

---

## 🔑 Why This Works

We are effectively checking:

> "If I sold today, what is the best profit I could have made?"

And ensuring we always pair that with the lowest historical buying price.

---

## 📚 What I Learned

- Greedy choice: always keep best previous buy
- No need for nested loops or brute force pairs
- Problems with “buy/sell once” often reduce to tracking min + max diff

---

## 🧠 Pattern Recognition

If you see:

- One buy, one sell
- Max difference in array
- Profit optimization

Think:

✔ Track minimum so far  
✔ Compute running difference  
✔ Greedy update  

---

## 🔄 Similar Problems

- Maximum Subarray (Kadane’s Algorithm idea)
- Stock II (multiple transactions)
- Best Time to Buy and Sell Stock with Cooldown