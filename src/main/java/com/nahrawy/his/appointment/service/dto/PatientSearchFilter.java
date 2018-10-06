package com.nahrawy.his.appointment.service.dto;

 import javax.validation.constraints.*;
import java.io.Serializable;
  

public class PatientSearchFilter extends AppointmentSearchFilter implements Serializable {

	private static final long serialVersionUID = 1L;
	@NotNull
	private Long patientId;

}
