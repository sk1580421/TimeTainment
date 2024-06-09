package com.timetainment.timetainment.service.booking;

import com.timetainment.timetainment.dto.booking.BookingInputDTO;
import com.timetainment.timetainment.dto.booking.BookingOutputDTO;
import com.timetainment.timetainment.model.booking.Booking;
import com.timetainment.timetainment.model.offerings.Offering;
import com.timetainment.timetainment.repository.booking.BookingRepository;
import com.timetainment.timetainment.repository.offerings.OfferingRepository;
import com.timetainment.timetainment.repository.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service("cricket")  //-- name of bean of this class    // this helps to fill Map<String, BookingStrategy> bookingStrategies in booking service;
public class CricketSessionBookingService implements BookingStrategy {

    private final BookingRepository bookingRepository;
    private final OfferingRepository offeringRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public CricketSessionBookingService(BookingRepository bookingRepository, OfferingRepository offeringRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.bookingRepository = bookingRepository;
        this.offeringRepository = offeringRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BookingOutputDTO book(BookingInputDTO bookingInputDTO) {
        // Logic to validate and book a 3-hour cricket session

        Offering offering = offeringRepository.findById(bookingInputDTO.getOfferingId())
                .orElseThrow(()-> new EntityNotFoundException("Offering not found"));

        if (!"cricket".equals(offering.getCategory())) {
            throw new IllegalArgumentException("Offering is not a cricket session");
        }

        if (offering.getDuration() != 180) {
            throw new IllegalArgumentException("Offering duration is not 3 hours");
        }

        // Additional validation and booking logic

        Booking newBooking = new Booking();
        newBooking.setOffering(offering);
        newBooking.setUser(userRepository.findById(bookingInputDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found")));
        newBooking.setBookingDate(LocalDateTime.now());
        newBooking.setStatus("CONFIRMED");

        bookingRepository.save(newBooking);

        return modelMapper.map(newBooking, BookingOutputDTO.class);
    }

}
