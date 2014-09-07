package simpp.newsfeed.android;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

import simpp.newsfeed.android.data.ArticleListingArrayAdapter;
import simpp.newsfeed.android.model.ArticleList;
import simpp.newsfeed.android.request.ArticleRequest;

/**
 * Created by user on 9/6/2014.
 */
public class ArticleActivity extends BaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_activity);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null
                && bundle.containsKey(getString(R.string.bundle_key_sub_category))
                && bundle.containsKey(getString(R.string.bundle_key_category))) {
            String subCategoryId = bundle.getString(getString(R.string.bundle_key_sub_category));
            String categoryId = bundle.getString(getString(R.string.bundle_key_category));
            getArticleRequest(this, categoryId, subCategoryId);
        }
    }

    private void getArticleRequest(Context context, String categoryId, String subCategoryId) {
        final ArticleRequest request = new ArticleRequest(
                context, categoryId, subCategoryId);
        this.getSpiceManager().execute(request, request.createCacheKey(),
                DurationInMillis.ALWAYS_EXPIRED, new ArticleListener());
    }

    private class ArticleListener implements
            RequestListener<ArticleList> {
        @Override
        public void onRequestFailure(SpiceException e) {
            e.printStackTrace();
        }

        @Override
        public void onRequestSuccess(ArticleList articleListList) {
            populateArticleListView(articleListList);
        }
    }

    private void populateArticleListView(ArticleList articleListList) {
        ListView articleListView = (ListView) findViewById(R.id.article_list_view);
        LinearLayout progressBarContainer = (LinearLayout) findViewById(R.id.article_progress_bar_container);
        final ArticleListingArrayAdapter articleArrayAdapter = new ArticleListingArrayAdapter(
                this, R.layout.article_row, articleListList.getArticles());
        articleListView.setAdapter(articleArrayAdapter);
        articleArrayAdapter.notifyDataSetChanged();

        articleListView.setVisibility(View.VISIBLE);
        progressBarContainer.setVisibility(View.GONE);
    }
}
