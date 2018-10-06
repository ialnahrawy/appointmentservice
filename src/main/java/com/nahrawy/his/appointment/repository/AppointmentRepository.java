package com.nahrawy.his.appointment.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nahrawy.his.appointment.domain.Appointment;
import com.nahrawy.his.appointment.domain.enumeration.SlotStatus;

import java.time.Instant;
import java.util.List;
import java.util.Optional;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query(value = "select distinct appointment from Appointment appointment left join fetch appointment.references",
        countQuery = "select count(distinct appointment) from Appointment appointment")
    Page<Appointment> findAllWithEagerRelationships(Pageable pageable);
    
  
 
    @Query(value = "select distinct appointment from Appointment appointment left join fetch appointment.references")
    List<Appointment> findAllWithEagerRelationships();

    @Query("select appointment from Appointment appointment left join fetch appointment.references where appointment.id =:id")
    Optional<Appointment> findOneWithEagerRelationships(@Param("id") Long id);
    
    
    @Query("select appointment from Slot slot inner join slot.appointment appointment left join fetch appointment.references where slot.id =:slotId")
    Optional<Appointment> findOneWithEagerRelationshipsForSlot(@Param("slotId") Long slotId);
    
    
	@Query(value = "select appointment from Appointment appointment inner join  appointment.slot slot where ((:doctorId is null) or appointment.doctorId = :doctorId) and  ((:locationId is null) or appointment.locationId = :locationId) and  ((:patientId is null) or appointment.patientId = :patientId)", 
			countQuery = "select count(appointment) from Appointment appointment where ((:doctorId is null) or appointment.doctorId = :doctorId) and  ((:locationId is null) or appointment.locationId = :locationId) and  ((:patientId is null) or appointment.patientId = :patientId)")
	
	Page<Appointment> searchAppointments(@Param("doctorId") Long doctorId, @Param("locationId") Long locationId, @Param("patientId") Long patientId , Pageable pageable);
	
	
	@Query(value = "select appointment from Appointment appointment inner join  appointment.slot slot where ((:doctorId is null) or appointment.doctorId = :doctorId) and  ((:locationId is null) or appointment.locationId = :locationId) and  ((:patientId is null) or appointment.patientId = :patientId) and  ((:afterDate is null) or slot.startTime >= :afterDate) and  ((:toDate is null) or  slot.startTime <= :toDate) and  ((:status is null) or  slot.status = :status) ", 
			countQuery = "select count(appointment) from Appointment appointment inner join appointment.slot slot where ((:doctorId is null) or appointment.doctorId = :doctorId) and  ((:locationId is null) or appointment.locationId = :locationId) and  ((:patientId is null) or appointment.patientId = :patientId)  and  ((:afterDate is null) or slot.startTime >= :afterDate) and  ((:toDate is null) or  slot.startTime <= :toDate) and  ((:status is null) or  slot.status = :status) ")
	
	 Page<Appointment> searchAppointments(@Param("doctorId") Long doctorId, @Param("locationId") Long locationId, @Param("patientId") Long patientId , @Param("afterDate") Instant afterDate, @Param("toDate") Instant toDate  , @Param("status") SlotStatus status , Pageable pageable);

}
