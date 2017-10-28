package pavel_pratasavitski.soundplayhelper.ui.login;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import pavel_pratasavitski.soundplayhelper.application.BaseApplication;
import pavel_pratasavitski.soundplayhelper.base.BaseMvpPresenter;
import pavel_pratasavitski.soundplayhelper.inject.LoginInterface;
import pavel_pratasavitski.soundplayhelper.pojo.OurResponse;
import pavel_pratasavitski.soundplayhelper.pojo.User;

@InjectViewState
public class LoginPresenter extends BaseMvpPresenter<LoginActivityView> {

    @Inject
    LoginInterface loginInterface;

    public LoginPresenter() {
        BaseApplication.getApplicationComponent().inject(this);
    }

    void signIn() {
        //TODO
        User user = new User("vb", "GodIsMyAll");
        loginInterface.makeAuthorisation(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<OurResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(OurResponse ourResponse) {
                        getViewState().startMainActivity(ourResponse.getToken());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
