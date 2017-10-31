package pavel_pratasavitski.soundplayhelper.inject;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import pavel_pratasavitski.soundplayhelper.pojo.OurResponse;
import pavel_pratasavitski.soundplayhelper.pojo.User;
import pavel_pratasavitski.soundplayhelper.pojo.songs.SongList;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LoginInterface {
    @Headers({
            "Content-Type: application/json"
    })
    @POST("auth")
    Observable<OurResponse> makeAuthorisation(@Body User user);

    @GET("song")
    Observable<SongList> getSongs(@Header("X-Auth-Token") String token,
                                  @Header("If-Modified-Since") boolean ifRequested);
}
