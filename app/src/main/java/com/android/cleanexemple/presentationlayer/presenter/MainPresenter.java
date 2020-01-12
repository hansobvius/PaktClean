package com.android.cleanexemple.presentationlayer.presenter;

import com.android.cleanexemple.businesslayer.models.ProjectModel;
import com.android.cleanexemple.presentationlayer.presenter.base.BasePresenter;
import com.android.cleanexemple.presentationlayer.ui.BaseView;

import java.util.List;

public interface MainPresenter extends BasePresenter {

    interface View extends BaseView {
        void displayProjectList(List<ProjectModel> projectModelList);
    }
}
