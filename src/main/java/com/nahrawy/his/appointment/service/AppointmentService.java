package com.nahrawy.his.appointment.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nahrawy.his.appointment.service.dto.AppointmentDTO;
import com.nahrawy.his.appointment.service.dto.AppointmentSearchFilter;
import com.nahrawy.his.appointment.service.dto.DoctorSearchFilter;

import java.util.Optional;

import javax.validation.Valid;

/**
 * Service Interface for managing Appointment.
 */
public interface AppointmentService {


    AppointmentDTO save(AppointmentDTO appointmentDTO);

    Page<AppointmentDTO> findAll(Pageable pageable);

     
    Optional<AppointmentDTO> findOne(Long id);

   
    void delete(Long id);

	Page<AppointmentDTO> searchAppointments(@Valid AppointmentSearchFilter searchFilter, Pageable pageable);

	Optional<AppointmentDTO> findOneWithEagerRelationshipsForSlot(Long slotId);
}
