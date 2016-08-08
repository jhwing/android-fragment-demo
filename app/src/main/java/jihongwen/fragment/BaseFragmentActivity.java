package jihongwen.fragment;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by jihongwen on 16/8/8.
 */

public abstract class BaseFragmentActivity extends AppCompatActivity {

    protected FragmentManager fm;
    protected String currentFragmentTag;
    protected boolean isInitFragment = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fm = getSupportFragmentManager();
        if (savedInstanceState != null) {
            currentFragmentTag = savedInstanceState.getString("currentFragmentTag");
            isInitFragment = false;
        } else {
            isInitFragment = true;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("currentFragmentTag", currentFragmentTag);
    }

    protected void changeFragment(String tag) {
        FragmentTransaction transaction = fm.beginTransaction();
        Fragment oldFragment = getCurFragment();
        if (oldFragment != null) {
            transaction.hide(oldFragment);
            oldFragment.setUserVisibleHint(false);
        }
        currentFragmentTag = tag;
        Fragment newFragment = getSupportFragmentManager().findFragmentByTag(tag);
        if (newFragment == null) {
            newFragment = newFragmentByTag(tag);
            transaction.add(R.id.fragment_container, newFragment, tag).commitAllowingStateLoss();
            newFragment.setUserVisibleHint(true);
        } else {
            transaction.show(newFragment).commitAllowingStateLoss();
            newFragment.setUserVisibleHint(true);
        }
    }

    protected Fragment getCurFragment() {
        return getSupportFragmentManager().findFragmentByTag(currentFragmentTag);
    }

    protected abstract Fragment newFragmentByTag(String tag);
}
