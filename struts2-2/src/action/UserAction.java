package action;


import action.entity.User;
import action.util.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Administrator on 14-7-25.
 */
public class UserAction extends BaseAction {
    private User user;
    private Connection connection= DB.getconnection();

    public String login() throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user where username = ? and password = ?");
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean b = resultSet.next();
        DB.Close(resultSet, preparedStatement, null);
        if (b) {
            getSession().put("user", user);
            return "login_success";
        } else {
            getRequest().put("message", "用户名或密码错误");
            return "input_success";
        }

    }

    public String sigup() throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into user values (null,?,?)");
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.executeUpdate();
        DB.Close(null, preparedStatement, null);
        return "sigup_success";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

