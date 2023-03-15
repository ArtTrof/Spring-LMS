package org.example;

import org.example.config.Configuration;
import org.example.implmentation.Iphone;
import org.example.implmentation.Nokia;
import org.example.interfaces.Phone;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //with xml config
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Phone nokia = context.getBean("nokia", Nokia.class);
        System.out.println(nokia);
        Phone iphone = context.getBean("iphone", Iphone.class);
        System.out.println(iphone);
        //map
        Map<Integer, Phone> phoneMap = context.getBean("phoneMap", Map.class);
        for (Map.Entry<Integer, Phone> phone : phoneMap.entrySet()) {
            System.out.println(phone.getKey() + " " + phone.getValue());
        }
        //with java conf
        System.out.println("********************************");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Configuration.class);
        Phone nokia2 = applicationContext.getBean("nokia", Nokia.class);
        System.out.println(nokia);
        Phone iphone2 = applicationContext.getBean("iphone", Iphone.class);
        System.out.println(iphone);
        Map<String, Phone> phoneMap2 = applicationContext.getBeansOfType(Phone.class);
        for (Phone phone : phoneMap2.values())
            System.out.println(phone);
    }
}

