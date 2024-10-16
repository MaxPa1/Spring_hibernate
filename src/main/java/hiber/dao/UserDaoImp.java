package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User userByCar(Car car) {
      User user = new User();
      Query<User> query = sessionFactory.getCurrentSession()
              .createQuery("from User where userCar.model = :model and userCar.series = :series", User.class);
      query.setParameter("model", car.getModel());
      query.setParameter("series", car.getSeries());
      if(!query.getResultList().isEmpty()) {
         user = query.getSingleResult();
      }
      return user;
   }
}

