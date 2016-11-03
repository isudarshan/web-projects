/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hms.domain;

import java.util.Date;

/**
 *
 * @author cmc
 */
public abstract class Domain {

    private Long id;
    private String guid;
    private String createdBy;
    private String modifiedBy;
    private Date createdOn;
    private Date modifiedOn;
    private Long active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Long getActive() {
        return active;
    }

    public void setActive(Long active) {
        this.active = active;
    }

   
    @Override
    public String toString() {
        return "Domain{" + "id=" + id + ", guid=" + guid + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", createdOn=" + createdOn + ", modifiedOn=" + modifiedOn + ", active=" + active + '}';
    }
    
}