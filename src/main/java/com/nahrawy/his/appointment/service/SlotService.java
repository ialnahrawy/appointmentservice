package com.nahrawy.his.appointment.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import com.nahrawy.his.appointment.domain.enumeration.SlotStatus;
import com.nahrawy.his.appointment.service.dto.SlotDTO;

/**
 * Service Interface for managing Slot.
 */
public interface SlotService {



    SlotDTO save(SlotDTO slotDTO);

  
    List<SlotDTO> findAllWhereAppointmentIsNull();
    
    Optional<SlotDTO> findOne(Long id);

    void delete(Long id);
    
    /**
     * Get all the SlotDTO for specific doctor in time frame 
     *
     * @return the list of slots
     * 
     */
    
	List<SlotDTO> findAllForDoctor(Long doctorId, Instant fromDate , Instant toDate);

    List<SlotDTO>  findForDoctor(Long doctorId, Instant fromDate , Instant toDate, SlotStatus status);
    
    List<SlotDTO>  findForDoctorWhereStatusNot(Long doctorId, Instant from , Instant toDate, SlotStatus status);

	List<SlotDTO> findAllForDoctorAfterDate(Long doctorId, Instant fromDate);

	List<SlotDTO> findForDoctorAfterDateWhereStatus(Long doctorId, Instant fromDate, SlotStatus status);

	List<SlotDTO> findForDoctorAfterDateWhereStatusNot(Long doctorId, Instant fromDate, SlotStatus status);

  
}
