package fr.viacesi.woodapp.http;

import fr.viacesi.woodapp.constant.ApiConstants;
import fr.viacesi.woodapp.model.AuthenticationRequest;
import fr.viacesi.woodapp.model.Devis;
import fr.viacesi.woodapp.model.Token;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by 1797531 on 04/02/2018.
 */

public interface DevisHttpService {
    @POST(ApiConstants.SEND_DEVIS)
    Call<Devis> sendDevis(@Body Devis devis);
}
