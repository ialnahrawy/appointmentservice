package com.nahrawy.his.appointment.service.impl;

import com.nahrawy.his.appointment.domain.Reference;
import com.nahrawy.his.appointment.repository.ReferenceRepository;
import com.nahrawy.his.appointment.service.ReferenceService;
import com.nahrawy.his.appointment.service.dto.ReferenceDTO;
import com.nahrawy.his.appointment.service.mapper.ReferenceMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing Reference.
 */
@Service
@Transactional
public class ReferenceServiceImpl implements ReferenceService {

    private final Logger log = LoggerFactory.getLogger(ReferenceServiceImpl.class);

    private final ReferenceRepository referenceRepository;

    private final ReferenceMapper referenceMapper;

    public ReferenceServiceImpl(ReferenceRepository referenceRepository, ReferenceMapper referenceMapper) {
        this.referenceRepository = referenceRepository;
        this.referenceMapper = referenceMapper;
    }

  

    @Override
    public ReferenceDTO save(ReferenceDTO referenceDTO) {
        log.debug("Request to save Reference : {}", referenceDTO);
        Reference reference = referenceMapper.toEntity(referenceDTO);
        reference = referenceRepository.save(reference);
        return referenceMapper.toDto(reference);
    }

  

    @Override
    @Transactional(readOnly = true)
    public Page<ReferenceDTO> findAll(Pageable pageable) {
        log.debug("Request to get all References");
        return referenceRepository.findAll(pageable)
            .map(referenceMapper::toDto);
    }


    

    @Override
    @Transactional(readOnly = true)
    public Optional<ReferenceDTO> findOne(Long id) {
        log.debug("Request to get Reference : {}", id);
        return referenceRepository.findById(id)
            .map(referenceMapper::toDto);
    }

   

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Reference : {}", id);
        referenceRepository.deleteById(id);
    }
}
