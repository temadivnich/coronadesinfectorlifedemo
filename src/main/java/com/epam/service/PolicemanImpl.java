package com.epam.service;

import com.epam.infrastructure_core.annotations.InjectByType;

import javax.annotation.PostConstruct;

/**
 * @author Evgeny Borisov
 */
public class PolicemanImpl implements Policeman {

    @InjectByType
    private Recommendator recommendator;

    @PostConstruct
    public void init() {
        System.out.println(recommendator.getClass());
    }

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("пиф паф, бах бах, кыш, кыш!");
    }
}
