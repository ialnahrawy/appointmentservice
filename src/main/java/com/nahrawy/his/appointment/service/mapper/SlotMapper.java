package com.nahrawy.his.appointment.service.mapper;

import com.nahrawy.his.appointment.domain.*;
import com.nahrawy.his.appointment.service.dto.SlotDTO;

import org.mapstruct.*;
 
@Mapper(componentModel = "spring", uses = {})
public interface SlotMapper extends EntityMapper<SlotDTO, Slot> {


    @Mapping(target = "appointment", ignore = true)
    Slot toEntity(SlotDTO slotDTO);

    default Slot fromId(Long id) {
        if (id == null) {
            return null;
        }
        Slot slot = new Slot();
        slot.setId(id);
        return slot;
    }
}
