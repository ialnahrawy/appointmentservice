package com.nahrawy.his.appointment.service.dto;

import java.time.Instant;
import javax.validation.constraints.*;

import com.nahrawy.his.appointment.domain.enumeration.AppointmentStatus;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
 
/**
 * A DTO for the Appointment entity.
 */
public class AppointmentDTO implements Serializable {

    private Long id;

    @NotNull
    private Long patientId;

    @NotNull
    private Long doctorId;

    @NotNull
    private Long locationId;

    private String remarks;

    private String reason;

    private Integer priority;

    private String description;

    private AppointmentStatus status;

    @NotNull
    private Instant createdOn;

    private Long slotId;

    private Long typeId;

    private String typeName;

    private Set<ReferenceDTO> references = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationID) {
        this.locationId = locationID;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Long getSlotId() {
        return slotId;
    }

    public void setSlotId(Long slotId) {
        this.slotId = slotId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long appointmentTypeId) {
        this.typeId = appointmentTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String appointmentTypeName) {
        this.typeName = appointmentTypeName;
    }

    public Set<ReferenceDTO> getReferences() {
        return references;
    }

    public void setReferences(Set<ReferenceDTO> references) {
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

        AppointmentDTO appointmentDTO = (AppointmentDTO) o;
        if (appointmentDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), appointmentDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AppointmentDTO{" +
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
            ", slot=" + getSlotId() +
            ", type=" + getTypeId() +
            ", type='" + getTypeName() + "'" +
            "}";
    }
}
