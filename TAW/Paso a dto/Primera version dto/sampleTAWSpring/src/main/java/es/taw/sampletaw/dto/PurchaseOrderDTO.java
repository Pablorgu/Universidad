package es.taw.sampletaw.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;



public class PurchaseOrderDTO implements Serializable {
    private Integer orderNum;
    //private Short quantity;  // Este atributo de la entidad no lo usé en la JSP por lo que aquí no lo añado
    private BigDecimal shippingCost;
//    private Date salesDate; // Este atributo de la entidad no lo usé en la JSP por lo que aquí no lo añado
    private Date shippingDate;
    private String freightCompany;
    private CustomerDTO customer;
    private ProductDTO product;

    public Integer getOrderNum() {
        return orderNum;
    }

    public BigDecimal getShippingCost() {
        return shippingCost;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public String getFreightCompany() {
        return freightCompany;
    }


    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public void setFreightCompany(String freightCompany) {
        this.freightCompany = freightCompany;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }


    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseOrderDTO entity = (PurchaseOrderDTO) o;
        return Objects.equals(this.orderNum, entity.orderNum) &&
                Objects.equals(this.shippingCost, entity.shippingCost) &&
                Objects.equals(this.shippingDate, entity.shippingDate) &&
                Objects.equals(this.freightCompany, entity.freightCompany) &&
                Objects.equals(this.customer, entity.customer) &&
                Objects.equals(this.product, entity.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNum, shippingCost, shippingDate, freightCompany, customer, product);
    }


}