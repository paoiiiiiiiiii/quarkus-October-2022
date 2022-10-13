package ch.survalit.greeting.control;

import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonObject;

import ch.survalit.greeting.entity.Address;
import ch.survalit.greeting.entity.Greeting;

@ApplicationScoped
public class GreetingLoader {

    /**
     * Json P (json processing)
     */
    public JsonObject getGreeting() {
        return Json.createObjectBuilder()
                .add("name", "peter")
                .add("age", 18)
                .add("isHappy", true)
                .add("address", Json.createObjectBuilder()
                        .add("street", "some street")
                        .add("house", 15)
                        .add("zip", 5405)
                        .build())
                .build();
    }

    /**
     * Json Binding
     */
    public Greeting getGreetingWithName() {
        return new Greeting("Joe",
                18,
                true,
                new Address("sandystreet", 40));
    }
}
