package pavel_pratasavitski.soundplayhelper.inject;

import javax.inject.Singleton;

import dagger.Component;
import pavel_pratasavitski.soundplayhelper.inject.module.BaseModule;
import pavel_pratasavitski.soundplayhelper.inject.module.LoginModule;
import pavel_pratasavitski.soundplayhelper.inject.module.MainModule;
import pavel_pratasavitski.soundplayhelper.inject.module.NavigationModule;
import pavel_pratasavitski.soundplayhelper.inject.module.NetworkModule;
import pavel_pratasavitski.soundplayhelper.inject.module.RetrofitModule;
import pavel_pratasavitski.soundplayhelper.ui.login.LoginPresenter;
import pavel_pratasavitski.soundplayhelper.ui.main.MainActivity;
import pavel_pratasavitski.soundplayhelper.ui.main.NavigationPresenter;
import pavel_pratasavitski.soundplayhelper.ui.sound.OneSoundPresenter;
import pavel_pratasavitski.soundplayhelper.ui.sound.SongListPresenter;

@Singleton
@Component(modules = {MainModule.class, NetworkModule.class, RetrofitModule.class,
        LoginModule.class, NavigationModule.class, BaseModule.class})
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(LoginPresenter loginPresenter);

    void inject(NavigationPresenter navigationPresenter);

    void inject(SongListPresenter songListPresenter);

    void inject(OneSoundPresenter oneSoundPresenter);
}
