package hr.from.bkoruznjak.teamwork.root;

import android.app.Application;

import hr.from.bkoruznjak.teamwork.network.NetworkModule;
import hr.from.bkoruznjak.teamwork.network.TeamWebApi;

/**
 * Created by bkoruznjak on 27/09/2017.
 */

public class TeamWorkApp extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule(TeamWebApi.BASE_URL, TeamWebApi.TEAMWORK_API_KEY, TeamWebApi.TEAMWORK_API_FAKE_PASSWORD))
                .build();
    }

    public AppComponent getAppComponent() {
        return this.mAppComponent;
    }
}
