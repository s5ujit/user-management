
package com.appliedsni.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.Transient;
import javax.persistence.Version;

@MappedSuperclass
public abstract class PersistenceObject  {

    /**
     * Serial Id Version.
     */
    private static final long serialVersionUID = 266530328555815999L;

    /**
     * Attribute that has the last stored version of the entity when loaded from the database.
     */
    @Transient
    private long oldVersion;

    /**
     * Attribute to hold the <code>version</code> property.
     */
    @Version
    @Column(name = "XVERSION", columnDefinition = "NUMBER(10)", nullable = false)
    private long version;

    @Column(name = "XLASTUPDATE", columnDefinition = "date default sysdate",nullable = true)
    private Date lastUpdate;
    /**
     * Default constructor.
     */
    public PersistenceObject() {

    }

    /**
     * Gets the object identifier property.
     * <p>
     * The object identifier of the persistence object.
     * <p>
     * 
     * @return the current value of the object identifier property.
     */
    public abstract Long getId();

    /**
     * Accessor of the {@code oldVersion} attribute. See {@link #oldVersion} attribute for more details on the
     * purpose of it.
     * 
     * @return long value of the {@code oldVersion} attribute
     */
    public long getOldVersion() {

        return this.oldVersion;
    }

    /**
     * Gets the <code>version</code> property.
     * <p>
     * Version of the persistent object.
     * <p>
     * 
     * @return the current value of the <code>version</code> property.
     */
    public long getVersion() {
        return this.version;
    }

    /**
     * Entity Life Cycle back Listener {@code @PostLoad} mapped to the mutator of {@link #oldVersion}. This
     * will set the version of the entity when loaded from the database to the {@code oldVersion} attribute.
     */
    @PostLoad
    public void setOldVersion() {
        this.oldVersion = this.version;
    }

    /**
     * Sets the <code>version</code> property.
     * <p>
     * Version of the persistent object.
     * <p>
     * 
     * @param pVersion the new value of the <code>version</code> property.
     */
    public void setVersion(final long pVersion) {
        this.version = pVersion;
    }

	public Date getLastUpdate() {
		if(this.lastUpdate==null)
			this.lastUpdate=new Date();
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
