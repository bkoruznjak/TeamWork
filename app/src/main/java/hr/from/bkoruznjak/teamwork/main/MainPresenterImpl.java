package hr.from.bkoruznjak.teamwork.main;

import java.util.List;

import hr.from.bkoruznjak.teamwork.main.model.Result;

/**
 * Created by bkoruznjak on 27/09/2017.
 */

public class MainPresenterImpl implements MainPresenter, MainInteractor.OnDataRetrievedFromServerListener {

    private MainView mMainView;
    private MainInteractor mMainInteractor;

    public MainPresenterImpl(MainView mainView) {
        this.mMainView = mainView;
        this.mMainInteractor = new MainInteractorImpl();
    }

    @Override
    public void loadUserProjectsToUi(String user) {
        mMainInteractor.getAllProjectsForUser(user, this);
        if (mMainView != null) {
            mMainView.showProgress();
        }
    }

    @Override
    public void onDestroy() {
        mMainView = null;
    }

    @Override
    public void onSuccess(List<Result> result) {
        if (mMainView != null) {
            mMainView.hideProgress();
            mMainView.setItems(result);
        }
    }

    @Override
    public void onError(Throwable error) {
        if (mMainView != null) {
            mMainView.hideProgress();
            mMainView.showMessage("Whoops an error happened");
        }
    }
}
