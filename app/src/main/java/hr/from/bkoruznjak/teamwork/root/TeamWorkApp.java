package hr.from.bkoruznjak.teamwork.root;

import android.app.Application;

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
                .build();
    }

    public AppComponent getAppComponent() {
        return this.mAppComponent;
    }
}
