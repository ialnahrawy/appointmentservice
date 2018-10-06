package com.nahrawy.his.appointment.service.impl;

import com.nahrawy.his.appointment.domain.Appointment;
import com.nahrawy.his.appointment.repository.AppointmentRepository;
import com.nahrawy.his.appointment.service.AppointmentService;
import com.nahrawy.his.appointment.service.dto.AppointmentDTO;
import com.nahrawy.his.appointment.service.dto.AppointmentSearchFilter;
import com.nahrawy.his.appointment.service.dto.DoctorSearchFilter;
import com.nahrawy.his.appointment.service.mapper.AppointmentMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

import javax.validation.Valid;
/**
 * Service Implementation for managing Appointment.
 */
@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

    private final Logger log = LoggerFactory.getLogger(AppointmentServiceImpl.class);

    private final AppointmentRepository appointmentRepository;

    private final AppointmentMapper appointmentMapper;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
    }

   

    @Override
    public AppointmentDTO save(AppointmentDTO appointmentDTO) {
        log.debug("Request to save Appointment : {}", appointmentDTO);
        Appointment appointment = appointmentMapper.toEntity(appointmentDTO);
        appointment = appointmentRepository.save(appointment);
        return appointmentMapper.toDto(appointment);
    }



    @Override
    @Transactional(readOnly = true)
    public Page<AppointmentDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Appointments");
        return appointmentRepository.findAll(pageable)
            .map(appointmentMapper::toDto);
    }

    
 
    

	@Override
    @Transactional(readOnly = true)
	public Page<AppointmentDTO> searchAppointments(@Valid AppointmentSearchFilter searchFilter, Pageable pageable) {
        log.debug("Request to get all Appointments based on filter {}" , searchFilter );        
		return appointmentRepository.searchAppointments(searchFilter.getDoctorId(), searchFilter.getLocationId(),
				searchFilter.getPatientId(), searchFilter.getFromTime(), searchFilter.getToTime(),
				searchFilter.getStatus(), pageable).map(appointmentMapper::toDto);
	}

 
    @Override
    @Transactional(readOnly = true)
    public Optional<AppointmentDTO> findOne(Long id) {
        log.debug("Request to get Appointment : {}", id);
        return appointmentRepository.findOneWithEagerRelationships(id)
            .map(appointmentMapper::toDto);
    }

    
    @Override
    @Transactional(readOnly = true)
    public Optional<AppointmentDTO> findOneWithEagerRelationshipsForSlot(Long slotId) {
        log.debug("Request to get Appointment for slotId: {}", slotId);
        return appointmentRepository.findOneWithEagerRelationshipsForSlot(slotId)
            .map(appointmentMapper::toDto);
    }

  

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Appointment : {}", id);
        appointmentRepository.deleteById(id);
    }



}
