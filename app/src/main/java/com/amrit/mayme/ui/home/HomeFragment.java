package com.amrit.mayme.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Supplier;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.amrit.mayme.R;
import com.amrit.mayme.adapter.MainPostListAdapter;
import com.amrit.mayme.core.Post;
import com.amrit.mayme.model.PostDB;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel =
//                new ViewModelProvider(this).get(HomeViewModel.class);
//        View root = inflater.inflate(R.layout.main_card_template, container, false);
//        return root;

        View root = inflater.inflate(R.layout.main_list, container, false);
        SwipeRefreshLayout swipeContainer = root.findViewById(R.id.main_swipe_container);

        RecyclerView recyclerView = root.findViewById(R.id.main_list_recycler_view);
        recyclerView.setHasFixedSize(false);//for now

        LinearLayoutManager layoutManager = new LinearLayoutManager(inflater.getContext());
        recyclerView.setLayoutManager(layoutManager);
        final MainPostListAdapter adapter = new MainPostListAdapter(PostDB.getPosts(),
                post -> Toast.makeText(inflater.getContext(),"Nothing to show",Toast.LENGTH_SHORT).show(),getCommentFragment());
        recyclerView.setAdapter(adapter);
//        mAdapter = adapter;

        // Setup refresh listener which triggers new data loading
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
//                        fetchTimelineAsync(0);
                Toast.makeText(inflater.getContext(),"coming soon...",Toast.LENGTH_SHORT).show();
                swipeContainer.setRefreshing(false);
            }
        });
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        return root;

    }

    Supplier<Integer> getCommentFragment(){
        return () -> getParentFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new CommentFragment()).commit();
    }
}