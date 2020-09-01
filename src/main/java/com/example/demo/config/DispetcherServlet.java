package com.example.demo.config;

import com.example.demo.rest.RestContainer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class DispetcherServlet extends HttpServlet {


    public void service(HttpServletRequest request, HttpServletResponse response) {

        String path = request.getPathTranslated();

        Map<String, String[]> params = request.getParameterMap();
      //  RestContainer.urlMethod.get(path)
    }
}
