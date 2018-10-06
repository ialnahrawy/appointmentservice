package com.nahrawy.his.appointment.service.dto;

import javax.validation.constraints.*;

import com.nahrawy.his.appointment.domain.enumeration.ReferenceType;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Reference entity.
 */
public class ReferenceDTO implements Serializable {

    private Long id;

    @NotNull
    private String summary;

    private String referenceUrl;

    @NotNull
    private String description;

    @NotNull
    private ReferenceType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getReferenceUrl() {
        return referenceUrl;
    }

    public void setReferenceUrl(String referenceUrl) {
        this.referenceUrl = referenceUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ReferenceType getType() {
        return type;
    }

    public void setType(ReferenceType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ReferenceDTO referenceDTO = (ReferenceDTO) o;
        if (referenceDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), referenceDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ReferenceDTO{" +
            "id=" + getId() +
            ", summary='" + getSummary() + "'" +
            ", referenceUrl='" + getReferenceUrl() + "'" +
            ", description='" + getDescription() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }
}
