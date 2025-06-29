package dev.final_group.khadamati.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import dev.final_group.khadamati.R;
import dev.final_group.khadamati.databinding.ItemRequestBinding;
import dev.final_group.khadamati.models.Request;
import dev.final_group.khadamati.screens.client.RateServiceActivity;

import java.util.List;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.RequestViewHolder> {

    private final List<Request> requestList;

    public RequestAdapter(List<Request> requestList) {
        this.requestList = requestList;
    }

    @NonNull
    @Override
    public RequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRequestBinding binding = ItemRequestBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new RequestViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RequestViewHolder holder, int position) {
        holder.bind(requestList.get(position));
    }

    @Override
    public int getItemCount() {
        return requestList.size();
    }

    public static class RequestViewHolder extends RecyclerView.ViewHolder {
        private final ItemRequestBinding binding;
        private final Context context;

        public RequestViewHolder(@NonNull ItemRequestBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.context = binding.getRoot().getContext();
        }

        public void bind(Request requestProvider) {
            binding.serviceName.setText(requestProvider.getServiceTitle());
            binding.serviceDescription.setText(requestProvider.getServiceDetails());

            if (requestProvider.getStatus() == 2) {
                binding.tvStatus.setVisibility(View.GONE);
                binding.reviewButton.setVisibility(View.VISIBLE);

                binding.reviewButton.setOnClickListener(v -> {
                    Intent intent = new Intent(context, RateServiceActivity.class);
                    intent.putExtra("request_id", requestProvider.getId());
                    context.startActivity(intent);
                });
            } else {
                binding.tvStatus.setVisibility(View.VISIBLE);
                binding.reviewButton.setVisibility(View.GONE);
            }

            if (requestProvider.getStatus() == 0) {
                binding.tvStatus.setText("معلق");
                binding.tvStatus.setTextColor(ContextCompat.getColor(context, R.color.pending_status));
            } else if (requestProvider.getStatus() == 1) {
                binding.tvStatus.setText("جار التنفيذ");
                binding.tvStatus.setTextColor(ContextCompat.getColor(context, R.color.underway_status));
            }
        }
    }
}

