package sk.kasv.kincel.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.kasv.kincel.test.entity.City;
import sk.kasv.kincel.test.entity.Country;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(City.class).
                addAnnotatedClass(Country.class).
                buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Country country2=new Country("Czech Republic");
            Country country1=new Country("Slovakia");
            City city1=new City("Kosice",country1);
            City city2=new City("Sobrance",country1);
            City city3=new City("Lviv",country2);
            City city4=new City("Kyiv",country2);



            session.beginTransaction();

           session.save(country1);
            session.save(country2);
            session.save(city1);
            session.save(city2);
            session.save(city3);
            session.save(city4);

            session.getTransaction().commit();
            System.out.println("Done");
        }finally {


            session.close();

            factory.close();
        }
    }
}
