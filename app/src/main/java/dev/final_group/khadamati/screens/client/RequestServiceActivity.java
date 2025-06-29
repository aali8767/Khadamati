package dev.final_group.khadamati.screens.client;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import dev.final_group.khadamati.databinding.ActivityRequestServiceBinding;
import dev.final_group.khadamati.screens.client.home.MyRequestsFragment;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.util.Calendar;
import java.util.Locale;

public class RequestServiceActivity extends AppCompatActivity {
    private ActivityRequestServiceBinding binding;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRequestServiceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.dateEt.setOnClickListener(view -> {
            calendar = Calendar.getInstance();

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    this,
                    (view1, selectedYear, selectedMonth, selectedDay) -> {
                        String selectedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                        binding.dateEt.setText(selectedDate);
                    },
                    year, month, day
            );

            datePickerDialog.show();
        });

        binding.timeEt.setOnClickListener(view -> {
            MaterialTimePicker picker = new MaterialTimePicker.Builder()
                    .setTimeFormat(TimeFormat.CLOCK_12H)
                    .setHour(12)
                    .setMinute(0)
                    .setTitleText("اختر الوقت")
                    .build();

            picker.show(getSupportFragmentManager(), "TIME_PICKER");

            picker.addOnPositiveButtonClickListener(dialog -> {
                int hour = picker.getHour();
                int minute = picker.getMinute();

                String period = hour >= 12 ? "م" : "ص";
                int hourFormatted = (hour > 12) ? hour - 12 : hour;
                hourFormatted = (hourFormatted == 0) ? 12 : hourFormatted;

                String selectedTime = String.format(Locale.getDefault(), "%02d:%02d %s", hourFormatted, minute, period);
                binding.timeEt.setText(selectedTime);
            });
            binding.confirmRequestBt.setOnClickListener(view1 -> {
                Intent intent = new Intent(getBaseContext(), MyRequestsFragment.class);
//
                startActivity(intent);
            });
        });
    }
}
