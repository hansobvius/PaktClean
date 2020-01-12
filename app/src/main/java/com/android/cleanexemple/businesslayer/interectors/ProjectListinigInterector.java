package com.android.cleanexemple.businesslayer.interectors;

import com.android.cleanexemple.businesslayer.models.ProjectModel;

import java.util.List;

public interface ProjectListinigInterector {

    interface Callback{

         void onProjectListRetrieved(List<ProjectModel>projectModelList);

         void onProjectRetrievedFailed(String error);
    }
}
