package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class HomeFragment extends Fragment {
    Button btnNews, btnProp;
    FragmentManager fm;
    FragmentTransaction fragmentTransaction;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btnNews = view.findViewById(R.id.btn_news);
        btnProp = view.findViewById(R.id.btn_property);
        fm = getActivity().getSupportFragmentManager();
        fragmentTransaction = fm.beginTransaction();
        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newsFragmwnt = new NewsMainFragment();
                fragmentTransaction.replace(R.id.container, newsFragmwnt).addToBackStack("NewsMainFragment");
                fragmentTransaction.commit();
            }
        });

        btnProp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment propertyFragment = new PropertyFragment();
                fragmentTransaction.replace(R.id.container, propertyFragment).addToBackStack("NewsMainFragment");
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}
