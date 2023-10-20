package es.taw.sampletaw.entity;

import es.taw.sampletaw.dto.CustomerDTO;
import es.taw.sampletaw.dto.DTO;
import es.taw.sampletaw.dto.DiscountCodeDTO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "DISCOUNT_CODE", schema = "SAMPLETAW", catalog = "")
public class DiscountCode  implements DTO<DiscountCodeDTO> {
    private String discountCode;
    private BigDecimal rate;

    @Id
    @Column(name = "DISCOUNT_CODE", nullable = false, length = 1)
    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    @Basic
    @Column(name = "RATE", nullable = true, precision = 2)
    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountCode that = (DiscountCode) o;
        return Objects.equals(discountCode, that.discountCode) && Objects.equals(rate, that.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountCode, rate);
    }

    public DiscountCodeDTO toDTO () {
        DiscountCodeDTO dto = new DiscountCodeDTO();
        dto.setDiscountCode(this.discountCode);
        dto.setRate(this.rate);
        return dto;
    }


}
