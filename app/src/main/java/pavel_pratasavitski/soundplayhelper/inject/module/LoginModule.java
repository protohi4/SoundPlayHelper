package pavel_pratasavitski.soundplayhelper.inject.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pavel_pratasavitski.soundplayhelper.inject.LoginInterface;
import retrofit2.Retrofit;

@Module
public class LoginModule {

    @Provides
    @Singleton
    LoginInterface provideLoginInterface(Retrofit retrofit) {
        return retrofit.create(LoginInterface.class);
    }
}
