package es.taw.sampletaw.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer {
    private Integer customerId;
    private String name;
    private String addressline1;
    private String addressline2;
    private String city;
    private String state;
    private String phone;
    private String fax;
    private String email;
    private Integer creditLimit;
    private DiscountCode discountCodeByDiscountCode;
    private MicroMarket microMarketByZip;
    private List<PurchaseOrder> purchaseOrdersByCustomerId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID", nullable = false)
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "NAME", nullable = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "ADDRESSLINE1", nullable = true, length = 30)
    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    @Basic
    @Column(name = "ADDRESSLINE2", nullable = true, length = 30)
    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    @Basic
    @Column(name = "CITY", nullable = true, length = 25)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "STATE", nullable = true, length = 2)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "PHONE", nullable = true, length = 12)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "FAX", nullable = true, length = 12)
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Basic
    @Column(name = "EMAIL", nullable = true, length = 40)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "CREDIT_LIMIT", nullable = true)
    public Integer getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId) && Objects.equals(name, customer.name) && Objects.equals(addressline1, customer.addressline1) && Objects.equals(addressline2, customer.addressline2) && Objects.equals(city, customer.city) && Objects.equals(state, customer.state) && Objects.equals(phone, customer.phone) && Objects.equals(fax, customer.fax) && Objects.equals(email, customer.email) && Objects.equals(creditLimit, customer.creditLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, name, addressline1, addressline2, city, state, phone, fax, email, creditLimit);
    }

    @ManyToOne
    @JoinColumn(name = "DISCOUNT_CODE", referencedColumnName = "DISCOUNT_CODE", nullable = false)
    public DiscountCode getDiscountCodeByDiscountCode() {
        return discountCodeByDiscountCode;
    }

    public void setDiscountCodeByDiscountCode(DiscountCode discountCodeByDiscountCode) {
        this.discountCodeByDiscountCode = discountCodeByDiscountCode;
    }

    @ManyToOne
    @JoinColumn(name = "ZIP", referencedColumnName = "ZIP_CODE", nullable = false)
    public MicroMarket getMicroMarketByZip() {
        return microMarketByZip;
    }

    public void setMicroMarketByZip(MicroMarket microMarketByZip) {
        this.microMarketByZip = microMarketByZip;
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public List<PurchaseOrder> getPurchaseOrdersByCustomerId() {
        return purchaseOrdersByCustomerId;
    }

    public void setPurchaseOrdersByCustomerId(List<PurchaseOrder> purchaseOrdersByCustomerId) {
        this.purchaseOrdersByCustomerId = purchaseOrdersByCustomerId;
    }
}
