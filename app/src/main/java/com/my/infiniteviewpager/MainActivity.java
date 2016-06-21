package com.my.infiniteviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.my.infiniteviewpager.app.InfiniteFragmentPagerAdapter;
import com.my.infiniteviewpager.view.InfinitePagerAdapter;
import com.my.infiniteviewpager.view.InfiniteViewPager;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    InfiniteViewPager mPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPager = (InfiniteViewPager) findViewById(R.id.pager);
        InfinitePagerAdapter adapter = new DatePagerAdapter(getSupportFragmentManager(),
                Calendar.getInstance().getTime());
        mPager.setAdapter(adapter);
    }

    private class DatePagerAdapter extends InfiniteFragmentPagerAdapter {

        private Calendar mCalendar;
        private final Date mStartDate;

        public DatePagerAdapter(FragmentManager fm, Date startDate) {
            super(fm);
            mCalendar= Calendar.getInstance();
            mCalendar.setTime(startDate);
            mCalendar.set(Calendar.SECOND, 0);
            mCalendar.set(Calendar.MINUTE, 0);
            mCalendar.set(Calendar.HOUR, 0);

            mStartDate = mCalendar.getTime();
        }

        @Override
        public Fragment getItem(int position) {
            mCalendar.setTime(mStartDate);
            mCalendar.add(Calendar.DAY_OF_MONTH, position);
            return DatePagerFragment.newInstance(mCalendar.getTime());
        }
    }

}
