package hr.from.bkoruznjak.teamwork.main;

import android.os.Handler;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import hr.from.bkoruznjak.teamwork.main.model.Result;

/**
 * Created by bkoruznjak on 27/09/2017.
 */

public class MainInteractorImpl implements MainInteractor {


    @Override
    public void getAllProjectsForUser(final String username, @Nullable final OnDataRetrievedFromServerListener callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<Result> results = new ArrayList<Result>(5);
                results.add(new Result("abc"));
                results.add(new Result("cba"));
                results.add(new Result("bca"));
                results.add(new Result("tbf"));
                results.add(new Result("lll"));
                callback.onSuccess(results);
            }
        }, 2000);
    }
}
