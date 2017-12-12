package pavel_pratasavitski.soundplayhelper.inject.module;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.objectbox.Box;
import io.objectbox.BoxStore;
import pavel_pratasavitski.soundplayhelper.pojo.songs.MyObjectBox;
import pavel_pratasavitski.soundplayhelper.pojo.songs.Song;

@Module
public class BaseModule {

    @Provides
    @NonNull
    @Singleton
    public BoxStore provideBoxStore(Context context) {
        return MyObjectBox.builder().androidContext(context).build();
    }

    @Provides
    @NonNull
    @Singleton
    public Box<Song> provideSongBox(BoxStore boxStore) {
        return boxStore.boxFor(Song.class);
    }
}
