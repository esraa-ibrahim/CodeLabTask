package com.me.codelabtask.userlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.me.codelabtask.R;
import com.me.codelabtask.models.User;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<User> mUserList;

    public UserListAdapter(Context context) {
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    public void setData(List<User> userList) {
        this.mUserList = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = mLayoutInflater.inflate(R.layout.view_holder_user, viewGroup, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {
        if (mUserList != null) {
            User user = mUserList.get(i);
            userViewHolder.tvUserData.setText(user.toString());
        }
    }

    @Override
    public int getItemCount() {
        if (mUserList != null) {
            return mUserList.size();
        }
        return 0;
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvUserData;

        private UserViewHolder(View itemView) {
            super(itemView);
            tvUserData = itemView.findViewById(R.id.tv_user_data);
        }
    }
}
