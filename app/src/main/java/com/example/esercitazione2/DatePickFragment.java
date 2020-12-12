package com.example.esercitazione2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickFragment extends DialogFragment {

    private Calendar date;

    public static DatePickFragment newIstance(){
        DatePickFragment frag = new DatePickFragment();
        Bundle args = new Bundle();
        frag.setArguments(args);
        return frag;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final DatePicker datePicker = new DatePicker(getActivity());
        date = Calendar.getInstance();

        return new AlertDialog.Builder(getActivity())
                .setView(datePicker)
                .setPositiveButton(R.string.alert_dialog_ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                date.set(Calendar.YEAR, datePicker.getYear());
                                date.set(Calendar.MONTH, datePicker.getMonth());
                                date.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());
                                ((MainActivity)getActivity()).updateNascita(date);
                                ((MainActivity)getActivity()).doPositiveClick(date);
                            }
                        }
                )
                .setNegativeButton(R.string.alert_dialog_cancel,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dismiss();
                            }
                        }
                ).create();
    }
    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }


}
