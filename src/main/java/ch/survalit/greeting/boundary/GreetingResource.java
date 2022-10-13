package ch.survalit.greeting.boundary;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ch.survalit.greeting.control.GreetingLoader;
import ch.survalit.greeting.entity.Greeting;

@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingLoader greetingLoader;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("there")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloThere() {
        return "Hello there how are you, nice";
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloByName(@PathParam("name") String name) {
        return "Hello " + name;
    }

    @GET
    @Path("jsonp")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject helloJsonP() {
        return this.greetingLoader.getGreeting();
    }

    @GET
    @Path("jsonb")
    @Produces(MediaType.APPLICATION_JSON)
    public Greeting helloJsonB() {
        return this.greetingLoader.getGreetingWithName();
    }
}