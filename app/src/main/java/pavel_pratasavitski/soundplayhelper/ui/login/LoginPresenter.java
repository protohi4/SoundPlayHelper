package pavel_pratasavitski.soundplayhelper.ui.login;

import android.content.Context;
import android.widget.Toast;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import io.objectbox.Box;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import pavel_pratasavitski.soundplayhelper.R;
import pavel_pratasavitski.soundplayhelper.application.BaseApplication;
import pavel_pratasavitski.soundplayhelper.base.BaseMvpPresenter;
import pavel_pratasavitski.soundplayhelper.inject.LoginInterface;
import pavel_pratasavitski.soundplayhelper.pojo.OurResponse;
import pavel_pratasavitski.soundplayhelper.pojo.User;
import pavel_pratasavitski.soundplayhelper.pojo.songs.Song;

@InjectViewState
public class LoginPresenter extends BaseMvpPresenter<LoginActivityView> {

    @Inject
    Context context;

    @Inject
    LoginInterface loginInterface;

    @Inject
    Box<Song> songBox;

    public LoginPresenter() {
        BaseApplication.getApplicationComponent().inject(this);
    }

    void signIn() {
        if (!isInternetConnection(context)) {
            if (songBox.count() == 0) {
                getViewState().onError();
            } else {
                getViewState().startMainActivity(null);
            }

            return;
        }

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
                        getViewState().onError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
