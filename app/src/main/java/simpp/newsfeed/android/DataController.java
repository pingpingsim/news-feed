package simpp.newsfeed.android;

import android.app.Application;
import android.content.Context;

import com.octo.android.robospice.JacksonSpringAndroidSpiceService;
import com.octo.android.robospice.SpiceManager;

public class DataController extends Application {
	private SpiceManager spiceManager;

	public SpiceManager getSpiceManager(Context context) {
		if (spiceManager == null) {
			spiceManager = new SpiceManager(
					JacksonSpringAndroidSpiceService.class);
		}
		return spiceManager;
	}
}