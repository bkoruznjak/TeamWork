package hr.from.bkoruznjak.teamwork.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import java.util.List;

import hr.from.bkoruznjak.teamwork.R;
import hr.from.bkoruznjak.teamwork.databinding.ActivityMainBinding;
import hr.from.bkoruznjak.teamwork.main.adapter.ProjectRecycleAdapter;
import hr.from.bkoruznjak.teamwork.main.contract.MainPresenter;
import hr.from.bkoruznjak.teamwork.main.contract.MainView;
import hr.from.bkoruznjak.teamwork.network.TeamWebApi;
import hr.from.bkoruznjak.teamwork.network.model.Project;
import hr.from.bkoruznjak.teamwork.root.TeamWorkApp;

public class MainActivity extends AppCompatActivity implements MainView {

    private ActivityMainBinding mainBinding;
    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        init();
    }

    private void init() {
        mPresenter = new MainPresenterImpl(this, ((TeamWorkApp) getApplication()).getAppComponent());
        mainBinding.recyclerViewMainContent.setLayoutManager(new LinearLayoutManager(this));
        mainBinding.recyclerViewMainContent.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
        mPresenter.loadUserProjectsToUi(TeamWebApi.USERNAME);
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
                mainBinding.recyclerViewMainContent.setAdapter(new ProjectRecycleAdapter(items));
            }
        });
    }

    @Override
    public void showMessage(String message) {
        Log.d("žžž", "random message");
    }
}
