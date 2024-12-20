package payloadBuilder;

import pojoObjectAPI.AddProductData;
import pojoObjectAPI.AddProduct;

public class AddProductPayload {

    public static AddProduct addProductPayload(String name, Integer year, Double price, String model, String disk){

        // Create ProductData
        AddProductData productData = new AddProductData();
        productData.setYear(year);
        productData.setPrice(price);
        productData.setCpuModel(model);
        productData.setHardDiskSize(disk);

        // Create Product
        AddProduct product = new AddProduct();
        product.setName(name);
        product.setData(productData);
        return product;

    }

}
