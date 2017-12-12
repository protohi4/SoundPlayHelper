package pavel_pratasavitski.soundplayhelper.ui.sound;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import pavel_pratasavitski.soundplayhelper.R;
import pavel_pratasavitski.soundplayhelper.application.Constants;
import pavel_pratasavitski.soundplayhelper.base.BaseMvpActivity;
import pavel_pratasavitski.soundplayhelper.pojo.songs.Song;

public class OneSoundActivity extends BaseMvpActivity
            implements OneSoundView{

    @InjectPresenter
    OneSoundPresenter presenter;

    @BindView(R.id.activity_one_sound_toolbar)
    Toolbar toolbar;
    @BindView(R.id.content_one_sound_words_text_view)
    TextView wordsTextView;
    @BindView(R.id.content_one_sound_chords_text_view)
    TextView chordsTextView;

    public static void start(final Context context, final int position) {
        Intent intent = new Intent(context, OneSoundActivity.class);
        intent.putExtra(Constants.Extras.SOUND_POSITION, position);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_one_sound);
    }

    @Override
    protected void onViewsBinded() {
        int position = getIntent().getIntExtra(Constants.Extras.SOUND_POSITION, -1);
        presenter.onActivityCreated(position);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void viewSong(final Song song) {
        final String title = emptyOrNullCheck(song.getOriginalName()) ?
                song.getName() : song.getOriginalName();
        setToolbar(toolbar, title, true);

        wordsTextView.setText(checkBeforeSetText(song.getText()));
        chordsTextView.setText(checkBeforeSetText(song.getChords()));
    }

    private String checkBeforeSetText(final String string) {
        if (emptyOrNullCheck(string)) {
            return Constants.NO_INFORMATION_MESSAGE;
        } else {
            return string.replace("\r", "\n");
        }
    }

    private boolean emptyOrNullCheck(final String string) {
        return string == null || string.isEmpty();
    }
}
