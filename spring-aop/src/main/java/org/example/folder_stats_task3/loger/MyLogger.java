package org.example.folder_stats_task3.loger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
@Aspect
@Component
public class MyLogger {

    @Pointcut("execution(* *(..)) && within(org.example.folder_stats_task3.*)")
    private void allMethods() {}

    @Around("allMethods()")
    public Object watchTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("Method begin: " + joinPoint.getSignature().toShortString() + " >>");

        for (Object arg : joinPoint.getArgs()) {
            System.out.println("Param: " + arg);
            String[] path = arg.toString().split("\\\\");
            String folderName = path[path.length - 1];
            System.out.println("Folder Name: " + folderName);
        }

        Object output = joinPoint.proceed();

        long time = System.currentTimeMillis() - start;
        System.out.println("Method end: " + joinPoint.getSignature().toShortString() + ", time=" + time + " ms <<");
        System.out.println();
        return output;
    }

    @AfterReturning(pointcut = "allMethods()", returning = "obj")
    public void print(Object obj) {
        System.out.println("Print info begin >>");

        if (obj instanceof Set) {
            Set<?> set = (Set<?>) obj;
            for (Object element : set) {
                System.out.println(element);
            }
        } else if (obj instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) obj;
            for (Object key : map.keySet()) {
                System.out.println("key=" + key + ", " + map.get(key));
            }
        }

        System.out.println("Print info end <<");
        System.out.println();
    }

    @Pointcut("execution(* org.example.folder_stats_task3.objects.MyService.*(..))")
    public void myServiceMethods() {}

    @Before("myServiceMethods()")
    public void init() {
        System.out.println("init");
    }

    @After("myServiceMethods()")
    public void close() {
        System.out.println("close");
    }

    @AfterReturning(pointcut = "myServiceMethods()", returning = "obj")
    public void printNumbers(Object obj) {
        System.out.println(obj);
    }
}
