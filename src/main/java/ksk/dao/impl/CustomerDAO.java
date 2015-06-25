package ksk.dao.impl;
import ksk.entity.Customer;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAO implements ksk.dao.CustomerDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT CUSTOMER.* FROM CUSTOMER");
        return sqlQuery.addEntity(Customer.class).list();
    }

    @Transactional
    public Customer getCustomer(int id) {
        return (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
    }

    @Transactional
    public void saveCustomer(Customer customer) {
        sessionFactory.getCurrentSession().save(customer);
    }

    @Transactional
    public void removeCustomerByID(Integer customerID) {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery sqlQuery = session.createSQLQuery("DELETE FROM CUSTOMER WHERE ID = :customerID");
        sqlQuery.setParameter("customerID", customerID);
        sqlQuery.executeUpdate();
    }
}
