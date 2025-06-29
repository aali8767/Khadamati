package dev.final_group.khadamati.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import dev.final_group.khadamati.R;
import dev.final_group.khadamati.databinding.ItemServiceBinding;
import dev.final_group.khadamati.databinding.ItemServiceVerticalBinding;
import dev.final_group.khadamati.models.Service;

public class ServiceAdapter extends ListAdapter<Service, ServiceAdapter.ServiceViewHolder> {
    private final OnServiceClickListener listener;
    private final boolean isVertical;

    public interface OnServiceClickListener {
        void onServiceClick(Service service);
    }

    public ServiceAdapter(boolean isVertical, OnServiceClickListener listener) {
        super(DIFF_CALLBACK);
        this.isVertical = isVertical;
        this.listener = listener;
    }

    public ServiceAdapter(OnServiceClickListener listener) {
        super(DIFF_CALLBACK);
        this.isVertical = false;
        this.listener = listener;
    }

    public static final DiffUtil.ItemCallback<Service> DIFF_CALLBACK = new DiffUtil.ItemCallback<Service>() {
        @Override
        public boolean areItemsTheSame(@NonNull Service oldItem, @NonNull Service newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Service oldItem, @NonNull Service newItem) {
            return oldItem.equals(newItem);
        }
    };

    @NonNull
    @Override
    public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (isVertical) {
            ItemServiceVerticalBinding binding = ItemServiceVerticalBinding.inflate(inflater, parent, false);
            return new ServiceViewHolder(binding);
        } else {
            ItemServiceBinding binding = ItemServiceBinding.inflate(inflater, parent, false);
            return new ServiceViewHolder(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceViewHolder holder, int position) {
        Service service = getItem(position);
        holder.serviceNameTv.setText(service.getTitle());
        holder.serviceDescriptionTv.setText(service.getDetails());
        holder.itemView.setOnClickListener(v -> listener.onServiceClick(service));
    }

    public static class ServiceViewHolder extends RecyclerView.ViewHolder {
        private final TextView serviceNameTv, serviceDescriptionTv;

        public ServiceViewHolder(@NonNull ViewBinding binding) {
            super(binding.getRoot());
            serviceNameTv = binding.getRoot().findViewById(R.id.serviceNameTv);
            serviceDescriptionTv = binding.getRoot().findViewById(R.id.serviceDescriptionTv);
        }
    }
}

