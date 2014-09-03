package simpp.newsfeed.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import simpp.newsfeed.android.model.Category;
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
        setContentView(R.layout.activity_main);
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
          
        }
    }
}
