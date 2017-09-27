package hr.from.bkoruznjak.teamwork.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import hr.from.bkoruznjak.teamwork.R;
import hr.from.bkoruznjak.teamwork.databinding.ActivityMainBinding;
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
        Log.d("žžž", "loading...");
    }

    @Override
    public void hideProgress() {
        Log.d("žžž", "loading finished");
    }

    @Override
    public void setItems(List<Project> items) {
        Log.d("žžž", "got items:" + items.size());
    }

    @Override
    public void showMessage(String message) {
        Log.d("žžž", "random message");
    }
}
