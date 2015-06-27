package ksk.dao.impl;

import ksk.entity.Customer;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAO implements ksk.dao.CustomerDAO {
    @Autowired
    SessionFactory sessionFactory;

    public List<Customer> getAll() {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT CUSTOMER.* FROM CUSTOMER");
        return sqlQuery.addEntity(Customer.class).list();
    }

    public Customer getByID(int id) {
        return (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
    }

    public void save(Customer customer) {
        sessionFactory.getCurrentSession().save(customer);
    }

    public void deleteByID(Integer customerID) {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery sqlQuery = session.createSQLQuery("DELETE FROM CUSTOMER WHERE ID = :customerID");
        sqlQuery.setParameter("customerID", customerID);
        sqlQuery.executeUpdate();
    }
}
