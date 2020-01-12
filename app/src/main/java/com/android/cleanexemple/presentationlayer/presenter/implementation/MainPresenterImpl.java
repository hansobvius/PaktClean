package com.android.cleanexemple.presentationlayer.presenter.implementation;

import com.android.cleanexemple.businesslayer.interectors.ProjectListinigInterector;
import com.android.cleanexemple.businesslayer.interectors.ProjectListiningInterecatorImpl;
import com.android.cleanexemple.businesslayer.models.ProjectModel;
import com.android.cleanexemple.businesslayer.repository.ProjectRepository;
import com.android.cleanexemple.presentationlayer.presenter.MainPresenter;

import java.util.List;

public class MainPresenterImpl implements MainPresenter, ProjectListinigInterector.Callback {

    MainPresenter.View view;
    ProjectRepository projectRepository;

    public MainPresenterImpl(View view, ProjectRepository projectRepository){
        this.view = view;
        this.projectRepository = projectRepository;
    }

    @Override
    public void onResume() {
        view.showProgress();
        new ProjectListiningInterecatorImpl(this, this.projectRepository);
    }

    @Override
    public void onError(String error) {
        view.showError(error);
    }

    @Override
    public void onProjectListRetrieved(List<ProjectModel> projectModelList) {
        view.hideProgress();
        view.displayProjectList(projectModelList);
    }

    @Override
    public void onProjectRetrievedFailed(String error) {
        view.hideProgress();
        view.showError(error);
    }
}
