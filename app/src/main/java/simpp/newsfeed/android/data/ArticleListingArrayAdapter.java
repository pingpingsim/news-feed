package simpp.newsfeed.android.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import simpp.newsfeed.android.R;
import simpp.newsfeed.android.model.Article;
import simpp.newsfeed.android.model.SubCategory;

/**
 * This class assigns category_fragment's status information to the list view's row
 * Created by user on 8/31/2014.
 */
public class ArticleListingArrayAdapter extends ArrayAdapter<Article> {
    private Context context;
    private List<Article> data;

    public ArticleListingArrayAdapter(Context context, int layoutResourceId, List<Article> data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount(){
        return data.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            final LayoutInflater layoutInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.article_row, null);
        }
        final Article article = data.get(position);
        if (article != null)
        {
            TextView txtViewTitle = (TextView) view
                    .findViewById(R.id.article_title);
            txtViewTitle.setText(article.getTitle());

            TextView txtViewPublishedDate = (TextView) view
                    .findViewById(R.id.article_publish_date);
            txtViewPublishedDate.setText(article.getPublish_date());

            TextView txtViewSummary = (TextView) view
                    .findViewById(R.id.article_summary);
            txtViewSummary.setText(article.getSummary());
        }
        return view;
    }
}
