package org.example.folder_stats_task3;

import org.example.folder_stats_task3.objects.FileManager;
import org.example.folder_stats_task3.objects.MyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		MyService service = (MyService) context.getBean("myService",MyService.class);
        System.out.println(service.getDoubleValue());
        System.out.println(service.getIntValue());
        FileManager fileManager = context.getBean("fileManager", FileManager.class);

        fileManager.getExtensionCount("c:\\Windows\\system32\\drivers");

    }
}
