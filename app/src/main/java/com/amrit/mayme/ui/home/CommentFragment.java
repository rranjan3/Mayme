package com.amrit.mayme.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.amrit.mayme.R;
import com.amrit.mayme.adapter.CommentAdapter;
import com.amrit.mayme.adapter.MainPostListAdapter;
import com.amrit.mayme.core.CommentSection;
import com.amrit.mayme.core.Constants;
import com.amrit.mayme.mock.CommentMock;
import com.amrit.mayme.model.PostDB;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CommentFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.comment_layout, container, false);
        Bundle args = getArguments();
        Long postId = args.getLong(Constants.POST_ID);
        Log.d("TAG", "onCreateView: "+postId);
        CommentSection commentSection = CommentMock.getPostComments(postId);
        RecyclerView recyclerView = root.findViewById(R.id.comment_recycler_view);
        recyclerView.setHasFixedSize(false);//for now

        LinearLayoutManager layoutManager = new LinearLayoutManager(inflater.getContext());
        recyclerView.setLayoutManager(layoutManager);
        final CommentAdapter adapter = new CommentAdapter(commentSection.getComments());
        recyclerView.setAdapter(adapter);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
//        FloatingActionButton fab = ((AppCompatActivity)getActivity()).findViewById(R.id.fab);
    }

    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
        FloatingActionButton fab = ((AppCompatActivity)getActivity()).findViewById(R.id.fab);
        fab.show();
    }
}
