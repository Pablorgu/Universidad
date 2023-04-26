package es.taw.sampletaw.dto;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;


public class ProductDTO implements Serializable {

    private Integer productId;
    private BigDecimal purchaseCost;
    private Integer quantityOnHand;
    private BigDecimal markup;
    private String available;
    private String description;

    public Integer getProductId() {
        return productId;
    }

    public BigDecimal getPurchaseCost() {
        return purchaseCost;
    }

    public Integer getQuantityOnHand() {
        return quantityOnHand;
    }

    public BigDecimal getMarkup() {
        return markup;
    }

    public String getAvailable() {
        return available;
    }

    public String getDescription() {
        return description;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setPurchaseCost(BigDecimal purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    public void setQuantityOnHand(Integer quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    public void setMarkup(BigDecimal markup) {
        this.markup = markup;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO entity = (ProductDTO) o;
        return Objects.equals(this.productId, entity.productId) &&
                Objects.equals(this.purchaseCost, entity.purchaseCost) &&
                Objects.equals(this.quantityOnHand, entity.quantityOnHand) &&
                Objects.equals(this.markup, entity.markup) &&
                Objects.equals(this.available, entity.available) &&
                Objects.equals(this.description, entity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, purchaseCost, quantityOnHand, markup, available, description);
    }
}