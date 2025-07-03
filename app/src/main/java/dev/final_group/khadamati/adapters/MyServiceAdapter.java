package dev.final_group.khadamati.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.final_group.khadamati.databinding.ItemMyServiceBinding;
import dev.final_group.khadamati.models.MyService;

public class MyServiceAdapter extends RecyclerView.Adapter<MyServiceAdapter.MyServiceViewHolder> {
    private final List<MyService> myServices;
    private final OnMyServiceClickListener listener;

    public void removeServiceFromList(int id) {
        for (int i = 0; i < myServices.size(); i++) {
            if (myServices.get(i).getId() == id) {
                myServices.remove(i);
                notifyItemRemoved(i);
                break;
            }
        }
    }

    public interface OnMyServiceClickListener {
        void onMyServiceClick(MyService myService);
    }

    public MyServiceAdapter(List<MyService> myServices, OnMyServiceClickListener listener) {
        this.myServices = myServices;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMyServiceBinding binding = ItemMyServiceBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyServiceViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyServiceViewHolder holder, int position) {
        MyService myService = myServices.get(position);
        holder.binding.serviceNameTv.setText(myService.getTitle());
        holder.binding.serviceDescriptionTv.setText(myService.getDetails());
        holder.binding.ivServiceImage.setImageResource(myService.getImage());
        holder.itemView.setOnClickListener(v -> listener.onMyServiceClick(myService));
    }

    @Override
    public int getItemCount() {
        return myServices.size();
    }

    public static class MyServiceViewHolder extends RecyclerView.ViewHolder {
        ItemMyServiceBinding binding;

        public MyServiceViewHolder(@NonNull ItemMyServiceBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
