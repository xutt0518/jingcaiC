package com.jingcai.jingcaic.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment{
	//定义FragmentActivity对象
	public FragmentActivity mActivity; 
	public Context context;
    /** 
     * 此方法可以得到上下文对象 
     */  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        context=getActivity();
    }  
    /** 
     * 返回一个需要展示的View 
     */  
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
                             Bundle savedInstanceState) {  
        mActivity = getActivity();  
        View view = initView(inflater);  
        initFindViewById(view);  
        initData(view);
        return view;  
    }  
  
	/** 
     * 当Activity初始化之后可以在这里进行一些数据的初始化操作 
     */  
    @Override  
    public void onActivityCreated(Bundle savedInstanceState) {  
        super.onActivityCreated(savedInstanceState);  
        initData();  
        setLinstener();  
    }  
    
    /** 
     * 子类可以复写此方法初始化事件(例如点击事件) 
     */  
    protected  void setLinstener(){  
  
    } 
    /** 
     * 子类实现此抽象方法返回View进行展示 
     * 
     * @return 
     */  
    public abstract View initView(LayoutInflater inflater);  
    
    /** 
     * 初始化控件 
     */  
    protected abstract void initFindViewById(View view);  
    /**
     * 
     *页面加载数据
     */
    protected abstract void initData(View view) ;
    /** 
     * 子类在此方法中实现数据的初始化 
     */  
    public  abstract void initData() ;  
}
