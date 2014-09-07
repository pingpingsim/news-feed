package simpp.newsfeed.android.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

import simpp.newsfeed.android.ArticleActivity;
import simpp.newsfeed.android.DataController;
import simpp.newsfeed.android.R;
import simpp.newsfeed.android.data.SubCategoryListingArrayAdapter;
import simpp.newsfeed.android.model.Category;
import simpp.newsfeed.android.model.SubCategory;
import simpp.newsfeed.android.model.SubCategoryList;
import simpp.newsfeed.android.request.SubCategoryRequest;

public class CategoryFragment extends Fragment {
    // Store instance variables
    private Category category = null;
    private ListView subcategoryListView = null;
    private LinearLayout progressBarContainer = null;

    // newInstance constructor for creating fragment with arguments
    public static CategoryFragment newInstance(Category category) {
        CategoryFragment categoryFragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putSerializable("category", category);
        categoryFragment.setArguments(args);
        return categoryFragment;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        category = (Category)getArguments().getSerializable("category");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.category_fragment, container, false);
        if (view != null){
            subcategoryListView = (ListView) view.findViewById(R.id.subcategory_list_view);
            progressBarContainer = (LinearLayout) view.findViewById(R.id.progress_bar_container);

            subcategoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //final ListView lv = (ListView) view.getParent();
                    //final int pos = lv.getPositionForView(view);
                    final SubCategory subCategory = (SubCategory) parent
                            .getItemAtPosition(position);
                    startArticleActivity(subCategory);
                }
            });
        }
        CategoryFragment.this.getSubCategoryRequest(CategoryFragment.this.getActivity().getBaseContext(), category.getCategory_id());

        return view;
    }

    private void startArticleActivity(SubCategory subCategory) {
        final Intent intent = new Intent(getActivity(), ArticleActivity.class);
        intent.putExtra(this.getString(R.string.bundle_key_sub_category), subCategory.getSubcategory_id());
        intent.putExtra(this.getString(R.string.bundle_key_category), subCategory.getCategory_id());
        startActivity(intent);
    }

    private void getSubCategoryRequest(Context context, String categoryId) {
        final SubCategoryRequest request = new SubCategoryRequest(context, categoryId);
        SpiceManager spiceManager = ((DataController) CategoryFragment.this.getActivity().getApplication()).getSpiceManager(CategoryFragment.this.getActivity().getBaseContext());

        spiceManager.execute(request, request.createCacheKey(),
                DurationInMillis.ALWAYS_EXPIRED, new SubCategoryListener());
    }

    private class SubCategoryListener implements
            RequestListener<SubCategoryList> {
        @Override
        public void onRequestFailure(SpiceException e) {

        }

        @Override
        public void onRequestSuccess(SubCategoryList subCategoryList) {
            final SubCategoryListingArrayAdapter jobArrayAdapter = new SubCategoryListingArrayAdapter(
                    CategoryFragment.this.getActivity().getBaseContext(), R.layout.subcategory_row, subCategoryList);
            subcategoryListView.setAdapter(jobArrayAdapter);
            jobArrayAdapter.notifyDataSetChanged();
            subcategoryListView.setVisibility(View.VISIBLE);
            progressBarContainer.setVisibility(View.GONE);
        }
    }
}
