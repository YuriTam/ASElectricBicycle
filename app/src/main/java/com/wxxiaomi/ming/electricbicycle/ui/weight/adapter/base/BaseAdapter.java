package com.wxxiaomi.ming.electricbicycle.ui.weight.adapter.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.wxxiaomi.ming.electricbicycle.R;

/**
 * Created by 12262 on 2016/4/28.
 */
public abstract class BaseAdapter extends RecyclerView.Adapter<ViewHolder> {

    /**
     * 有数据的标识
     */
    private final int HAVADATA = 4;

    /**
     * 其他状态的标识
     */
    private final int OTHERSTATE = 5;
    /**
     * 加载是否完成
     */
    private boolean loadingComplete;
    /**
     * 是否加载失败
     */
    private boolean loadingFail;

    private Context context;

    public BaseAdapter(Context context){
        this.context = context;
    }

    private String loadingText = "正在加载中";
    private String loadFailText = "加载失败";


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case HAVADATA:
                return onCreateViewHolderOnChild(parent, viewType);
            case OTHERSTATE:
                View view = LayoutInflater.from(context).inflate(
                        R.layout.item_recycleview_state, parent, false);
                return new OtherStateViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
       if(viewHolder instanceof OtherStateViewHolder){
            OtherStateViewHolder holder = (OtherStateViewHolder) viewHolder;
            if(!loadingComplete){
                //正在加载中
                holder.rl_loading.setVisibility(View.VISIBLE);
                holder.pb_loading.setVisibility(View.VISIBLE);
//                holder.rl_loading.settext
                holder.rl_fail.setVisibility(View.GONE);
                holder.rl_nodata.setVisibility(View.GONE);
            }else if(loadingComplete && loadingFail){

                holder.rl_loading.setVisibility(View.GONE);
                holder.rl_fail.setVisibility(View.VISIBLE);
                holder.rl_nodata.setVisibility(View.GONE);
            }else if(loadingComplete){
                holder.rl_loading.setVisibility(View.GONE);
                holder.rl_fail.setVisibility(View.GONE);
                holder.rl_nodata.setVisibility(View.VISIBLE);
            }
        }else{
           onBindViewHolderOnChild(viewHolder, position);
       }

    }

    @Override
    public int getItemCount() {
        return getItemCountOnChild()==0?1:getItemCountOnChild();
    }

    @Override
    public int getItemViewType(int position) {
        return getItemCountOnChild()==0?OTHERSTATE:HAVADATA;
    }

    public class OtherStateViewHolder extends ViewHolder {
        public RelativeLayout rl_fail;
        public RelativeLayout rl_loading;
        public RelativeLayout rl_nodata;
        public ProgressBar pb_loading;

        public OtherStateViewHolder(View view) {
            super(view);
            rl_fail = (RelativeLayout) view.findViewById(R.id.rl_fail);
            rl_loading = (RelativeLayout) view.findViewById(R.id.rl_loading);
            rl_nodata = (RelativeLayout) view.findViewById(R.id.rl_nodata);
            pb_loading = (ProgressBar) view.findViewById(R.id.pb_loading);
        }
    }

    	/**
	 * 加载数据失败
	 */
	public void setLoadingFail(){
		loadingFail = true;
		notifyDataSetChanged();
	}

	/**
	 * 加载数据完成
	 */
	public void setLoadingComplete(){
		loadingComplete = true;
		notifyDataSetChanged();
	}

    public abstract ViewHolder onCreateViewHolderOnChild(ViewGroup parent, int viewType);

    public abstract void onBindViewHolderOnChild(ViewHolder holder, int position);

    public abstract int getItemCountOnChild();

    public  interface OnItemClickListener<T>{
        void onItemClick(T t);
    }

}