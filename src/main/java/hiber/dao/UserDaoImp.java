package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.context.spi.CurrentSessionContext;
import org.hibernate.query.QueryParameter;
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

   public List<User> listByModelSeries(String model, int series){
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(
              "select u from User u, " +
                 "Car c where u.id = c.userId " +
                      "and c.model like :model " +
                      "and c.series = :series")
              .setParameter("model", model)
              .setParameter("series", series);

      return query.getResultList();
   }

   public SessionFactory getSessionFactory() {
      return sessionFactory;
   }
}
