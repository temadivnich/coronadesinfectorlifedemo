package com.epam.infrastructure_core.object_processing;

import com.epam.infrastructure_core.ApplicationContext;

/**
 * @author Evgeny Borisov
 */
public interface ObjectConfigurator {
    void configure(Object t, ApplicationContext context);
}
