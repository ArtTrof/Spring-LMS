package org.example.speed_test_task4;

import org.example.speed_test_task4.objects.MyFileManager;
import org.example.speed_test_task4.objects.MyFileManagerExtension;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context2.xml");
        MyFileManager fileManager = (MyFileManager) context.getBean("myFileManager");
        MyFileManagerExtension fileManagerExtension = (MyFileManagerExtension) context.getBean("myFileManagerExtension");
        System.out.println( "MyFileManager:");
        fileManager.getExtensionCount("c:\\Windows\\");
        fileManager.getExtensionList("c:\\Windows\\");
        System.out.println( "MyFileManagerExtension:" );
        fileManagerExtension.getExtensionCount("c:\\Windows");
        fileManagerExtension.getExtensionList("c:\\Windows\\");
    }
}
