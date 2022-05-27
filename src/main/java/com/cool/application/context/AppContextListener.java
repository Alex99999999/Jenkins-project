package com.cool.application.context;

import com.cool.application.context.impl.PostgresApplicationContextImpl;
import com.cool.application.servlet.webcommand.CommandContainer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;

@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        Connection con = null;

        //TODO Establish db connection

        ApplicationContext applicationContext = new PostgresApplicationContextImpl();
        CommandContainer commandContainer = new CommandContainer(applicationContext);
        ctx.setAttribute("DbConnection", con);
        ctx.setAttribute("CommandContainer", commandContainer);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();
        Connection con = (Connection) ctx.getAttribute("DbConnection");

        //TODO Close DB connection

    }

}