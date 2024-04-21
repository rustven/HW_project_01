package client;

import app.controller.CarsController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Client {
    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
                "app");
        CarsController controller = context.getBean(CarsController.class);
        System.out.println(controller.getById(2L));
    }
}
