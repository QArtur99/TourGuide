package com.android.tourguideapp;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.tourguideapp.Fragments.Bars;
import com.android.tourguideapp.Fragments.Hotels;
import com.android.tourguideapp.Fragments.Restaurants;
import com.android.tourguideapp.Fragments.ShoppingMalls;
import com.android.tourguideapp.Fragments.TuristAttractions;

import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private int currentPosition = 1;
    private ActionBarDrawerToggle drawerToggle;
    private Fragment fragment;

    private Runnable pendingRunnable;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt("position");
            setActionBarTitle(currentPosition);
        } else {
            fragment = new TuristAttractions();
            callFragment();
            setActionBarTitle(currentPosition);
        }

        loadViews();
        navigationView();
        drawerLayout();
        backStackListener();
    }

    private void loadViews() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
    }

    private void navigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                switch (menuItem.getItemId()) {
                    case R.id.touristAttractions:
                        fragment = new TuristAttractions();
                        break;
                    case R.id.shoppingMalls:
                        fragment = new ShoppingMalls();
                        break;
                    case R.id.restaurants:
                        fragment = new Restaurants();
                        break;
                    case R.id.bars:
                        fragment = new Bars();
                        break;
                    case R.id.hotels:
                        fragment = new Hotels();
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "Somethings Wrong", Toast.LENGTH_SHORT).show();
                        return true;
                }
                drawerLayout.closeDrawers();
                pendingRunnable = new Runnable() {
                    @Override
                    public void run() {
                        callFragment();
                    }
                };
                return true;
            }
        });
    }

    private void drawerLayout() {
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();

                if (pendingRunnable != null) {
                    handler.post(pendingRunnable);
                    pendingRunnable = null;
                }

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }


        };
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    private void callFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment, "visible_fragment");
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    private void backStackListener() {
        getSupportFragmentManager().addOnBackStackChangedListener(
                new FragmentManager.OnBackStackChangedListener() {
                    public void onBackStackChanged() {
                        FragmentManager fragMan = getSupportFragmentManager();
                        Fragment fragment = fragMan.findFragmentByTag("visible_fragment");
                        if (fragment instanceof TuristAttractions) {
                            currentPosition = 1;
                        }
                        if (fragment instanceof ShoppingMalls) {
                            currentPosition = 2;
                        }
                        if (fragment instanceof Restaurants) {
                            currentPosition = 3;
                        }
                        if (fragment instanceof Bars) {
                            currentPosition = 4;
                        }
                        if (fragment instanceof Hotels) {
                            currentPosition = 5;
                        }

                        setActionBarTitle(currentPosition);
                        navigationView.getMenu().getItem(currentPosition - 1).setChecked(true);

                    }
                }
        );
        super.setResult(0);
    }

    private void setActionBarTitle(int currentPosition) {
        String title = "";
        switch (currentPosition) {
            case 1:
                title = getResources().getString(R.string.touristAttractions);
                break;
            case 2:
                title = getResources().getString(R.string.shoppingMalls);
                break;
            case 3:
                title = getResources().getString(R.string.restaurants);
                break;
            case 4:
                title = getResources().getString(R.string.bars);
                break;
            case 5:
                title = getResources().getString(R.string.hotels);
                break;
        }
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", currentPosition);
    }

    @Override
    public void onBackPressed() {
        final Fragment fragment = getSupportFragmentManager().findFragmentByTag("visible_fragment");
        if (currentPosition == 1) {
            fragment.onDestroy();
            MainActivity.this.finish();
        } else if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            super.onBackPressed();
        }
    }

    public static class ObjectComparatorByName implements Comparator<ViewObject> {
        public int compare(ViewObject obj1, ViewObject obj2) {
            return obj1.name.compareTo(obj2.name);
        }
    }
}
