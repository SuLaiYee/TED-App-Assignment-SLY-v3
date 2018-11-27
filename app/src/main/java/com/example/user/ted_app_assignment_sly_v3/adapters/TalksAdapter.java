package com.example.user.ted_app_assignment_sly_v3.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.user.ted_app_assignment_sly_v3.R;
import com.example.user.ted_app_assignment_sly_v3.data.vo.TedTalksVO;
import com.example.user.ted_app_assignment_sly_v3.delegate.TalksDelegate;
import com.example.user.ted_app_assignment_sly_v3.viewholders.TalksViewHolder;

import java.util.ArrayList;
import java.util.List;

public class TalksAdapter extends RecyclerView.Adapter <TalksViewHolder>{

    TalksDelegate mTalksDelegate;
    private List<TedTalksVO> mTalksList;
    public TalksAdapter(TalksDelegate talksDelegate){
        this.mTalksDelegate = talksDelegate;
        mTalksList = new ArrayList<>();
    }

    @Override
    public TalksViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.viewholder_talks,viewGroup, false);
        return new TalksViewHolder(view, mTalksDelegate);

    }

    @Override
    public void onBindViewHolder(@NonNull TalksViewHolder talksViewHolder, int i) {
        talksViewHolder.setNewsData(mTalksList.get(i));
    }

  @Override
    public int getItemCount() {
        return mTalksList.size();
    }

    public void setTalksList(List<TedTalksVO> talksList){
        mTalksList = talksList;
        notifyDataSetChanged();
    }
}
