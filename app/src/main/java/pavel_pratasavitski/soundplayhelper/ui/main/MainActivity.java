package pavel_pratasavitski.soundplayhelper.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.arellomobile.mvp.presenter.InjectPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import pavel_pratasavitski.soundplayhelper.R;
import pavel_pratasavitski.soundplayhelper.application.BaseApplication;
import pavel_pratasavitski.soundplayhelper.application.Constants;
import pavel_pratasavitski.soundplayhelper.base.BaseMvpActivity;
import pavel_pratasavitski.soundplayhelper.ui.sound.SoundsFragment;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.SupportAppNavigator;

public class MainActivity extends BaseMvpActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        MainPresenterView {

    @Inject
    NavigatorHolder navigatorHolder;

    @InjectPresenter
    MainPresenter presenter;

    @BindView(R.id.main_navigation_view)
    NavigationView navigationView;

    @BindView(R.id.main_drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.main_container_layout)
    FrameLayout containerLayout;

//    @BindView(R.id.activity_main_swipe_refresh)
//    SwipeRefreshLayout swipeRefreshLayout;

    private String token;

    private Navigator navigator = new SupportAppNavigator(MainActivity.this,
            R.id.main_container_layout) {
        @Override
        protected Intent createActivityIntent(String screenKey, Object data) {
            return null;
        }

        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            setToolbarTitle((String) data);

            switch (screenKey) {
                case Constants.Screens.SONGS_FRAGMENT:
                    return SoundsFragment.getInstance();
//                case Constants.Screens.FAVORITES_FRAGMENT:
//                    return MoviesFragment.getInstance();
//                case Constants.Screens.SET_LIST_FRAGMENT:
//                    return TvFragment.getInstance();
//                case Constants.Screens.ACCOUNT_FRAGMENT:
//                    return ActorsFragment.getInstance();
//                case Constants.Screens.FILTERS_FRAGMENT:
//                    return SettingsFragment.getInstance();
                default:
                    throw new RuntimeException("Unknown screen key!");
            }
        }
    };

    public static void start(Context context, String token) {
        Intent intent = new Intent(context, MainActivity.class);
//        intent.putExtra(Constants.Extras.TOKEN, token);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BaseApplication.getApplicationComponent().inject(this);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();

        super.onPause();
    }

    @Override
    protected void onViewsBinded() {
        setToolbar(toolbar, getString(R.string.app_name), false);

        final ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

//        swipeRefreshLayout.setOnRefreshListener(this);
//        swipeRefreshLayout.setColorSchemeResources(R.color.transparent);
//        swipeRefreshLayout.setProgressViewOffset(true, 100, 200);

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_songs);
        MenuItem item = navigationView.getMenu().findItem(R.id.nav_songs);
        presenter.onNavigationItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        presenter.onOptionsItemSelected(item);

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        presenter.onNavigationItemSelected(item);

        return true;
    }
}
