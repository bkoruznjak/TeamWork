package hr.from.bkoruznjak.teamwork.detail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import hr.from.bkoruznjak.teamwork.R;
import hr.from.bkoruznjak.teamwork.databinding.ActivityDetailBinding;
import hr.from.bkoruznjak.teamwork.detail.contract.DetailPresenter;
import hr.from.bkoruznjak.teamwork.detail.contract.DetailView;

public class DetailActivity extends AppCompatActivity implements DetailView {

    private ActivityDetailBinding mDetailBinding;
    private DetailPresenter mDetailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDetailPresenter != null) {
            mDetailPresenter.onDestroy();
        }
    }

    private void init(@NonNull final ProjectDetail project) {
        mDetailPresenter = new DetailPresenterImpl(this, getResources());
        mDetailPresenter.loadProjectToUI(project);
    }

    @Override
    public void setStartDate(String dateString, String yearString) {
        mDetailBinding.textViewStartDate.setText(dateString);
        mDetailBinding.textViewStartYear.setText(yearString);
    }

    @Override
    public void setEndDate(String dateString, String yearString) {
        mDetailBinding.textViewEndDate.setText(dateString);
        mDetailBinding.textViewEndYear.setText(yearString);
    }

    @Override
    public void setDescription(String description) {
        mDetailBinding.textViewDescription.setText(description);
    }

    @Override
    public void setProjectStatus(String status, int color) {
        mDetailBinding.textViewProjectStatus.setText(status);
        mDetailBinding.textViewProjectStatus.setBackgroundColor(color);
    }

    @Override
    public void setDetailViewTitle(String title) {
        setTitle(title);
    }
}
