package com.wmpscc.wintertraining2017.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wmpscc.wintertraining2017.R;
import com.wmpscc.wintertraining2017.bean.User;

import java.util.List;

/**
 * Created by wmpscc on 2018/1/21.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleViewHoder> {

    private List<User> mUserList;

    public RecycleAdapter(List<User> userList){
        mUserList = userList;
    }

    @Override
    public RecycleViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);

        return new RecycleViewHoder(view);
    }

    //绑定每个item
    @Override
    public void onBindViewHolder(RecycleViewHoder holder, int position) {
        holder.bindHolder(mUserList.get(position));

    }

    //获取items的个数
    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    static OnItemClickListenr mOnItemClickListenr;

    public void setOnItemClickListenr(OnItemClickListenr onItemClickListenr) {
        mOnItemClickListenr = onItemClickListenr;
    }

    public interface OnItemClickListenr{
        void onCLick(User user);
    }


}
