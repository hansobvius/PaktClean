package com.android.cleanexemple.businesslayer.repository;

import com.android.cleanexemple.businesslayer.models.ProjectModel;

import java.util.List;

public interface ProjectRepository {

    List<ProjectModel> getProjectListing();
}
