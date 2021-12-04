package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(Car car) {
      sessionFactory.getCurrentSession().save(car);
   }

   @Override
   public List<Car> listCar() {
      TypedQuery query=sessionFactory.getCurrentSession().createQuery("from Car", Car.class);
      return query.getResultList();
   }

   @Override
   public List<Car> findCar(String firstName, String lastName){
      TypedQuery query=sessionFactory
              .getCurrentSession()
              .createQuery("from Car car inner join User user with user.firstName = :name AND user.lastName = :lastName", Car.class)
              .setParameter("firstName", firstName)
              .setParameter("lastName", lastName);
      return query.getResultList();
   }

}
