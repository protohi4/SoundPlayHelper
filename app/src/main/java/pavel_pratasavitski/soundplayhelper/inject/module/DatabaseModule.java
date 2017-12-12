//package pavel_pratasavitski.soundplayhelper.inject.module;
//
//import android.arch.persistence.room.Room;
//import android.content.Context;
//import android.support.annotation.NonNull;
//
//import javax.inject.Singleton;
//
//import dagger.Module;
//import dagger.Provides;
//import pavel_pratasavitski.soundplayhelper.application.Constants;
//import pavel_pratasavitski.soundplayhelper.db.SongsDatabase;
//import pavel_pratasavitski.soundplayhelper.pojo.songs.SongDao;
//
//@Module
//public class DatabaseModule {
//    @Provides
//    @NonNull
//    @Singleton
//    public SongsDatabase provideAppDatabase(Context context) {
//        return Room
//                .databaseBuilder(context, SongsDatabase.class, Constants.DATABASE_NAME)
//                .fallbackToDestructiveMigration()
//                .build();
//    }
//
//    @Provides
//    @NonNull
//    @Singleton
//    public SongDao provideUserDao(SongsDatabase appDatabase) {
//        return appDatabase.songDao();
//    }
//
//}