package pl.sdacademy.bookDaoInterface;


import pl.sdacademy.HibernateUtil;

import javax.persistence.EntityManager;

public abstract class AbstractDao<T, ID> implements DaoInterface<T, ID>{
    public EntityManager connection(){
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
        entityManager.getTransaction().begin();
        return entityManager;
    }
}
