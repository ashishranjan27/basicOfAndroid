package com.example.saifi369.simpledialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

public class FragmentAlertDialog extends DialogFragment {

    public static final String TAG = "TAG";

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //can use getContext also instaed of the getActivity and note here this will not work
        //also ki 'this' not work in fragment
        final AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        builder.setTitle("Age selection");

        builder.setMessage("Are you an adult?");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(), "Done...", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(), "No...", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                builder.create().dismiss();
            }
        });

        return builder.create();
    }

    //onCancel will be called when you press button outside the fragment dialog box and that dialog box
    //should also be exit and for exit you have to set it true alertDialog.setCancelable(true);
    //or comment that line alertDialog.setCancelable(false)
    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Log.d(TAG, "onCancel: Called");
    }


    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        Log.d(TAG, "onDismiss: Called");
    }
}
