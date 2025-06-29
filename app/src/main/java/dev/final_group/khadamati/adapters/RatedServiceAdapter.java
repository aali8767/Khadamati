package dev.final_group.khadamati.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import dev.final_group.khadamati.databinding.ItemServiceRatingBinding;
import dev.final_group.khadamati.models.RatedService;

import java.util.List;

public class RatedServiceAdapter extends RecyclerView.Adapter<RatedServiceAdapter.RatedServiceViewHolder> {
    private final List<RatedService> ratedServiceList;
    private final OnClickListener listener;

    public RatedServiceAdapter(List<RatedService> ratedServiceList, OnClickListener listener) {
        this.ratedServiceList = ratedServiceList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RatedServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemServiceRatingBinding binding = ItemServiceRatingBinding.inflate(inflater, parent, false);
        return new RatedServiceViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RatedServiceViewHolder holder, int position) {
        RatedService service = ratedServiceList.get(position);
        holder.bind(service,listener);
        holder.itemView.setOnClickListener(view ->{
            System.out.println("service.getId() " + service.getId());
            listener.OnRatedServiceClickListener(service.getId());
                }

        );
    }

    @Override
    public int getItemCount() {
        return ratedServiceList.size();
    }

    public static class RatedServiceViewHolder extends RecyclerView.ViewHolder {

        private final ItemServiceRatingBinding binding;

        public RatedServiceViewHolder(ItemServiceRatingBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(RatedService service, OnClickListener listener) {
            binding.tvService.setText(service.getName());
            binding.tvRate.setText(String.valueOf(service.getRating()));
            binding.ivService.setImageResource(service.getImage());
        }
    }

    public static interface OnClickListener {
        void OnRatedServiceClickListener(String serviceId);
    }
}

