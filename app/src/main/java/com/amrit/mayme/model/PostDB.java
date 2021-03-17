package com.amrit.mayme.model;

import com.amrit.mayme.core.Post;
import com.amrit.mayme.core.Vote;

import java.util.ArrayList;
import java.util.List;

public class PostDB {

    static List<Post> posts = new ArrayList<>();
    public static List<Post> getPosts(){
        Post post =  new Post("abc",  new String[]{"fab", "cook"},"feeling something today", "happy",4,2);
        posts.add(post);
        post =  new Post("abc",  new String[]{"tab", "cook"},"feeling nostalgic today", "nostalgic",44,32);
        posts.add(post);
        post =  new Post("abc",  new String[]{"fab", "mood"},"feeling ok types today", "sad",342,22);
        posts.add(post);
        post = new Post("abc",  new String[]{"modi", "rahul"},"driving car today", "car",932,4332);
        posts.add(post);
        post = new Post("abc",  new String[]{"india", "up"},"feeling good today", "india",2439,357);
        posts.add(post);
        return posts;
    }
}
