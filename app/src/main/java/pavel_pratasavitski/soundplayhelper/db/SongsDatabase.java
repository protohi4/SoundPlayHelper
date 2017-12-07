package pavel_pratasavitski.soundplayhelper.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import pavel_pratasavitski.soundplayhelper.pojo.songs.Song;
import pavel_pratasavitski.soundplayhelper.pojo.songs.SongDao;

@Database(entities = {Song.class}, version = 1)
public abstract class SongsDatabase extends RoomDatabase {
    public abstract SongDao songDao();
}
