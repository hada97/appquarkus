package crud.quarkus.controller;

import crud.quarkus.entity.UserEntity;
import crud.quarkus.servicce.UserService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.UUID;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GET
    public Response findAll(@QueryParam("page") Integer page, @QueryParam("pagesize") @DefaultValue("10") Integer pagesize) {
        var users = userService.findAll(page, pagesize);
        return Response.ok(users).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@QueryParam("id") UUID userId) {
        return Response.ok(UserService.findById(userId)).build();
    }

    @POST
    @Transactional
    public Response createUser(UserEntity userEntity) {
        return Response.ok(userService.createUser(userEntity)).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Response updateUser(@PathParam("id") UUID userId, UserEntity userEntity) {
        return Response.ok(userService.updateUser(userId, userEntity)).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteById(@PathParam("id") UUID userId) {
        return Response.noContent().build();
    }

}
