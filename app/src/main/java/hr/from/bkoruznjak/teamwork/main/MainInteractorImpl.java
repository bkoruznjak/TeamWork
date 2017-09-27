package hr.from.bkoruznjak.teamwork.main;

import android.support.annotation.Nullable;

import java.io.IOException;

import hr.from.bkoruznjak.teamwork.main.contract.MainInteractor;
import hr.from.bkoruznjak.teamwork.network.TeamWebApi;
import hr.from.bkoruznjak.teamwork.network.model.AllProjectsResponseModel;
import retrofit2.Response;

/**
 * Interceptor is in charge of executing the network retrieval of
 * all projects for given username and notify the callback if it
 * exists
 * <p>
 * Created by bkoruznjak on 27/09/2017.
 */

public class MainInteractorImpl implements MainInteractor {

    private TeamWebApi mWebApi;

    public MainInteractorImpl(TeamWebApi webApi) {
        this.mWebApi = webApi;
    }

    @Override
    public void getAllProjectsForUser(final String username, @Nullable final OnDataRetrievedFromServerListener callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response<AllProjectsResponseModel> response = mWebApi.getAllProjectsForUser(String.format(TeamWebApi.GET_ALL_PROJECTS_URL, username)).execute();
                    if (response.isSuccessful()) {
                        callback.onSuccess(response.body());
                    }
                } catch (IOException ioEx) {
                    callback.onError(ioEx);
                }
            }
        }).start();
    }
}
