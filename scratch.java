import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
class Twitter {
    private  HashMap<Integer,HashSet<Integer> >Follewers;
    private HashMap<Integer, int[]> Tweet;
    private  int sort;
    /** Initialize your data structure here. */
    public Twitter() {
        Follewers= new  HashMap<>();
        Tweet=new  HashMap<>();
        sort=0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        int[] list={userId,tweetId};
        Tweet.put(sort,list);
        sort++;

    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        int m=sort-1;
        List<Integer> listReturn= new ArrayList<Integer>();
        while(m>=0){
            int[] time=Tweet.get(m);
            HashSet<Integer> list4=Follewers.get(userId);
            if(list4==null){list4=new HashSet<Integer>();}
            list4.add(userId);
            if(list4.contains(time[0])){listReturn.add(time[1]);}
            if(listReturn.size()==10){break;}
            m=m-1;
        }return listReturn;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!Follewers.containsKey(followerId)){
            HashSet<Integer> list=new HashSet<>();
            list.add(followeeId);
            Follewers.put(followerId,list);}else{
            HashSet<Integer> list1=Follewers.get(followerId);
            list1.add(followeeId);
            Follewers.put(followerId,list1);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!Follewers.containsKey(followerId)){return;}
        HashSet<Integer> list2=Follewers.get(followerId);
        list2.remove(followeeId);
        Follewers.put(followerId,list2);
    }
}