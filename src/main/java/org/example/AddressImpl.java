package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AddressImpl implements AddressDAO {
    EntityManagerFactory emf;
    EntityManager em;

    public AddressImpl() {
        emf = Persistence.createEntityManagerFactory("jpa");
        em = emf.createEntityManager();
    }

    @Override
    public void create(Address address) {
        em.getTransaction().begin();
        em.persist(address);
        em.getTransaction().commit();
    }

    @Override
    public void update(Address address) {
        em.getTransaction().begin();
        em.merge(address);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Address address) {
        em.getTransaction().begin();
        em.remove(address);
        em.getTransaction().commit();
    }

    @Override
    public Address getById(long id) {
        return em.find(Address.class, id);
    }

    @Override
    public void cityPerCountry() {
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Address> addressRoot = cq.from(Address.class);

        cq.multiselect(addressRoot.get("country"), cb.count(addressRoot)).groupBy(addressRoot.get("country"));
        cq.orderBy(cb.desc(cb.count(addressRoot)));

        System.out.print("Country");
        System.out.println("\t Cities");
        List<Object[]> list = em.createQuery(cq).getResultList();
        for (Object[] object : list) {
            System.out.println(object[0] + "\t   " + object[1]);
        }
        em.getTransaction().commit();

    }

    @Override
    public List<Address> getAll() {
        return em.createQuery("SELECT address FROM Address address", Address.class).getResultList();
    }


}
