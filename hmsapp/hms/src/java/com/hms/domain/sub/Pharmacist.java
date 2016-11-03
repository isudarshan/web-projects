/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hms.domain.sub;

/**
 *
 * @author cmc
 */
public class Pharmacist {

    private Long id;
    private String pharmacistName;
    private byte[] photograph;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPharmacistName() {
        return pharmacistName;
    }

    public void setPharmacistName(String pharmacistName) {
        this.pharmacistName = pharmacistName;
    }

    public byte[] getPhotograph() {
        return photograph;
    }

    public void setPhotograph(byte[] photograph) {
        this.photograph = photograph;
    }

    

}
