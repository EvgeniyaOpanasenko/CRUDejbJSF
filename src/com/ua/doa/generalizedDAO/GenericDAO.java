package com.ua.doa.generalizedDAO;

import com.ua.doa.interfaces.EJBdataCRUDMEthods;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Map;

//TODO @Local or @Remote for client
public abstract class GenericDAO<T> implements EJBdataCRUDMEthods<T> {

    private final static String UNIT_NAME = "CrudPU";

    private Class<T> entityClass;

    public GenericDAO() {
    }

    //Autowires the database entity manager
    @PersistenceContext(unitName = UNIT_NAME)
    private EntityManager entityManager;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void save(T entity) {
        entityManager.persist(entity);
    }

    public void delete(T entity) {
        T entityToBEremoved = entityManager.merge(entity);
        entityManager.remove(entityToBEremoved);
    }


    // Using the unchecked because JPA does not have a
    // em.getCriteriaBuilder().createQuery()<T> method
    //TODO doe it nesessary to put warnings because the JPA code does not “understand” generics yet
    @SuppressWarnings({ "unchecked", "rawtypes"})
    public List<T> findAll() {
        CriteriaQuery<Object> criteriaQuery = entityManager.getCriteriaBuilder().createQuery();
        criteriaQuery.select(criteriaQuery.from(entityClass));
        return (List<T>) entityManager.createQuery(criteriaQuery).getResultList();

        //TODO check if works
        /*CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ConfigurationEntry> cq = cb.createQuery(ConfigurationEntry.class);
        Root<ConfigurationEntry> rootEntry = cq.from(ConfigurationEntry.class);
        CriteriaQuery<ConfigurationEntry> all = cq.select(rootEntry);
        TypedQuery<ConfigurationEntry> allQuery = em.createQuery(all);
        return allQuery.getResultList();*/
    }

    public T find(int entityID) {
        return entityManager.find(entityClass, entityID);
    }

    public T update(T entity) {
        return entityManager.merge(entity);
    }

    // Using the unchecked because JPA does not have a
    // ery.getSingleResult()<T> method
    @SuppressWarnings("unchecked")
    public T findOneResult(String namedQuery, Map<String, Object> parameters) {
        T result = null;

        try {
            Query query = entityManager.createNamedQuery(namedQuery);

            // Method that will populate parameters if they are passed not null and empty
            if (parameters != null && !parameters.isEmpty()) {
                populateQueryParameters(query, parameters);
            }

            result = (T) query.getSingleResult();

        } catch (Exception e) {
            System.out.println("Error while running query: '" + e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    private void populateQueryParameters(Query query, Map<String, Object> parameters) {

        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
    }
}
