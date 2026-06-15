# 📚 Group Anagrams

## 🎯 Difficulty
Medium

## 🏷️ Pattern
HashMap, Frequency Counting

## ❓ Problem

Group together strings that are anagrams of each other.

## 💡 Approach

Sort each word alphabetically.

Words that are anagrams produce the same sorted string.

Use the sorted string as a HashMap key.

## ⏱️ Time Complexity

O(n * k log k)

n = number of strings

k = average string length

## 💾 Space Complexity

O(nk)

## 🔑 Key Insight

Anagrams share identical sorted representations.

## 📚 What I Learned

- HashMaps can map patterns to groups.
- Sorting can create unique signatures.
- Grouping problems often involve building collections dynamically.