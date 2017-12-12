package pavel_pratasavitski.soundplayhelper.ui.sound;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import io.objectbox.Box;
import pavel_pratasavitski.soundplayhelper.application.BaseApplication;
import pavel_pratasavitski.soundplayhelper.base.BaseMvpPresenter;
import pavel_pratasavitski.soundplayhelper.pojo.songs.Song;

@InjectViewState
public class OneSoundPresenter extends BaseMvpPresenter<OneSoundView> {

    @Inject
    Box<Song> songBox;

    public OneSoundPresenter() {
        BaseApplication.getApplicationComponent().inject(this);
    }

    void onActivityCreated(int position) {
        Song song = songBox.get(position);
        getViewState().viewSong(song);
    }
}
