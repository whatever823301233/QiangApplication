package com.lovedou.qiang.qiangapplication.custom;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Qiang on 2016/7/20.
 */
public abstract class RecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerHolder> {

    /**
     * 上下文
     */
    private Context context;
    /**
     * 数据集合
     */
    private List<T> realDataList;

    /**
     * 主构造
     *
     * @param context
     *            上下文
     */
    public RecyclerAdapter(Context context) {
        this.context = context;
    }

    /**
     * 获取上下文
     *
     * @return 上下文
     */
    public Context getContext() {
        return context;
    }

    /**
     * 获取item对象
     *
     * @param position
     *            位置
     */
    public T getItem(int position) {
        if (null != realDataList && realDataList.size() > position) {
            return realDataList.get(position);
        }
        return null;
    }

    @Override
    public int getItemCount() {
        if (null != realDataList) {
            return realDataList.size();
        }
        return 0;
    }

    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View root = createView(inflater, parent, viewType);
        return new RecyclerHolder(root, context);
    }

    /**
     * 创建item的根视图
     *
     * @param inflater
     *            LayoutInflater
     * @param parent
     *            父视图
     * @param viewType
     *            视图类型
     * @return item根视图
     */
    public abstract View createView(LayoutInflater inflater, ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(RecyclerHolder holder, int position) {
        convert(holder, realDataList.get(position), position);
    }

    /**
     * Recycler适配器填充方法
     *
     * @param holder
     *            viewholder
     * @param item
     *            javabean
     */
    public abstract void convert(RecyclerHolder holder, T item, int position);

    /**
     * 设置数据
     *
     * @param data
     *            数据
     * @param isLoadMore
     *            是否为加载更多
     * @return 适配器对象
     */
    public RecyclerAdapter<T> setData(Collection<T> data, boolean isLoadMore) {
        if (isLoadMore) {
            if (null != data && null != realDataList) {
                Iterator<T> iterator = data.iterator();
                while (iterator.hasNext()) {
                    T t = iterator.next();
                    realDataList.add(t);
                }
            }
        } else {
            if (data == null) {
                realDataList = new ArrayList<>();
            } else if (data instanceof List) {
                realDataList = (List<T>) data;
            } else {
                realDataList = new ArrayList<>(data);
            }
        }
        return this;
    }

}
