package com.wmpscc.wintertraining2017.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.wmpscc.wintertraining2017.R;
import com.wmpscc.wintertraining2017.bean.User;

/**
 * Created by wmpscc on 2018/1/21.
 */
public class RecycleViewHoder extends RecyclerView.ViewHolder {
    private TextView usernameTextView;
    private TextView ageTextView;
    private RecycleAdapter.OnItemClickListenr mOnItemClickListenr = RecycleAdapter.mOnItemClickListenr;

    public RecycleViewHoder(View itemView) {
        super(itemView);
        usernameTextView = itemView.findViewById(R.id.user_name_text_view);
        ageTextView = itemView.findViewById(R.id.age_text_view);
    }

    public void bindHolder(final User user) {
        usernameTextView.setText(user.getUsername());
        ageTextView.setText("" + user.getAge());


        if (mOnItemClickListenr != null){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListenr.onCLick(user);
                }
            });
        }


    }


}
