package com.example.nikhiljain.mobileapplicationproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Nikhil Jain on 08-11-2017.
 */

public class ThirdFragment extends Fragment {

    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView= inflater.inflate(R.layout.third_layout, container, false);
        return myView;
    }
}
