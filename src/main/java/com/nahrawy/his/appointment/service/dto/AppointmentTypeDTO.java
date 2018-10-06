package com.nahrawy.his.appointment.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the AppointmentType entity.
 */
public class AppointmentTypeDTO implements Serializable {

    private Long id;

    private String name;

    private String code;

    private String description;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
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

        AppointmentTypeDTO appointmentTypeDTO = (AppointmentTypeDTO) o;
        if (appointmentTypeDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), appointmentTypeDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AppointmentTypeDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", code='" + getCode() + "'" +
            ", description='" + getDescription() + "'" +
            ", comment='" + getComment() + "'" +
            "}";
    }
}
