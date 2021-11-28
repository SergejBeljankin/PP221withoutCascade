package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("Model1", 111);
      Car car2 = new Car("Model2", 222);
      Car car3 = new Car("Model1", 111);
      Car car4 = new Car("Model2", 222);
      User user1 = new User("User01", "Lastname01", "user1@mail.ru");
      User user2 = new User("User02", "Lastname2", "user2@mail.ru");
      User user3 = new User("User03", "Lastname3", "user3@mail.ru");
      User user4 = new User("User04", "Lastname4", "user4@mail.ru");
      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);
      user4.setCar(car4);
      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar().toString());
         System.out.println();
      }


      List<User> userCar = userService.findUser("Model1", 111);
      context.close();
      System.out.println("**************************");

      for(User user:userCar){
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar().toString());
         System.out.println();
      }
   }
}
