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
    private final String[] mColors={"Red","Green","Blue","Yellow","Orange","Purple","Green","Blue","Yellow","Orange","Purple","Blue","Yellow","Orange","Purple"};

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        /*  final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Pick Color");
        builder.setItems(mColors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d(TAG,"onclick" +mColors[which]);
            }
        });

        return builder.create(); */


        /*
        //This will be shown in radio button and in radio button you will have to

        final AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Pick Color");
        builder.setSingleChoiceItems(mColors,3 ,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d(TAG,"onclick" +mColors[which]);
            }
        });

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
        return builder.create();*/

        final AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Pick Color");
        builder.setMultiChoiceItems(mColors, new boolean[]{false,false,false,true,false,false,true,false,false,false,false,false,false,false,false}, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                if(b){
                    //add item to selected items list
                    Log.d(TAG, "onClick: Added: "+mColors[i]);
                }else{
                    //if the item is in selected items list
                    //remove it from the list
                    Log.d(TAG, "onClick: Removed: "+mColors[i]);
                }

            }
        });

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
