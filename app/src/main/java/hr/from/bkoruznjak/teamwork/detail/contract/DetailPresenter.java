package hr.from.bkoruznjak.teamwork.detail.contract;

import hr.from.bkoruznjak.teamwork.detail.ProjectDetail;

/**
 * Created by bkoruznjak on 29/09/2017.
 */

public interface DetailPresenter {

    void loadProjectToUI(ProjectDetail project);

    void onDestroy();
}
