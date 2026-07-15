# Permutations - Notes

## Pattern

Backtracking

Permutations are different from subsets.

Subsets:

"Do I include this element?"

Permutations:

"Which element goes next?"

---

# Recursive State

Need:

1. Current permutation

List<Integer> permutation


2. Used tracking

boolean[] used


The used array tells us which numbers are already in the current permutation.

---

# Template

backtrack(permutation, used)

Base case:

if permutation.size() == nums.length

    save copy


Otherwise:

for every number:

    if already used:
        continue

    choose

    recurse

    undo

---

# Choosing

When selecting nums[i]:

used[i] = true

permutation.add(nums[i])


Then recurse:

backtrack(...)

---

# Undoing Choice

After recursion:

used[i] = false

permutation.remove(permutation.size()-1)


This restores the state.

The next branch starts clean.

---

# Example

nums:

[1,2,3]


Start:

[]

Choose 1:

[1]


Choose 2:

[1,2]


Choose 3:

[1,2,3]

Save.


Backtrack:

Remove 3

[1,2]


Try another choice:

[1,3,2]

---

# Why Loop Every Number?

At every position, any unused number can be chosen.

Example:

After:

[1]

Possible next choices:

2

or

3


Therefore:

for (int i = 0; i < nums.length; i++)

is required.

---

# used[] Example

nums:

[1,2,3]


Current:

[1,3]


used:

[
true,
false,
true
]


Only 2 can be chosen next.

---

# Common Bugs

## Forgetting used tracking

Without used:

[1,1,1]

would be possible.

---

## Forgetting backtracking

Wrong:

add()

recurse()


Correct:

add()

recurse()

remove()

---

## Creating new state in recursion

Wrong:

new ArrayList<>()

new boolean[]


This loses the current path.

Correct:

Modify existing state.

Undo after recursion.

---

# Subsets vs Permutations

## Subsets

Order does not matter.

[1,2]

equals:

[2,1]


Uses:

index

Take / Skip


---

## Permutations

Order matters.

[1,2]

different from:

[2,1]


Uses:

used[]


Choose any available number.

---

# Complexity

Number of permutations:

n!


Each permutation takes:

n

operations to build.


Time:

O(n × n!)


Space:

O(n)

Recursion depth:

n

---

# Mental Model

Imagine filling empty slots:

_ _ _


First slot:

Choose any number.


After choosing:

X _ _


Second slot:

Choose any remaining number.


Continue until:

X X X


Every completed path is one permutation.

---

# Recognition

If the problem asks:

"Generate every ordering"

or:

"Arrange all elements"

Think:

Backtracking + used[]