package hr.from.bkoruznjak.teamwork.main.contract;

/**
 * Created by bkoruznjak on 27/09/2017.
 */

public interface MainPresenter {

    void loadUserProjectsToUi(String username);

    void onResume();

    void onDestroy();
}
