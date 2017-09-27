package hr.from.bkoruznjak.teamwork.root;

import dagger.Component;
import hr.from.bkoruznjak.teamwork.main.MainActivity;

/**
 * Created by bkoruznjak on 27/09/2017.
 */
@AppScope
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(MainActivity target);
}
