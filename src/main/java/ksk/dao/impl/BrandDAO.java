package ksk.dao.impl;

import ksk.entity.Brand;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BrandDAO implements ksk.dao.BrandDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<Brand> getBrands() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Brand.class);
        return criteria.list();
    }

    @Transactional
    public Brand getBrand(int brandID) {
        return (Brand) sessionFactory.getCurrentSession().get(Brand.class, brandID);
    }
}
