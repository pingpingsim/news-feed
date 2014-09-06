package simpp.newsfeed.android.data;

import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import simpp.newsfeed.android.model.Category;
import simpp.newsfeed.android.ui.CategoryFragment;

/**
 * Created by user on 8/29/2014.
 */
public class CategoryPagerAdapter extends FragmentPagerAdapter {
    private List<Category> categoryList;

    public CategoryPagerAdapter(android.support.v4.app.FragmentManager fragmentManager, List<Category> categoryList) {
        super(fragmentManager);
        this.categoryList = categoryList;
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return categoryList.size();
    }

    // Returns the fragment to display for that page
    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return CategoryFragment.newInstance(categoryList.get(position));
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return categoryList.get(position).getDisplay_category_name();
    }
}
