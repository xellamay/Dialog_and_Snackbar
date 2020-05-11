package com.example.dialogandsnackbar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Snackbar snackbar;
                snackbar = Snackbar.make(view, "Wow! it's fine?", Snackbar.LENGTH_LONG).setAction("Yeah :)", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                View snackbarView = snackbar.getView();

                snackbar.show();
            }
        });
    }

    public void showAlertDialog(View view) {
        AlertDialog.Builder bld = new AlertDialog.Builder(this);
        DialogInterface.OnClickListener lst = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }

        };

        bld.setMessage("Are you ready?");
        bld.setTitle("Hi!");
        bld.setNegativeButton("No =(", (DialogInterface.OnClickListener) lst);
        bld.setNeutralButton("Later", (DialogInterface.OnClickListener) lst);
        bld.setPositiveButton("Yes", (DialogInterface.OnClickListener) lst);
        AlertDialog dialog = bld.create();
        dialog.show();

    }

    public void showDateDialog(View view) {

        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            }
        };

        Calendar calendar = Calendar.getInstance();
        DatePickerDialog dialog = new DatePickerDialog(
                MainActivity.this,
                listener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));

        dialog.show();
    }

    public void showTimeDialog(View view) {

        TimePickerDialog.OnTimeSetListener startTime = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            }
        };

        Calendar newCalendar = Calendar.getInstance();
        TimePickerDialog dialog = new TimePickerDialog(
                MainActivity.this,
                startTime,
                newCalendar.get(Calendar.HOUR_OF_DAY),
                newCalendar.get(Calendar.MINUTE),
                true);

        dialog.show();
    }

}
