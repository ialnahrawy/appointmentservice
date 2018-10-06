package com.nahrawy.his.appointment.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nahrawy.his.appointment.domain.enumeration.SlotStatus;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A Slot.
 */
@Entity
@Table(name = "slot")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Slot implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "start_time", nullable = false)
    private Instant startTime;

    @NotNull
    @Column(name = "end_time", nullable = false)
    private Instant endTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private SlotStatus status;

    @OneToOne(mappedBy = "slot")
    @JsonIgnore
    private Appointment appointment;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public Slot startTime(Instant startTime) {
        this.startTime = startTime;
        return this;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public Slot endTime(Instant endTime) {
        this.endTime = endTime;
        return this;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public SlotStatus getStatus() {
        return status;
    }

    public Slot status(SlotStatus status) {
        this.status = status;
        return this;
    }

    public void setStatus(SlotStatus status) {
        this.status = status;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public Slot appointment(Appointment appointment) {
        this.appointment = appointment;
        return this;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Slot slot = (Slot) o;
        if (slot.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), slot.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Slot{" +
            "id=" + getId() +
            ", startTime='" + getStartTime() + "'" +
            ", endTime='" + getEndTime() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
