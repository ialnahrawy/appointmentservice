package com.nahrawy.his.appointment.service.mapper;

import com.nahrawy.his.appointment.domain.*;
import com.nahrawy.his.appointment.service.dto.ReferenceDTO;

import org.mapstruct.*;
 
@Mapper(componentModel = "spring", uses = {})
public interface ReferenceMapper extends EntityMapper<ReferenceDTO, Reference> {


    @Mapping(target = "appointments", ignore = true)
    Reference toEntity(ReferenceDTO referenceDTO);

    default Reference fromId(Long id) {
        if (id == null) {
            return null;
        }
        Reference reference = new Reference();
        reference.setId(id);
        return reference;
    }
}
