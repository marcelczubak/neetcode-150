import java.util.*;

class Twitter {

    // user -> users they follow
    Map<Integer, Set<Integer>> followMap;

    // user -> list of tweets
    Map<Integer, List<Tweet>> tweetMap;

    // global timestamp counter
    int time;

    // Represents an individual tweet
    private class Tweet {
        int timestamp;
        int tweetId;

        public Tweet(int timestamp, int tweetId) {
            this.timestamp = timestamp;
            this.tweetId = tweetId;
        }
    }

    // Heap entry stores enough information to find the next tweet
    private class HeapEntry {
        int userId;
        int tweetIndex;
        Tweet tweet;

        public HeapEntry(int userId, int tweetIndex, Tweet tweet) {
            this.userId = userId;
            this.tweetIndex = tweetIndex;
            this.tweet = tweet;
        }
    }


    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        time = 0;
    }


    public void postTweet(int userId, int tweetId) {

        time++;

        Tweet tweet = new Tweet(time, tweetId);

        // Create tweet list if first tweet
        tweetMap.putIfAbsent(userId, new ArrayList<>());

        tweetMap.get(userId).add(tweet);
    }


    public List<Integer> getNewsFeed(int userId) {

        List<Integer> result = new ArrayList<>();

        // Max heap: newest timestamp first
        PriorityQueue<HeapEntry> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                b.tweet.timestamp,
                a.tweet.timestamp
            )
        );

        // Users contributing to feed
        Set<Integer> users = new HashSet<>();

        // Include own tweets
        users.add(userId);

        // Include followed users
        if (followMap.containsKey(userId)) users.addAll(followMap.get(userId));

        // Add newest tweet from each user
        for (int user : users) {

            List<Tweet> tweets = tweetMap.get(user);

            // User may have no tweets
            if (tweets != null && !tweets.isEmpty()) {

                int index = tweets.size() - 1;

                maxHeap.offer(
                    new HeapEntry(
                        user,
                        index,
                        tweets.get(index)
                    )
                );
            }
        }


        // Retrieve 10 most recent tweets
        while (result.size() < 10 && !maxHeap.isEmpty()) {

            HeapEntry current = maxHeap.poll();

            result.add(current.tweet.tweetId);

            // Move backwards in this user's tweet history
            int previousIndex = current.tweetIndex - 1;

            // Add next oldest tweet from same user
            if (previousIndex >= 0) {

                maxHeap.offer(
                    new HeapEntry(
                        current.userId,
                        previousIndex,
                        tweetMap.get(current.userId).get(previousIndex)
                    )
                );
            }
        }

        return result;
    }


    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent( followerId, new HashSet<>() );
        followMap.get(followerId).add(followeeId);
    }


    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) followMap.get(followerId).remove(followeeId);
    }
}