package com.nahrawy.his.appointment.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nahrawy.his.appointment.domain.enumeration.AppointmentStatus;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Appointment.
 */
@Entity
@Table(name = "appointment")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "patient_id", nullable = false)
    private Long patientId;

    @NotNull
    @Column(name = "doctor_id", nullable = false)
    private Long doctorId;

    @NotNull
    @Column(name = "location_id", nullable = false)
    private Long locationId;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "reason")
    private String reason;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AppointmentStatus status;

    @NotNull
    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    //@OneToOne(cascade = CascadeType.ALL)
    @OneToOne
    @JoinColumn(unique = true)
    private Slot slot;

    @ManyToOne
    @JsonIgnoreProperties("")
    private AppointmentType type;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "appointment_reference",
               joinColumns = @JoinColumn(name = "appointments_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "references_id", referencedColumnName = "id"))
    private Set<Reference> references = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public Appointment patientId(Long patientId) {
        this.patientId = patientId;
        return this;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public Appointment doctorId(Long doctorId) {
        this.doctorId = doctorId;
        return this;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public Appointment locationID(Long locationID) {
        this.locationId = locationID;
        return this;
    }

    public void setLocationId(Long locationID) {
        this.locationId = locationID;
    }

    public String getRemarks() {
        return remarks;
    }

    public Appointment remarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getReason() {
        return reason;
    }

    public Appointment reason(String reason) {
        this.reason = reason;
        return this;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getPriority() {
        return priority;
    }

    public Appointment priority(Integer priority) {
        this.priority = priority;
        return this;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public Appointment description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public Appointment status(AppointmentStatus status) {
        this.status = status;
        return this;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public Appointment createdOn(Instant createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Slot getSlot() {
        return slot;
    }

    public Appointment slot(Slot slot) {
        this.slot = slot;
        return this;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public AppointmentType getType() {
        return type;
    }

    public Appointment type(AppointmentType appointmentType) {
        this.type = appointmentType;
        return this;
    }

    public void setType(AppointmentType appointmentType) {
        this.type = appointmentType;
    }

    public Set<Reference> getReferences() {
        return references;
    }

    public Appointment references(Set<Reference> references) {
        this.references = references;
        return this;
    }

    public Appointment addReference(Reference reference) {
        this.references.add(reference);
        reference.getAppointments().add(this);
        return this;
    }

    public Appointment removeReference(Reference reference) {
        this.references.remove(reference);
        reference.getAppointments().remove(this);
        return this;
    }

    public void setReferences(Set<Reference> references) {
        this.references = references;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Appointment appointment = (Appointment) o;
        if (appointment.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), appointment.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Appointment{" +
            "id=" + getId() +
            ", patientId=" + getPatientId() +
            ", doctorId=" + getDoctorId() +
            ", locationID=" + getLocationId() +
            ", remarks='" + getRemarks() + "'" +
            ", reason='" + getReason() + "'" +
            ", priority=" + getPriority() +
            ", description='" + getDescription() + "'" +
            ", status='" + getStatus() + "'" +
            ", createdOn='" + getCreatedOn() + "'" +
            "}";
    }
}
