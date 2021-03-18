package com.amrit.mayme.adapter;

import android.content.ContentUris;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.arch.core.util.Function;
import androidx.core.util.Supplier;

import com.amrit.mayme.core.Constants;
import com.amrit.mayme.core.CurUsrAction;
import com.amrit.mayme.core.Post;
import com.amrit.mayme.ui.home.CommentFragment;



public class MainPostListAdapterUtil {

    View.OnClickListener upvoteListener(Post list){
        //TODO: change color of upvote.
        //TODO: send notif if need.
        return v -> {
            switch (list.getAction()){
                case UPVOTED:
                    list.setAction(CurUsrAction.NONE);
                    list.setUpVoteCount(list.getUpVoteCount()-1);
                    break;
                case DOWNVOTED:
                    list.setDownVoteCount(list.getDownVoteCount()-1);
                case NONE:
                    list.setAction(CurUsrAction.UPVOTED);
                    list.setUpVoteCount(list.getUpVoteCount()+1);
            }
            Toast.makeText(v.getContext(), list.getUpVoteCount()+" people up voted",Toast.LENGTH_SHORT).show(); };
    }

    View.OnClickListener downvoteListener(Post list){
        return v -> {

            switch (list.getAction()){

                case DOWNVOTED:
                    list.setAction(CurUsrAction.NONE);
                    list.setDownVoteCount(list.getDownVoteCount()-1);
                    break;
                case UPVOTED:
                    list.setUpVoteCount(list.getUpVoteCount()-1);
                case NONE:
                    list.setAction(CurUsrAction.DOWNVOTED);
                    list.setDownVoteCount(list.getDownVoteCount()+1);
            }
            Toast.makeText(v.getContext(),list.getDownVoteCount()+" people down voted",Toast.LENGTH_SHORT).show(); };
    }

    View.OnClickListener commentListener(Post post, Function<CommentFragment,Integer> commentFragment){
        CommentFragment fragment = new CommentFragment();
        Bundle args = new Bundle();
        args.putLong(Constants.POST_ID,post.getPostId());
        fragment.setArguments(args);
        return v -> commentFragment.apply(fragment);
    }
}
