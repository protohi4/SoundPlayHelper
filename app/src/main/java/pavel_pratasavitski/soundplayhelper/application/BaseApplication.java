package pavel_pratasavitski.soundplayhelper.application;

import android.app.Application;

import pavel_pratasavitski.soundplayhelper.inject.ApplicationComponent;
import pavel_pratasavitski.soundplayhelper.inject.DaggerApplicationComponent;
import pavel_pratasavitski.soundplayhelper.inject.module.NetworkModule;
import pavel_pratasavitski.soundplayhelper.inject.module.RetrofitModule;

public class BaseApplication extends Application {

    private static ApplicationComponent applicationComponent;

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

//        initCalligraphy();
        initApplicationComponent();
    }
//
//    private void initCalligraphy() {
//        final String defaultFontPath = getString(R.string.font_regular_path);
//
//        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
//                .setDefaultFontPath(defaultFontPath)
//                .setFontAttrId(R.attr.fontPath)
//                .build());
//    }

    private void initApplicationComponent() {
        applicationComponent = DaggerApplicationComponent.builder()
                .retrofitModule(new RetrofitModule(Constants.BASE_URL))
                .networkModule(new NetworkModule(Constants.NetworkingConfig.TIMEOUT))
                .build();
    }
}
