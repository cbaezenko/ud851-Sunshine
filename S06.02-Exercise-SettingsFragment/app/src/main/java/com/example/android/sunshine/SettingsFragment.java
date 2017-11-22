package com.example.android.sunshine;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;

/**
 * Created by baeza on 21.11.2017.
 */

public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener{
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.pref);

        SharedPreferences sharedPreferences=getPreferenceScreen().getSharedPreferences();
        PreferenceScreen preferenceScreen=getPreferenceScreen();

        int count =preferenceScreen.getPreferenceCount();
        for (int i=0; i<count;i++){
            Preference p = preferenceScreen.getPreference(i);
            if(!(p instanceof CheckBoxPreference)){
                String value = sharedPreferences.getString(p.getKey(),"");
                setPreferenceSummary(p,value);}
        }
    }

    private void setPreferenceSummary(Preference preference, Object value){
//        preference.setSummary(value.toString());
    String stringValue =value.toString();
    if(preference instanceof ListPreference){
            ListPreference listPreference=(ListPreference) preference;
            int preIndex =listPreference.findIndexOfValue(stringValue);
            if(preIndex>=0){
                preference.setSummary(listPreference.getEntries()[preIndex]);
            }
            else {
                preference.setSummary(stringValue);
            }
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Preference p=findPreference(key);
        if(p!=null) {
            if (!(p instanceof CheckBoxPreference)) {
                String value= sharedPreferences.getString(p.getKey(),"");
                setPreferenceSummary(p, value);
            }
        }
    }

    @Override
    public void onStart(){
        super.onStart();
    getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }
    @Override
    public void onStop(){
        super.onStop();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }
}
