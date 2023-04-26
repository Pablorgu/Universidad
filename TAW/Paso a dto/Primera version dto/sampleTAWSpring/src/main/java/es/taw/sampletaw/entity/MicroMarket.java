package es.taw.sampletaw.entity;


import es.taw.sampletaw.dto.DTO;
import es.taw.sampletaw.dto.MicroMarketDTO;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "MICRO_MARKET", schema = "SAMPLETAW", catalog = "")
public class MicroMarket implements DTO<MicroMarketDTO> {
    private String zipCode;
    private Double radius;
    private Double areaLength;
    private Double areaWidth;
    private List<Customer> customersByZipCode;
    private Administrador administradorByAdminId;

    @Id
    @Column(name = "ZIP_CODE", nullable = false, length = 10)
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "RADIUS", nullable = true, precision = 0)
    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Basic
    @Column(name = "AREA_LENGTH", nullable = true, precision = 0)
    public Double getAreaLength() {
        return areaLength;
    }

    public void setAreaLength(Double areaLength) {
        this.areaLength = areaLength;
    }

    @Basic
    @Column(name = "AREA_WIDTH", nullable = true, precision = 0)
    public Double getAreaWidth() {
        return areaWidth;
    }

    public void setAreaWidth(Double areaWidth) {
        this.areaWidth = areaWidth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MicroMarket that = (MicroMarket) o;
        return Objects.equals(zipCode, that.zipCode) && Objects.equals(radius, that.radius) && Objects.equals(areaLength, that.areaLength) && Objects.equals(areaWidth, that.areaWidth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zipCode, radius, areaLength, areaWidth);
    }

    @OneToMany(mappedBy = "microMarketByZip")
    public List<Customer> getCustomersByZipCode() {
        return customersByZipCode;
    }

    public void setCustomersByZipCode(List<Customer> customersByZipCode) {
        this.customersByZipCode = customersByZipCode;
    }

    @ManyToOne
    @JoinColumn(name = "ADMIN_ID", referencedColumnName = "ADMIN_ID")
    public Administrador getAdministradorByAdminId() {
        return administradorByAdminId;
    }

    public void setAdministradorByAdminId(Administrador administradorByAdminId) {
        this.administradorByAdminId = administradorByAdminId;
    }

    public MicroMarketDTO toDTO () {
        MicroMarketDTO dto = new MicroMarketDTO();
        dto.setZipCode(zipCode);
        dto.setRadius(radius);
        dto.setAreaLength(areaLength);
        dto.setAreaWidth(areaWidth);
        return dto;
    }

}
