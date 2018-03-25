
package com.appliedsni.dao;

import java.util.Date;

import java.util.Map;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import org.springframework.transaction.annotation.Transactional;
import com.appliedsni.entity.PersistenceObject;
import com.appliedsni.exception.DaoException;
public abstract class BaseJpaDaoImpl  implements BaseJpaDao {

    private static final String HIBERNATE_CACHE_ENABLE = "org.hibernate.cacheable";
    
    private static final String TIMEOUT_PROPERTY = "javax.persistence.lock.timeout";
    
    private static final String DEFAULT_TIMEOUT = "5000";

    /**
     * Attribute to hold the <code>EntityManager</code> object.
     */
    @PersistenceContext
    private EntityManager entityManager;


    /**
     * <code>Default constructor</code>.
     */
    public BaseJpaDaoImpl() {

    }

    @Override
    public final <T extends PersistenceObject> T create(final T pObject)
                throws Exception {
        try {
            this.getEntityManager().persist(pObject);
        }
        catch (final EntityExistsException aEntityExistsException) {
            throw new Exception();
        }
        return pObject;
    }

    @Override
    public final Query createNamedQuery(final String pNamedQuery,
                final Map<String, Object> pBindParameters) {
        Query aQuery = null;
        aQuery = this.getEntityManager().createNamedQuery(pNamedQuery);
        return this.buildQuery(aQuery, pBindParameters);
    }

 
    @Override
    public Query createNativeQuery(final String pNativeQuery) {

        return this.getEntityManager().createNativeQuery(pNativeQuery);
    }

    @Override
    public final Query createNativeQuery(final String pJpaQuery,
                final Map<String, Object> pBindParameters) {

        Query aQuery = null;

        aQuery = this.getEntityManager().createNativeQuery(pJpaQuery);
        return this.buildQuery(aQuery, pBindParameters);
    }

    @Override
    public final Query createQuery(final String pJpaQuery,
                final Map<String, Object> pBindParameters) {

        Query aQuery = null;

        aQuery = this.getEntityManager().createQuery(pJpaQuery);
        if(pBindParameters!=null)
        return this.buildQuery(aQuery, pBindParameters);
        else 
        	return aQuery;
    }

    @Override
    public final <T extends PersistenceObject> void delete(final T pObject) throws DaoException {
        try {
            final Object anObject = this.getObjectReference(pObject);

            this.getEntityManager().remove(anObject);

        }
        catch (final EntityNotFoundException aEntityNotFoundException) {
            throw new DaoException("entity does not exist");
        }

    }
    public Query createCachedQuery(final String pQuery) {

        Query aQuery = null;
        aQuery = this.getEntityManager().createNamedQuery(pQuery);
        aQuery.setHint(HIBERNATE_CACHE_ENABLE, true);
        return aQuery;
    }
    @Override
    public final <T extends PersistenceObject> T findbyPK(final T pObject)
                throws DaoException {

        Object anObject = null;

        try {
            this.getObjectReference(pObject);
            anObject = this.getEntityManager().find(pObject.getClass(),
                pObject.getId());
        }
        catch (final EntityNotFoundException aEntityNotFoundException) {
            throw new DaoException("entity does not exist");
        }
        return (T) anObject;
    }
    public EntityManager getEntityManager() {  	
        
        return this.entityManager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final <T extends PersistenceObject> T mergeManaged(final T pObject)
                throws DaoException {

        if (pObject.getOldVersion() > pObject.getVersion()) {

            throw new DaoException("");
        }
        
        pObject.setVersion(pObject.getVersion() + 1);

        return pObject;

    }

    /**
     * {@inheritDoc}
     */

    @Override
    public final <T extends PersistenceObject> T update(final T pObject)
                throws DaoException {

        Object anObject = null;
        try {

            this.getObjectReference(pObject);
            this.checkVersionMisMatch(pObject);
            anObject = this.getEntityManager().merge(pObject);
            final PersistenceObject thePersistenceObject = (PersistenceObject) anObject;
            thePersistenceObject
                        .setVersion(thePersistenceObject.getVersion() + 1);
        }
        catch (final DaoException aException) {
            throw new DaoException("");
        }
        return (T) anObject;

    }
  
    private <T extends PersistenceObject> void checkVersionMisMatch(
                final T pObject) throws DaoException {

        if (pObject.getOldVersion() > pObject.getVersion()) {

            throw new DaoException("");
        }
    }
    public <T extends PersistenceObject>  void merge(final T pObject) {
        try {
            this.getEntityManager().merge(pObject);
        }
        catch (PersistenceException e) {
           
        }
    }
	public <T extends PersistenceObject> void refresh(final T pObject) {
		try {
			this.getEntityManager().refresh(pObject);
		} catch (PersistenceException e) {
			
		}
	}
	 private <T extends PersistenceObject> T getObjectReference(final T pObject)
             throws DaoException {

     Object anObject = null;
     try {
         anObject = this.getEntityManager().find(pObject.getClass(),
             pObject.getId());
     }
     catch (final EntityNotFoundException aEntityNotFoundException) {
         throw new DaoException("entity does not exist");
     }
     return (T) anObject;
 }
	  private Query buildQuery(final Query pQuery,
              final Map<String, Object> pBindParameters) {
      for (final Map.Entry<String, Object> aKeyValue : pBindParameters
                  .entrySet()) {
          if (aKeyValue.getKey().contains("TemporalTimeStamp")) {
              pQuery.setParameter(aKeyValue.getKey(),
                  (Date) aKeyValue.getValue(), TemporalType.TIMESTAMP);
          }
          else if (aKeyValue.getKey().contains("TemporalDate")) {
              pQuery.setParameter(aKeyValue.getKey(),
                  (Date) aKeyValue.getValue(), TemporalType.DATE);
          }
          else if (aKeyValue.getKey().contains("TemporalTime")) {
              pQuery.setParameter(aKeyValue.getKey(),
                  (Date) aKeyValue.getValue(), TemporalType.TIME);
          }
          else {
              pQuery.setParameter(aKeyValue.getKey(), aKeyValue.getValue());
          }
      }
      return pQuery;
  }
}
