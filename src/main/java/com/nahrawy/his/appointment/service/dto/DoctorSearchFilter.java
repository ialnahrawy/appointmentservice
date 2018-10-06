package com.nahrawy.his.appointment.service.dto;

import java.time.Instant;
import javax.validation.constraints.*;

import com.nahrawy.his.appointment.domain.enumeration.SlotStatus;

import java.io.Serializable;
import java.util.Objects;


public class DoctorSearchFilter extends AppointmentSearchFilter {

	@NotNull
	private Long doctorId;
	
    
}
