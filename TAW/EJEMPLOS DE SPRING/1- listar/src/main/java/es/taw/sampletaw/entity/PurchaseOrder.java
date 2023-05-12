package es.taw.sampletaw.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "PURCHASE_ORDER", schema = "SAMPLETAW", catalog = "")
public class PurchaseOrder {
    private Integer orderNum;
    private Short quantity;
    private BigDecimal shippingCost;
    private Date salesDate;
    private Date shippingDate;
    private String freightCompany;
    private Customer customerByCustomerId;
    private Product productByProductId;

    @Id
    @Column(name = "ORDER_NUM", nullable = false)
    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Basic
    @Column(name = "QUANTITY", nullable = true)
    public Short getQuantity() {
        return quantity;
    }

    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "SHIPPING_COST", nullable = true, precision = 2)
    public BigDecimal getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }

    @Basic
    @Column(name = "SALES_DATE", nullable = true)
    public Date getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(Date salesDate) {
        this.salesDate = salesDate;
    }

    @Basic
    @Column(name = "SHIPPING_DATE", nullable = true)
    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    @Basic
    @Column(name = "FREIGHT_COMPANY", nullable = true, length = 30)
    public String getFreightCompany() {
        return freightCompany;
    }

    public void setFreightCompany(String freightCompany) {
        this.freightCompany = freightCompany;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseOrder that = (PurchaseOrder) o;
        return Objects.equals(orderNum, that.orderNum) && Objects.equals(quantity, that.quantity) && Objects.equals(shippingCost, that.shippingCost) && Objects.equals(salesDate, that.salesDate) && Objects.equals(shippingDate, that.shippingDate) && Objects.equals(freightCompany, that.freightCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNum, quantity, shippingCost, salesDate, shippingDate, freightCompany);
    }

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID", nullable = false)
    public Customer getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID", nullable = false)
    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }
}
