package action;

import action.entity.Book;
import action.util.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 14-7-24.
 */
public class BookAction extends BaseAction {
    private Book book;
    private Connection connection = DB.getConnection();
    public String add() throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into book values (null,?,?,?)");
        preparedStatement.setString(1, book.getTitle());
        preparedStatement.setString(2, book.getAuthor());
        preparedStatement.setInt(3, book.getAmount());
        preparedStatement.executeUpdate();
        DB.close(null,preparedStatement,null);
        return "add_success";
    }

    public String list() throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from book");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Book> books = new ArrayList<Book>();
        while (resultSet.next()) {
            Book book = new Book(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("author"), resultSet.getInt("amount"));
            books.add(book);
        }
        getSession().put("books", books);
        return "list_success";
    }

    public String search() throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from book where id=?");
        preparedStatement.setInt(1, book.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        Book book = new Book(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("author"), resultSet.getInt("amount"));
        getSession().put("book", book);
        DB.close(resultSet, preparedStatement, null);
        return "search_success";
    }

    public String update() throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement("update book set title=?,author=?,amount=? where id=?");
        preparedStatement.setString(1, book.getTitle());
        preparedStatement.setString(2, book.getAuthor());
        preparedStatement.setInt(3, book.getAmount());
        preparedStatement.setInt(4, book.getId());
        preparedStatement.executeUpdate();
        return "update_success";
    }

    public String remove() throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from book where id=?");
        preparedStatement.setInt(1, book.getId());
        preparedStatement.executeUpdate();
        DB.close(null, preparedStatement, null);
        return "remove_success";
    }
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
