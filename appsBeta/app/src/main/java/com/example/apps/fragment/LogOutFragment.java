package com.example.apps.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.apps.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LogOutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LogOutFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_log_out, container, false);
    }
}