package pavel_pratasavitski.soundplayhelper.inject;

import io.reactivex.Observable;
import pavel_pratasavitski.soundplayhelper.pojo.OurResponse;
import pavel_pratasavitski.soundplayhelper.pojo.User;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LoginInterface {
    @Headers({
            "Content-Type: application/json"
    })
    @POST("auth")
    Observable<OurResponse> makeAuthorisation(@Body User user);
}
