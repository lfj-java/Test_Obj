package action;

import action.entity.User;
import action.util.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Administrator on 14-7-23.
 */
public class UserAction extends BaseAction {
    private User user;
    private Connection connection = DB.getConnection();
    public String login() throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user where username=? and password=?");
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean b = resultSet.next();
        DB.close(resultSet, preparedStatement, null);
        if (b) {
            getSession().put("user", user);
            return "login_success";
        } else {
            getRequest().put("message", "用户名或密码错误");
            return "login_input";
        }
    }

    public String signup() throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into user values(null,?,?)");
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.executeUpdate();
        DB.close(null, preparedStatement, null);
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
