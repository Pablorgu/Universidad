package es.taw.sampletaw.dto;


import java.io.Serializable;
import java.util.Objects;


public class AdministradorDTO implements Serializable {

    private Integer adminId;
    private String email;
    private String password;

    public Integer getAdminId() {
        return adminId;
    }

    public AdministradorDTO setAdminId(Integer adminId) {
        this.adminId = adminId;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public AdministradorDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AdministradorDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdministradorDTO entity = (AdministradorDTO) o;
        return Objects.equals(this.adminId, entity.adminId) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.password, entity.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, email, password);
    }

}