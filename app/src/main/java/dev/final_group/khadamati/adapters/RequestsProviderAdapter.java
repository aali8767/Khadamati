package dev.final_group.khadamati.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import dev.final_group.khadamati.R;
import dev.final_group.khadamati.databinding.ItemRequestProviderBinding;
import dev.final_group.khadamati.models.RequestProvider;

import java.util.List;

public class RequestsProviderAdapter extends RecyclerView.Adapter<RequestsProviderAdapter.RequestProviderViewHolder> {

    public interface OnCompleteClickListener {
        void onComplete(RequestProvider requestProvider);

        void onAccept(RequestProvider requestProvider);

        void onReject(RequestProvider requestProvider);
    }

    private final List<RequestProvider> requestProviderList;
    private final OnCompleteClickListener listener;

    public RequestsProviderAdapter(List<RequestProvider> requestProviderList, OnCompleteClickListener listener) {
        this.requestProviderList = requestProviderList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RequestProviderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRequestProviderBinding binding = ItemRequestProviderBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new RequestProviderViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RequestProviderViewHolder holder, int position) {
        holder.bind(requestProviderList.get(position));
    }

    @Override
    public int getItemCount() {
        return requestProviderList.size();
    }

    public class RequestProviderViewHolder extends RecyclerView.ViewHolder {
        private final ItemRequestProviderBinding binding;
        private final Context context;

        RequestProviderViewHolder(ItemRequestProviderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            context = binding.getRoot().getContext();
        }

        @SuppressLint("SetTextI18n")
        void bind(RequestProvider requestProvider) {
            binding.clintImage.setImageResource(requestProvider.getImage());
            binding.clintName.setText(requestProvider.getClientName());
            binding.tvRequestTitle.setText(requestProvider.getRequestTitle());
            binding.tvRequestDescription.setText(requestProvider.getDescription());
            binding.tvClintAddress.setText("العنوان : " + requestProvider.getAddress());
            binding.tvClintPhone.setText("رقم الهاتف : " + requestProvider.getPhone());
            binding.requestTime.setText(requestProvider.getTime());

            // توثيق
            if (requestProvider.isApproved()) {
                binding.ivApproved.setImageResource(R.drawable.approve);
                binding.tvApproved.setText("موثوق");
                binding.tvApproved.setTextColor(ContextCompat.getColor(context, R.color.green));
            } else {
                binding.ivApproved.setColorFilter(R.color.gray);
                binding.tvApproved.setText("غير موثوق");
                binding.tvApproved.setTextColor(ContextCompat.getColor(context, R.color.gray));
            }

            // إظهار الحالة حسب status
            if (requestProvider.getStatus() == RequestProvider.Status.RECEIVED) {
                binding.containerButtons.setVisibility(ViewGroup.VISIBLE);
                binding.containerOnProgress.setVisibility(ViewGroup.GONE);
                binding.ratingContainer.setVisibility(ViewGroup.GONE);

                binding.btnAccept.setOnClickListener(v -> {
                    listener.onAccept(requestProvider);
                });

                binding.btnReject.setOnClickListener(v -> {
                    listener.onReject(requestProvider);
                });
                // Listener قبول/رفض يمكن إضافة هنا

            } else if (requestProvider.getStatus() == RequestProvider.Status.IN_PROGRESS) {
                binding.containerButtons.setVisibility(ViewGroup.GONE);
                binding.containerOnProgress.setVisibility(ViewGroup.VISIBLE);
                binding.ratingContainer.setVisibility(ViewGroup.GONE);

                binding.btnCompleteRequest.setOnClickListener(v -> {
                    listener.onComplete(requestProvider);
                });

            } else if (requestProvider.getStatus() == RequestProvider.Status.COMPLETED) {
                binding.containerButtons.setVisibility(ViewGroup.GONE);
                binding.containerOnProgress.setVisibility(ViewGroup.GONE);

                if (requestProvider.getRating() > 0) {
                    binding.ratingContainer.setVisibility(ViewGroup.VISIBLE);
                    binding.ratingbar.setRating(requestProvider.getRating());
                    binding.noRatingYet.setText(String.valueOf(requestProvider.getRating()));
                } else {
                    binding.ratingContainer.setVisibility(ViewGroup.VISIBLE);
                    binding.ratingbar.setRating(0);
                    binding.noRatingYet.setText("لم يتم التقيم بعد");
                }
            }
        }
    }
}

