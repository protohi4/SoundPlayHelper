package pavel_pratasavitski.soundplayhelper.application;

import android.app.Application;

import pavel_pratasavitski.soundplayhelper.inject.ApplicationComponent;
import pavel_pratasavitski.soundplayhelper.inject.DaggerApplicationComponent;
import pavel_pratasavitski.soundplayhelper.inject.module.MainModule;
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

        initApplicationComponent();
    }

    private void initApplicationComponent() {
        applicationComponent = DaggerApplicationComponent.builder()
                .mainModule(new MainModule(getApplicationContext()))
                .retrofitModule(new RetrofitModule(Constants.BASE_URL))
                .networkModule(new NetworkModule(Constants.NetworkingConfig.TIMEOUT))
                .build();
    }
}
