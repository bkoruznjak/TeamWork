package hr.from.bkoruznjak.teamwork.main;

import java.util.List;

import hr.from.bkoruznjak.teamwork.main.model.Result;

/**
 * Created by bkoruznjak on 27/09/2017.
 */

public interface MainView {

    void showProgress();

    void hideProgress();

    void setItems(List<Result> items);

    void showMessage(String message);
}
