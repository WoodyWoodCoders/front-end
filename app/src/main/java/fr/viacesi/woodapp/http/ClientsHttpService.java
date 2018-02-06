package fr.viacesi.woodapp.http;

import java.util.List;

import fr.viacesi.woodapp.constant.ApiConstants;
import fr.viacesi.woodapp.model.Client;
import fr.viacesi.woodapp.model.User;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 1797531 on 03/02/2018.
 */

public interface ClientsHttpService {
    @GET(ApiConstants.GET_CLIENTS_URL)
    Call<List<Client>> getClients();
}
