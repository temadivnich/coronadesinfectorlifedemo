package com.epam.infrastructure_core.proxy;

/**
 * @author Evgeny Borisov
 */
public interface ProxyConfigurator {
    Object replaceWithProxyIfNeeded(Object t, Class implClass);
}
