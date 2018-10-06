package com.nahrawy.his.appointment.service.impl;

import com.nahrawy.his.appointment.domain.AppointmentType;
import com.nahrawy.his.appointment.repository.AppointmentTypeRepository;
import com.nahrawy.his.appointment.service.AppointmentTypeService;
import com.nahrawy.his.appointment.service.dto.AppointmentTypeDTO;
import com.nahrawy.his.appointment.service.mapper.AppointmentTypeMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Service Implementation for managing AppointmentType.
 */
@Service
@Transactional
public class AppointmentTypeServiceImpl implements AppointmentTypeService {

    private final Logger log = LoggerFactory.getLogger(AppointmentTypeServiceImpl.class);

    private final AppointmentTypeRepository appointmentTypeRepository;

    private final AppointmentTypeMapper appointmentTypeMapper;

    public AppointmentTypeServiceImpl(AppointmentTypeRepository appointmentTypeRepository, AppointmentTypeMapper appointmentTypeMapper) {
        this.appointmentTypeRepository = appointmentTypeRepository;
        this.appointmentTypeMapper = appointmentTypeMapper;
    }



    @Override
    public AppointmentTypeDTO save(AppointmentTypeDTO appointmentTypeDTO) {
        log.debug("Request to save AppointmentType : {}", appointmentTypeDTO);
        AppointmentType appointmentType = appointmentTypeMapper.toEntity(appointmentTypeDTO);
        appointmentType = appointmentTypeRepository.save(appointmentType);
        return appointmentTypeMapper.toDto(appointmentType);
    }

  

    @Override
    @Transactional(readOnly = true)
    public List<AppointmentTypeDTO> findAll() {
        log.debug("Request to get all AppointmentTypes");
        return appointmentTypeRepository.findAll().stream()
            .map(appointmentTypeMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


  

    @Override
    @Transactional(readOnly = true)
    public Optional<AppointmentTypeDTO> findOne(Long id) {
        log.debug("Request to get AppointmentType : {}", id);
        return appointmentTypeRepository.findById(id)
            .map(appointmentTypeMapper::toDto);
    }



    @Override
    public void delete(Long id) {
        log.debug("Request to delete AppointmentType : {}", id);
        appointmentTypeRepository.deleteById(id);
    }
}
