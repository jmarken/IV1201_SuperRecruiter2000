package view.entrypoints;


import org.springframework.beans.BeanUtils;
import shared.PersonDTO;
import view.response.UserRest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by enfet on 2018-01-29.
 */

@Path("/users")
public class UsersEntryPoint {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserRest createUser(UserRest requestObject) {
        PersonDTO personDTO = new PersonDTO();
        UserRest returnValue = new UserRest();

        BeanUtils.copyProperties(requestObject, personDTO);

        System.out.println(personDTO);

        BeanUtils.copyProperties(requestObject, returnValue);

        return returnValue ;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserRest getUserProfile(@PathParam("id") String id) {
        UserRest returnvalue =  new UserRest();



        return returnvalue;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserRest> getUsers(@DefaultValue("0") @QueryParam("start") int start,
                                   @DefaultValue("1000")@QueryParam("limit") int limit) {
        List<UserRest> returnValue = null;

        return returnValue;
    }



}
