package dev.final_group.khadamati.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import dev.final_group.khadamati.databinding.ItemProviderServiceBinding;
import dev.final_group.khadamati.models.Service;

import java.util.List;

public class ProviderServiceAdapter extends RecyclerView.Adapter<ProviderServiceAdapter.ProviderServiceViewHolder> {
    private final List<Service> services;
    private final OnServiceClickListener listener;

    public interface OnServiceClickListener {
        void onServiceClick(Service service);
    }

    public ProviderServiceAdapter(List<Service> services, OnServiceClickListener listener) {
        this.services = services;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProviderServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProviderServiceBinding binding = ItemProviderServiceBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ProviderServiceViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProviderServiceViewHolder holder, int position) {
        Service service = services.get(position);
        holder.binding.serviceNameTv.setText(service.getTitle());
        holder.binding.serviceDescriptionTv.setText(service.getDetails());
        holder.itemView.setOnClickListener(v -> listener.onServiceClick(service));
    }

    @Override
    public int getItemCount() {
        return services.size();
    }

    public static class ProviderServiceViewHolder extends RecyclerView.ViewHolder {
        private ItemProviderServiceBinding binding;

        public ProviderServiceViewHolder(@NonNull ItemProviderServiceBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
