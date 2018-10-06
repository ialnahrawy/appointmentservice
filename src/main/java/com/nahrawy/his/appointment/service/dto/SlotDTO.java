package com.nahrawy.his.appointment.service.dto;

import java.time.Instant;
import javax.validation.constraints.*;

import com.nahrawy.his.appointment.domain.enumeration.SlotStatus;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Slot entity.
 */
public class SlotDTO implements Serializable {

    private Long id;

    @NotNull
    private Instant startTime;

    @NotNull
    private Instant endTime;

    private SlotStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public SlotStatus getStatus() {
        return status;
    }

    public void setStatus(SlotStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SlotDTO slotDTO = (SlotDTO) o;
        if (slotDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), slotDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "SlotDTO{" +
            "id=" + getId() +
            ", startTime='" + getStartTime() + "'" +
            ", endTime='" + getEndTime() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
