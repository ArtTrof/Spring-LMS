package org.example.folder_stats_task3.post_proc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
class MyPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object object, String name) throws BeansException {
        System.err.println(object + " - postProcessAfterInitialization()");
        return object;
    }

    @Override
    public Object postProcessBeforeInitialization(Object object, String name) throws BeansException {
        return object;
    }

}
