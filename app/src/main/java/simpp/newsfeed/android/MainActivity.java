package simpp.newsfeed.android;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import simpp.newsfeed.android.data.CategoryPagerAdapter;
import simpp.newsfeed.android.model.CategoryList;
import simpp.newsfeed.android.request.CategoryRequest;

import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

/**
 * Created by user on 9/3/2014.
 */
public class MainActivity extends BaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_activity);
        setTitle(getString(R.string.title_feed_category));
        getCategoryRequest(this);
    }

    private void getCategoryRequest(Context context) {
        final CategoryRequest request = new CategoryRequest(
                context);
        this.getSpiceManager().execute(request, request.createCacheKey(),
                DurationInMillis.ALWAYS_EXPIRED, new CategoryListener());
    }

    private class CategoryListener implements
            RequestListener<CategoryList> {
        @Override
        public void onRequestFailure(SpiceException e) {

        }

        @Override
        public void onRequestSuccess(CategoryList categoryList) {
            ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
            categoryList.remove(0);
            CategoryPagerAdapter adapterViewPager = new CategoryPagerAdapter(MainActivity.this.getSupportFragmentManager(), categoryList);
            vpPager.setAdapter(adapterViewPager);
            vpPager.setPageMargin(15);

            com.astuetz.PagerSlidingTabStrip tabs = (com.astuetz.PagerSlidingTabStrip) findViewById(R.id.pager_header);
            tabs.setViewPager(vpPager);
            tabs.setIndicatorColor(getResources().getColor(R.color.red));
        }
    }
}
