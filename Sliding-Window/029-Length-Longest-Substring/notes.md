# 📝 Notes

---

## 🏷️ Pattern

Sliding Window + HashSet

---

## 🧠 Core Idea

Maintain a window:

```text
[left, right]
```

such that:

```text
all characters are unique
```

---

## 🚀 Algorithm Flow

### Step 1: Expand right pointer

Move through string:

```java
for (int right = 0; right < s.length(); right++)
```

---

### Step 2: Fix invalid window

If duplicate found:

```java
while (set.contains(s.charAt(right))) {
    set.remove(s.charAt(left));
    left++;
}
```

---

### Step 3: Add current character

```java
set.add(s.charAt(right));
```

---

### Step 4: Update answer

```java
maxLength = Math.max(maxLength, right - left + 1);
```

---

## 🧪 Example

```text
s = "abcabcbb"
```

| Step | Window | Max |
| ---- | ------ | --- |
| a    | a      | 1   |
| b    | ab     | 2   |
| c    | abc    | 3   |
| a    | bca    | 3   |
| b    | cab    | 3   |
| c    | abc    | 3   |
| b    | cb     | 3   |
| b    | b      | 3   |

---

## ⚠️ Common Mistakes

- Moving both pointers manually (breaks structure)
- Tracking length separately (unnecessary)
- Forgetting to shrink until valid
- Not updating max after adding character

---

## 🔄 Alternative Approaches

### ❌ Brute force

Check all substrings → O(n²)

### ❌ HashMap last-seen index

More advanced optimization (O(n) with jumps)

### ✅ HashSet sliding window

Cleanest and most intuitive approach

---

## 🎯 Pattern Recognition

If you see:

- substring
- uniqueness constraint
- longest/shortest window

Think:

✔ Sliding window  
✔ Expand right  
✔ Shrink left when invalid

---

## 🧩 Key Insight

The window is always valid:

```text
no duplicates allowed inside [left, right]
```

We only adjust `left` when this condition is broken.
