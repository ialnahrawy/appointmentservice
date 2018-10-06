package com.nahrawy.his.appointment.web.rest;

import com.nahrawy.his.appointment.service.AppointmentTypeService;
import com.nahrawy.his.appointment.service.dto.AppointmentTypeDTO;
import com.nahrawy.his.appointment.web.rest.errors.BadRequestAlertException;
import com.nahrawy.his.appointment.web.rest.util.HeaderUtil;
import com.nahrawy.his.appointment.web.rest.util.ResponseUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing AppointmentType.
 */
@RestController
@RequestMapping("/api")
public class AppointmentTypeResource {

    private final Logger log = LoggerFactory.getLogger(AppointmentTypeResource.class);

    private static final String ENTITY_NAME = "appointmentType";

    private final AppointmentTypeService appointmentTypeService;

    public AppointmentTypeResource(AppointmentTypeService appointmentTypeService) {
        this.appointmentTypeService = appointmentTypeService;
    }

    /**
     * POST  /appointment-types : Create a new appointmentType.
     *
     * @param appointmentTypeDTO the appointmentTypeDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new appointmentTypeDTO, or with status 400 (Bad Request) if the appointmentType has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/appointment-types")
    
    public ResponseEntity<AppointmentTypeDTO> createAppointmentType(@RequestBody AppointmentTypeDTO appointmentTypeDTO) throws URISyntaxException {
        log.debug("REST request to save AppointmentType : {}", appointmentTypeDTO);
        if (appointmentTypeDTO.getId() != null) {
            throw new BadRequestAlertException("A new appointmentType cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AppointmentTypeDTO result = appointmentTypeService.save(appointmentTypeDTO);
        return ResponseEntity.created(new URI("/api/appointment-types/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /appointment-types : Updates an existing appointmentType.
     *
     * @param appointmentTypeDTO the appointmentTypeDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated appointmentTypeDTO,
     * or with status 400 (Bad Request) if the appointmentTypeDTO is not valid,
     * or with status 500 (Internal Server Error) if the appointmentTypeDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/appointment-types")
    
    public ResponseEntity<AppointmentTypeDTO> updateAppointmentType(@RequestBody AppointmentTypeDTO appointmentTypeDTO) throws URISyntaxException {
        log.debug("REST request to update AppointmentType : {}", appointmentTypeDTO);
        if (appointmentTypeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AppointmentTypeDTO result = appointmentTypeService.save(appointmentTypeDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, appointmentTypeDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /appointment-types : get all the appointmentTypes.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of appointmentTypes in body
     */
    @GetMapping("/appointment-types")
    
    public List<AppointmentTypeDTO> getAllAppointmentTypes() {
        log.debug("REST request to get all AppointmentTypes");
        return appointmentTypeService.findAll();
    }

    /**
     * GET  /appointment-types/:id : get the "id" appointmentType.
     *
     * @param id the id of the appointmentTypeDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the appointmentTypeDTO, or with status 404 (Not Found)
     */
    @GetMapping("/appointment-types/{id}")
    
    public ResponseEntity<AppointmentTypeDTO> getAppointmentType(@PathVariable Long id) {
        log.debug("REST request to get AppointmentType : {}", id);
        Optional<AppointmentTypeDTO> appointmentTypeDTO = appointmentTypeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(appointmentTypeDTO);
    }

    /**
     * DELETE  /appointment-types/:id : delete the "id" appointmentType.
     *
     * @param id the id of the appointmentTypeDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/appointment-types/{id}")
    
    public ResponseEntity<Void> deleteAppointmentType(@PathVariable Long id) {
        log.debug("REST request to delete AppointmentType : {}", id);
        appointmentTypeService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
