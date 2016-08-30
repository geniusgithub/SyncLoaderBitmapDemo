package com.geniusgithub.lazyloaddemo;


import android.app.Activity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

import com.geniusgithub.lazyloaddemo.cache.ImageLoader;


/**
 * @author lance
 * @csdn  http://blog.csdn.net/geniuseoe2012
 * @github https://github.com/geniusgithub
 * @QQgroupID 298044305
 */
public class MainActivity extends Activity {


	/** Called when the activity is first created. */
	private ListView mListview;
	private LoaderAdapter adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setupViews();
	}
	
	

	@Override
	protected void onDestroy() {
		
		
		ImageLoader imageLoader = adapter.getImageLoader();
		if (imageLoader != null){
			imageLoader.clearCache();
		}
		
		super.onDestroy();
	}



	private void setupViews() {
		mListview = (ListView) findViewById(R.id.main_lv_list);
		adapter = new LoaderAdapter(300, this, URLS);
		mListview.setAdapter(adapter);
		mListview.setOnScrollListener(mScrollListener);
	}

	OnScrollListener mScrollListener = new OnScrollListener() {

		@Override
		public void onScrollStateChanged(AbsListView view, int scrollState) {
			switch (scrollState) {
			case OnScrollListener.SCROLL_STATE_FLING:
				adapter.setFlagBusy(true);
				break;
			case OnScrollListener.SCROLL_STATE_IDLE:
				adapter.setFlagBusy(false);
				break;
			case OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
				adapter.setFlagBusy(false);
				break;
			default:
				break;
			}
			adapter.notifyDataSetChanged();
		}

		@Override
		public void onScroll(AbsListView view, int firstVisibleItem,
				int visibleItemCount, int totalItemCount) {

		}
	};


	
	
	private static final String[] URLS = {
			"http://ww3.sinaimg.cn/thumbnail/6cc0b934jw1e0bnwu709kj.jpg",
			"http://ww2.sinaimg.cn/thumbnail/519e330bjw1e0bw1icjokj.jpg",
			"http://ww3.sinaimg.cn/thumbnail/a163c684jw1e0c0gbftdpj.jpg",
			"http://ww4.sinaimg.cn/thumbnail/a163c684jw1e0c0g9tgmhj.jpg",
			"http://ww3.sinaimg.cn/thumbnail/a163c684jw1e0c0g9fxcqj.jpg",
			"http://ww4.sinaimg.cn/thumbnail/a81bce36jw1e0brpwol6yj.jpg",
			"http://ww4.sinaimg.cn/thumbnail/a81bce36jw1e0brqequ1oj.jpg",
			"http://ww1.sinaimg.cn/thumbnail/a81bce36jw1e0brpwnn0bj.jpg",
			"http://ww2.sinaimg.cn/thumbnail/721f7167jw1e0aeqrqtlfj.jpg",
			"http://ww1.sinaimg.cn/thumbnail/60dd4473jw1e0aj52otyaj.jpg",
			"http://ww2.sinaimg.cn/thumbnail/60dd4473jw1e0aj55nla0j.jpg",
			"http://ww3.sinaimg.cn/thumbnail/60dd4473jw1e0aj58f25ej.jpg",
			"http://ww2.sinaimg.cn/thumbnail/6a0eaf89jw1e08lb58kvlj.jpg",
			"http://ww1.sinaimg.cn/thumbnail/519e330bjw1e0apzdiahjj.jpg",
			"http://ww3.sinaimg.cn/thumbnail/90d9c590jw1e07wb1wzboj.jpg",
			"http://ww3.sinaimg.cn/thumbnail/90d9c590jw1e07wbbhyyjj.jpg",
			"http://ww4.sinaimg.cn/thumbnail/90d9c590jw1e07wbj69i9j.jpg",
			"http://ww4.sinaimg.cn/thumbnail/a2a3173fjw1e081ozwxjmj.jpg",
			"http://ww3.sinaimg.cn/thumbnail/6ff80741jw1e08953w5qfj.jpg",
			"http://ww4.sinaimg.cn/thumbnail/6ff80741jw1e0895blofij.jpg",
			"http://ww4.sinaimg.cn/thumbnail/6ff80741jw1e0895d36ecj.jpg",
			"http://ww3.sinaimg.cn/thumbnail/747afab6jw1dwje069pf0j.jpg",
			"http://ww3.sinaimg.cn/thumbnail/747afab6jw1dwje080cgvj.jpg",
			"http://ww1.sinaimg.cn/thumbnail/747afab6jw1dwje0816tqj.jpg",
			"http://ww1.sinaimg.cn/thumbnail/a76d9befjw1dwil9gud5wj.jpg",
			"http://ww3.sinaimg.cn/thumbnail/5214cc6fjw1dwighgidtaj.jpg",
			"http://ww4.sinaimg.cn/thumbnail/a6a477dajw1dwh76vv34fj.jpg",
			"http://ww1.sinaimg.cn/thumbnail/a6a477dajw1dwh76w0j96j.jpg",
			"http://ww2.sinaimg.cn/thumbnail/a6a477dajw1dwh76wskuoj.jpg",
			"http://ww3.sinaimg.cn/thumbnail/a4283cf3jw1dwhe1ml3tsj.jpg",
			"http://ww1.sinaimg.cn/thumbnail/628be6e8jw1dwi2v963nnj.jpg",
			"http://ww3.sinaimg.cn/thumbnail/a211c31djw1dwi80so2wqj.jpg",
			"http://ww1.sinaimg.cn/thumbnail/a211c31djw1dwi80v2f0gj.jpg",
			"http://ww1.sinaimg.cn/thumbnail/a211c31djw1dwi80we9zzj.jpg",
			"http://ww2.sinaimg.cn/thumbnail/9ad55e80jw1dwfmg3ilekj.jpg",
			"http://t3.qpic.cn/mblogpic/5d44a78a759f89af3078/500",
			"http://t3.qpic.cn/mblogpic/d85edf25f34e12b532d2/500",
			"http://t1.qpic.cn/mblogpic/f09d2d9a2e0a3350aeac/500",
			"http://t1.qpic.cn/mblogpic/71f7f57f8561a13f023c/500",
			"http://t3.qpic.cn/mblogpic/d15aaea64c6bd857f0a2/500",
			"http://t1.qpic.cn/mblogpic/7ce47ddc070683b0ad4e/500",
			"http://t3.qpic.cn/mblogpic/629643c9aa93396cb70e/500",
			"http://t3.qpic.cn/mblogpic/b58f2f735310a65aa39e/500",
			"http://t3.qpic.cn/mblogpic/7d4b90d3bd45be5b6116/500",
			"http://t1.qpic.cn/mblogpic/9990ffcd1f60235fa6aa/500",
			"http://t2.qpic.cn/mblogpic/cdcfa67522ebd19fbff2/500",
			"http://t3.qpic.cn/mblogpic/50ae9c7cd6ab10d82f90/500",
			"http://t3.qpic.cn/mblogpic/ef2a79537b27acef8c5c/500",
			"http://t3.qpic.cn/mblogpic/494f236508983deab53e/500"
		};

}
