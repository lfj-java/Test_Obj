package action;

import action.entity.Book;
import action.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Created by Administrator on 14-7-25.
 */
public class BookAction extends BaseAction {
    private Book book;
    public String add() throws Exception {
        Session session = HibernateUtil.getSession();
        session.save(book);
        session.beginTransaction().commit();
        session.close();
        return "add_success";
    }

    public String list() throws Exception {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("FROM Book");
        getSession().put("books", query.list());
        session.close();
        return "list_success";
    }

    public String search() throws Exception {
        Session session = HibernateUtil.getSession();
        getSession().put("book", session.get(Book.class, book.getId()));
        session.close();
        return "search_success";

    }

    public String update() throws Exception {
        Session session = HibernateUtil.getSession();
        session.update(book);
        session.beginTransaction().commit();
        session.close();
        return "update_success";
    }


    public String remove() throws Exception {
        Session session = HibernateUtil.getSession();
        session.delete(book);
        session.beginTransaction().commit();
        session.close();
        return "remove_success";
    }



    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
