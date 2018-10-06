package com.nahrawy.his.appointment.service.mapper;

import com.nahrawy.his.appointment.domain.*;
import com.nahrawy.his.appointment.service.dto.AppointmentTypeDTO;

import org.mapstruct.*;

 
@Mapper(componentModel = "spring", uses = {})
public interface AppointmentTypeMapper extends EntityMapper<AppointmentTypeDTO, AppointmentType> {



    default AppointmentType fromId(Long id) {
        if (id == null) {
            return null;
        }
        AppointmentType appointmentType = new AppointmentType();
        appointmentType.setId(id);
        return appointmentType;
    }
}
