package com.badribbit.weatherbroadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;

import com.badribbit.weatherbroadcast.Utils.SharedPreferencesManager;
import com.badribbit.weatherbroadcast.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private static final String NotFirstTimeRunning="Not_First_Time";
    private SharedPreferencesManager sharedPreferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferencesManager=new SharedPreferencesManager(this);
        if(ShouldShowPermissionAlarmDialog()){
            sharedPreferencesManager.getEditor().putBoolean(NotFirstTimeRunning,true).apply();
            ShowPermissionAlarmDialog();
        }
    }

    private boolean ShouldShowPermissionAlarmDialog(){
        return !sharedPreferencesManager.contains(NotFirstTimeRunning);
    }

    //显示第一次进入APP时的权限申请弹窗
    private void ShowPermissionAlarmDialog(){
        DialogFragment dialogFragment=new PermissionAlarmDialogFragment();
        dialogFragment.show(getSupportFragmentManager(),"First Time");
    }


}