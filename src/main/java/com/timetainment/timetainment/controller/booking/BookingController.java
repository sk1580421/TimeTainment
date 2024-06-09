package com.timetainment.timetainment.controller.booking;

import com.timetainment.timetainment.dto.booking.BookingInputDTO;
import com.timetainment.timetainment.dto.booking.BookingOutputDTO;
import com.timetainment.timetainment.service.booking.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/create-booking")
    public BookingOutputDTO addBooking(@RequestBody @Valid BookingInputDTO bookingInputDTO) {
        return bookingService.addBooking(bookingInputDTO);
    }

//    @GetMapping("/user/{userId}")
//    public List<BookingOutputDTO> getBookingsByUserId(@PathVariable Long userId) {
//        return bookingService.getBookingsByUserId(userId);
//    }
//
//    @DeleteMapping("/{bookingId}")
//    public void cancelBooking(@PathVariable Long bookingId) {
//        bookingService.cancelBooking(bookingId);
//    }
//
//    @GetMapping("/service/{serviceId}")
//    public List<BookingOutputDTO> getBookingsByServiceId(@PathVariable Long serviceId) {
//        return bookingService.getBookingsByServiceId(serviceId);
//    }
}

