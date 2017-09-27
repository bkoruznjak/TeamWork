package hr.from.bkoruznjak.teamwork.main.contract;

import android.support.annotation.NonNull;

import java.util.List;

import hr.from.bkoruznjak.teamwork.main.model.Result;

/**
 * Created by bkoruznjak on 27/09/2017.
 */

public interface MainInteractor {

    void getAllProjectsForUser(String username, OnDataRetrievedFromServerListener callback);

    interface OnDataRetrievedFromServerListener {
        void onSuccess(@NonNull List<Result> result);

        void onError(@NonNull Throwable error);
    }
}
