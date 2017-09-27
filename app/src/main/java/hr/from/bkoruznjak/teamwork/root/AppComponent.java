package hr.from.bkoruznjak.teamwork.root;

import dagger.Component;
import hr.from.bkoruznjak.teamwork.main.MainPresenterImpl;
import hr.from.bkoruznjak.teamwork.network.NetworkModule;

/**
 * Created by bkoruznjak on 27/09/2017.
 */
@AppScope
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

    void inject(MainPresenterImpl target);
}
