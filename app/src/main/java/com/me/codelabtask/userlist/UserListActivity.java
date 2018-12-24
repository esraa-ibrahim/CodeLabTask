package com.me.codelabtask.userlist;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.me.codelabtask.R;
import com.me.codelabtask.models.UsersData;

public class UserListActivity extends AppCompatActivity {

    private UserListViewModel mUserListViewModel;
    private UserListAdapter mUserListAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        mRecyclerView = findViewById(R.id.main_recycler);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mUserListViewModel = ViewModelProviders.of(this).get(UserListViewModel.class);

        mUserListAdapter = new UserListAdapter(this);

        mUserListViewModel.loadUserList();

        mUserListViewModel.userData.observe(this, new Observer<UsersData>() {
            @Override
            public void onChanged(@Nullable UsersData usersData) {
                if (usersData != null) {
                    mUserListAdapter.setData(usersData.userList);
                    mRecyclerView.setAdapter(mUserListAdapter);
                }
            }
        });
    }
}
