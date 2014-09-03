package simpp.newsfeed.android;

import android.app.Activity;
import android.os.Bundle;

import com.octo.android.robospice.SpiceManager;

/**
 * Created by user on 9/3/2014.
 */
public class BaseActivity extends Activity {
    private SpiceManager spiceManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        spiceManager = ((DataController) this.getApplication())
                .getSpiceManager(this);
        if (!spiceManager.isStarted()) {
            spiceManager.start(this);
        }
    }

    public SpiceManager getSpiceManager() {
        return spiceManager;
    }

    public void setSpiceManager(SpiceManager spiceManager) {
        this.spiceManager = spiceManager;
    }
}

