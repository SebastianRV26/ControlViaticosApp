/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.data.model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author pache
 */
public class Reason {
    @SerializedName("id")
    private Integer id;
    
    @SerializedName("descripcion")
    private String descripcion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        return "Client{"
                + "id=" + id
                + ", descripcion=" + descripcion
                + '}';
    }
}
