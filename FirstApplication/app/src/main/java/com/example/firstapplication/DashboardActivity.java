package com.example.firstapplication;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class DashboardActivity extends Activity {

    Resources resources;
    int resOne, colour,colorMode,densityDpi, orientation, sHt, sWt, sLayout;
    int [] rollNumbers;
    String studentName;
    String [] studentNames;
    TypedArray natureImageIcons;
    TypedArray colors;
    float fontScale;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dashboard);

        resources = getResources();
        resOne = resources.getInteger(R.integer.one);
        Log.e("tag","one -- $one");
        rollNumbers = resources.getIntArray(R.array.rollNumbers);
        studentName = resources.getString(R.string.pravin);
        studentNames = resources.getStringArray(R.array.studentNames);
        colour = resources.getColor(R.color.purple_500);
        natureImageIcons = resources.obtainTypedArray(R.array.natureImageIcons);
        colors = resources.obtainTypedArray(R.array.colors);

        Configuration configuration  = resources.getConfiguration();
        configuration.locale.getDisplayCountry();
        configuration.locale.getDisplayLanguage();
        configuration.locale.getDisplayName();
        configuration.locale.getCountry();
        configuration.getLocales();
        colorMode = configuration.colorMode;
        fontScale = configuration.fontScale;

        densityDpi = configuration.densityDpi;
        //Log.e("tag","DensityDpi " + "${densityDpi}");
        orientation = configuration.orientation;
        sHt = configuration.screenHeightDp;
        sWt = configuration.screenWidthDp;
        sLayout = configuration.screenLayout;
    }

    public void makeToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}
