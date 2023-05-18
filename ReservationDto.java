package com.FlightAPI.Payload;

import com.FlightAPI.entity.Flight;
import com.FlightAPI.entity.Passenger;
import lombok.Data;

@Data
public class ReservationDto {

    private long reservationId;

    private boolean checkedIn;

    private int numberOfBags;

    private Flight flight;
    private Passenger passenger;
}
