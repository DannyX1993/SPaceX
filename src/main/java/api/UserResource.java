package api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Uris.VERSION)
public class UserResource {

    @RequestMapping(value = Uris.USERS + Uris.USERS_VERSION, method = RequestMethod.GET)
    public String version()  {
        return "{version: " + Uris.VERSION.toString() + "}";
    }

    @RequestMapping(value = Uris.USERS, method = RequestMethod.GET)
    public void userRegistration()  {
        System.out.println("Entra GET /players");
    }
}
