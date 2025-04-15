package com.muchiri.resource;

import java.util.Random;

import com.muchiri.events.LoginEvent;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("user")
@ApplicationScoped
public class LoginResource {
    @Inject
    Event<LoginEvent> loginEvent;

    @GET
    public String login(@QueryParam("name") String name) {
        var user = new LoginEvent(new Random().nextInt(), name);
        loginEvent.fire(user);
        return "%s logged in successfully!\n".formatted(name);
    }
}
