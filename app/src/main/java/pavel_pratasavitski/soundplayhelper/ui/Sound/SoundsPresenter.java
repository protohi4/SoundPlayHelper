package pavel_pratasavitski.soundplayhelper.ui.Sound;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import pavel_pratasavitski.soundplayhelper.application.BaseApplication;
import pavel_pratasavitski.soundplayhelper.base.BaseMvpPresenter;
import pavel_pratasavitski.soundplayhelper.inject.LoginInterface;
import pavel_pratasavitski.soundplayhelper.pojo.songs.SongList;

@InjectViewState
public class SoundsPresenter extends BaseMvpPresenter<SoundFragmentView> {

    @Inject
    LoginInterface loginInterface;

    public SoundsPresenter() {
        BaseApplication.getApplicationComponent().inject(this);
    }

    public void getDate(String token, boolean isRequested) {
        loginInterface.getSongs(token, isRequested)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SongList>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SongList songList) {
                        getViewState().setSounds(songList.getSongs());
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
