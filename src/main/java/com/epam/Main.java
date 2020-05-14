package com.epam;

import com.epam.infrastructure_core.Application;
import com.epam.infrastructure_core.ApplicationContext;
import com.epam.model.Room;
import com.epam.service.CoronaDesinfector;
import com.epam.service.Policeman;
import com.epam.service.PolicemanImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
//        CoronaDesinfector desinfector = ObjectFactory.getInstance().createObject(CoronaDesinfector.class);
        ApplicationContext context = Application.run("com.epam", new HashMap<>(Map.of(Policeman.class, PolicemanImpl.class)));
        CoronaDesinfector desinfector = context.getObject(CoronaDesinfector.class); // analog getBean
        desinfector.start(new Room());
    }
}
