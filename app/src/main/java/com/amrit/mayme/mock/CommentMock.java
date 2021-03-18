package com.amrit.mayme.mock;

import com.amrit.mayme.core.Comment;
import com.amrit.mayme.core.CommentSection;
import com.amrit.mayme.model.UserDB;

import java.util.ArrayList;
import java.util.List;

public class CommentMock {
    public static CommentSection getPostComments(long postId){
         for(CommentSection commentSection : getComments()){
            if(commentSection.getPostId() == postId){
                return commentSection;
            }
        }
        CommentSection cmnt = new CommentSection();
        cmnt.setPostId(11);
        List<Comment> list = new ArrayList<>();
        list.add(new Comment(UserDB.getUsers().get(0).getUserName(),"this is default commnet"));
        list.add(new Comment(UserDB.getUsers().get(1).getUserName(),"postId is 11"));
        cmnt.setComments(list);
         return cmnt;
    }


    public static List<CommentSection> getComments(){
        List<CommentSection> commentSections = new ArrayList<>();
        CommentSection cmnt = new CommentSection();
        cmnt.setPostId(43277);
        List<Comment> list = new ArrayList<>();
        list.add(new Comment(UserDB.getUsers().get(0).getUserName(),"wow looking nice"));
        list.add(new Comment(UserDB.getUsers().get(1).getUserName(),"I was sure this will work"));
        list.add(new Comment(UserDB.getUsers().get(3).getUserName(),"rahul baba is not going to win this time"));
        cmnt.setComments(list);
        commentSections.add(cmnt);
        cmnt = new CommentSection();
        cmnt.setPostId(47);
        cmnt.setComments(list);
        commentSections.add(cmnt);
        cmnt = new CommentSection();
        cmnt.setPostId(147);
        cmnt.setComments(list);
        commentSections.add(cmnt);
        cmnt = new CommentSection();
        cmnt.setPostId(65219);
        list = new ArrayList<>();
        list.add(new Comment(UserDB.getUsers().get(0).getUserName(),"we should binge watch avatar"));
        cmnt.setComments(list);
        commentSections.add(cmnt);
        cmnt = new CommentSection();
        cmnt.setPostId(4194284373L);
        list.add(new Comment(UserDB.getUsers().get(0).getUserName(),"that's a huge score"));
        cmnt.setComments(list);
        commentSections.add(cmnt);

        return commentSections;
    }
}
