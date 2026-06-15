# 📝 Notes

## 🏷️ Pattern

HashSet Lookup

## 🚀 Optimized Solution

Store each number in a `HashSet` as you iterate through the array.

Before inserting:

* If the number already exists → duplicate found.
* Otherwise insert it and continue.

## 🐌 Brute Force

Compare every element with every other element.

Time Complexity: `O(n²)`

## ⚠️ Common Mistakes

* Using a `List` instead of a `HashSet`.
* Forgetting that `HashSet.contains()` is typically `O(1)`.
* Continuing after finding a duplicate instead of returning immediately.

## 🔄 Similar Problems

* Valid Anagram
* Two Sum
* Group Anagrams
* Longest Consecutive Sequence

## 🎯 Pattern Recognition

If a problem asks:

* "Have I seen this before?"
* "Does this value exist?"
* "Are all elements unique?"

Consider using a `HashSet`.
