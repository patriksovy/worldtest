package sk.kasv.kincel.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;
import sk.kasv.kincel.test.entity.City;
import sk.kasv.kincel.test.entity.Country;

import java.util.Iterator;
import java.util.List;

public class GetDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(City.class).
                addAnnotatedClass(Country.class).
                buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            
            String hql="FROM Country ";
            Query query=session.createQuery(hql);
            List<Country> countryList=query.list();
            Iterator<Country> countryIterator=countryList.iterator();
            while(countryIterator.hasNext()){
                Country country=countryIterator.next();
                System.out.println(country.getCities()+" "+country.getName());
            }


            session.getTransaction().commit();
            System.out.println("Done");
        }finally {


            session.close();

            factory.close();
        }
    }
}
