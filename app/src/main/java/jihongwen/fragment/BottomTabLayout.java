package jihongwen.fragment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by jihongwen on 16/8/8.
 */

public class BottomTabLayout extends RelativeLayout {

    public interface IBottomTabView {
        void changeTab(int id);
    }

    @BindViews({R.id.tab1, R.id.tab2, R.id.tab3, R.id.tab4, R.id.tab5})
    List<TextView> tabs;
    Unbinder unbinder;

    IBottomTabView iBottomTabView;

    public BottomTabLayout(Context context) {
        super(context);
        init();
    }

    public BottomTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BottomTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.bottom_tab_layout, this);
        unbinder = ButterKnife.bind(this);
    }

    public void bind(IBottomTabView view) {
        iBottomTabView = view;
    }

    @OnClick({R.id.tab1, R.id.tab2, R.id.tab3, R.id.tab4, R.id.tab5})
    @SuppressWarnings("unused")
    public void onClickTab(View view) {
        iBottomTabView.changeTab(view.getId());
    }

    public void unbind() {
        unbinder.unbind();
    }
}
