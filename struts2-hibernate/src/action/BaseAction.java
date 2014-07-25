package action;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by Administrator on 14-7-25.
 */
public class BaseAction implements RequestAware, SessionAware {

    private Map<String, Object> request;
    private Map<String, Object> session;

    public Map<String, Object> getRequest() {
        return request;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;

    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

}
