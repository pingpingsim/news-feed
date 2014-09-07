package simpp.newsfeed.android.request;

import android.content.Context;

import com.octo.android.robospice.request.springandroid.SpringAndroidSpiceRequest;

import simpp.newsfeed.android.R;
import simpp.newsfeed.android.model.ArticleList;
import simpp.newsfeed.android.model.CategoryList;

/**
 * Created by user on 9/7/2014.
 */
public class ArticleRequest extends SpringAndroidSpiceRequest<ArticleList> {
    private final Context context;
    private final String subCategoryId;
    private final String categoryId;

    public ArticleRequest(Context context, String categoryId, String subCategoryId) {
        super(ArticleList.class);
        this.context = context;
        this.subCategoryId = subCategoryId;
        this.categoryId = categoryId;
    }

    @Override
    public ArticleList loadDataFromNetwork() throws Exception {
        String url = String.format(context.getString(R.string.api_base_url),
                context.getString(R.string.api_version),
                String.format(context.getString(R.string.api_articles_for_sub_category), categoryId, subCategoryId ));
        return getRestTemplate().getForObject(url, ArticleList.class);
    }

    public String createCacheKey() {
        return null;
    }
}
