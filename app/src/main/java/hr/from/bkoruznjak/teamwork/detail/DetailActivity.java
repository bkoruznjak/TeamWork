package hr.from.bkoruznjak.teamwork.detail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.text.ParseException;
import java.util.Date;

import hr.from.bkoruznjak.teamwork.R;
import hr.from.bkoruznjak.teamwork.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding mDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);

        Bundle data = getIntent().getExtras();
        if (data == null) {
            throw new IllegalStateException("No extras found");
        }

        ProjectDetail project = data.getParcelable(ProjectDetail.KEY);
        if (project == null) {
            throw new IllegalArgumentException("Activity started without project details");
        }
        init(project);
    }

    private void init(@NonNull final ProjectDetail project) {
        setTitle(project.getName());

        String startDateString = "";
        String startYearString = "";
        String endDateString = "";
        String endYearString = "";
        String dueToFinish = "";
        try {
            Date startDate = DateUtil.dateParseFormat.parse(project.getStartDate());
            Date endDate = DateUtil.dateParseFormat.parse(project.getEndDate());
            Date currentDate = new Date();
            startDateString = DateUtil.monthDayFormat.format(startDate);
            startYearString = DateUtil.yearFormat.format(startDate);
            endDateString = DateUtil.monthDayFormat.format(endDate);
            endYearString = DateUtil.yearFormat.format(endDate);

            dueToFinish = DateUtil.getProjectStatusString(getResources(), endDate.getTime());
            long timeDiff = endDate.getTime() - currentDate.getTime();

            if (timeDiff > 0) {
                //we still have time
                mDetailBinding.textViewProjectStatus.setBackgroundColor(getResources().getColor(R.color.jordyblue));
            } else {
                //were over due
                mDetailBinding.textViewProjectStatus.setBackgroundColor(getResources().getColor(R.color.valencia));
            }
        } catch (ParseException parEx) {
            Log.e("žžž", "parse exception:" + parEx);
        }

        mDetailBinding.textViewProjectStatus.setText(dueToFinish);
        mDetailBinding.textViewStartDate.setText(startDateString);
        mDetailBinding.textViewStartYear.setText(startYearString);
        mDetailBinding.textViewEndDate.setText(endDateString);
        mDetailBinding.textViewEndYear.setText(endYearString);
        mDetailBinding.textViewDescription.setText(project.getDescription());
    }
}
