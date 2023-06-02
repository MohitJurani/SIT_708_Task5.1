package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NewsMainFragment extends Fragment implements NewsListAdapter.NewsItemClickListener {
    RecyclerView rcHeading;
    LinearLayoutManager linearLayoutManager;
    NewsListAdapter myRvAdapter;

    List<NewsItem> newsList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        rcHeading = view.findViewById(R.id.rv_top_stories);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NewsItem item1 = new NewsItem();
        item1.setImgId("ImageUrl");
        item1.setTitle("India bowling line-up for WTC Final still a mystery for Australia");
        item1.setDescription("David Warner has taken aim at his Ashes nemesis Stuart Broad, " + "suggesting " + "he won’t be the force who ruined the opening batsman’s 2019 tour this " + "time around.\n" + "\n" + "“He’s got to get selected first,” " + "Warner told this masthead as the Australians continued their preparations " + "for the World Test Championship final in London on Wednesday.Broad has not been shy in" + " firing public potshots at the Australians, but the expectation is that the veteran quick and " + "his new ball partner Jimmy Anderson, 41 next month, will struggle to play in all five Ashes Tests, " + "to be played over " + "six weeks.\n" + "\n" + "Broad is set to lead a depleted England attack in a Test against " + "Ireland at Lord’s, beginning on Thursday, while Anderson (groin) and Ollie Robinson (ankle) are " + "hopeful of being fit for opening Ashes Test.");


        NewsItem item2 = new NewsItem();
        item2.setImgId("ImageUrl");
        item2.setTitle("Ponting names India’s keys to World Test Championship Final success");
        item2.setDescription("David Warner has taken aim at his Ashes nemesis Stuart Broad, suggesting " + "he won’t be the force who ruined the opening batsman’s 2019 tour this " + "time around.\n" + "\n" + "“He’s got to get selected first,” " + "Warner told this masthead as the Australians continued their preparations " + "for the World Test Championship final in London on Wednesday.Broad has not been shy in" + " firing public potshots at the Australians, but the expectation is that the veteran quick and " + "his new ball partner Jimmy Anderson, 41 next month, will struggle to play in all five Ashes Tests, " + "to be played over " + "six weeks.\n" + "\n" + "Broad is set to lead a depleted England attack in a Test against " + "Ireland at Lord’s, beginning on Thursday, while Anderson (groin) and Ollie Robinson (ankle) are " + "hopeful of being fit for opening Ashes Test.");


        NewsItem item3 = new NewsItem();
        item3.setImgId("ImageUrl");
        item3.setTitle("Mike Hussey picks out senior India duo as key for WTC Final success");
        item3.setDescription("David Warner has taken aim at his Ashes nemesis Stuart Broad, suggesting " + "he won’t be the force who ruined the opening batsman’s 2019 tour this " + "time around.\n" + "\n" + "“He’s got to get selected first,” " + "Warner told this masthead as the Australians continued their preparations " + "for the World Test Championship final in London on Wednesday.Broad has not been shy in" + " firing public potshots at the Australians, but the expectation is that the veteran quick and " + "his new ball partner Jimmy Anderson, 41 next month, will struggle to play in all five Ashes Tests, " + "to be played over " + "six weeks.\n" + "\n" + "Broad is set to lead a depleted England attack in a Test against " + "Ireland at Lord’s, beginning on Thursday, while Anderson (groin) and Ollie Robinson (ankle) are " + "hopeful of being fit for opening Ashes Test.");


        NewsItem item4 = new NewsItem();
        item4.setImgId("ImageUrl");
        item4.setTitle("Prize money announced for ICC World Test Championship 2021-23 cycle");
        item4.setDescription("David Warner has taken aim at his Ashes nemesis Stuart Broad, suggesting " + "he won’t be the force who ruined the opening batsman’s 2019 tour this " + "time around.\n" + "\n" + "“He’s got to get selected first,” " + "Warner told this masthead as the Australians continued their preparations " + "for the World Test Championship final in London on Wednesday.Broad has not been shy in" + " firing public potshots at the Australians, but the expectation is that the veteran quick and " + "his new ball partner Jimmy Anderson, 41 next month, will struggle to play in all five Ashes Tests, " + "to be played over " + "six weeks.\n" + "\n" + "Broad is set to lead a depleted England attack in a Test against " + "Ireland at Lord’s, beginning on Thursday, while Anderson (groin) and Ollie Robinson (ankle) are " + "hopeful of being fit for opening Ashes Test.");


        NewsItem item5 = new NewsItem();
        item5.setImgId("ImageUrl");
        item5.setTitle("‘He’s got to get selected first’: Warner fires back at Broad");
        item5.setDescription("David Warner has taken aim at his Ashes nemesis Stuart Broad, suggesting " + "he won’t be the force who ruined the opening batsman’s 2019 tour this " + "time around.\n" + "\n" + "“He’s got to get selected first,” " + "Warner told this masthead as the Australians continued their preparations " + "for the World Test Championship final in London on Wednesday.Broad has not been shy in" + " firing public potshots at the Australians, but the expectation is that the veteran quick and " + "his new ball partner Jimmy Anderson, 41 next month, will struggle to play in all five Ashes Tests, " + "to be played over " + "six weeks.\n" + "\n" + "Broad is set to lead a depleted England attack in a Test against " + "Ireland at Lord’s, beginning on Thursday, while Anderson (groin) and Ollie Robinson (ankle) are " + "hopeful of being fit for opening Ashes Test.");


        newsList = new ArrayList<>();
        newsList.add(item1);
        newsList.add(item2);
        newsList.add(item3);
        newsList.add(item4);
        newsList.add(item5);


        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        myRvAdapter = new NewsListAdapter(newsList, getActivity(), this);
        rcHeading.setLayoutManager(linearLayoutManager);
        rcHeading.setAdapter(myRvAdapter);
    }

    @Override
    public void onItemClick(NewsItem item) {
        Bundle bundle = new Bundle();
        bundle.putString("id", item.getImgId());
        bundle.putString("title", item.getTitle());
        bundle.putString("description", item.getDescription());

        Fragment newsFragmwnt = new NewsDetailsFragment();
        newsFragmwnt.setArguments(bundle);
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.container, newsFragmwnt).addToBackStack("NewsMainFragment");
        fragmentTransaction.commit();
    }
}
