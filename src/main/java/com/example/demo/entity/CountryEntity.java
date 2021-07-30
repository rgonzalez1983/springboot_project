package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@SuppressWarnings("ALL")
@Entity
@Table(name = "country", schema = "public", catalog = "springboot_new_db", indexes = @Index(name = "country_name_idx", columnList = "name"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CountryEntity {
    private long idCountry;
    private String name;
    private Collection<CityEntity> citiesByIdCountry;

    @Id
    @Column(name = "id_country", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_country")
    @SequenceGenerator(name = "sequence_country", sequenceName = "country_id_country_seq", allocationSize = 1)
    @ApiModelProperty(hidden = true)
    public long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(long idCountry) {
        this.idCountry = idCountry;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryEntity that = (CountryEntity) o;
        return idCountry == that.idCountry &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCountry, name);
    }

    @OneToMany(mappedBy = "countryByCountry", fetch = FetchType.LAZY)
    @JsonIgnore
    public Collection<CityEntity> getCitiesByIdCountry() {
        return citiesByIdCountry;
    }

    public void setCitiesByIdCountry(Collection<CityEntity> citiesByIdCountry) {
        this.citiesByIdCountry = citiesByIdCountry;
    }

    @Override
    public String toString() {
        return "CountryEntity{" +
                "idCountry=" + idCountry +
                ", name='" + name + '\'' +
                '}';
    }
}
