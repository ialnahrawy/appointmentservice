package com.nahrawy.his.appointment.service.mapper;

import com.nahrawy.his.appointment.domain.*;
import com.nahrawy.his.appointment.service.dto.AppointmentDTO;

import org.mapstruct.*;

 
@Mapper(componentModel = "spring", uses = {SlotMapper.class, AppointmentTypeMapper.class, ReferenceMapper.class})
public interface AppointmentMapper extends EntityMapper<AppointmentDTO, Appointment> {

    @Mapping(source = "slot.id", target = "slotId")
    @Mapping(source = "type.id", target = "typeId")
    @Mapping(source = "type.name", target = "typeName")
    AppointmentDTO toDto(Appointment appointment);

    @Mapping(source = "slotId", target = "slot")
    @Mapping(source = "typeId", target = "type")
    Appointment toEntity(AppointmentDTO appointmentDTO);

    default Appointment fromId(Long id) {
        if (id == null) {
            return null;
        }
        Appointment appointment = new Appointment();
        appointment.setId(id);
        return appointment;
    }
}
