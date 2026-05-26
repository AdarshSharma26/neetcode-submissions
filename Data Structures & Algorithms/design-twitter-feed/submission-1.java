class Twitter {
    // Inner class to represent a Tweet with a global sequence timestamp
    private static class Tweet {
        int id;
        int time;
        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    private int timestamp;
    private Map<Integer, List<Tweet>> tweets;
    private Map<Integer, Set<Integer>> following;

    public Twitter() {
        this.timestamp = 0;
        this.tweets = new HashMap<>();
        this.following = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        // Add new tweet to the end of the user's tweet list
        tweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // Max-heap ordered by tweet timestamp descending
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        // Gather all users whose tweets need to be pulled (followees + self)
        Set<Integer> users = new HashSet<>();
        if (following.containsKey(userId)) {
            users.addAll(following.get(userId));
        }
        users.add(userId);
        
        // Push the most recent tweet of each user into the heap
        for (int uId : users) {
            List<Tweet> userTweets = tweets.get(uId);
            if (userTweets != null && !userTweets.isEmpty()) {
                int lastIdx = userTweets.size() - 1;
                Tweet t = userTweets.get(lastIdx);
                // Array elements: [timestamp, tweetId, userId, nextIndexInList]
                maxHeap.offer(new int[]{t.time, t.id, uId, lastIdx - 1});
            }
        }
        
        List<Integer> feed = new ArrayList<>();
        // Pop the highest timestamp tweet and insert the next one from that user
        while (!maxHeap.isEmpty() && feed.size() < 10) {
            int[] top = maxHeap.poll();
            feed.add(top[1]);
            
            int uId = top[2];
            int nextIdx = top[3];
            
            if (nextIdx >= 0) {
                Tweet nextTweet = tweets.get(uId).get(nextIdx);
                maxHeap.offer(new int[]{nextTweet.time, nextTweet.id, uId, nextIdx - 1});
            }
        }
        
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}
