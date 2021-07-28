package com.badribbit.weatherbroadcast;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;


public class PermissionAlarmDialogFragment extends DialogFragment {

    private static final int Request_Code=100;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder myBuilder=new AlertDialog.Builder(getActivity());
        myBuilder.setMessage(R.string.permission_request)
                .setPositiveButton(R.string.accept, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        PermissionRequestAccepted();
                    }
                }).setNegativeButton(R.string.decline, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                    PermissionRequestDenied();
            }
        });
        return myBuilder.create();
    }
    public void PermissionRequestAccepted(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            //Android Q or later
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_BACKGROUND_LOCATION},Request_Code);
        }else{
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION},Request_Code);
        }

    }
    public void PermissionRequestDenied(){
        Toast.makeText(getActivity(), R.string.permission_decline_inform, Toast.LENGTH_SHORT).show();
    }

}
