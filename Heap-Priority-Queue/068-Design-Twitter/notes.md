# Design Twitter - Notes

## Pattern

**Merge K Sorted Lists + HashMap + Priority Queue**

The key insight:

Each user's tweets are already sorted chronologically.

Instead of collecting every tweet and sorting everything:

1. Treat each user's tweets as a sorted list.
2. Use a max heap to merge these lists.
3. Always keep the newest available tweet from each user in the heap.

---

# Data Structures

## Follow Map

```java
Map<Integer, Set<Integer>> followMap;
```

Stores:

```
user -> users they follow
```

Example:

```
1 -> {2,3,4}
```

Meaning user 1 follows users 2, 3, and 4.

A Set is used because:

- Duplicate follows are prevented.
- Removing a follow is O(1) average.

---

## Tweet Map

```java
Map<Integer, List<Tweet>> tweetMap;
```

Stores:

```
user -> list of tweets
```

Each tweet contains:

```java
class Tweet {
    int timestamp;
    int tweetId;
}
```

Tweets are stored in chronological order.

Example:

```
User 1:

[
 (time=1, id=100),
 (time=2, id=200),
 (time=3, id=300)
]
```

The newest tweet is always:

```java
tweets.get(tweets.size() - 1);
```

---

# Heap Entry

The heap needs more information than just the tweet.

```java
class HeapEntry {
    int userId;
    int tweetIndex;
    Tweet tweet;
}
```

## Why store tweetIndex?

After removing the newest tweet from a user, we need to access their next oldest tweet.

Example:

```
Index:
0    1    2

50   80   100
          ^
          removed
```

Next candidate:

```
index 1 -> 80
```

The index allows us to move backwards through the user's tweet list.

---

# getNewsFeed()

## Step 1: Find Relevant Users

The feed contains:

- Your own tweets.
- Tweets from users you follow.

Example:

```
User 1 follows:

2,3
```

Relevant users:

```
1,2,3
```

Use a Set instead of a List.

Why?

Because of self-follow:

```
follow(1,1)
```

Without a Set:

```
[1,1]
```

The same tweet could be added twice.

---

# Step 2: Add Newest Tweet From Each User

For every relevant user:

1. Get their newest tweet.
2. Add it to the max heap.

Example:

```
User 1:
100,80,50

User 2:
120,90

User 3:
110,70
```

Initial heap:

```
120
110
100
```

Only one tweet per user is stored initially.

---

# Step 3: Build Feed

Continue while:

```java
result.size() < 10 && !heap.isEmpty()
```

Process:

1. Remove newest tweet from heap.
2. Add tweet ID to result.
3. Move backwards in that user's tweet list.
4. Add the next tweet from that user into the heap.

Example:

Before:

```
User 2:

70 -> 90 -> 120
          ^
          removed
```

Add:

```
90
```

The heap always contains the best available candidates.

---

# Heap Comparator

Java PriorityQueue is a min heap by default.

To create a max heap:

```java
PriorityQueue<HeapEntry> heap =
    new PriorityQueue<>(
        (a,b) -> Integer.compare(
            b.tweet.timestamp,
            a.tweet.timestamp
        )
    );
```

Higher timestamps have higher priority.

---

# Why Not Sort All Tweets?

Brute force:

1. Collect all tweets.
2. Sort by timestamp.
3. Return first 10.

Complexity:

```
O(T log T)
```

where T is the total number of tweets.

The heap solution only considers relevant users:

```
O(F log F)
```

where F is the number of users contributing to the feed.

---

# Common Mistakes

## 1. Storing Only One Tweet Per User

Wrong:

```java
Map<Integer, Tweet>
```

A user can have many tweets.

Correct:

```java
Map<Integer, List<Tweet>>
```

---

## 2. Adding Every Tweet Into The Heap

Wrong:

```
User 1:
100
90
80

User 2:
70
60
50
```

Adding everything:

```
100
90
80
70
60
50
```

is inefficient.

Instead:

Start with:

```
100
70
```

Then add older tweets only when needed.

---

## 3. Forgetting Users With No Tweets

A followed user might not have posted.

Always check:

```java
tweets != null && !tweets.isEmpty()
```

before adding to heap.

---

## 4. Self Follow Bug

Example:

```
follow(1,1)
```

If using a List:

```
users = [1,1]
```

The same tweet can appear twice.

Solution:

Use:

```java
Set<Integer> users;
```

to remove duplicates.

---

# Complexity

Let:

- F = number of users followed
- T = total tweets

## postTweet()

```
Time: O(1)
Space: O(T)
```

---

## follow()

```
Time: O(1)
```

---

## unfollow()

```
Time: O(1)
```

---

## getNewsFeed()

Adding initial tweets:

```
O(F log F)
```

Retrieving 10 tweets:

```
O(10 log F)
```

Overall:

```
O(F log F)
```

---

# Main Takeaway

This problem is a variation of:

```
Merge K Sorted Lists
```

Each user's tweet history is already sorted.

The heap stores:

```
The newest remaining tweet from each user
```

Process:

```
Remove newest tweet
        |
        v
Add next oldest tweet from same user
```

Mental model:

```
User Timeline 1 \
User Timeline 2  ---> Max Heap ---> News Feed
User Timeline 3 /
```