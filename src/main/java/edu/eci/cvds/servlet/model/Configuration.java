package edu.eci.cvds.servlet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Table(name = "CONFIGURATION")
public class Configuration {

    @Id
    @Column(name = "PROPIEDAD")
    private String propiedad;
    @Column(name = "VALOR")
    private int valor;

    public Configuration(String propiedad, int valor) {
        this.propiedad = propiedad;
        this.valor = valor;
    }

    public Configuration() {
    }

    public String getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(String propiedad) {
        this.propiedad = propiedad;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "propiedad='" + propiedad + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Configuration that = (Configuration) o;
        return Objects.equals(propiedad, that.propiedad) && Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propiedad, valor);
    }
}
