package pojoObjectAPI;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateProduct {

    private String name;

    @JsonProperty("data") // Map the "data" field in JSON
    private UpdateProductData data;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UpdateProductData getData() {
        return data;
    }

    public void setData(UpdateProductData data) {
        this.data = data;
    }
}
