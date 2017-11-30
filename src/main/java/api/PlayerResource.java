package api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Uris.VERSION)
public class PlayerResource {

    @RequestMapping(value = Uris.PLAYERS, method = RequestMethod.GET)
    public void userRegistration()  {
        System.out.println("Entra GET /players");
    }
}
