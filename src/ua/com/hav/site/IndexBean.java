package ua.com.hav.site;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexBean {

    private HttpServletRequest request;
    private HttpServletResponse response;

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

//    private String request;
//    private String response;
//
//    public void setRequest(String request) {
//        this.request = request;
//    }
//
//    public void setResponse(String response) {
//        this.response = response;
//    }

    public String foo() {
        return "sss=" + request.getParameter("sss");
    }

    @Override
    public String toString() {
        return "IndexBean{" +
                "request='" + request + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}
