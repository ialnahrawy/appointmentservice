package com.nahrawy.his.appointment.service.impl;

import com.nahrawy.his.appointment.domain.Slot;
import com.nahrawy.his.appointment.domain.enumeration.SlotStatus;
import com.nahrawy.his.appointment.repository.SlotRepository;
import com.nahrawy.his.appointment.service.SlotService;
import com.nahrawy.his.appointment.service.dto.SlotDTO;
import com.nahrawy.his.appointment.service.mapper.SlotMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
/**
 * Service Implementation for managing Slot.
 * @author Islam Alnahrawy
 */

@Service
@Transactional
public class SlotServiceImpl implements SlotService {

    private final Logger log = LoggerFactory.getLogger(SlotServiceImpl.class);

    private final SlotRepository slotRepository;

    private final SlotMapper slotMapper;

    public SlotServiceImpl(SlotRepository slotRepository, SlotMapper slotMapper) {
        this.slotRepository = slotRepository;
        this.slotMapper = slotMapper;
    }

 

    @Override
    public SlotDTO save(SlotDTO slotDTO) {
        log.debug("Request to save Slot : {}", slotDTO);
        Slot slot = slotMapper.toEntity(slotDTO);
        slot = slotRepository.save(slot);
        return slotMapper.toDto(slot);
    }

    
    @Override
	public List<SlotDTO> findAllForDoctor(Long doctorId, Instant fromDate, Instant toDate) {
		if (toDate == null) {
			return findAllForDoctorAfterDate(doctorId, fromDate);
		}
		
		log.debug("Request to get all slots for a Doctor: {} from: {}  to: {} ", doctorId, fromDate, toDate);
		return slotRepository
				.findByAppointmentDoctorIdAndStartTimeBetweenOrderByStartTimeAsc(doctorId, fromDate, toDate).stream()
				.map(slotMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
	}

    
    @Override
    @Transactional(readOnly = true)
	public List<SlotDTO> findForDoctor(Long doctorId, Instant fromDate, Instant toDate,
			SlotStatus status) {
		if (toDate == null) {
			return findForDoctorAfterDateWhereStatus(doctorId, fromDate, status);
		}
		log.debug("Request to get slots of status : {} for Doctor: {} from: {}  to: {} ", status, doctorId, fromDate, toDate);
		
		return slotRepository.findByAppointmentDoctorIdAndStartTimeBetweenAndStatusOrderByStartTimeAsc(doctorId,
				fromDate, toDate, status).stream().map(slotMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}
    
    @Override
	public List<SlotDTO> findForDoctorWhereStatusNot(Long doctorId, Instant fromDate, Instant toDate, SlotStatus status) {
    	
    	if (toDate == null) {
			return findForDoctorAfterDateWhereStatusNot(doctorId, fromDate, status);
		}

		log.debug("Request to get  slots which is not {} for Doctor: {} from: {}  to: {}",status, doctorId, fromDate, toDate);
 		return slotRepository.findByAppointmentDoctorIdAndStartTimeBetweenAndStatusNotOrderByStartTimeAsc(doctorId, fromDate, toDate, status).stream()
 	            .map(slotMapper::toDto)
 	            .collect(Collectors.toCollection(LinkedList::new));
	
	}

    
    @Override
    @Transactional(readOnly = true)
   	public List<SlotDTO> findAllForDoctorAfterDate(Long doctorId, Instant afterDate) {
   		log.debug("Request to get all slots for Doctor: {} after: {} ", doctorId, afterDate);
    		return slotRepository.findByAppointmentDoctorIdAndStartTimeAfterOrderByStartTimeAsc(doctorId, afterDate).stream()
    	            .map(slotMapper::toDto)
    	            .collect(Collectors.toCollection(LinkedList::new));
   	}

    
	@Override
    @Transactional(readOnly = true)
	public List<SlotDTO> findForDoctorAfterDateWhereStatus(Long doctorId,Instant afterDate, SlotStatus status) {
   		log.debug("Request to get all slots for   Doctor: {} , after: {} , Status is {}", doctorId, afterDate , status);
		return slotRepository.findByAppointmentDoctorIdAndStartTimeAfterAndStatusOrderByStartTimeAsc(doctorId, afterDate , status).stream()
	            .map(slotMapper::toDto)
	            .collect(Collectors.toCollection(LinkedList::new));
	}
	
	@Override
	public List<SlotDTO> findForDoctorAfterDateWhereStatusNot(Long doctorId,Instant afterDate, SlotStatus status) {
    		log.debug("Request to get all slots which Status is not {}  for  Doctor: {} , after: {}  ",status, doctorId, afterDate );
		return slotRepository.findByAppointmentDoctorIdAndStartTimeAfterAndStatusNotOrderByStartTimeAsc(doctorId, afterDate , status).stream()
	            .map(slotMapper::toDto)
	            .collect(Collectors.toCollection(LinkedList::new));
	}



    @Transactional(readOnly = true) 
    public List<SlotDTO> findAllWhereAppointmentIsNull() {
        log.debug("Request to get all slots where Appointment is null");
        return StreamSupport
            .stream(slotRepository.findAll().spliterator(), false)
            .filter(slot -> slot.getAppointment() == null)
            .map(slotMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

 
    @Override
    @Transactional(readOnly = true)
    public Optional<SlotDTO> findOne(Long id) {
        log.debug("Request to get Slot : {}", id);
        return slotRepository.findById(id)
            .map(slotMapper::toDto);
    }

    
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Slot : {}", id);
        slotRepository.deleteById(id);
    }

	
}
