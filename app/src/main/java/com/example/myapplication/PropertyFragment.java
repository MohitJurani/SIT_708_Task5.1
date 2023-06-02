package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PropertyFragment extends Fragment {
    RecyclerView rcProperties;
    LinearLayoutManager linearLayoutManager;
    PropertyListVerticalAdapter myRvAdapter;

    ImageView imageView;

    TextView tvTitle, tvDescription;

    List<PropertyItem> propertyList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_property_detail, container, false);
        rcProperties = view.findViewById(R.id.rv_top_properties);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PropertyItem item1 = new PropertyItem();
        item1.setLocation("Carlton");
        item1.setPrice("$755,871");
        item1.setBathrooms("2");
        item1.setBedrooms("3");
        item1.setParking_space("200 sq.ft");


        PropertyItem item2 = new PropertyItem();
        item2.setLocation("Burwood");
        item2.setPrice("$955,871");
        item2.setBathrooms("1");
        item2.setBedrooms("2");
        item2.setParking_space("100 sq.ft");

        PropertyItem item3 = new PropertyItem();
        item3.setLocation("Chadstone");
        item3.setPrice("$655,871");
        item3.setBathrooms("3");
        item3.setBedrooms("4");
        item3.setParking_space("150 sq.ft");


        PropertyItem item4 = new PropertyItem();
        item4.setLocation("Clayton");
        item4.setPrice("$695,871");
        item4.setBathrooms("2");
        item4.setBedrooms("1");
        item4.setParking_space("250 sq.ft");

        PropertyItem item5 = new PropertyItem();
        item5.setLocation("Doncaste");
        item5.setPrice("$1095,871");
        item5.setBathrooms("4");
        item5.setBedrooms("4");
        item5.setParking_space("450 sq.ft");

        propertyList = new ArrayList<>();
        propertyList.add(item1);
        propertyList.add(item2);
        propertyList.add(item3);
        propertyList.add(item4);
        propertyList.add(item5);


        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        myRvAdapter = new PropertyListVerticalAdapter(propertyList, getActivity());
        rcProperties.setLayoutManager(linearLayoutManager);
        rcProperties.setAdapter(myRvAdapter);
    }
}
