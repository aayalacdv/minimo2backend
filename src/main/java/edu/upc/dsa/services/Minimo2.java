package edu.upc.dsa.services;

import edu.upc.dsa.FactoryImpl;
import edu.upc.dsa.models.M2Usuario;
import edu.upc.dsa.models.Medalla;
import edu.upc.dsa.models.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Api(value = "/minimo2", description = "Endpoint to authentication service")
@Path("/minimo2")
public class Minimo2{
    private List<Medalla> medallaList;
    private List<M2Usuario> m2UsuarioList;

    public void LoadData(){
        M2Usuario user1 = new M2Usuario("Axel", "http://10.0.2.2:8080/user1.png");
        M2Usuario user2 = new M2Usuario("Clara", "http://10.0.2.2:8080/user2.png");

        Medalla m1 = new Medalla("http://10.0.2.2:8080/medalla1.png");
        Medalla m2 = new Medalla("http://10.0.2.2:8080/medalla2.png");
        Medalla m3 = new Medalla("http://10.0.2.2:8080/medalla3.jpg");
        Medalla m4 = new Medalla("http://10.0.2.2:8080/medalla4.jpg");

        this.medallaList.add(m1);
        this.medallaList.add(m2);
        this.medallaList.add(m3);
        this.medallaList.add(m4);

        user1.getMedallaList().add(m1);
        user1.getMedallaList().add(m2);

        user2.getMedallaList().add(m3);
        user2.getMedallaList().add(m4);

        this.m2UsuarioList.add(user2);
        this.m2UsuarioList.add(user1);


    }

    public M2Usuario findUser( String name){
        for(M2Usuario m : this.m2UsuarioList){
            if(m.getName().equals(name)){
                return m;
            }
        }
        return null;
    }


    public Minimo2() {
        this.medallaList = new ArrayList<>();
        this.m2UsuarioList = new ArrayList<>();
        LoadData();


    }

    @GET
    @ApiOperation(value = "Get all medalls ", notes = "get all medalls ")
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/medals")
    public Response getMedals (){

        GenericEntity<List<Medalla>> entity = new GenericEntity<List<Medalla>>(this.medallaList){};
        return Response.status(201).entity(entity).build();

    }

    @GET
    @ApiOperation(value = "Get userinfo ", notes = "get userinfo ")
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/user/{name}")
    public Response getUserInfo(@PathParam("name") String name){
        M2Usuario user = findUser(name);
        if(user != null) {
            GenericEntity<M2Usuario> entity = new GenericEntity<M2Usuario>(user){};
            return Response.status(201).entity(entity).build();
        }
        return Response.status(404).entity("NOT FOUND").build();


    }




}