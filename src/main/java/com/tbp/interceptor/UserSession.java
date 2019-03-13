package com.tbp.interceptor;

import com.tbp.model.Person;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class UserSession {

    Person person;

    public void addLoggedUser(Person person) {
        this.person = person;
    }

    public Person getLoggedUser() {
        return person;
    }

    public void removeLoggedUser() {
        this.person = null;
    }

}