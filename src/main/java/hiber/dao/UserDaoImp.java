package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public List<User> listUsers() {
      TypedQuery query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public List<User> findUser(String model, int seria){
      TypedQuery query=sessionFactory
              .getCurrentSession()
              .createQuery("select user from User user where user.car.series = :seria AND user.car.model = :model", User.class)
              .setParameter("seria", seria)
              .setParameter("model", model);
      return query.getResultList();
   }

}
