package hr.from.bkoruznjak.teamwork.main;

import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Named;

import hr.from.bkoruznjak.teamwork.main.contract.MainInteractor;
import hr.from.bkoruznjak.teamwork.main.contract.MainPresenter;
import hr.from.bkoruznjak.teamwork.main.contract.MainView;
import hr.from.bkoruznjak.teamwork.network.TeamWebApi;
import hr.from.bkoruznjak.teamwork.network.model.AllProjectsResponseModel;
import hr.from.bkoruznjak.teamwork.root.AppComponent;

/**
 * Created by bkoruznjak on 27/09/2017.
 */

public class MainPresenterImpl implements MainPresenter, MainInteractor.OnDataRetrievedFromServerListener {

    @Inject
    @Named("simpleWebApi")
    TeamWebApi webApi;
    private MainView mMainView;
    private MainInteractor mMainInteractor;

    public MainPresenterImpl(MainView mainView, @NonNull AppComponent component) {
        component.inject(this);
        this.mMainView = mainView;
        this.mMainInteractor = new MainInteractorImpl(webApi);
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
    public void onSuccess(final AllProjectsResponseModel result) {
        if (mMainView != null) {
            mMainView.hideProgress();
            mMainView.setItems(result.getProjects());
        }
    }

    @Override
    public void onError(Throwable error) {
        if (mMainView != null) {
            mMainView.hideProgress();
        }
    }

    public MainView getMainView() {
        return mMainView;
    }
}
