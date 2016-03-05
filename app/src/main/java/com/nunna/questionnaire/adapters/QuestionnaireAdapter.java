package com.nunna.questionnaire.adapters;

/**
 * Created by Sri Krishna on 04-02-2016.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nunna.questionnaire.R;
import com.nunna.questionnaire.model.QuestionDO;
import com.squareup.picasso.Picasso;

import java.util.List;

public class QuestionnaireAdapter extends
        RecyclerView.Adapter<QuestionnaireAdapter.ViewHolder> {

    private Context context;
    private List<QuestionDO> questionDOs;

    public QuestionnaireAdapter(Context context, List<QuestionDO> items) {
        this.context = context;
        this.questionDOs = questionDOs;
    }

    public void refresh(List<QuestionDO> questionDOs)
    {
        this.questionDOs = questionDOs;
        notifyDataSetChanged();
    }

    // Create new views
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflateView = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_item, null);
            return new ViewHolder(inflateView);
    }

    String BASE_IMAGE_URL = "http://54.179.128.29:8080/";
    String FILE_PATH = "images/";

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        String imagePath;
        if(position%3 == 0)
            imagePath = BASE_IMAGE_URL + FILE_PATH + "2016-02-19-13-04-11-sportentertain.jpg";
        else if(position%3 == 1)
            imagePath = BASE_IMAGE_URL + FILE_PATH + "2016-02-16-08-46-50-ent1.jpg";
        else
            imagePath = BASE_IMAGE_URL + FILE_PATH + "2016-02-14-18-30-19-parties.jpg";

        if (imagePath != null && !"".equalsIgnoreCase(imagePath)) {
            Picasso.with(context)
                    .load(imagePath)
                    .resize(100, 100)
                    .centerCrop()
                    .into(viewHolder.ivQuestion);
        }
    }

    @Override
    public int getItemCount() {
        return 12;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvCreationDate;
        public TextView tvQuestion;
        public ImageView ivQuestion;


        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            tvCreationDate = (TextView) itemLayoutView.findViewById(R.id.tvCreationDate);
            tvQuestion = (TextView) itemLayoutView.findViewById(R.id.tvQuestion);
            ivQuestion = (ImageView) itemLayoutView.findViewById(R.id.ivQuestion);
        }
    }

    // method to access in activity after updating selection
    public List<QuestionDO> getQuestions() {
        return questionDOs;
    }
}
