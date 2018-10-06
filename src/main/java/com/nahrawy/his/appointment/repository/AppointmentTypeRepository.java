package com.nahrawy.his.appointment.repository;

 import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.nahrawy.his.appointment.domain.AppointmentType;



@Repository
public interface AppointmentTypeRepository extends JpaRepository<AppointmentType, Long> {

}
