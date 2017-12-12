package pavel_pratasavitski.soundplayhelper.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseMvpPresenter<View extends MvpView> extends MvpPresenter<View> {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    protected void unSubscribeOnDestroy(@NonNull final Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        compositeDisposable.clear();
    }

    protected boolean isInternetConnection(@NonNull final Context context) {
        final ConnectivityManager cm = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return (cm != null ? cm.getActiveNetworkInfo() : null) != null &&
                cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}
