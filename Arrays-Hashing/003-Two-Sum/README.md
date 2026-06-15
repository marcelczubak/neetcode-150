# ➕ Two Sum

## 🎯 Difficulty
Easy

## 🏷️ Pattern
HashMap Lookup

## ❓ Problem

Find two numbers whose sum equals the target and return their indices.

## 💡 Approach

Store previously seen numbers in a HashMap.

For each number:

1. Calculate its complement.
2. Check if the complement exists.
3. If yes, return both indices.

## ⏱️ Time Complexity

O(n)

## 💾 Space Complexity

O(n)

## 🔑 Key Insight

Instead of checking every pair, store values already seen and look up complements instantly.

## 📚 What I Learned

- Complement-based problems often use HashMaps.
- HashMaps trade memory for speed.
- Single-pass solutions are usually preferred.