package pavel_pratasavitski.soundplayhelper.pojo.songs;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface SongDao {
    @Query("SELECT * FROM songs")
    List<Song> getSongs();

    @Query("SELECT * FROM songs WHERE id IN (:id)")
    List<Song> loadAllByIds(int[] id);

    @Insert
    void insertAll(Song... songs);

    @Delete
    void delete(Song song);
}
