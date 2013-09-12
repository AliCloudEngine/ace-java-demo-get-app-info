package com.acedemo.hello.ace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

/**
 * @author ding.lid
 */
public class ShowAppInfo extends HttpServlet {
    private static final long serialVersionUID = -1120930759438832012L;
    private static final Logger logger = LoggerFactory.getLogger(ShowAppInfo.class);

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info(ShowAppInfo.class.getName() + " accessed!");
        ResourceBundle publicPropertiesBundle = ResourceBundle.getBundle("ace4j-public");

        String appIdentifier = publicPropertiesBundle.getString("ace4j.thisapp.identifier");
        String appDomain = publicPropertiesBundle.getString("ace4j.thisapp.alidomain");


        PrintWriter writer = resp.getWriter();
        writer.printf("App Identifier: %s, App Domain: %s.", appIdentifier, appDomain);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
