package com.muchiri.events;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class UserControl {
    public void afterLogin(@Observes LoginEvent loginEvent) {
        System.out.println("Login event triggered. The user is: ");
        System.out.println(loginEvent);
    }
}
