package br.com.dv.mvc.air.model;

import jakarta.validation.constraints.NotBlank;

public class OrderDTO {

    @NotBlank
    private String productName;
    private String description;
    @NotBlank
    private String productUrl;
    @NotBlank
    private String imageUrl;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Order toOrder() {
        Order order = new Order();
        order.setProductName(this.productName);
        order.setProductUrl(this.productUrl);
        order.setImageUrl(this.imageUrl);
        order.setDescription(this.description);
        return order;
    }

}
