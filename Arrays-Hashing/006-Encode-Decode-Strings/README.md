# 🔐 Encode and Decode Strings

## 🎯 Difficulty
Medium

## 🏷️ Pattern
String Design, Serialization, Two-Pointer Parsing

---

## ❓ Problem

Design an algorithm to encode a list of strings into a single string, and decode it back into the original list.

The encoded string must be reversible with no loss of information.

---

## 💡 Approach

We cannot rely on simple delimiters (like `/`, `#`, `,`) because strings may contain these characters.

Instead, we use a **length-prefix encoding**:


## 🔁 Encoding Strategy

For each string:
1. Get its length
2. Append `length + "/" + string`

---

## 🔁 Decoding Strategy

To decode:

1. Read characters until `/` → this gives the length
2. Parse the length
3. Read the next `length` characters as the string
4. Repeat until the end

---

## ⏱️ Time Complexity

### Encode:
O(n)

### Decode:
O(n)

Where n is the total number of characters across all strings.

---

## 💾 Space Complexity

O(1) extra space (excluding output)

---

## 🔑 Key Insight

Instead of using delimiters (which can collide with data), we embed structure using:

> explicit length metadata

This makes the encoding unambiguous and fully reversible.

---

## 📚 What I Learned

- Delimiters alone are unreliable for serialization
- Length-prefix encoding guarantees correctness
- Parsing requires careful pointer control
- `StringBuilder` should be used for efficient string construction

---

## 🧠 Pattern Recognition

If you see:

- encode/decode
- serialize/deserialize
- convert list ↔ string

Think:

1. Add structure (length or metadata)
2. Avoid relying on content characters
3. Use pointer-based decoding