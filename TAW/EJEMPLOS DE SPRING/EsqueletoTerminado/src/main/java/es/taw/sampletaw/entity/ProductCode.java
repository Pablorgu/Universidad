package es.taw.sampletaw.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT_CODE", schema = "SAMPLETAW", catalog = "")
public class ProductCode {
    private String prodCode;
    private String discountCode;
    private String description;

    @Id
    @Column(name = "PROD_CODE", nullable = false, length = 2)
    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    @Basic
    @Column(name = "DISCOUNT_CODE", nullable = false, length = 1)
    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 10)
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
        ProductCode that = (ProductCode) o;
        return Objects.equals(prodCode, that.prodCode) && Objects.equals(discountCode, that.discountCode) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodCode, discountCode, description);
    }
}
