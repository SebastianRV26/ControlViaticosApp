package app.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * This data class represents a cost from the database.
 */
public class Cost {

    @SerializedName("id")
    private Integer id;

    @SerializedName("descripcion")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Cost{"
                + "id=" + id + ", "
                + "description=" + description + '}';
    }
}
