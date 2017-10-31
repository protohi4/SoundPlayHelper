package pavel_pratasavitski.soundplayhelper.ui.main;

import android.view.MenuItem;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import pavel_pratasavitski.soundplayhelper.R;
import pavel_pratasavitski.soundplayhelper.application.BaseApplication;
import pavel_pratasavitski.soundplayhelper.application.Constants;
import pavel_pratasavitski.soundplayhelper.base.BaseMvpPresenter;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class MainPresenter extends BaseMvpPresenter<MainPresenterView> {
    @Inject
    Router router;

    public MainPresenter() {
        BaseApplication.getApplicationComponent().inject(this);
    }

    void onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_songs:
                router.replaceScreen(Constants.Screens.SONGS_FRAGMENT, item.getTitle());

                break;
            case R.id.nav_favorites:
//                router.replaceScreen(Constants.Screens.FAVORITES_FRAGMENT, item.getTitle());

                break;
            case R.id.nav_setlists:
//                router.replaceScreen(Constants.Screens.SET_LIST_FRAGMENT, item.getTitle());

                break;
            case R.id.nav_account:
//                router.replaceScreen(Constants.Screens.ACCOUNT_FRAGMENT, item.getTitle());

                break;
        }
    }

    void onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_filters:
//                router.navigateTo(Constants.Screens.FILTERS_FRAGMENT, item.getTitle());

                break;
        }
    }
}
