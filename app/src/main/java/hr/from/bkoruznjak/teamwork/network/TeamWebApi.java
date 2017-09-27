package hr.from.bkoruznjak.teamwork.network;

import hr.from.bkoruznjak.teamwork.network.model.AllProjectsResponseModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by bkoruznjak on 27/09/2017.
 */

public interface TeamWebApi {

    String USERNAME = "yat";
    String TEAMWORK_API_KEY = "twp_TEbBXGCnvl2HfvXWfkLUlzx92e3T";
    String TEAMWORK_API_FAKE_PASSWORD = "X";
    String BASE_URL = "https://" + USERNAME + ".teamwork.com";

    @Headers({
            "Accept:application/json",
            "Content-Type:application/x-www-form-urlencoded"
    })
    @GET("/projects.json")
    Call<AllProjectsResponseModel> getAllProjects();
}
