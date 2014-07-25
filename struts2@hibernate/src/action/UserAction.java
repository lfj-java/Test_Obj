package action;

import action.entity.User;
import action.util.DB;
import action.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Administrator on 14-7-25.
 */
public class UserAction extends BaseAction {
    private User user;
    public String login() throws Exception {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("from User where username=:username and password =:password ");
        query.setString("username", user.getUsername());
        query.setString("password", user.getPassword());
        List<User> users = query.list();
        session.close();
        if (users.size() > 0) {
            getSession().put("user", user);
            return "login_success";
        } else {
            getRequest().put("message", "用户名或密码错误");
            return "login_input";
        }

    }

    public String signup() throws Exception {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
        return "signup_success";
    }

    public String logout() throws Exception {
        getSession().clear();
        return "logout_success";
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

