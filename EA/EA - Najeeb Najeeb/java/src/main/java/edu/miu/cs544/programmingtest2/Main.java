package edu.miu.cs544.programmingtest2;

import edu.miu.cs544.programmingtest2.service.EmailSystem;
import edu.miu.cs544.programmingtest2.service.StudentCRUD;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        usingjavaConfig();

        usingXMLConfig();
    }

    private static void usingXMLConfig() {
        GenericXmlApplicationContext springContext = new GenericXmlApplicationContext();
        springContext.load("config.xml");
        springContext.refresh();

        EmailSystem emailSystem = springContext.getBean(EmailSystem.class);
        emailSystem.connectToMailServer();

    }

    private static void usingjavaConfig() {
        AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext();
        springContext.scan("edu.miu.cs544.programmingtest2");
//        springContext.getEnvironment().setActiveProfiles("production");
//        System.out.println("ENV : "+springContext.getEnvironment());
        springContext.refresh();

        EmailSystem emailSystem =springContext.getBean(EmailSystem.class);
        emailSystem.connectToMailServer();
        emailSystem.sendEmail();

        StudentCRUD studentCRUD = springContext.getBean(StudentCRUD.class);
        studentCRUD.create();
        studentCRUD.update();
        studentCRUD.read();
        studentCRUD.delete();
    }
}
