package payloadBuilder;

import pojoObjectAPI.UpdateProduct;
import pojoObjectAPI.UpdateProductData;

public class UpdateProductPayload {

    public static UpdateProduct updateProductPayload(String name, Integer year, Double price, String model, String disk, String color){

        // Create ProductData
        UpdateProductData productData = new UpdateProductData();
        productData.setYear(year);
        productData.setPrice(price);
        productData.setCpuModel(model);
        productData.setHardDiskSize(disk);
        productData.setColor(color);

        // Create Product
        UpdateProduct product = new UpdateProduct();
        product.setName(name);
        product.setData(productData);
        return product;

    }
}
