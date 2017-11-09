package pavel_pratasavitski.soundplayhelper.ui.sound;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import pavel_pratasavitski.soundplayhelper.R;
import pavel_pratasavitski.soundplayhelper.application.Constants;
import pavel_pratasavitski.soundplayhelper.base.BaseMvpFragment;
import pavel_pratasavitski.soundplayhelper.pojo.songs.Song;

public class SoundsFragment extends BaseMvpFragment implements SoundFragmentView {

    @InjectPresenter
    SoundsPresenter presenter;

    @BindView(R.id.fragment_sounds_recycler_view)
    RecyclerView recyclerView;

    SongsAdapter songsAdapter;

    public static SoundsFragment getInstance() {
        return new SoundsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sound, container, false);
    }

    @Override
    protected void onViewsBinded() {
        SharedPreferences settings = getActivity().
                getSharedPreferences(Constants.SHARED_PREFERENCES, 0);
        String token = settings.getString(Constants.Extras.TOKEN, null);

        presenter.getDate(token, false);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<Song> list = new ArrayList<>();
        songsAdapter = new SongsAdapter(getActivity(), list);
        recyclerView.setAdapter(songsAdapter);
    }

    @Override
    public void setSounds(List<Song> songList) {
        songsAdapter.setData(songList);
    }
}
