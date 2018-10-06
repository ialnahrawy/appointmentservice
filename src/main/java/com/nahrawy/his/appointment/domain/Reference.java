package com.nahrawy.his.appointment.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nahrawy.his.appointment.domain.enumeration.ReferenceType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Reference.
 */
@Entity
@Table(name = "reference")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Reference implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "summary", nullable = false)
    private String summary;

    @Column(name = "reference_url")
    private String referenceUrl;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "ref_type", nullable = false)
    private ReferenceType type;

    @ManyToMany(mappedBy = "references")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Appointment> appointments = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public Reference summary(String summary) {
        this.summary = summary;
        return this;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getReferenceUrl() {
        return referenceUrl;
    }

    public Reference referenceUrl(String referenceUrl) {
        this.referenceUrl = referenceUrl;
        return this;
    }

    public void setReferenceUrl(String referenceUrl) {
        this.referenceUrl = referenceUrl;
    }

    public String getDescription() {
        return description;
    }

    public Reference description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ReferenceType getType() {
        return type;
    }

    public Reference type(ReferenceType type) {
        this.type = type;
        return this;
    }

    public void setType(ReferenceType type) {
        this.type = type;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public Reference appointments(Set<Appointment> appointments) {
        this.appointments = appointments;
        return this;
    }

    public Reference addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
        appointment.getReferences().add(this);
        return this;
    }

    public Reference removeAppointment(Appointment appointment) {
        this.appointments.remove(appointment);
        appointment.getReferences().remove(this);
        return this;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Reference reference = (Reference) o;
        if (reference.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), reference.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Reference{" +
            "id=" + getId() +
            ", summary='" + getSummary() + "'" +
            ", referenceUrl='" + getReferenceUrl() + "'" +
            ", description='" + getDescription() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }
}
