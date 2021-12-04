package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MainApp {
   public static void main(String[] args) throws SQLException {

      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("HundaySolyaris", 1021);
      Car car2 = new Car("SkodaOktavia", 56);
      Car car3 = new Car("MitsubishiPadjaro", 1344);
      Car car4 = new Car("FiatUno", 2656);
      User user1 = new User("Ivan", "Petrov", "Petrov@gmail.com");
      User user2 = new User("Petr", "Ivanov", "Ivanov@mail.ru");
      User user3 = new User("Sidor", "Kuznetsov", "Kuznetsov@yandex.ru");
      User user4 = new User("Alexander", "Petrov", "Sidorov@rambler.ru");
      User user5 = new User("Petr", "Sidorov", "Sidorov@yandex.ru");
      User user6 = new User("Vasiliy", "Krechetov", "Krechetov@rambler.ru");

      car1.setUser(user1);
      car2.setUser(user3);
      car3.setUser(user5);
      car4.setUser(user6);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);
      userService.add(user5);
      userService.add(user6);

      userService.add(car1);
      userService.add(car2);
      userService.add(car3);
      userService.add(car4);



      List<User> users = userService.listUsers();
      List<Car> cars = userService.listCar();

      for(User user:users){
         String carText = new String();
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         for (Car car : cars){
            if(car.getId() == user.getId()){
               carText = car.toString();
            }
         }
      }


      System.out.println("*************************");

      for (Car car: cars){
         System.out.println(car.toString());
      }

      List<User> findUser = userService.findUser("FiatUno", 2656);

      for(User user: findUser){
         System.out.println(user);
      }


/*
      System.out.println("**************************");

      for(User user:userCar){
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
//         System.out.println("Car = " + user.getCar().toString());
         System.out.println();
      }

 */
   }


}
