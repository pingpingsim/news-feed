package simpp.newsfeed.android.request;

import android.content.Context;

import com.octo.android.robospice.request.springandroid.SpringAndroidSpiceRequest;

import simpp.newsfeed.android.R;
import simpp.newsfeed.android.model.CategoryList;

/**
 * Created by user on 9/3/2014.
 */
public class CategoryRequest extends SpringAndroidSpiceRequest<CategoryList> {
    private final Context context;

    public CategoryRequest(Context context) {
        super(CategoryList.class);
        this.context = context;
    }

    @Override
    public CategoryList loadDataFromNetwork() throws Exception {
        String url = String.format(context.getString(R.string.api_base_url),
                context.getString(R.string.api_version),
                context.getString(R.string.api_category_json));

        return getRestTemplate().getForObject(url, CategoryList.class);
    }

    public String createCacheKey() {
        return null;
    }
}
