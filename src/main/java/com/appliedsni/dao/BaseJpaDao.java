
package com.appliedsni.dao;
import java.util.Map;



import javax.persistence.Query;

import com.appliedsni.entity.PersistenceObject;
import com.appliedsni.exception.DaoException;


/**
 * <code>BaseJpaDao</code> interface provides the basic definition of a Java Persistence API's Data Access
 * Object for LMS.
 * <p>
 * The operations defined here are as follows:
 * <ul>
 * <li>create
 * <li>delete
 * <li>findbyPK
 * <li>update
 * <li>flush
 * </ul>
 * 
 */
public interface BaseJpaDao {

    /**
     * Inserts the entity in the database.
     * <p>
     * It uses a persistence provider to perform this task.
     * <p>
     * 
     * @param <T> is a persistence object type variable.
     * @param pObject is a persistence object type variable.
     * @return <T> a persistence object type variable.
     * @throws DaoException if the create operation fails.
     */
    <T extends PersistenceObject> T create(T pObject) throws Exception;

    /**
     * Binds the value to the named query.
     * <p>
     * 
     * @param pNamedQuery is a named query.
     * @param pBindParameters holds the variables to be bound.
     * @return the named query.
     */
    Query createNamedQuery(String pNamedQuery, Map<String, Object> pBindParameters);

    /**
     * Binds the value to the native query.
     * <p>
     * 
     * @param pNativeQuery is a native query.
     * @return the native query.
     */
    Query createNativeQuery(final String pNativeQuery) throws DaoException;

    /**
     * Binds the value to the native query.
     * <p>
     * 
     * @param pNativeQuery is a native query.
     * @param pBindParameters holds the variables to be bound.
     * @return the native query.
     */
    Query createNativeQuery(String pNativeQuery, Map<String, Object> pBindParameters);

    /**
     * Binds the value to the JPA query.
     * <p>
     * 
     * @param pJpaQuery is a JPA query.
     * @param pBindParameters holds the variables to be bound.
     * @return the query.
     */
    Query createQuery(String pJpaQuery, Map<String, Object> pBindParameters);

    /**
     * Deletes a particular record from the database.
     * <p>
     * 
     * @param <T> is a persistence object type variable.
     * @param pObject is a persistence object type variable.
     * @throws DaoException if the delete operation fails.
     */
    <T extends PersistenceObject> void delete(T pObject) throws DaoException;

    <T extends PersistenceObject> T findbyPK(T pObject) throws DaoException;

    /**
     * Finds the entity based on object identifier and object oid.
     * <p>
     * 
     * @param <T> is a object type variable.
     * @param pObject is a object type variable.
     * 
     * @param pOid is a long variable
     *            holds the OId.
     * @return a object type variable.
     * 
     * @throws DaoException if the find operation fails.
     */
    <T extends Object> T findChildbyPK(final T pObject, final long pOid)
                throws DaoException;

   
    <T extends PersistenceObject> T mergeManaged(final T pObject) throws DaoException;

    <T extends PersistenceObject> T update(T pObject) throws DaoException;

}
