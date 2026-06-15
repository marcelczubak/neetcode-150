# 🔤 Valid Anagram

## 🎯 Difficulty
Easy

## 🏷️ Pattern
HashMap, Frequency Counting

## ❓ Problem

Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.

## 💡 Approach

Count the frequency of each character in `s`.

Then decrement frequencies using characters from `t`.

If all frequencies return to zero, the strings are anagrams.

## ⏱️ Time Complexity

O(n)

## 💾 Space Complexity

O(n)

## 🔑 Key Insight

Anagrams contain exactly the same characters with exactly the same frequencies.

## 📚 What I Learned

- Frequency counting is a common HashMap pattern.
- Length checks can eliminate invalid cases immediately.
- HashMaps are useful for tracking occurrences.