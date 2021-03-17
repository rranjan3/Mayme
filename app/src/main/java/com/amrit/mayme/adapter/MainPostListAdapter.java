package com.amrit.mayme.adapter;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.util.Supplier;
import androidx.recyclerview.widget.RecyclerView;

import com.amrit.mayme.R;
import com.amrit.mayme.core.Post;

import java.util.ArrayList;
import java.util.List;

public class MainPostListAdapter extends RecyclerView.Adapter<MainPostListAdapter.MainPostListViewHolder> implements Filterable {

    private static List<Post> aCList;
    private static List<Post> aCListFull;
    public MainPostListAdapterUtil adapterUtil;
    Supplier<Integer> commentFragment;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MainPostListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        TextView genreView;
        TextView postDurationView;
        TextView postTitleView;
        ImageView postImgView;
        ImageButton upVoteView;
        ImageButton downVoteView;
        ImageButton postCommentView;

        static IMyViewHolderClicks mListener;

        MainPostListViewHolder(View v) {
            super(v);
            TextView genreView =  v.findViewById(R.id.genre_text);
            TextView postDurationView = v.findViewById(R.id.post_duration_text);
            TextView postTitleView = v.findViewById(R.id.post_title_text);
            ImageView postImgView = v.findViewById(R.id.post_image);
            ImageButton upVoteView =  v.findViewById(R.id.upVote);
            ImageButton downVoteView =  v.findViewById(R.id.downVote);
            ImageButton postCommentView =  v.findViewById(R.id.post_comment);
            this.genreView = genreView;
            this.postDurationView = postDurationView;
            this.postTitleView = postTitleView;
            this.postImgView = postImgView;
            this.upVoteView = upVoteView;
            this.downVoteView = downVoteView;
            this.postCommentView = postCommentView;

            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            //here we can decide alot of things like which view type actuall called like What's App image or normal view
            mListener.onItemClicked( aCList.get(getAdapterPosition()));
        }
    }

    // Another constructor
    public MainPostListAdapter(List<Post> aCList, IMyViewHolderClicks mListener, androidx.core.util.Supplier<Integer> commentFragment) {
        MainPostListViewHolder.mListener = mListener;
        MainPostListAdapter.aCList = aCList;
        aCListFull = new ArrayList<>(aCList);
        adapterUtil = new MainPostListAdapterUtil();
        this.commentFragment = commentFragment;
    }

    @NonNull
    @Override
    public MainPostListAdapter.MainPostListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        Log.d("onCreateViewHolder","CountryAdapter.onCreateViewHolder---------");
        View fragment = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_card_template, parent, false);
        MainPostListAdapter.MainPostListViewHolder vh = new MainPostListAdapter.MainPostListViewHolder(fragment);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MainPostListAdapter.MainPostListViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Post post = aCList.get(position);
        if(post != null){
            holder.genreView.setText(post.getGenre());
            holder.postDurationView.setText("8hr");
            holder.postTitleView.setText(post.getTitle());
//            try {
//                holder.postImgView.setImageURI(new Uri("abc"));
//            } catch (URISyntaxException e) {
//                e.printStackTrace();
//            }
            holder.upVoteView.setOnClickListener(adapterUtil.upvoteListener(post));
            holder.downVoteView.setOnClickListener(adapterUtil.downvoteListener(post));
            holder.postCommentView.setOnClickListener(adapterUtil.commentListener(post,commentFragment));
        }
    }

    public void sortCountryList(int sort){
        if(aCList!=null && !aCList.isEmpty()){
            switch (sort){
//                case R.id.sort_by_death:
//                    Collections.sort(aCList, new Comparator<Post>() {
//                        @Override
//                        public int compare(Post u1, Post u2) {
//                            return Integer.compare(u2.getTotalDeaths(), u1.getTotalDeaths());
//                        }
//                    });
//                    break;
//                case R.id.sort_by_death_today:
//                    Collections.sort(aCList, new Comparator<Post>() {
//                        @Override
//                        public int compare(Post u1, Post u2) {
//                            return Integer.compare(u2.getTotalNewDeathsToday(), u1.getTotalNewDeathsToday());
//                        }
//                    });
//                    break;
//                case R.id.sort_by_new_cases:
//                    Collections.sort(aCList, new Comparator<Post>() {
//                        @Override
//                        public int compare(Post u1, Post u2) {
//                            return Integer.compare(u2.getTotalNewCasesToday(), u1.getTotalNewCasesToday());
//                        }
//                    });
//                    break;
//                case R.id.sort_by_total_cases:
//                    Collections.sort(aCList, new Comparator<Post>() {
//                        @Override
//                        public int compare(Post u1, Post u2) {
//                            return Integer.compare(u2.getTotalCases(), u1.getTotalCases());
//                        }
//                    });
//                    break;
            }
            this.notifyDataSetChanged();
        }
    }

    public void updateReceiptsList(List<Post> newList) {
        aCList.clear();
        aCList.addAll(newList);
        aCListFull.clear();
        aCListFull.addAll(newList);
        this.notifyDataSetChanged();
    }
    public void updateReceiptsList(Post list) {
//        aCList.clear();
        aCList.add(list);
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return aCList.size();
    }

    //Creates an object filter with two method on which filtered Post is present which is shown to user
    @Override
    public Filter getFilter() {
        return  new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<Post> filteredList = new ArrayList<>();

                if (constraint == null || constraint.length() == 0) {
                    filteredList.addAll(aCListFull);
                } else {
                    String filterPattern = constraint.toString().toLowerCase().trim();

                    for (Post item : aCListFull) {
                        if (item.getTitle().toLowerCase().contains(filterPattern)) {
                            filteredList.add(item);
                        }
                    }
                }

                FilterResults results = new FilterResults();
                results.values = filteredList;

                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                aCList.clear();
                aCList.addAll((List) results.values);
                notifyDataSetChanged();
            }
        };
    }

    public interface IMyViewHolderClicks {
        //we can write own methods so that can be picked for different item touched
        void onItemClicked(Post countryData);
    }
}
