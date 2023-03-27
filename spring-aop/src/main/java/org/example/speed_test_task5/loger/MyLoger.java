package org.example.speed_test_task5.loger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
@Aspect
public class MyLoger {
    private static long time;
    private static Set<String> set;
    private static Map<String, Integer> map;

    public MyLoger() {
    }

    @Pointcut("@annotation(org.example.speed_test_task5.custom_annotations.ShowTime))")
    private void showTime() {
    }

    @Pointcut("@annotation(org.example.speed_test_task5.custom_annotations.ShowRes)")
    private void showResult() {
    }

    @Around("showTime()")
    public Object watchTime(ProceedingJoinPoint joinpoint) {
        long start = System.currentTimeMillis();
        Object output = null;
        try {
            output = joinpoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        time = System.currentTimeMillis() - start;
        return output;
    }

    @AfterReturning(pointcut = "showResult()", returning = "obj")
    public void print(Object obj) {
        if (obj instanceof Set) {
            set = (Set) obj;
        } else if (obj instanceof Map) {
            map = (Map) obj;
        }
    }

    public static long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public static Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public static Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }
}
