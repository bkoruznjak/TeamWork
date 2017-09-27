package hr.from.bkoruznjak.teamwork.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import hr.from.bkoruznjak.teamwork.R;
import hr.from.bkoruznjak.teamwork.databinding.ActivityMainBinding;
import hr.from.bkoruznjak.teamwork.main.model.Result;
import hr.from.bkoruznjak.teamwork.root.AppConstants;
import hr.from.bkoruznjak.teamwork.root.TeamWorkApp;

public class MainActivity extends AppCompatActivity implements MainView {

    private ActivityMainBinding mainBinding;
    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ((TeamWorkApp) getApplication()).getAppComponent().inject(this);
        init();
    }

    private void init() {
        mPresenter = new MainPresenterImpl(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
        mPresenter.loadUserProjectsToUi(AppConstants.USERNAME);
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
    public void setItems(List<Result> items) {
        Log.d("žžž", "got items:" + items.size());
    }

    @Override
    public void showMessage(String message) {
        Log.d("žžž", "random message");
    }
}
