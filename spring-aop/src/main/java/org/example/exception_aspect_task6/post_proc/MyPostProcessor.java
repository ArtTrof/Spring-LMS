package org.example.exception_aspect_task6.post_proc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyPostProcessor implements BeanPostProcessor {
    public Object postProcessAfterInitialization(Object object, String name) throws BeansException {
        System.err.println(object + " - postProcessAfterInitialization()");
        return object;
    }

    public Object postProcessBeforeInitialization(Object object, String name) throws BeansException {
        return object;
    }
}
