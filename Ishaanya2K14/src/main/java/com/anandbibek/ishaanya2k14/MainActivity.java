package com.anandbibek.ishaanya2k14;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        // set which fragment is loaded based on clicked index no.
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment newInstance = new Fragment();
        switch (position) {
            case 0:
                newInstance = WelcomeFragment.newInstance(position);
                break;
            case 1:
                newInstance = EventFragment.newInstance(position);
                break;
            case 2:
                newInstance = WrkshopFragment.newInstance(position);
                break;
            case 3:
                newInstance = AboutFragment.newInstance(position);
                break;
        }
        fragmentManager.beginTransaction()
                .replace(R.id.container, newInstance)
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 0:
                mTitle = getResources().getStringArray(R.array.menu_items)[0];
                break;
            case 1:
                mTitle = getResources().getStringArray(R.array.menu_items)[1];
                break;
            case 2:
                mTitle = getResources().getStringArray(R.array.menu_items)[2];
                break;
            case 3:
                mTitle = getResources().getStringArray(R.array.menu_items)[3];
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    public void openFb(View view){
        Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.fb_link)));
        startActivity(browser);
    }
    public void openTwitter(View view){
        Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.twitter_link)));
        startActivity(browser);
    }
    public void open_reg(View view){
        Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.reg_link)));
        startActivity(browser);
    }

    public void merchandise(View view){
        Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.merchandise_link)));
        startActivity(browser);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_fb:
                openFb(null);
                return true;
            case R.id.action_twitter:
                openTwitter(null);
                return true;
            case R.id.action_merchandise:
                merchandise(null);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
