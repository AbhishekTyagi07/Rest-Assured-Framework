package pojoObjectAPI;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateProductData {

    private int year;
    private double price;

    @JsonProperty("CPU model") // Map the "CPU model" field in JSON
    private String cpuModel;

    @JsonProperty("Hard disk size") // Map the "Hard disk size" field in JSON
    private String hardDiskSize;

    private String color;

    // Getters and Setters
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCpuModel() {
        return cpuModel;
    }

    public void setCpuModel(String cpuModel) {
        this.cpuModel = cpuModel;
    }

    public String getHardDiskSize() {
        return hardDiskSize;
    }

    public void setHardDiskSize(String hardDiskSize) {
        this.hardDiskSize = hardDiskSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
