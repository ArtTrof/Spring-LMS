package org.example.exception_aspect_task6;

import org.example.exception_aspect_task6.objects.SuperCalculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context4.xml");
        SuperCalculator calculator = (SuperCalculator) context.getBean("superCalculator");
        try {
            System.out.println(calculator.divide(1, 0));//помітив рофл шо якщо не опрацювати метод то ексепшн викадаэться тільки з інтовими значеннями (дабл і фолт дають infinity)
        } catch (Exception e) {
        }
    }
}
