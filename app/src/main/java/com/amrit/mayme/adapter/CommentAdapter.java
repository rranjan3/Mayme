package com.amrit.mayme.adapter;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amrit.mayme.R;
import com.amrit.mayme.core.Comment;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder>{

    private static List<Comment> comments;
//    private static List<Post> aCListFull;
//    public CommentAdapterUtil adapterUtil;
//    Function<CommentFragment,Integer> commentFragment;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class CommentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        TextView userNameView;
        TextView commentDurationView;
        TextView commentMainView;
        ImageButton upVoteView;
        ImageButton downVoteView;
        ImageButton commentOnCommentView;


        CommentViewHolder(View v) {
            super(v);
            TextView userNameView =  v.findViewById(R.id.user_name);
            TextView commentDurationView = v.findViewById(R.id.comment_duration);
            TextView commentMainView = v.findViewById(R.id.comment_main);
            ImageButton upVoteView =  v.findViewById(R.id.comment_up_vote);
            ImageButton downVoteView =  v.findViewById(R.id.comment_down_vote);
            ImageButton commentOnCommentView =  v.findViewById(R.id.comment_on_comment);
            this.userNameView = userNameView;
            this.commentDurationView = commentDurationView;
            this.commentMainView = commentMainView;
            this.upVoteView = upVoteView;
            this.downVoteView = downVoteView;
            this.commentOnCommentView = commentOnCommentView;

            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            //here we can decide alot of things like which view type actuall called like What's App image or normal view
        }
    }

    // Another constructor
    public CommentAdapter(List<Comment> comments) {
        this.comments = comments;
//        aCListFull = new ArrayList<>(aCList);
//        adapterUtil = new CommentAdapterUtil();
//        this.commentFragment = commentFragment;
    }

    @NonNull
    @Override
    public CommentAdapter.CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        Log.d("onCreateViewHolder","CountryAdapter.onCreateViewHolder---------");
        View fragment = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_card_template, parent, false);
        CommentAdapter.CommentViewHolder vh = new CommentAdapter.CommentViewHolder(fragment);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.CommentViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Comment comment = comments.get(position);
        if(comment != null){
            holder.userNameView.setText(comment.getUserName());
            holder.commentDurationView.setText("8hr");
            holder.commentMainView.setText(comment.getComment());
//            try {
//                holder.postImgView.setImageURI(new Uri("abc"));
//            } catch (URISyntaxException e) {
//                e.printStackTrace();
//            }
//            holder.upVoteView.setOnClickListener(adapterUtil.upvoteListener(comment));
//            holder.downVoteView.setOnClickListener(adapterUtil.downvoteListener(comment));
//            holder.postCommentView.setOnClickListener(adapterUtil.commentListener(comment,commentFragment));
        }
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

}
