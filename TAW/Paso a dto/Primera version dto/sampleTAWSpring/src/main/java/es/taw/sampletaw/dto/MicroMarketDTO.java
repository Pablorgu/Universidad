package es.taw.sampletaw.dto;


import java.io.Serializable;
import java.util.Objects;


public class MicroMarketDTO implements Serializable{
    private String zipCode;
    private Double radius;
    private Double areaLength;
    private Double areaWidth;


    public String getZipCode() {
        return zipCode;
    }

    public Double getRadius() {
        return radius;
    }

    public Double getAreaLength() {
        return areaLength;
    }

    public Double getAreaWidth() {
        return areaWidth;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public void setAreaLength(Double areaLength) {
        this.areaLength = areaLength;
    }

    public void setAreaWidth(Double areaWidth) {
        this.areaWidth = areaWidth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MicroMarketDTO entity = (MicroMarketDTO) o;
        return Objects.equals(this.zipCode, entity.zipCode) &&
                Objects.equals(this.radius, entity.radius) &&
                Objects.equals(this.areaLength, entity.areaLength) &&
                Objects.equals(this.areaWidth, entity.areaWidth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zipCode, radius, areaLength, areaWidth);
    }

}