package com.wxxiaomi.ming.electricbicycle.ui.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;





/**
 * Created by MummyDing on 16-1-29.
 * GitHub: https://github.com/MummyDing
 * Blog: http://blog.csdn.net/mummyding
 */
public abstract class BaseFragment extends Fragment {

    protected View parentView = null;

    private void loadConfig(){

    }

    protected abstract void init();
    public abstract String getTitle();

    protected abstract int getLayoutID();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EventBus.getDefault().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = View.inflate(getContext(),getLayoutID(),null);
        init();
        loadConfig();
        return parentView;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onDestroy() {
//        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

//    @Subscribe
//    public void onEventMainThread(EventModel eventModel){
//        if(eventModel != null){
//           onEventComing(eventModel);
//        }
//    }
}
