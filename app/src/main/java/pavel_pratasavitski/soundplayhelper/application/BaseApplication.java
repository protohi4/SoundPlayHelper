package pavel_pratasavitski.soundplayhelper.application;

import android.app.Application;

import io.objectbox.BoxStore;
import pavel_pratasavitski.soundplayhelper.db.MyObjectBox;
import pavel_pratasavitski.soundplayhelper.inject.ApplicationComponent;
import pavel_pratasavitski.soundplayhelper.inject.DaggerApplicationComponent;
import pavel_pratasavitski.soundplayhelper.inject.module.NetworkModule;
import pavel_pratasavitski.soundplayhelper.inject.module.RetrofitModule;

public class BaseApplication extends Application {

    private static BoxStore boxStore;
    private static ApplicationComponent applicationComponent;

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        boxStore = MyObjectBox.builder().androidContext(BaseApplication.this).build();
        initApplicationComponent();
    }

    private void initApplicationComponent() {
        applicationComponent = DaggerApplicationComponent.builder()
                .retrofitModule(new RetrofitModule(Constants.BASE_URL))
                .networkModule(new NetworkModule(Constants.NetworkingConfig.TIMEOUT))
                .build();
    }

    public static BoxStore getBoxStore() {
        return boxStore;
    }
}
