# 📝 Notes

---

## 🏷️ Pattern

Serialization / String Parsing

---

## 🧠 Core Idea

We must design a reversible encoding scheme.

The key constraint:

> Strings may contain any characters, so delimiters are unsafe.

---

## 🚀 Final Strategy

### Encoding:
For each string:

- compute length
- append: `length + "/" + string`

---

### Decoding:

Use a pointer:

1. Read digits until `/`
2. Convert to integer length
3. Move past `/`
4. Read exactly `length` characters
5. Repeat

---

## ⚠️ Common Mistakes

- Using only delimiters (breaks with special characters)
- Not handling multi-digit lengths
- Off-by-one errors when slicing strings
- Using `String +=` instead of `StringBuilder.append()`
- Forgetting to move pointer correctly after reading a word

---

## 🔄 Similar Problems

- Serialize and Deserialize Binary Tree
- Design TinyURL
- String Compression
- Log Encoding Problems
- Protobuf-style encoding ideas

---

## 🎯 Pattern Recognition

If a problem asks:

- Convert structure → string
- Store multiple values in one string
- Recover original data exactly

Then think:

✔ Add length or metadata  
✔ Avoid delimiter-only parsing  
✔ Use pointer-based decoding  

---

## 🧩 Key Insight

The correctness of this problem does NOT depend on coding tricks.

It depends on:

> designing an unambiguous format first

Once the format is correct, implementation is straightforward.