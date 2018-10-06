package com.nahrawy.his.appointment.service.dto;

import java.time.Instant;

import com.nahrawy.his.appointment.domain.enumeration.SlotStatus;

import java.io.Serializable;


public class AppointmentSearchFilter implements Serializable {

 
	private static final long serialVersionUID = -1329093040648499047L;
	private Long doctorId;
	private Long locationId;
	private Long patientId;

	private Instant fromTime;

	private Instant toTime;

	private SlotStatus status;

	public Long getDoctorId() {
		return doctorId;
	}

    public void setDoctorId(Long id) {
        this.doctorId = id;
    }

    public Instant getFromTime() {
        return fromTime;
    }

    public void setFromTime(Instant startTime) {
        this.fromTime = startTime;
    }

    public Instant getToTime() {
        return toTime;
    }

    public void setToTime(Instant endTime) {
        this.toTime = endTime;
    }

    public SlotStatus getStatus() {
        return status;
    }

    public void setStatus(SlotStatus status) {
        this.status = status;
    }
    

    
    public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	@Override
	public String toString() {
		
		return "AppointmentSearchFilter [doctorId=" + doctorId + ", locationId=" + locationId + ", patientId="
				+ patientId + ", fromTime=" + fromTime + ", toTime=" + toTime + ", status=" + status + "]";
	}

	

    

     

    
}
