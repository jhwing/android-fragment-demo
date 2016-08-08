package jihongwen.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;

public class MainActivity extends BaseFragmentActivity implements BottomTabLayout.IBottomTabView {

    private static final String tab1 = "tab1";
    private static final String tab2 = "tab2";
    private static final String tab3 = "tab3";
    private static final String tab4 = "tab4";
    private static final String tab5 = "tab5";

    BottomTabLayout bottomTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomTabLayout = (BottomTabLayout) findViewById(R.id.bottomTabLayout);
        bottomTabLayout.bind(this);
        if (isInitFragment) {
            bottomTabLayout.findViewById(R.id.tab1).performClick();
        }
    }

    @Override
    protected Fragment newFragmentByTag(String tag) {
        if (tab1.equals(tag)) {
            return Tab1Fragment.newInstance();
        } else if (tab2.equals(tag)) {
            return Tab2Fragment.newInstance();
        } else if (tab3.equals(tag)) {
            return Tab3Fragment.newInstance();
        } else if (tab4.equals(tag)) {
            return Tab4Fragment.newInstance();
        } else if (tab5.equals(tag)) {
            return Tab5Fragment.newInstance();
        }
        return Tab1Fragment.newInstance();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bottomTabLayout.unbind();
    }

    @Override
    public void changeTab(int id) {
        switch (id) {
            case R.id.tab1:
                changeFragment(tab1);
                break;
            case R.id.tab2:
                changeFragment(tab2);
                break;
            case R.id.tab3:
                changeFragment(tab3);
                break;
            case R.id.tab4:
                changeFragment(tab4);
                break;
            case R.id.tab5:
                changeFragment(tab5);
                break;
        }
    }
}
