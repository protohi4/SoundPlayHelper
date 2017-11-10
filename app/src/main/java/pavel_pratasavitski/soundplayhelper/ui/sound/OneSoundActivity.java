package pavel_pratasavitski.soundplayhelper.ui.sound;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import pavel_pratasavitski.soundplayhelper.R;
import pavel_pratasavitski.soundplayhelper.application.Constants;
import pavel_pratasavitski.soundplayhelper.base.BaseMvpActivity;
import pavel_pratasavitski.soundplayhelper.ui.main.MainActivity;

public class OneSoundActivity extends BaseMvpActivity {

    public static void start(Context context, int position) {
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
        int i = getIntent().getIntExtra(Constants.Extras.SOUND_POSITION, -1);

    }
}
