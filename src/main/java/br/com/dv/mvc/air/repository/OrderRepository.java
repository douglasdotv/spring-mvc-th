package br.com.dv.mvc.air.repository;

import br.com.dv.mvc.air.model.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Order> getAllOrders() {
        Query query = entityManager.createQuery("Select p from Order p", Order.class);
        return query.getResultList();
    }

}
