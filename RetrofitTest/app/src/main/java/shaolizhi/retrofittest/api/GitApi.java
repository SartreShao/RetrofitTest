package shaolizhi.retrofittest.api;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import shaolizhi.retrofittest.model.GitModel;

/**
 * 由邵励治于2017/5/10创造.
 */

public interface GitApi {
    @GET("/users/{user}")      // here is the other url part.best way is to start using /
    void getFeed(@Path("user") String user, Callback<GitModel> response);
    // string user is for passing values from edittext for eg: user=basil2style,google
    // response is the response from the server which is now in the POJO
}
