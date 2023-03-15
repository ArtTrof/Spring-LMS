package org.example.config;

import org.example.implmentation.Iphone;
import org.example.implmentation.Nokia;
import org.example.interfaces.Phone;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration//i dont know why here it doesnt import by itself
public class Configuration {
    @Bean
    public Phone nokia(){
        Nokia nokia = new Nokia("Black",2.5);
        nokia.init();
        nokia.setBattery("200 mAh");
        return nokia;
    }
    @Bean
    public Phone iphone(){
        Iphone iphone = new Iphone("White",12);
        iphone.init();
        iphone.setBattery("2500 mAh");
        return iphone;
    }
}
