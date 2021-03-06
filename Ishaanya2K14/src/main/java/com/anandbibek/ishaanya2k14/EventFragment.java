package com.anandbibek.ishaanya2k14;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anand on 1/14/14.
 */
public class EventFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static EventFragment newInstance(int sectionNumber) {
        EventFragment fragment = new EventFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public EventFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_events, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.listView);
        List<Map<String,String>> data = new ArrayList<Map<String, String>>();

        String[] event_names = getResources().getStringArray(R.array.event_names);
        String[] event_details = getResources().getStringArray(R.array.event_details);
        String[] event_desc = getResources().getStringArray(R.array.event_descriptions);
        for(int i=0; i<event_names.length ; i++ ){
            Map<String,String> datum = new HashMap<String, String>(2);
            datum.put("event_names",event_names[i]);
            datum.put("event_details",event_details[i]);
            datum.put("event_desc",event_desc[i]);
            int imageId = getResources().getIdentifier("event"+i,"drawable",getActivity().getPackageName());
            if(imageId==0)
                imageId=R.drawable.event_default;
            datum.put("pic_id",imageId+"");
            data.add(datum);
        }

        SimpleAdapter adapter = new SimpleAdapter(
                rootView.getContext(),
                data,
                R.layout.list_item,
                new String[]{"event_names","event_details","event_desc","pic_id"},
                new int[]{R.id.text1,R.id.text2,R.id.text3,R.id.list_img});
        listView.addHeaderView(inflater.inflate(R.layout.list_header,null));
        listView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));
    }
}
