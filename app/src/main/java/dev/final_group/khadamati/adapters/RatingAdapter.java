package dev.final_group.khadamati.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import dev.final_group.khadamati.databinding.ItemRatingBinding;
import dev.final_group.khadamati.models.RatingModel;

import java.util.List;

public class RatingAdapter extends RecyclerView.Adapter<RatingAdapter.RatingViewHolder> {
    private final List<RatingModel> ratingList;

    public RatingAdapter(List<RatingModel> ratingList) {
        this.ratingList = ratingList;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateList(List<RatingModel> ratingList) {
        this.ratingList.clear();
        this.ratingList.addAll(ratingList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RatingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRatingBinding binding = ItemRatingBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new RatingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RatingViewHolder holder, int position) {
        RatingModel model = ratingList.get(position);
        holder.binding.userName.setText(model.getUserName());
        holder.binding.userImage.setImageResource(model.getUserImage());
        holder.binding.userRating.setRating(model.getRating());
        holder.binding.userComment.setText(model.getComment());
    }

    @Override
    public int getItemCount() {
        return ratingList.size();
    }

    public static class RatingViewHolder extends RecyclerView.ViewHolder {
        ItemRatingBinding binding;

        public RatingViewHolder(@NonNull ItemRatingBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

