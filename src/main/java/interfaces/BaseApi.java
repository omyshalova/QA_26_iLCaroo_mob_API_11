package interfaces;

import com.google.gson.Gson;
import dto.RegistrationBodyDto;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

public interface BaseApi {
    String BASE_URL = "https://ilcarro-backend.herokuapp.com";
    String REGISTRATION_URL = "/v1/user/registration/usernamepassword";
    String LOGIN_URL = "/v1/user/login/usernamepassword";
    String ADD_NEW_CAR_URL = "/v1/cars";
    String GET_USER_CARS_URL = "/v1/cars/my";
    String DELETE_CAR_URL = "/v1/cars/";
    Gson GSON = new Gson();
    MediaType JSON = MediaType.get("application/json");
    OkHttpClient OK_HTTP_CLIENT = new OkHttpClient();

    RegistrationBodyDto USER_LOGIN = RegistrationBodyDto.builder()
            .username("789baggins_bilbo@mail.com")
            .password("Zxc12345!")
            .build();

}
