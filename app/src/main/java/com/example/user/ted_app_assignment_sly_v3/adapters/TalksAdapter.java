package com.example.user.ted_app_assignment_sly_v3.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.user.ted_app_assignment_sly_v3.R;
import com.example.user.ted_app_assignment_sly_v3.delegate.TalksDelegate;
import com.example.user.ted_app_assignment_sly_v3.viewholders.TalksViewHolder;

public class TalksAdapter extends RecyclerView.Adapter {

    TalksDelegate mTalksDelegate;
    public TalksAdapter(TalksDelegate talksDelegate){
        this.mTalksDelegate = talksDelegate;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.viewholder_talks, parent, false);
        return new TalksViewHolder(view, mTalksDelegate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 15;
    }
}
