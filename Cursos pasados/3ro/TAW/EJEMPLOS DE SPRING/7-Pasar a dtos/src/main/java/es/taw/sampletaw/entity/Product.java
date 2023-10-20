package es.taw.sampletaw.entity;


import es.taw.sampletaw.dto.DTO;
import es.taw.sampletaw.dto.ProductDTO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
public class Product implements DTO<ProductDTO> {
    private Integer productId;
    private BigDecimal purchaseCost;
    private Integer quantityOnHand;
    private BigDecimal markup;
    private String available;
    private String description;
    private Manufacturer manufacturerByManufacturerId;
    private ProductCode productCodeByProductCode;
    private List<PurchaseOrder> purchaseOrdersByProductId;

    @Id
    @Column(name = "PRODUCT_ID", nullable = false)
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "PURCHASE_COST", nullable = true, precision = 2)
    public BigDecimal getPurchaseCost() {
        return purchaseCost;
    }

    public void setPurchaseCost(BigDecimal purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    @Basic
    @Column(name = "QUANTITY_ON_HAND", nullable = true)
    public Integer getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(Integer quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    @Basic
    @Column(name = "MARKUP", nullable = true, precision = 2)
    public BigDecimal getMarkup() {
        return markup;
    }

    public void setMarkup(BigDecimal markup) {
        this.markup = markup;
    }

    @Basic
    @Column(name = "AVAILABLE", nullable = true, length = 5)
    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 50)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId) && Objects.equals(purchaseCost, product.purchaseCost) && Objects.equals(quantityOnHand, product.quantityOnHand) && Objects.equals(markup, product.markup) && Objects.equals(available, product.available) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, purchaseCost, quantityOnHand, markup, available, description);
    }

    @ManyToOne
    @JoinColumn(name = "MANUFACTURER_ID", referencedColumnName = "MANUFACTURER_ID", nullable = false)
    public Manufacturer getManufacturerByManufacturerId() {
        return manufacturerByManufacturerId;
    }

    public void setManufacturerByManufacturerId(Manufacturer manufacturerByManufacturerId) {
        this.manufacturerByManufacturerId = manufacturerByManufacturerId;
    }

    @ManyToOne
    @JoinColumn(name = "PRODUCT_CODE", referencedColumnName = "PROD_CODE", nullable = false)
    public ProductCode getProductCodeByProductCode() {
        return productCodeByProductCode;
    }

    public void setProductCodeByProductCode(ProductCode productCodeByProductCode) {
        this.productCodeByProductCode = productCodeByProductCode;
    }

    @OneToMany(mappedBy = "productByProductId")
    public List<PurchaseOrder> getPurchaseOrdersByProductId() {
        return purchaseOrdersByProductId;
    }

    public void setPurchaseOrdersByProductId(List<PurchaseOrder> purchaseOrdersByProductId) {
        this.purchaseOrdersByProductId = purchaseOrdersByProductId;
    }

    public ProductDTO toDTO () {
        ProductDTO dto = new ProductDTO();

        dto.setProductId(productId);
        dto.setPurchaseCost(purchaseCost);
        dto.setQuantityOnHand(quantityOnHand);
        dto.setMarkup(markup);
        dto.setAvailable(available);
        dto.setDescription(description);

        return dto;
    }


}
