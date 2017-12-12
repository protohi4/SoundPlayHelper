package pavel_pratasavitski.soundplayhelper.ui.sound;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import pavel_pratasavitski.soundplayhelper.R;
import pavel_pratasavitski.soundplayhelper.application.Constants;
import pavel_pratasavitski.soundplayhelper.base.BaseMvpFragment;
import pavel_pratasavitski.soundplayhelper.pojo.songs.Song;

public class SongListFragment extends BaseMvpFragment
        implements SongFragmentView, SongsAdapter.OnClickListener {

    @InjectPresenter
    SongListPresenter presenter;

    @BindView(R.id.fragment_sounds_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.fragment_sounds_search_view)
    SearchView searchView;

    SongsAdapter songsAdapter;

    public static SongListFragment getInstance() {
        return new SongListFragment();
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

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                songsAdapter.setData(presenter.search(newText));

                return false;
            }
        });

        songsAdapter.setOnClickListener(this);
    }

    @Override
    public void setSounds(final List<Song> songList) {
        songsAdapter.setData(songList);
    }

    @Override
    public void showError(final List<Song> songList) {
        songsAdapter.setData(songList);
        Toast.makeText(getActivity(),
                "Can't get data from server! " +
                        "Load from DB", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSoundClicked(final View view, final int id) {
        presenter.onSoundClick(getActivity(), id);
    }

    @Override
    public void onFavoriteClick(long id) {
        presenter.onFavoriteClick(id);
    }
}
