package com.epam.service;

import com.epam.infrastructure_core.annotations.InjectProperty;
import com.epam.infrastructure_core.annotations.Singleton;

/**
 * @author Evgeny Borisov
 */
@Singleton
public class RecommendatorImpl implements Recommendator {
    @InjectProperty("wisky")
    private String alcohol;

    public RecommendatorImpl() {
        System.out.println("recommendator was created");
    }

    @Override
    public void recommend() {
        System.out.println("to protect from covid-2019, drink "+alcohol);
    }
}
