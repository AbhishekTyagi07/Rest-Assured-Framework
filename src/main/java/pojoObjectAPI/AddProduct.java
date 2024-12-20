package pojoObjectAPI;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddProduct {

    private String name;

    @JsonProperty("data") // Map the "data" field in JSON
    private AddProductData data;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddProductData getData() {
        return data;
    }

    public void setData(AddProductData data) {
        this.data = data;
    }
}
