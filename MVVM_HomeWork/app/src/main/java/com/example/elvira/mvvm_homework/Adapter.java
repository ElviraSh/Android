package com.example.elvira.mvvm_homework;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import com.example.elvira.mvvm_homework.databinding.UserItemBinding;

import java.util.LinkedList;

/**
 * Created by Elvira on 11.03.2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.UserViewHolder> {
    LinkedList<User> users;


    public Adapter() {
        users = GenerateUser.getGenerateUser().users();

    }

    @Override
    public Adapter.UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        UserItemBinding userItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.user_item,
                        parent, false);
        return new UserViewHolder(userItemBinding);

    }


    @Override
    public void onBindViewHolder(final UserViewHolder holder, final int position) {
        User currentUser = users.get(position);
        final User user1 = currentUser;
        holder.userItemBinding.setUser(currentUser);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.userItemBinding.getMainViewModel() == null)
                    holder.userItemBinding.setMainViewModel(new ViewModel(view.getContext()));
                holder.userItemBinding.getMainViewModel().click(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    public class UserViewHolder extends RecyclerView.ViewHolder {

        TextView user;
        UserItemBinding userItemBinding;


        public UserViewHolder(UserItemBinding userItemBinding) {
            super(userItemBinding.userItem);
            this.userItemBinding = userItemBinding;

            user = (TextView) itemView.findViewById(R.id.user);

        }


    }
}
