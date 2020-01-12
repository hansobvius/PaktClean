package com.android.cleanexemple.storage;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.android.cleanexemple.businesslayer.models.ProjectModel;

import java.util.List;

@Dao
public interface ProjectDAO {

    @Query("SELECT * FROM project")
    List<ProjectModel> getProjectList();

    @Query("SELECT * FROM project WHERE title LIKE :projectTitle")
    ProjectModel getProject(String projectTitle);

    @Insert
    void insertAll(ProjectModel projectModel);

    @Delete
    void delete(ProjectModel projectModel);
}
