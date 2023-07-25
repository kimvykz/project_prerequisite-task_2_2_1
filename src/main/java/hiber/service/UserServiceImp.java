package hiber.service;

import com.sun.xml.bind.annotation.OverrideAnnotationOf;
import hiber.dao.UserDao;
import hiber.dao.UserDaoImp;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listByModelSeries(String model, int series){
      UserDaoImp ud = (UserDaoImp) userDao;

      return  ud.listByModelSeries(model, series);
   }


}
