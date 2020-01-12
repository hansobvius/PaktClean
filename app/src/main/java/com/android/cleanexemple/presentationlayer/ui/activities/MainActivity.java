package com.android.cleanexemple.presentationlayer.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.cleanexemple.R;
import com.android.cleanexemple.businesslayer.models.ProjectModel;
import com.android.cleanexemple.presentationlayer.presenter.MainPresenter;
import com.android.cleanexemple.presentationlayer.presenter.implementation.MainPresenterImpl;
import com.android.cleanexemple.presentationlayer.ui.adapter.MainAdapter;
import com.android.cleanexemple.storage.ProjectListingRepository;
import com.facebook.stetho.Stetho;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {

    private MainAdapter mMainAdapter;
    private MainPresenter mMainPresenter;
    private ListView mListView;

    private List<ProjectModel> projectModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Stetho.initializeWithDefaults(this);

        mListView = findViewById(R.id.project_list);
        mMainAdapter = new MainAdapter(this);
        mListView.setAdapter(mMainAdapter);
        mMainPresenter = new MainPresenterImpl(this, new ProjectListingRepository(this));
    }

    @Override
    protected void onResume(){
        super.onResume();
        mMainPresenter.onResume();
    }

    @Override
    public void displayProjectList(List<ProjectModel> projectModelList) {
        this.projectModelList = projectModelList;
        mMainAdapter.addItems(this.projectModelList);
    }

    @Override
    public void showProgress() {
        Toast.makeText(this, "Progress start", Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideProgress() {
        Toast.makeText(this, "Progress end", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}
