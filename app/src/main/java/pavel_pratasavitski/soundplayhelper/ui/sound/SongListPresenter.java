package pavel_pratasavitski.soundplayhelper.ui.sound;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;

import java.util.List;

import javax.inject.Inject;

import io.objectbox.Box;
import io.objectbox.query.QueryBuilder;
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
import pavel_pratasavitski.soundplayhelper.pojo.songs.Song_;

@InjectViewState
public class SongListPresenter extends BaseMvpPresenter<SongFragmentView> {

    @Inject
    LoginInterface loginInterface;

    @Inject
    Box<Song> songBox;

    SongListPresenter() {
        BaseApplication.getApplicationComponent().inject(this);
    }

    void getDate(final String token, final boolean isRequested) {
        loginInterface.getSongs(token, isRequested)
                .map(new Function<SongList, SongList>() {
                    @Override
                    public SongList apply(SongList songList) throws Exception {
                        songBox.removeAll();
                        songBox.put(songList.getSongs());

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
                        getViewState().setSounds(songBox.getAll());
                    }

                    @Override
                    public void onError(Throwable e) {
                        getViewState().showError(songBox.getAll());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    List<Song> search(final String searchingSequence) {
        QueryBuilder<Song> builder = songBox.query();

        builder.contains(Song_.name, searchingSequence).or()
                .contains(Song_.originalName, searchingSequence).or()
                .contains(Song_.text, searchingSequence);

        return builder.build().find();
    }

    void onSoundClick(final Context context, final int id) {
        OneSoundActivity.start(context, id);
    }

    void onFavoriteClick(long id) {
        final Song song = songBox.get(id);

        song.setFavorite(!song.isFavorite());
        songBox.put(song);
    }
}
