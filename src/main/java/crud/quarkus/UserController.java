package crud.quarkus;

import crud.quarkus.entity.UserEntity;
import crud.quarkus.servicce.UserService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GET
    public Response teste() {
        UserEntity.findAll();
        return Response.ok("teste").build();
    }

    @POST
    public Response createUser(UserEntity userEntity) {
        return Response.ok("bruno").build();
    }

}
