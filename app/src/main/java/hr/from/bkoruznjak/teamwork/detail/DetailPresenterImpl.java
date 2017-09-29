package hr.from.bkoruznjak.teamwork.detail;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.Log;

import java.text.ParseException;
import java.util.Date;

import hr.from.bkoruznjak.teamwork.R;
import hr.from.bkoruznjak.teamwork.detail.contract.DetailPresenter;
import hr.from.bkoruznjak.teamwork.detail.contract.DetailView;

/**
 * Created by bkoruznjak on 29/09/2017.
 */

public class DetailPresenterImpl implements DetailPresenter {

    private DetailView mView;
    private Resources mResources;

    public DetailPresenterImpl(DetailView view, @NonNull Resources resources) {
        this.mView = view;
        this.mResources = resources;
    }


    @Override
    public void loadProjectToUI(ProjectDetail project) {
        if (mView != null) {
            mView.setDetailViewTitle(project.getName());

            String startDateString = "";
            String startYearString = "";
            String endDateString = "";
            String endYearString = "";
            try {
                Date startDate = DateUtil.dateParseFormat.parse(project.getStartDate());
                Date endDate = DateUtil.dateParseFormat.parse(project.getEndDate());
                Date currentDate = new Date();
                startDateString = DateUtil.monthDayFormat.format(startDate);
                startYearString = DateUtil.yearFormat.format(startDate);
                endDateString = DateUtil.monthDayFormat.format(endDate);
                endYearString = DateUtil.yearFormat.format(endDate);

                if (ProjectDetail.STATUS_ACTIVE.equals(project.getStatus())) {
                    long timeDiff = endDate.getTime() - currentDate.getTime();
                    int color = 0;
                    if (timeDiff > 0) {
                        //we still have time
                        color = mResources.getColor(R.color.jordyblue);
                    } else {
                        //were over due
                        color = mResources.getColor(R.color.valencia);
                    }
                    mView.setProjectStatus(DateUtil.getProjectStatusString(mResources, endDate.getTime()), color);
                }
            } catch (ParseException parEx) {
                Log.e("žžž", "parse exception:" + parEx);
            }
            mView.setStartDate(startDateString, startYearString);
            mView.setEndDate(endDateString, endYearString);
            mView.setDescription(project.getDescription());
        }
    }

    @Override
    public void onDestroy() {
        mView = null;
        mResources = null;
    }
}
