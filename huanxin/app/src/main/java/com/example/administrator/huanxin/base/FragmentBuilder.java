package com.example.administrator.huanxin.base;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;



public class FragmentBuilder {
	int containerViewId;
	private FragmentManager mFragmentManager;
	private static FragmentBuilder mFragmentBuilder;
	private FragmentTransaction mFragmentTransaction;
	private BaseFragment mBaseNowFragment;
	private BaseFragment mBaseLastFragment;

	private FragmentBuilder() {
		init();
	}

	/**
	 * 获取单例的方法
	 * @return
	 */
	public synchronized static FragmentBuilder getFragmentBuilder() {
		if (mFragmentBuilder == null) {
			mFragmentBuilder = new FragmentBuilder();
		}
		return mFragmentBuilder;
	}

	/**
	 *
	 * @param containerViewId   输入 一个view的地址
	 * @return                  返回一个当前类的对象
	 *
	 *
	 * 输入一个view  返回一个对象，基本上可以断定改方法是有个构建者模式的一个方法
	 */
	public FragmentBuilder containerId(int containerViewId){
		this.containerViewId = containerViewId;
		return this;
	}



	// 初始化FragmentManager   获取Fragment的对象
	private void init() {
		mFragmentManager =App.mBaseActivity.getSupportFragmentManager();
	}

	// 打开一个Fragment(隐藏上一个Fragment添加并显示当前Fragment，并将当前Fragment添加到回退栈中)
	public FragmentBuilder satrt(Class<? extends BaseFragment> fragmentClass) {
		/*if (mFragmentManager.getBackStackEntryCount()>0) {
			int count=mFragmentManager.getBackStackEntryCount();
			String name=mFragmentManager.getBackStackEntryAt(count-1).getName();
			MyApp.mBaseLastFragment = (BaseFragment) mFragmentManager
					.findFragmentByTag(name);

		}*/
		mFragmentTransaction = mFragmentManager.beginTransaction();
		mBaseNowFragment = (BaseFragment) mFragmentManager.findFragmentByTag(fragmentClass.getSimpleName());
		try {
			if (mBaseNowFragment == null) {
				//创建一个Fragment对象
				mBaseNowFragment = fragmentClass.newInstance();
				//把fragment添加到了transacttion里面
				mFragmentTransaction.add(containerViewId,
						mBaseNowFragment, fragmentClass.getSimpleName());
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		// 隐藏上一个Fragment
		if (App.mBaseLastFragment != null) {
			mFragmentTransaction.hide(App.mBaseLastFragment);
		}
		// 显示现在的Frgament
		mFragmentTransaction.show(mBaseNowFragment);
		// 并将现在的Frgament添加到回退栈中
		mFragmentTransaction.addToBackStack(fragmentClass.getSimpleName());
		return this;
	}

	// 将现在的BaseFragment赋值给上一个Fragment 并返回现在的BaseFragment
	public BaseFragment build() {
		//把当前的Fragment赋值给上一个Fargment对象
		App.mBaseLastFragment = mBaseNowFragment;
		if (mFragmentTransaction!=null){
			mFragmentTransaction.commit();
		}
		return mBaseNowFragment;
	}


}
