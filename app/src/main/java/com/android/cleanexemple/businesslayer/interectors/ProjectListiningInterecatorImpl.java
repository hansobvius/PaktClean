package com.android.cleanexemple.businesslayer.interectors;

import com.android.cleanexemple.businesslayer.models.ProjectModel;
import com.android.cleanexemple.businesslayer.repository.ProjectRepository;

import java.util.List;

public class ProjectListiningInterecatorImpl implements ProjectListinigInterector {

    ProjectListinigInterector.Callback callback;
    ProjectRepository projectRepository;

    public ProjectListiningInterecatorImpl(Callback callback, ProjectRepository projectRepository){
        this.callback = callback;
        this.projectRepository = projectRepository;
        getData();
    }

    private void getData(){
        final List<ProjectModel> projectModelList = projectRepository.getProjectListing();
        if(projectModelList == null || projectModelList.size() == 0){
            callError();
            return;
        }
        notifyDataUpdate(projectModelList);
    }

    private void notifyDataUpdate(List<ProjectModel> projectModelList) {
        callback.onProjectListRetrieved(projectModelList);
    }

    private void callError() {
        callback.onProjectRetrievedFailed("Project List are empty");
    }
}
