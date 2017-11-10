package pavel_pratasavitski.soundplayhelper.application;

public class Constants {
    public static final String API_KEY = "";
    public static final String BASE_URL = "https://dart-api.azurewebsites.net/api/";
    public static final String BASE_IMAGE_URL = "";

    public static final String USERNAME = "vb";
    public static final String PASSWORD = "GodIsMyAll";

    public static final String SHARED_PREFERENCES = "preferences_file";

    public interface NetworkingConfig {
        int TIMEOUT = 20;
    }

    public interface Extras {
        String TOKEN = "user's_token";
        String SOUND_POSITION = "extra_position";
    }

    public interface Screens {
        String SONGS_FRAGMENT = "songs_fragment";
        String FAVORITES_FRAGMENT = "favorites_fragment";
        String SET_LIST_FRAGMENT = "set_list_fragment";
        String ACCOUNT_FRAGMENT = "account_fragment";
        String FILTERS_FRAGMENT = "filters_fragment";
    }
}
