package com.nahrawy.his.appointment.web.rest;

 import com.nahrawy.his.appointment.service.AppointmentService;
import com.nahrawy.his.appointment.service.NotificationService;
import com.nahrawy.his.appointment.service.dto.AppointmentDTO;
import com.nahrawy.his.appointment.service.dto.DoctorSearchFilter;
import com.nahrawy.his.appointment.service.dto.PatientSearchFilter;
import com.nahrawy.his.appointment.web.rest.errors.BadRequestAlertException;
import com.nahrawy.his.appointment.web.rest.util.HeaderUtil;
import com.nahrawy.his.appointment.web.rest.util.PaginationUtil;
import com.nahrawy.his.appointment.web.rest.util.ResponseUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Appointment.
 */
@RestController
@RequestMapping("/api")
public class AppointmentResource {

    private final Logger log = LoggerFactory.getLogger(AppointmentResource.class);

    private static final String ENTITY_NAME = "appointment";

    private final AppointmentService appointmentService;
    private final NotificationService notificationService;
    
    public AppointmentResource(AppointmentService appointmentService , NotificationService notificationService ) {
        this.appointmentService = appointmentService;
        this.notificationService = notificationService;
    }


    @PostMapping("/appointments")
    public ResponseEntity<AppointmentDTO> createAppointment(@Valid @RequestBody AppointmentDTO appointmentDTO) throws URISyntaxException {
        log.debug("REST request to save Appointment : {}", appointmentDTO);
        if (appointmentDTO.getId() != null) {
            throw new BadRequestAlertException("A new appointment cannot already have an ID", ENTITY_NAME, "idexists");
        }
        
        AppointmentDTO result = appointmentService.save(appointmentDTO);
       // notificationService.sendConfirmNotificationEmail(result, "islam.alnahrawy@gmail.com");
        return ResponseEntity.created(new URI("/api/appointments/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }



    @PutMapping("/appointments")
    public ResponseEntity<AppointmentDTO> updateAppointment(@Valid @RequestBody AppointmentDTO appointmentDTO) throws URISyntaxException {
        log.debug("REST request to update Appointment : {}", appointmentDTO);
        if (appointmentDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AppointmentDTO result = appointmentService.save(appointmentDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, appointmentDTO.getId().toString()))
            .body(result);
    }

 
    
    @GetMapping("/appointments-search/doctor")
	public ResponseEntity<List<AppointmentDTO>> searchAppointments(Pageable pageable, @Valid @RequestBody DoctorSearchFilter searchFilter) {
 		  log.debug("REST request to search for Appointments for doctor: {} with search filter{} ",  searchFilter.getDoctorId(),  searchFilter);
	       
 		 Page<AppointmentDTO> page = appointmentService.searchAppointments(searchFilter, pageable);
	       
	        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/appointments-search/doctor");
	        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}
	
    
    @GetMapping("/appointments-search/patient")
	public ResponseEntity<List<AppointmentDTO>> searchAppointments(Pageable pageable, @Valid @RequestBody PatientSearchFilter searchFilter) {
 		  log.debug("REST request to search for Appointments for patient: {} with search filter{} " , searchFilter.getPatientId(),  searchFilter);
	       
 		 Page<AppointmentDTO> page = appointmentService.searchAppointments(searchFilter, pageable);
	       
	        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/appointments-search/patient");
	        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
	}
    
    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments(Pageable pageable) {
        log.debug("REST request to get a page of Appointments");
        Page<AppointmentDTO> page = appointmentService.findAll(pageable);
        
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/appointments");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

   

    @GetMapping("/appointments/{id}")
    
    public ResponseEntity<AppointmentDTO> getAppointment(@PathVariable Long id) {
        log.debug("REST request to get Appointment : {}", id);
        Optional<AppointmentDTO> appointmentDTO = appointmentService.findOne(id);
        return ResponseUtil.wrapOrNotFound(appointmentDTO);
    }
    
    
 @GetMapping("/appointment-of-slot/{slotId}")
    
    public ResponseEntity<AppointmentDTO> getAppointmentForSlot(@PathVariable Long slotId) {
        log.debug("REST request to get Appointment : {}", slotId);
        Optional<AppointmentDTO> appointmentDTO = appointmentService.findOneWithEagerRelationshipsForSlot(slotId);
        return ResponseUtil.wrapOrNotFound(appointmentDTO);
    }

  

    @DeleteMapping("/appointments/{id}")
    
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        log.debug("REST request to delete Appointment : {}", id);
        appointmentService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
