package com.wxxiaomi.ming.electricbicycle.ui.presenter.impl;

import com.wxxiaomi.ming.electricbicycle.common.GlobalManager;
import com.wxxiaomi.ming.electricbicycle.dao.bean.Option;
import com.wxxiaomi.ming.electricbicycle.dao.db.UserService;
import com.wxxiaomi.ming.electricbicycle.support.common.myglide.ImgShower;
import com.wxxiaomi.ming.electricbicycle.ui.activity.SettingActivity;
import com.wxxiaomi.ming.electricbicycle.ui.presenter.base.BasePreImpl;
import com.wxxiaomi.ming.electricbicycle.ui.presenter.PersonalPresenter;
import com.wxxiaomi.ming.electricbicycle.ui.activity.view.PersonaView;
import com.wxxiaomi.ming.electricbicycle.ui.activity.MyInfoEditActivity;
import com.wxxiaomi.ming.electricbicycle.ui.weight.adapter.OptionAdapter2;
import com.wxxiaomi.ming.electricbicycle.ui.weight.pull2refreshreview.PullToRefreshRecyclerView;

import java.util.List;

import rx.functions.Action1;

/**
 * Created by 12262 on 2016/11/1.
 */

public class PersonalPreImpl extends BasePreImpl<PersonaView> implements PersonalPresenter<PersonaView>{
    private PullToRefreshRecyclerView listView;

    @Override
    public void init() {
        listView = mView.getListView();
        listView.setRefreshing(true);
        requestOptionData();
    }

    @Override
    public void onViewResume() {
        super.onViewResume();
        ImgShower.showHead(mView.getContext(), mView.getHeadView(), GlobalManager.getInstance().getUser().userCommonInfo.head);
        mView.setViewData(GlobalManager.getInstance().getUser().userCommonInfo);
    }

    private void requestOptionData() {
        UserService.getInstance().getUserOptions(GlobalManager.getInstance().getUser().userCommonInfo.id)
                .subscribe(new Action1<List<Option>>() {
                    @Override
                    public void call(List<Option> options) {
                        OptionAdapter2 adapter = new OptionAdapter2(options,mView.getContext());
                        listView.setAdapter(adapter);
                        listView.setRefreshing(false);
                    }
                });
    }

    @Override
    public void onHeadBrnClick() {
    }

    @Override
    public void onSettingClick() {
        mView.runActivity(SettingActivity.class,null,false);
    }

    @Override
    public void onEditClick() {
        mView.runActivity(MyInfoEditActivity.class,null,false);
    }


}