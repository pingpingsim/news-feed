package simpp.newsfeed.android.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import simpp.newsfeed.android.R;
import simpp.newsfeed.android.model.SubCategory;

/**
 * This class assigns category_fragment's status information to the list view's row
 * Created by user on 8/31/2014.
 */
public class SubCategoryListingArrayAdapter extends ArrayAdapter<SubCategory> {
    private Context context;
    private List<SubCategory> data;

    public SubCategoryListingArrayAdapter(Context context, int layoutResourceId, List<SubCategory> data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            final LayoutInflater layoutInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.subcategory_row, null);
        }
        final SubCategory subCategory = data.get(position);
        if (subCategory != null)
        {
            TextView display = (TextView) view
                    .findViewById(R.id.subcategory_display_name);

            display.setText(subCategory.getDisplay_subcategory_name());
        }
        return view;
    }

}
