package com.badribbit.weatherbroadcast.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {
    private final SharedPreferences mySharedPreference;
    private final SharedPreferences.Editor myEditor;
    public SharedPreferencesManager(Activity activity){
        this.mySharedPreference=activity.getPreferences(Context.MODE_PRIVATE);
        this.myEditor=this.mySharedPreference.edit();
    }
    public SharedPreferences getSharedPreference(){
        return this.mySharedPreference;
    }
    public SharedPreferences.Editor getEditor(){
        return this.myEditor;
    }
    public boolean contains(String Tag){
        return this.mySharedPreference.contains(Tag);
    }
}
