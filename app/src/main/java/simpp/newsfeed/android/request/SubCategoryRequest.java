package simpp.newsfeed.android.request;

import android.content.Context;

import com.octo.android.robospice.request.springandroid.SpringAndroidSpiceRequest;

import simpp.newsfeed.android.R;
import simpp.newsfeed.android.model.SubCategoryList;

/**
 * Created by user on 9/6/2014.
 */
public class SubCategoryRequest extends SpringAndroidSpiceRequest<SubCategoryList> {
    private final Context context;
    private final String categoryId;

    public SubCategoryRequest(Context context, String categoryId) {
        super(SubCategoryList.class);
        this.context = context;
        this.categoryId = categoryId;
    }

    @Override
    public SubCategoryList loadDataFromNetwork() throws Exception {
        String url = String.format(context.getString(R.string.api_base_url),
        context.getString(R.string.api_version),
        String.format(context.getString(R.string.api_sub_categories_for_category), this.categoryId));

        return getRestTemplate().getForObject(url, SubCategoryList.class);
    }

    public String createCacheKey() {
        return null;
    }
}
