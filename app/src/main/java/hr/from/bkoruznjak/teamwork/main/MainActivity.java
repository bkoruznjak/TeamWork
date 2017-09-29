package hr.from.bkoruznjak.teamwork.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.List;

import hr.from.bkoruznjak.teamwork.R;
import hr.from.bkoruznjak.teamwork.databinding.ActivityMainBinding;
import hr.from.bkoruznjak.teamwork.detail.DetailActivity;
import hr.from.bkoruznjak.teamwork.detail.ProjectDetail;
import hr.from.bkoruznjak.teamwork.main.adapter.ProjectRecycleAdapter;
import hr.from.bkoruznjak.teamwork.main.contract.MainPresenter;
import hr.from.bkoruznjak.teamwork.main.contract.MainView;
import hr.from.bkoruznjak.teamwork.network.TeamWebApi;
import hr.from.bkoruznjak.teamwork.network.model.Project;
import hr.from.bkoruznjak.teamwork.root.TeamWorkApp;

public class MainActivity extends AppCompatActivity implements MainView, ProjectRecycleAdapter.OnItemClickListener {

    private ActivityMainBinding mainBinding;
    private MainPresenter mPresenter;
    private ProjectRecycleAdapter mProjectAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        init();
    }

    private void init() {
        mPresenter = new MainPresenterImpl(this, ((TeamWorkApp) getApplication()).getAppComponent());
        mProjectAdapter = new ProjectRecycleAdapter();
        mainBinding.recyclerViewMainContent.setLayoutManager(new LinearLayoutManager(this));
        mainBinding.recyclerViewMainContent.setItemAnimator(new DefaultItemAnimator());
        mainBinding.recyclerViewMainContent.setAdapter(mProjectAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
        mPresenter.loadUserProjectsToUi(TeamWebApi.USERNAME);
        mProjectAdapter.addOnItemClickListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mProjectAdapter.removeOnItemClickListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void showProgress() {
        mainBinding.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mainBinding.progressBar.setVisibility(View.INVISIBLE);
    }

    @MainThread
    @Override
    public void setItems(@NonNull final List<Project> items) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mProjectAdapter.setProjectData(items);
                mProjectAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onProjectClicked(Project project) {
        Intent detailActivityIntent = new Intent(this, DetailActivity.class);
        detailActivityIntent.putExtra(ProjectDetail.KEY, new ProjectDetail(project));
        startActivity(detailActivityIntent);
    }
}
