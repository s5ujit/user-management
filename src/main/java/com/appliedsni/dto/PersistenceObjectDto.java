
package com.appliedsni.dto;


public abstract class PersistenceObjectDto  {

    private static final long serialVersionUID = 266530328555815999L;
    private long version;
    public PersistenceObjectDto() {

    }
    public abstract Long getId();
    public long getVersion() {
        return this.version;
    }
    public void setVersion(final long pVersion) {
        this.version = pVersion;
    }
}
