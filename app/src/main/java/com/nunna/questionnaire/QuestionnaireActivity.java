package com.nunna.questionnaire;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.nunna.questionnaire.adapters.QuestionnaireAdapter;
import com.nunna.questionnaire.utils.DividerItemDecoration;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Created by Sri Krishna on 04-03-2016.
 */
public class QuestionnaireActivity extends AppCompatActivity {

    private RecyclerView mTimeLineResultList;
    private QuestionnaireAdapter mQuestionnaireAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionnaire_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTimeLineResultList = (RecyclerView) findViewById(R.id.timeLineResultList);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(QuestionnaireActivity.this);
        mTimeLineResultList.setLayoutManager(mLayoutManager);
        mTimeLineResultList.addItemDecoration(new DividerItemDecoration(QuestionnaireActivity.this, DividerItemDecoration.VERTICAL_LIST));

        mQuestionnaireAdapter = new QuestionnaireAdapter(QuestionnaireActivity.this, null);
        mTimeLineResultList.setItemAnimator(new SlideInUpAnimator());
        mTimeLineResultList.setAdapter(mQuestionnaireAdapter);
    }
}
