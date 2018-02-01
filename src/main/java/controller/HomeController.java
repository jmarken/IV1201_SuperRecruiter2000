package controller;


import org.springframework.stereotype.Controller;
import shared.PersonDTO;

@Controller
public class HomeController {
    public model.Model modelObject = new model.Model();

    /**
     *  This method is called from the View layer when a someone is trying to register a new user.
     *
     *  Calls the registerUser method from the Model object modelObject from the Model layer.
     *  Returns a PersonDTO object.
     *
     * @param   person  A PersonDTO(Person Data Transfer Object), which contains all necessary data for a person.
     * @return  user    The Registered User.
     */
    public PersonDTO registerUser(PersonDTO person) {
        PersonDTO user = modelObject.user.registerUser(person);
        return user;
    }
    /*@RequestMapping("/LoginUser")
    public boolean loginUser(String username, String password) {
        boolean check = modelObject.user.loginUser(username, password);
        return check;
    }*/
}
