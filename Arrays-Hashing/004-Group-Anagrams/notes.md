# 📝 Notes

## 🏷️ Pattern

Grouping by Signature

## 🚀 Optimized Solution

Use the sorted version of each string as a key.

All anagrams share the same sorted representation.

## 🐌 Alternative Solution

Use a frequency count array as the key.

Can achieve O(nk) instead of O(n * k log k).

## ⚠️ Common Mistakes

- Forgetting to create a new list for unseen keys.
- Returning the map instead of its values.
- Using mutable objects incorrectly as keys.

## 🔄 Similar Problems

- Valid Anagram
- Find All Anagrams in a String
- Top K Frequent Elements

## 🎯 Pattern Recognition

If a problem asks:

- Group similar items
- Categorize strings
- Find equivalent patterns

Think HashMap + Signature.