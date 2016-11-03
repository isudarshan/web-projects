/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bankapp.domain;

/**
 *
 * @author Sudarsan
 */
public class Dummy {
    
    private Long id;
    private String name;
    private byte[] pic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "Dummy{" + "id=" + id + ", name=" + name + ", pic=" + pic + '}';
    }
    
    
}
