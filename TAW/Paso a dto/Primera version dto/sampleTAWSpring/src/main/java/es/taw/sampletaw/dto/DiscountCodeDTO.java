package es.taw.sampletaw.dto;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;


public class DiscountCodeDTO implements Serializable{

    protected String discountCode;
    protected BigDecimal rate;

    public String getDiscountCode() {
        return discountCode;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountCodeDTO entity = (DiscountCodeDTO) o;
        return Objects.equals(this.discountCode, entity.discountCode) &&
                Objects.equals(this.rate, entity.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountCode, rate);
    }

}