package com.timetainment.timetainment.service.booking;

import com.timetainment.timetainment.dto.booking.BookingInputDTO;
import com.timetainment.timetainment.dto.booking.BookingOutputDTO;
import com.timetainment.timetainment.model.offerings.Offering;
import com.timetainment.timetainment.repository.booking.BookingRepository;
import com.timetainment.timetainment.repository.offerings.OfferingRepository;
import com.timetainment.timetainment.repository.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BookingService {

    private final Map<String, BookingStrategy> bookingStrategies;
    private final OfferingRepository offeringRepository;

    @Autowired
    public BookingService(Map<String, BookingStrategy> bookingStrategies, OfferingRepository offeringRepository) {
        this.bookingStrategies = bookingStrategies;
        this.offeringRepository = offeringRepository;
    }
    public BookingOutputDTO addBooking(BookingInputDTO bookingInputDTO) {
        String category = getCategoryByOfferingId(bookingInputDTO.getOfferingId());
        BookingStrategy bookingStrategy = bookingStrategies.get(category);

        if (bookingStrategy == null) {
            throw new RuntimeException("No booking strategy found for category: " + category);
        }

        return bookingStrategy.book(bookingInputDTO);
    }

    private String getCategoryByOfferingId(Long offeringId) {
        Offering offering = offeringRepository.findById(offeringId)
                .orElseThrow(() -> new EntityNotFoundException("Offering not found with id: " + offeringId));
        return offering.getCategory();
    }
}

