package ksk.dao.impl;

import ksk.entity.Purchase;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseDAO implements ksk.dao.PurchaseDAO {
    @Autowired
    SessionFactory sessionFactory;

    public void save(Purchase purchase) {
        sessionFactory.getCurrentSession().save(purchase);
    }

    public List<Purchase> getByCustomerID(Integer customerID) {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM PURCHASE WHERE " +
                                                   "CUSTOMER_ID = :customerID");
        return sqlQuery.addEntity(Purchase.class).setParameter("customerID", customerID).list();
    }

    public Purchase getByID(Integer purchaseID) {
        Session session = sessionFactory.getCurrentSession();
        return (Purchase) session.get(Purchase.class, purchaseID);
    }

    public void deleteByID(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery sqlQuery = session.createSQLQuery("DELETE FROM PURCHASE WHERE ID = :ID");
        sqlQuery.setParameter("ID", id);
        sqlQuery.executeUpdate();
    }
}
