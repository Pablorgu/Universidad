package es.taw.sampletaw.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Manufacturer {
    private Integer manufacturerId;
    private String name;
    private String addressline1;
    private String addressline2;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String fax;
    private String email;
    private String rep;
    private List<Product> productsByManufacturerId;

    @Id
    @Column(name = "MANUFACTURER_ID", nullable = false)
    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
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
    @Column(name = "ZIP", nullable = true, length = 10)
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
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
    @Column(name = "REP", nullable = true, length = 30)
    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturer that = (Manufacturer) o;
        return Objects.equals(manufacturerId, that.manufacturerId) && Objects.equals(name, that.name) && Objects.equals(addressline1, that.addressline1) && Objects.equals(addressline2, that.addressline2) && Objects.equals(city, that.city) && Objects.equals(state, that.state) && Objects.equals(zip, that.zip) && Objects.equals(phone, that.phone) && Objects.equals(fax, that.fax) && Objects.equals(email, that.email) && Objects.equals(rep, that.rep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturerId, name, addressline1, addressline2, city, state, zip, phone, fax, email, rep);
    }

    @OneToMany(mappedBy = "manufacturerByManufacturerId")
    public List<Product> getProductsByManufacturerId() {
        return productsByManufacturerId;
    }

    public void setProductsByManufacturerId(List<Product> productsByManufacturerId) {
        this.productsByManufacturerId = productsByManufacturerId;
    }
}
