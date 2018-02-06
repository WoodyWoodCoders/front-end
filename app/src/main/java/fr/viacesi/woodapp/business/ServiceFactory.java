package fr.viacesi.woodapp.business;

import fr.viacesi.woodapp.business.impl.ClientsRestServiceImpl;
import fr.viacesi.woodapp.business.impl.DevisRestServiceImpl;
import fr.viacesi.woodapp.business.impl.UserAuthenticationServiceImpl;
import fr.viacesi.woodapp.business.impl.UserRestServiceImpl;

public class ServiceFactory {

    public static final UserAuthenticationService getUserAuthenticationService() {
        return new UserAuthenticationServiceImpl();
    }
    public static final UserRestService getUserRestService() {
        return new UserRestServiceImpl();
    }

    public static final ClientsRestService getClientsRestService() {
        return new ClientsRestServiceImpl();
    }
    public static final DevisRestService sendDevisRestService() {
        return new DevisRestServiceImpl();
    }


}
