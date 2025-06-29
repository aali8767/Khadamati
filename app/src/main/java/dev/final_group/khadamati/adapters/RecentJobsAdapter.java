package dev.final_group.khadamati.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import dev.final_group.khadamati.R;

public class RecentJobsAdapter extends RecyclerView.Adapter<RecentJobsAdapter.JobViewHolder> {

//    private List<Job> jobList;

    @NonNull
    @Override
    public JobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recent_job, parent, false);
        return new JobViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JobViewHolder holder, int position) {
//        Job job = jobList.get(position);
//        holder.tvJobTitle.setText(job.getTitle());
//        holder.tvJobDate.setText("Date: " + job.getDate());
//        holder.tvJobStatus.setText("Status: " + job.getStatus());
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    static class JobViewHolder extends RecyclerView.ViewHolder {
        TextView tvJobTitle, tvJobDate, tvJobStatus;

        JobViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJobTitle = itemView.findViewById(R.id.tvJobTitle);
            tvJobDate = itemView.findViewById(R.id.tvJobDate);
            tvJobStatus = itemView.findViewById(R.id.tvJobStatus);
        }
    }
}

