package hr.from.bkoruznjak.teamwork.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;

import java.util.List;

import hr.from.bkoruznjak.teamwork.databinding.ItemProjectBinding;
import hr.from.bkoruznjak.teamwork.network.model.Project;

/**
 * Created by bkoruznjak on 27/09/2017.
 */

public class ProjectRecycleAdapter extends RecyclerView.Adapter<ProjectRecycleAdapter.ViewHolder> {
    private List<Project> mDataset;

    public ProjectRecycleAdapter(List<Project> myDataset) {
        mDataset = myDataset;
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


    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ItemProjectBinding mBinding;

        public ViewHolder(ItemProjectBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        public void bind(Project project) {
            mBinding.setVariable(BR.project, project);
            mBinding.executePendingBindings();
        }
    }
}




