package com.timetainment.timetainment.service.offerings;
import com.timetainment.timetainment.dto.offerings.OfferingInputDTO;
import com.timetainment.timetainment.dto.offerings.OfferingOutputDTO;
import com.timetainment.timetainment.model.offerings.Offering;
import com.timetainment.timetainment.repository.offerings.OfferingRepository;
import com.timetainment.timetainment.repository.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OfferingService {

    private final OfferingRepository offeringRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public OfferingService(OfferingRepository offeringRepository, ModelMapper modelMapper) {
        this.offeringRepository = offeringRepository;
        this.modelMapper = modelMapper;
    }

    public OfferingOutputDTO addService(OfferingInputDTO offeringInputDTO) {
        Offering offering = modelMapper.map(offeringInputDTO, Offering.class);
        offering = offeringRepository.save(offering);
        return modelMapper.map(offering, OfferingOutputDTO.class);
    }

    public OfferingOutputDTO editService(Long offeringId, OfferingInputDTO updatedOfferingInputDTO) {
        Optional<Offering> offering = offeringRepository.findById(offeringId);
        if (offering.isPresent()) {
            Offering existingoffering = offering.get();
            modelMapper.map(updatedOfferingInputDTO, existingoffering);
            existingoffering.setId(offeringId); // Ensure ID is set
            existingoffering = offeringRepository.save(existingoffering);
            return modelMapper.map(existingoffering, OfferingOutputDTO.class);
        } else {
            throw new EntityNotFoundException("Service not found with id: " + offeringId);
        }
    }

    public void deleteService(Long offeringId) {
        if (offeringRepository.existsById(offeringId)) {
            offeringRepository.deleteById(offeringId);
        } else {
            throw new EntityNotFoundException("Service not found with id: " + offeringId);
        }
    }

    public List<OfferingOutputDTO> getAllServices() {
        List<Offering> offerings = offeringRepository.findAll();
        return offerings.stream()
                .map(offering -> modelMapper.map(offering, OfferingOutputDTO.class))
                .collect(Collectors.toList());
    }

    public OfferingOutputDTO getServiceById(Long offeringId) {
        Optional<Offering> optionalService = offeringRepository.findById(offeringId);
        if (optionalService.isPresent()) {
            Offering existingoffering = optionalService.get();
            return modelMapper.map(existingoffering, OfferingOutputDTO.class);
        } else {
            throw new EntityNotFoundException("Service not found with id: " + offeringId);
        }
    }

}









