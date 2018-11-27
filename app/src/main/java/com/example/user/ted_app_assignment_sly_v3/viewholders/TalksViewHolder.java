package com.example.user.ted_app_assignment_sly_v3.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.ted_app_assignment_sly_v3.R;
import com.example.user.ted_app_assignment_sly_v3.data.vo.SpeakerVO;
import com.example.user.ted_app_assignment_sly_v3.data.vo.TedTalksVO;
import com.example.user.ted_app_assignment_sly_v3.delegate.TalksDelegate;

import butterknife.BindView;

public class TalksViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_talks)
    ImageView iv_talks;

    @BindView(R.id.tv_talker_name)
    TextView tv_talker_name;

    @BindView(R.id.tv_talks_content)
    TextView tv_talks_content;

    @BindView(R.id.tv_time)
    TextView tvTime;

    TalksDelegate talksDelegate;

    private TedTalksVO mTalks;
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

    //add data from adapter
    public void setNewsData(TedTalksVO talks){
        mTalks= talks;

        tv_talks_content.setText(talks.getTitle());

    }
}
