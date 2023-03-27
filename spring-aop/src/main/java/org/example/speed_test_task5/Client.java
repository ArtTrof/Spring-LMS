package org.example.speed_test_task5;

import org.example.speed_test_task5.custom_annotations.ShowRes;
import org.example.speed_test_task5.custom_annotations.ShowTime;
import org.example.speed_test_task5.loger.MyLoger;
import org.example.speed_test_task5.objects.MyFileManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class Client {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        ApplicationContext context = new ClassPathXmlApplicationContext("context3.xml");

        MyFileManager myFileManager = new MyFileManager();

        Class<?> clazz = myFileManager.getClass();

        System.out.println("@SHOWTIME:");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ShowTime.class)) {
                myFileManager = (MyFileManager) context.getBean("myFileManager");
                method.invoke(myFileManager, "c:\\Windows\\");
                System.out.println("Method:" + method.getName() + " time:" + MyLoger.getTime() + " ms");
            }
        }
        System.out.println("@SHOWRES:");
        for (Method method : methods) {
            if (method.isAnnotationPresent(ShowRes.class)) {
                myFileManager = (MyFileManager) context.getBean("myFileManager");
                method.invoke(myFileManager, "c:\\Windows\\");
                if (method.getReturnType().equals(Set.class)) {
                    System.out.println("Method:" + method.getName() + " " + MyLoger.getSet());
                } else
                    System.out.println("Method:" + method.getName() + " " + MyLoger.getMap());
            }
        }
    }
}
//question
//why  інстанс оф не коренктно відпрацбовує
//} else if(method.getReturnType().isInstance(Map.class))
//        System.out.println("Method name: " + method.getName() + ", map: " + MyLoger.getMap());
//        }
