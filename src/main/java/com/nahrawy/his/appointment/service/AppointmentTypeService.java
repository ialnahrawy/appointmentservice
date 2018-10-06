package com.nahrawy.his.appointment.service;

import java.util.List;
import java.util.Optional;

import com.nahrawy.his.appointment.service.dto.AppointmentTypeDTO;

public interface AppointmentTypeService {

    AppointmentTypeDTO save(AppointmentTypeDTO appointmentTypeDTO);

    List<AppointmentTypeDTO> findAll();
  
    Optional<AppointmentTypeDTO> findOne(Long id);

    void delete(Long id);
}
