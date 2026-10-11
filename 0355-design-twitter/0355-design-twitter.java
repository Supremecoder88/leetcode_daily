
import java.util.*;

class Twitter {

    // Stores each user's tweets
    private Map<Integer, List<int[]>> tweets;

    // Stores the users each user follows
    private Map<Integer, Set<Integer>> following;

    // Global timestamp to track tweet order
    private int time;

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());

        // Store [timestamp, tweetId]
        tweets.get(userId).add(new int[]{time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap =
            new PriorityQueue<>((a, b) ->
                Integer.compare(b[0], a[0]));

        List<Integer> feed = new ArrayList<>();

        // Include the user's own tweets
        addTweetsToHeap(userId, maxHeap);

        // Include tweets from followed users
        Set<Integer> users = following.getOrDefault(
            userId, Collections.emptySet());

        for (int followeeId : users) {
            addTweetsToHeap(followeeId, maxHeap);
        }

        // Get at most 10 newest tweets
        while (!maxHeap.isEmpty() && feed.size() < 10) {
            feed.add(maxHeap.poll()[1]);
        }

        return feed;
    }

    private void addTweetsToHeap(
        int userId, PriorityQueue<int[]> maxHeap) {

        List<int[]> userTweets = tweets.get(userId);

        if (userTweets == null) {
            return;
        }

        for (int[] tweet : userTweets) {
            maxHeap.offer(tweet);
        }
    }

    public void follow(int followerId, int followeeId) {
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}
