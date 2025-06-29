package dev.final_group.khadamati.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import dev.final_group.khadamati.databinding.ItemNotificationProviderBinding;
import dev.final_group.khadamati.models.Notification;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class NotificationProviderAdapter extends RecyclerView.Adapter<NotificationProviderAdapter.NotificationProviderViewHolder> {
    private final List<Notification> notificationList;

    public NotificationProviderAdapter(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    @NonNull
    @Override
    public NotificationProviderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNotificationProviderBinding binding = ItemNotificationProviderBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new NotificationProviderViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationProviderViewHolder holder, int position) {
        holder.bind(notificationList.get(position));
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    public static class NotificationProviderViewHolder extends RecyclerView.ViewHolder {
        ItemNotificationProviderBinding binding;

        public NotificationProviderViewHolder(ItemNotificationProviderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Notification notification) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - hh:mm a", Locale.getDefault());
            String formattedDate = sdf.format(notification.getDate());
            binding.notificationDateTime.setText(formattedDate);

            binding.notificationTitle.setText(notification.getTitle());
            binding.notificationMessage.setText(notification.getMessage());

            if (notification.getRating() != null && notification.getRating() > 0) {
                binding.ratingbar.setVisibility(android.view.View.VISIBLE);
                binding.ratingbar.setRating(notification.getRating());
            } else {
                binding.ratingbar.setVisibility(android.view.View.GONE);
            }
        }
    }
}

