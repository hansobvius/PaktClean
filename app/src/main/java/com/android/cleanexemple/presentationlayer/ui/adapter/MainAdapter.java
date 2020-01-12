package com.android.cleanexemple.presentationlayer.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.cleanexemple.R;
import com.android.cleanexemple.businesslayer.models.ProjectModel;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<ProjectModel> projectModelList = new ArrayList<>();
    private TextView mTextView;

    public MainAdapter(Context context){
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    public void addItems(List<ProjectModel> list){
        projectModelList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return projectModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return projectModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = mLayoutInflater.inflate(R.layout.item_layout, null);

        mTextView = view.findViewById(R.id.tv_title);
        mTextView.setText(projectModelList.get(position).getTitle());

        return view;
    }
}