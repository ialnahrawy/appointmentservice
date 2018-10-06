package com.nahrawy.his.appointment.repository;

 import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.nahrawy.his.appointment.domain.Slot;
import com.nahrawy.his.appointment.domain.enumeration.SlotStatus;
 


@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {
	


	List<Slot> findByAppointmentDoctorIdAndStartTimeBetweenAndStatusOrderByStartTimeAsc(Long doctorId, Instant fromDate, Instant toDate,
			SlotStatus status);

	List<Slot> findByAppointmentDoctorIdAndStartTimeAfterOrderByStartTimeAsc(Long doctorId, Instant afterDate);

	List<Slot> findByAppointmentDoctorIdAndStartTimeAfterAndStatusOrderByStartTimeAsc(Long doctorId, Instant afterDate,
			SlotStatus status);

	List<Slot> findByAppointmentDoctorIdAndStartTimeAfterAndStatusNotOrderByStartTimeAsc(Long doctorId, Instant afterDate,
			SlotStatus status);

	List<Slot> findByAppointmentDoctorIdAndStartTimeBetweenAndStatusNotOrderByStartTimeAsc(Long doctorId,
			Instant fromDate, Instant toDate, SlotStatus status);

	List<Slot> findByAppointmentDoctorIdAndStartTimeBetweenOrderByStartTimeAsc(Long doctorId, Instant fromDate,
			Instant toDate);
	 


}
