package com.btl.medifin.fragment.nguoidung;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.btl.medifin.activity.News;
import com.btl.medifin.activity.UpdateInfor;
import com.btl.medifin.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class NdHomeFragment extends Fragment implements View.OnClickListener{

    public NdHomeFragment() {
        // Required empty public constructor
    }

    public static NdHomeFragment newInstance() {
        NdHomeFragment fragment = new NdHomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nd_home, container, false);
        mappingView(view);
        // Inflate the layout for this fragment
        return view;
    }

    private void mappingView(View view) {
        view.findViewById(R.id.cvHistory_ndHome).setOnClickListener(this);
        view.findViewById(R.id.cvProfile_ndHome).setOnClickListener(this);
        view.findViewById(R.id.cv_message_ndHome).setOnClickListener(this);
        view.findViewById(R.id.cv_news_ndHome).setOnClickListener(this);
        view.findViewById(R.id.btnDatLich_ndHome).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        BottomNavigationView bnv = getActivity().findViewById(R.id.bottom_nav);
        switch (v.getId()){
            case R.id.btnDatLich_ndHome:
                bnv.setSelectedItemId(R.id.menu_datLich);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new NdDatLichFragment()).commit();
                break;
            case R.id.cvHistory_ndHome:
                bnv.setSelectedItemId(R.id.menu_history);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new NdHistoryFragment()).commit();
                break;
            case R.id.cvProfile_ndHome:
                getActivity().startActivity(new Intent(getContext(), UpdateInfor.class));
                break;
            case R.id.cv_message_ndHome:
                bnv.setSelectedItemId(R.id.menu_chat);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new NdChatFragment()).commit();
                break;
            case R.id.cv_news_ndHome:
                getActivity().startActivity(new Intent(getContext(), News.class));
                break;
        }
    }


}