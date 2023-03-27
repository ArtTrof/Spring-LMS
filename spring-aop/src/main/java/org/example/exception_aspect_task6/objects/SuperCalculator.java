package org.example.exception_aspect_task6.objects;

import org.springframework.stereotype.Component;

@Component
public class SuperCalculator {
    public float divide(float a,float b){
        if (b==0)
            throw new ArithmeticException("cant be divided by zero !:(");
        else
        return a/b;
    }
}
