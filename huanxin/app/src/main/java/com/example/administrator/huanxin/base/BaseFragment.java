package com.example.administrator.huanxin.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment  {
	Bundle params;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = inflater.inflate(layoutId(), container, false);
		initView(view);
		initData();
		updateTitleBar();
		return view;
	}

	/**
	 * 初始化View控件
	 *
	 * @param view
	 */
	protected abstract void initView(View view);

	/**
	 * 初始化数据
	 */
	protected abstract void initData();

	/**
	 * 更改标题
	 */
	protected abstract void updateTitleBar();

	/**
	 * Fragment加载布局
	 */
	protected abstract int layoutId();


	/**
	 * 设置数据
	 * @param bundle
	 */
	public void setParams(Bundle bundle){
		this.params = bundle;
	}

	public Bundle getParams(){
		return params;
	}

	/**
	 * add hide show 旧的Fragemnt在跳转到新的Fragment之前会回调这个方法 旧的Frgament不会调用onStop()方法
	 * 新的Fragment也不会回调这个方法
	 */
	@Override
	public void onHiddenChanged(boolean hidden) {
		super.onHiddenChanged(hidden);

		if (hidden)
			onHidden();
		else
			onShow();

	}

	private void onShow() {
		updateTitleBar();
	}

	private void onHidden() {

	}

	@Override
	public void onDestroyView() {
		layoutId();
		super.onDestroyView();
	}


}
