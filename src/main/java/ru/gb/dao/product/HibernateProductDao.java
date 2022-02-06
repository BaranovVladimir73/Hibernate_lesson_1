package ru.gb.dao.product;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Product;

import java.util.Collections;

@Repository
@RequiredArgsConstructor
public class HibernateProductDao implements ProductDao{

    private final SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Product> findAll() {
        return Collections.unmodifiableList(sessionFactory.getCurrentSession().createQuery("from Product p").list());
    }

    @Override
    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return (Product) sessionFactory.getCurrentSession().getNamedQuery("Product.findById")
                .setParameter("id", id).uniqueResult();
    }

    @Override
    @Transactional(readOnly = true)
    public String findNameById(Long id) {
        return (String) sessionFactory.getCurrentSession().getNamedQuery("Product.findNameById")
                .setParameter("id", id).uniqueResult();
    }

    @Override
    public void insert(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
