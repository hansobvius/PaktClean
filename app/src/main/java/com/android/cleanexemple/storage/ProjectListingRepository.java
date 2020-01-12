package com.android.cleanexemple.storage;

import android.content.Context;

import com.android.cleanexemple.businesslayer.models.ProjectModel;
import com.android.cleanexemple.businesslayer.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.List;

public class ProjectListingRepository implements ProjectRepository {

    ProjectDatabase projectDatabase;
    Context mContext;

    public ProjectListingRepository(Context context){
        this.mContext = context;
        projectDatabase = ProjectDatabase.getProjectDatabaseInstance(context);
        populateProjectListining(projectDatabase);
    }

    @Override
    public List<ProjectModel> getProjectListing() {

        List<ProjectModel> projectModelList = new ArrayList<>();

        ProjectDatabase projectDatabase = ProjectDatabase.getProjectDatabaseInstance(this.mContext);
        projectModelList = projectDatabase.projectDAO().getProjectList();

        return projectModelList;
    }

    private static void populateProjectListining(ProjectDatabase projectDatabase){
        List<ProjectModel> projectModelList = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            ProjectModel projectModel = new ProjectModel();
            projectModel.setDescription("Description");
            projectModel.setTitle("Project " + i);
            projectModelList.add(projectModel);
            addProject(projectDatabase, projectModel);
        }
    }

    private static void addProject(ProjectDatabase projectDatabase, ProjectModel projectModel) {
        projectDatabase.projectDAO().insertAll(projectModel);
    }

}
