package hr.from.bkoruznjak.teamwork.detail.contract;

/**
 * Created by bkoruznjak on 29/09/2017.
 */

public interface DetailView {

    void setStartDate(String dateString, String yearString);

    void setEndDate(String dateString, String yearString);

    void setDescription(String description);

    void setProjectStatus(String status, int color);

    void setDetailViewTitle(String title);
}
