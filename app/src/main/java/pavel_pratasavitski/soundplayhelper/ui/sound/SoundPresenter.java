package pavel_pratasavitski.soundplayhelper.ui.sound;

import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import pavel_pratasavitski.soundplayhelper.application.BaseApplication;
import pavel_pratasavitski.soundplayhelper.base.BaseMvpPresenter;
import pavel_pratasavitski.soundplayhelper.inject.LoginInterface;
import pavel_pratasavitski.soundplayhelper.pojo.songs.Song;
import pavel_pratasavitski.soundplayhelper.pojo.songs.SongList;

@InjectViewState
public class SoundPresenter extends BaseMvpPresenter<SoundFragmentView> {

    @Inject
    LoginInterface loginInterface;

    private List<Song> songs;

    SoundPresenter() {
        BaseApplication.getApplicationComponent().inject(this);
    }

    void getDate(String token, boolean isRequested) {
        songs = new ArrayList<>();
        loginInterface.getSongs(token, isRequested)
                .map(new Function<SongList, SongList>() {
                    @Override
                    public SongList apply(SongList songList) throws Exception {
                        songs = songList.getSongs();

                        return songList;
                    }
                })
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
                        getViewState().showError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    List<Song> search(String newText) {
        List<Song> resultList = new ArrayList<>();

        for (Song song : songs) {
            if (song.getName().toLowerCase().contains(newText.toLowerCase())) {
                resultList.add(song);
            }
        }

        return resultList;
    }
}
