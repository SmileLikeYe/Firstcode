package com.smile.fragmenttest;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RightFragment extends Fragment {
    protected static final String LOGTAG = "RightFragment";

    public RightFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(LOGTAG, "onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOGTAG, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.right_frament,container,false);
        Log.d(LOGTAG, "onCreateView");
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(LOGTAG, "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(LOGTAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOGTAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(LOGTAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(LOGTAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(LOGTAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOGTAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(LOGTAG, "onDetach");
    }
}
