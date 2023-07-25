package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import hiber.service.UserServiceImp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.management.Query;
import java.sql.SQLException;
import java.util.List;
import java.util.Queue;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User u1 = new User("Tinkov", "Oleg", "tinkov@tinkovbank.ru");
      Car c1 = new Car("BMW", 550);
      u1.setCar(c1);
      c1.setUser(u1);

      userService.add(u1);

      u1 = new User("Musk", "Elon", "Elon@Tesla.com");
      c1 = new Car("Tesla", 3);
      u1.setCar(c1);
      c1.setUser(u1);
      userService.add(u1);

      u1 = new User("Cook", "Tim", "Tim@apple.com");
      c1 = new Car("Ford", 350);
      u1.setCar(c1);
      c1.setUser(u1);
      userService.add(u1);

      u1 = new User("Kim", "Vyacheslav", "vya@gmail.com");
      c1 = new Car("Lada", 350);
      u1.setCar(c1);
      c1.setUser(u1);
      userService.add(u1);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar().getModel() + " " + user.getCar().getSeries());
         System.out.println();
      }


      List<User> usersByModSer = userService.listByModelSeries("Lada", 350);
      for (User user : usersByModSer) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar().getModel() + " " + user.getCar().getSeries());
         System.out.println();
      }

      context.close();
   }
}
