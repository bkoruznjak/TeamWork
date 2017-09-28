package hr.from.bkoruznjak.teamwork.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;

import java.util.ArrayList;
import java.util.List;

import hr.from.bkoruznjak.teamwork.databinding.ItemProjectBinding;
import hr.from.bkoruznjak.teamwork.network.model.Project;

/**
 * Created by bkoruznjak on 27/09/2017.
 */

public class ProjectRecycleAdapter extends RecyclerView.Adapter<ProjectRecycleAdapter.ViewHolder> {
    private List<Project> mDataset = new ArrayList<>();
    private OnItemClickListener mItemClickListener;

    public void setProjectData(List<Project> dataset) {
        this.mDataset = dataset;
        notifyDataSetChanged();
    }

    @Override
    public ProjectRecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {

        ItemProjectBinding binding = ItemProjectBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Project project = mDataset.get(position);
        holder.bind(project);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void addOnItemClickListener(OnItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    public void removeOnItemClickListener() {
        this.mItemClickListener = null;
    }


    public interface OnItemClickListener {
        void onProjectClicked(Project project);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ItemProjectBinding mBinding;
        private Project mProject;

        public ViewHolder(ItemProjectBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
            mBinding.getRoot().setOnClickListener(this);
        }

        public void bind(Project project) {
            this.mProject = project;
            mBinding.setVariable(BR.project, project);
            mBinding.executePendingBindings();
        }

        @Override
        public void onClick(View view) {
            if (mItemClickListener != null) {
                mItemClickListener.onProjectClicked(mProject);
            }
        }
    }
}




