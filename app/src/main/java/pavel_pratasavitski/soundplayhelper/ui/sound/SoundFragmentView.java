package pavel_pratasavitski.soundplayhelper.ui.sound;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import pavel_pratasavitski.soundplayhelper.pojo.songs.Song;

public interface SoundFragmentView extends MvpView {
    void setSounds(List<Song> songList);
}
