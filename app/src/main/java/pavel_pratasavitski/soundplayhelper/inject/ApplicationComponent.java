package pavel_pratasavitski.soundplayhelper.inject;

import javax.inject.Singleton;

import dagger.Component;
import pavel_pratasavitski.soundplayhelper.inject.module.MyModule;
import pavel_pratasavitski.soundplayhelper.inject.module.NavigationModule;
import pavel_pratasavitski.soundplayhelper.inject.module.NetworkModule;
import pavel_pratasavitski.soundplayhelper.inject.module.RetrofitModule;
import pavel_pratasavitski.soundplayhelper.ui.login.LoginPresenter;
import pavel_pratasavitski.soundplayhelper.ui.main.MainActivity;
import pavel_pratasavitski.soundplayhelper.ui.main.MainPresenter;

@Singleton
@Component(modules = {NetworkModule.class, RetrofitModule.class,
        MyModule.class, NavigationModule.class})
public interface ApplicationComponent {
    void inject(LoginPresenter loginPresenter);

    void inject(MainActivity mainActivity);

    void inject(MainPresenter mainPresenter);
}
