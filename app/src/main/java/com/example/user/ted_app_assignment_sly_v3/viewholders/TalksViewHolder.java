package com.example.user.ted_app_assignment_sly_v3.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.user.ted_app_assignment_sly_v3.delegate.TalksDelegate;

public class TalksViewHolder extends RecyclerView.ViewHolder {
    TalksDelegate talksDelegate;
    public TalksViewHolder(View itemView, final TalksDelegate talksDelegate) {
        super(itemView);
        this.talksDelegate = talksDelegate;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                talksDelegate.onTapTalks();
            }
        });
    }
}
