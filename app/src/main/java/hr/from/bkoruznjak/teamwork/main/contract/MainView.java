package hr.from.bkoruznjak.teamwork.main.contract;

import java.util.List;

import hr.from.bkoruznjak.teamwork.network.model.Project;

/**
 * Created by bkoruznjak on 27/09/2017.
 */

public interface MainView {

    void showProgress();

    void hideProgress();

    void setItems(List<Project> items);

}
