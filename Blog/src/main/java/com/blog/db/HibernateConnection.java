package com.blog.db;

import com.blog.model.Entry;
import com.blog.model.Post;
import com.blog.model.User;
import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateConnection {
    public SessionFactory sessionFactory;

    public Session doHibernateConnection() {

        try {
            Properties database = new Properties();
            database.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            database.setProperty("hibernate.connection.username", "root");
            database.setProperty("hibernate.connection.password", "root");
            database.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/blog");
            database.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

            Configuration cfg = new Configuration().setProperties(database).addPackage("com.blog.demo")
                    .addAnnotatedClass(User.class).addAnnotatedClass(Entry.class).addAnnotatedClass(Post.class);

            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
                    .applySettings(cfg.getProperties());

            sessionFactory = cfg.buildSessionFactory(ssrb.build());
        } catch (Exception e) {
            System.out.println(e);
        }
        return sessionFactory.openSession();
    }

}
