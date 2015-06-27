package ksk.dao.impl;

import ksk.entity.Order;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAO implements ksk.dao.OrderDAO {
    @Autowired
    SessionFactory sessionFactory;

    public List<Order> getByPurchaseID(Integer purchaseID) {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM PRODUCT_PURCHASE " +
                                                   "WHERE PURCHASE_ID = :purchaseID");
        return sqlQuery.addEntity(Order.class).setParameter("purchaseID", purchaseID).list();
    }

    public void save(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    public void deleteByPurchaseID(Integer purchaseID) {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery sqlQuery = session.createSQLQuery("DELETE FROM PRODUCT_PURCHASE " +
                                                   "WHERE PURCHASE_ID = :purchaseID");
        sqlQuery.setParameter("purchaseID", purchaseID);
        sqlQuery.executeUpdate();
    }

}
