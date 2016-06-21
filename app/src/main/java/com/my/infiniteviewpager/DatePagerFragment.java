package com.my.infiniteviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DatePagerFragment extends Fragment {

    public static DatePagerFragment newInstance(Date date) {
        DatePagerFragment fragment = new DatePagerFragment();
        Bundle args = new Bundle();
        args.putSerializable("date", date);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_date_pager, container, false);
        TextView dayOfWeek = (TextView) layout.findViewById(R.id.day_of_week);
        TextView day = (TextView) layout.findViewById(R.id.day);
        TextView month = (TextView) layout.findViewById(R.id.month);
        TextView year = (TextView) layout.findViewById(R.id.year);


        Date date = (Date)getArguments().getSerializable("date");
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        dayOfWeek.setText(String.valueOf(c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault())));
        day.setText(String.valueOf(c.get(Calendar.DAY_OF_MONTH)));
        month.setText(String.valueOf(c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())));
        year.setText(String.valueOf(c.get(Calendar.YEAR)));

        return layout;
    }
}
