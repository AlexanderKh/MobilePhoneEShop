package ksk.dao.impl;

import ksk.entity.Product;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductDAO implements ksk.dao.ProductDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<Product> getAll() {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT PRODUCT.* FROM PRODUCT");
        return sqlQuery.addEntity(Product.class).list();
    }

    @Transactional
    public Product getByID(int id) {
        return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
    }

    @Transactional
    public void save(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    @Transactional
    public void deleteByID(Integer productID) {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery sqlQuery = session.createSQLQuery("DELETE FROM PRODUCT WHERE ID = :productID");
        sqlQuery.setParameter("productID", productID);
        sqlQuery.executeUpdate();
    }
}
