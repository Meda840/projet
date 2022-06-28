package com.maven.jee.Restaurant;


import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.inject.Inject;

@Path("restaurant")
public class RestaurantRessource {

    @Inject
    private RestaurantDao restaurantDao;
    @EJB
    RestaurantBean rBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listrestau")
    public Response listRestaurant() {
        return Response.ok(rBean.getRestaurant()).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("spicy")
    public Response getSpicyRestaurant() {
        return Response.ok(rBean.getSpicy()).build();
    }

    @POST
    @Path("insertrestau")
    public Response insertRestaurant(Restaurant restaurants) {
        rBean.addRestaurants(restaurants);
        Logger.getGlobal().info(restaurants.toString());
        return Response.ok("Success 200").build();
    }

    @PUT
    @Path("/update/{id}")
    public Response updateRestaurant(@PathParam("id") Integer id, Restaurant restaurants) {
        rBean.updateRestaurant(id, restaurants);
        return Response.ok("Success 200").build();

    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteFilm(@PathParam("id") Integer id) {
        rBean.deleteRestaurants(id);
        return Response.ok("success delete").build();
    }
}
