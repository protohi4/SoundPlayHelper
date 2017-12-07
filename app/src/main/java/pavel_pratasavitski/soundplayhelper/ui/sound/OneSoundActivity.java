package pavel_pratasavitski.soundplayhelper.ui.sound;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import io.objectbox.Box;
import pavel_pratasavitski.soundplayhelper.R;
import pavel_pratasavitski.soundplayhelper.application.BaseApplication;
import pavel_pratasavitski.soundplayhelper.application.Constants;
import pavel_pratasavitski.soundplayhelper.base.BaseMvpActivity;
import pavel_pratasavitski.soundplayhelper.db.Item;
import pavel_pratasavitski.soundplayhelper.pojo.songs.Song;

public class OneSoundActivity extends BaseMvpActivity {

    @BindView(R.id.activity_one_sound_toolbar)
    Toolbar toolbar;
    @BindView(R.id.content_one_sound_words_text_view)
    TextView wordsTextView;
    @BindView(R.id.content_one_sound_chords_text_view)
    TextView chordsTextView;

    public static void start(Context context, Song song) {
        Intent intent = new Intent(context, OneSoundActivity.class);
        intent.putExtra(Constants.Extras.SOUND_POSITION, song);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_one_sound);
    }

    @Override
    protected void onViewsBinded() {
        Song song = (Song) getIntent().getSerializableExtra(Constants.Extras.SOUND_POSITION);

        setToolbar(toolbar, song.getOriginalName(), true);

        wordsTextView.setText(checkBeforeSetText(song.getText()));
        chordsTextView.setText(checkBeforeSetText(song.getChords()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    private String checkBeforeSetText(String string) {
        if (string == null || string.isEmpty()) {
            return Constants.NO_INFORMATION_MESSAGE;
        } else {
            return string.replace("\r", "\n");
        }
    }
}
