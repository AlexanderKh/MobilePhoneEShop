package ksk.dao.impl;

import ksk.entity.Order;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class OrderDAO implements ksk.dao.OrderDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<Order> getByPurchaseID(Integer purchaseID) {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM PRODUCT_PURCHASE WHERE PURCHASES_ID = :purchaseID");
        return sqlQuery.addEntity(Order.class).setParameter("purchaseID", purchaseID).list();
    }
}
