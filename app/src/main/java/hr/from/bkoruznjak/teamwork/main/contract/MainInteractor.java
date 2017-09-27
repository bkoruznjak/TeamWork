package hr.from.bkoruznjak.teamwork.main.contract;

import android.support.annotation.NonNull;

import hr.from.bkoruznjak.teamwork.network.model.AllProjectsResponseModel;

/**
 * Created by bkoruznjak on 27/09/2017.
 */

public interface MainInteractor {

    void getAllProjectsForUser(String username, OnDataRetrievedFromServerListener callback);

    interface OnDataRetrievedFromServerListener {
        void onSuccess(@NonNull AllProjectsResponseModel result);

        void onError(@NonNull Throwable error);
    }
}
