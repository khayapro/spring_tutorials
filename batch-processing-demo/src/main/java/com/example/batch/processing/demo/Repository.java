package com.example.batch.processing.demo;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class Repository {

    @PersistenceContext(unitName = "db_pu")
    private EntityManager em;

    public void save(final Person person) {
        em.persist(person);
        em.flush();
        System.out.println("******* saved successfully *******");
    }

}
