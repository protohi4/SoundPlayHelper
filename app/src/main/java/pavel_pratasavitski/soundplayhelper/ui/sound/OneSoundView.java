package pavel_pratasavitski.soundplayhelper.ui.sound;

import com.arellomobile.mvp.MvpView;

import pavel_pratasavitski.soundplayhelper.pojo.songs.Song;

public interface OneSoundView extends MvpView{
    void viewSong(Song song);
}
