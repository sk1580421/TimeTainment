package com.timetainment.timetainment.service.booking;

import com.timetainment.timetainment.dto.booking.BookingInputDTO;
import com.timetainment.timetainment.dto.booking.BookingOutputDTO;

public interface BookingStrategy {
    BookingOutputDTO book(BookingInputDTO bookingInputDTO);
}
