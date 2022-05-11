package sk.kasv.kincel.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.kasv.kincel.test.entity.City;
import sk.kasv.kincel.test.entity.Country;

public class UpdateDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(City.class).
                addAnnotatedClass(Country.class).
                buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int id=1;
            session.beginTransaction();
            City city=session.get(City.class,id);
            city.setName("Sobrance");
            session.update(city);
            session.getTransaction().commit();
            System.out.println("Done");

        }finally {


            session.close();

            factory.close();
        }
    }
}
