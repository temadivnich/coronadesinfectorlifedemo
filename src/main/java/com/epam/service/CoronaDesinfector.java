package com.epam.service;

import com.epam.infrastructure_core.annotations.InjectByType;
import com.epam.model.Room;
import com.epam.service.Announcer;
import com.epam.service.Policeman;

/**
 * @author Evgeny Borisov
 */

public class CoronaDesinfector {

    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Policeman policeman;


    public void start(Room room) {
        announcer.announce("Начинаем дезинфекцию, всё вон!");
        policeman.makePeopleLeaveRoom();
        desinfect(room);
        announcer.announce("Рискните зайти обратно");
    }

    private void desinfect(Room room){
        System.out.println("зачитывается молитва: 'корона изыди!' - молитва прочитана, вирус низвергнут в ад");
    }
}
