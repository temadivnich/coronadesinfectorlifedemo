package com.epam.infrastructure_core;

import com.epam.infrastructure_core.object_processing.ObjectFactory;
import com.epam.infrastructure_core.annotations.Singleton;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Evgeny Borisov
 */
public class ApplicationContext {
    @Setter
    private ObjectFactory factory;  //  creates objects using reflection
    private Map<Class, Object> cache = new ConcurrentHashMap<>(); // stores application beans across the app
    @Getter
    private Config config;

    public ApplicationContext(Config config) {
        this.config = config;
    }

    public <T> T getObject(Class<T> type) {
        if (cache.containsKey(type)) {
            return (T) cache.get(type);
        }

        Class<? extends T> implClass = type;

        if (type.isInterface()) {
            implClass = config.getImplClass(type);
        }
        T t = factory.createObject(implClass);   // beans create, init, post-construct

        if (implClass.isAnnotationPresent(Singleton.class)) {
            cache.put(type, t);
        }

        return t;
    }
}
