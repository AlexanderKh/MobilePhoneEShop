package ksk.dao.impl;

import ksk.entity.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

import static org.hibernate.criterion.Restrictions.eq;

@Repository
public class CharacteristicDAO implements ksk.dao.CharacteristicDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<Characteristic> getCharacteristicsByProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Characteristic.class);
        criteria.add(eq("product", product));
        return criteria.list();
    }
}
