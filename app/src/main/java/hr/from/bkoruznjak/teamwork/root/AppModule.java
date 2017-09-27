package hr.from.bkoruznjak.teamwork.root;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.preference.PreferenceManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by bkoruznjak on 27/09/2017.
 */
@Module
public class AppModule {

    private TeamWorkApp mApplication;
    private SharedPreferences mSharedPreferences;

    public AppModule(TeamWorkApp context) {
        this.mApplication = context;
        this.mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @AppScope
    public TeamWorkApp providesApplication() {
        return this.mApplication;
    }

    @Provides
    @AppScope
    public SharedPreferences providesSharedPreferences() {
        return this.mSharedPreferences;
    }

    @Provides
    @AppScope
    public ConnectivityManager provideConnectivityManager(TeamWorkApp context) {
        return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }
}
