package com.nahrawy.his.appointment.web.rest;

import com.nahrawy.his.appointment.domain.enumeration.SlotStatus;
import com.nahrawy.his.appointment.service.SlotService;
import com.nahrawy.his.appointment.service.dto.SlotDTO;
import com.nahrawy.his.appointment.web.rest.errors.BadRequestAlertException;
import com.nahrawy.his.appointment.web.rest.util.HeaderUtil;
import com.nahrawy.his.appointment.web.rest.util.ResponseUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Slot.
 * @author Islam Alnahrawy
 */
@RestController
@RequestMapping("/api")
public class SlotResource {

    private final Logger log = LoggerFactory.getLogger(SlotResource.class);

    private static final String ENTITY_NAME = "slot";

    private final SlotService slotService;

    public SlotResource(SlotService slotService) {
        this.slotService = slotService;
    }


    @PostMapping("/slots")
    
    public ResponseEntity<SlotDTO> createSlot(@Valid @RequestBody SlotDTO slotDTO) throws URISyntaxException {
        log.debug("REST request to save Slot : {}", slotDTO);
        if (slotDTO.getId() != null) {
            throw new BadRequestAlertException("A new slot cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SlotDTO result = slotService.save(slotDTO);
        return ResponseEntity.created(new URI("/api/slots/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }



    @PutMapping("/slots")
    public ResponseEntity<SlotDTO> updateSlot(@Valid @RequestBody SlotDTO slotDTO) throws URISyntaxException {
        log.debug("REST request to update Slot : {}", slotDTO);
        if (slotDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SlotDTO result = slotService.save(slotDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, slotDTO.getId().toString()))
            .body(result);
    }

 
    @GetMapping(value ="/slots-for-doctor/{doctorId}", params = {"fromDate", "toDate"})
    public List<SlotDTO> getAllSlots(@PathVariable Long doctorId, @RequestParam(value = "fromDate") LocalDate fromDate,
            @RequestParam(required = false , value = "toDate") LocalDate toDate, @RequestParam(required = false) String filter ) {
    	
		Instant fromInstant = fromDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
		Instant toInstant = null;
		if (toDate != null) {
			toInstant = toDate.atStartOfDay(ZoneId.systemDefault()).plusDays(1).toInstant();
		}
  
        if ("status-not-cancelled".equals(filter)) {
            log.debug("REST request to get all Slots where status is not cancelled");
			return slotService.findForDoctorWhereStatusNot(doctorId, fromInstant, toInstant, SlotStatus.CANCELLED);
        }
        
        log.debug("REST request to get all Slots");
        return slotService.findAllForDoctor(doctorId, fromInstant, toInstant);
    }

 
    @GetMapping("/slots/{id}")
    
    public ResponseEntity<SlotDTO> getSlot(@PathVariable Long id) {
        log.debug("REST request to get Slot : {}", id);
        Optional<SlotDTO> slotDTO = slotService.findOne(id);
        return ResponseUtil.wrapOrNotFound(slotDTO);
    }

     
    @DeleteMapping("/slots/{id}")
    
    public ResponseEntity<Void> deleteSlot(@PathVariable Long id) {
        log.debug("REST request to delete Slot : {}", id);
        slotService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
