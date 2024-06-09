package com.timetainment.timetainment.controller.offerings;

import com.timetainment.timetainment.dto.offerings.OfferingInputDTO;
import com.timetainment.timetainment.dto.offerings.OfferingOutputDTO;
import com.timetainment.timetainment.service.offerings.OfferingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/offerings")
public class OfferingsController {

    private final OfferingService offeringService;

    @Autowired
    public OfferingsController(OfferingService offeringService) {
        this.offeringService = offeringService;
    }

    @PostMapping("/add")
    public ResponseEntity<OfferingOutputDTO> addService(@Valid @RequestBody OfferingInputDTO offeringInputDTO) {
        OfferingOutputDTO createdOffering = offeringService.addService(offeringInputDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOffering);
    }

    @PutMapping("/{offeringId}")
    public ResponseEntity<OfferingOutputDTO> editService(@PathVariable Long offeringId, @Valid @RequestBody OfferingInputDTO updatedOfferingInputDTO) {
        OfferingOutputDTO updatedOffering = offeringService.editService(offeringId, updatedOfferingInputDTO);
        return ResponseEntity.ok(updatedOffering);
    }

    @DeleteMapping("/{offeringId}")
    public ResponseEntity<Void> deleteService(@PathVariable Long offeringId) {
        offeringService.deleteService(offeringId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<OfferingOutputDTO>> getAllServices() {
        List<OfferingOutputDTO> offerings = offeringService.getAllServices();
        return ResponseEntity.ok(offerings);
    }

    @GetMapping("/{offeringId}")
    public ResponseEntity<OfferingOutputDTO> getServiceById(@PathVariable Long offeringId) {
        OfferingOutputDTO offering = offeringService.getServiceById(offeringId);
        return ResponseEntity.ok(offering);
    }

}

