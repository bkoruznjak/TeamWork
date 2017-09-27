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

    /**
     * Normally we would call this with credentials stored in shared prefs or a similar storage
     * but for the sake of this App we have a hard coded constant
     *
     * @param user
     */
    @Override
    public void loadUserProjectsToUi(String user) {
        mMainInteractor.getAllProjectsForUser(user, this);
    }

    @Override
    public void onItemClicked(int position) {
        if (mMainView != null) {
            mMainView.showMessage("item clicked:" + position);
        }
    }

    @Override
    public void onResume() {
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

    public MainView getMainView() {
        return mMainView;
    }
}
