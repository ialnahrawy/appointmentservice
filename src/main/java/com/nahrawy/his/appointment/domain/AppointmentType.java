package com.nahrawy.his.appointment.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A AppointmentType.
 */
@Entity
@Table(name = "appointment_type")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AppointmentType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "comment")
    private String comment;

     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public AppointmentType name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public AppointmentType code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public AppointmentType description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public AppointmentType comment(String comment) {
        this.comment = comment;
        return this;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppointmentType appointmentType = (AppointmentType) o;
        if (appointmentType.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), appointmentType.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AppointmentType{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", code='" + getCode() + "'" +
            ", description='" + getDescription() + "'" +
            ", comment='" + getComment() + "'" +
            "}";
    }
}
