package com.FlightAPI.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDTO {
        private long flightId;

        @NotEmpty(message = "Is mandatory")
        @Size(min = 4, message = "flight number should be at least 2 character and 2 number")
        private String flightNumber;

        @NotEmpty(message = "Is mandatory")
        @Size(min = 3, message = "operating airlines should be at least 3 character")
        private String operatingAirlines;

        @NotEmpty(message = "Is mandatory")
        @Size(min = 3, message = "departure City should be at least 3 character")
        private String departureCity;

        @NotEmpty(message = "Is mandatory")
        @Size(min = 3, message = "arrivalCity should be at least 3 character")
        private String arrivalCity;

       // @NotEmpty(message = "Is mandatory")
        //@Size(min = 4, message = "date Of Departure should be in YYYY-MM-DD hh:mm:ss")
        private Date dateOfDeparture;

       //@NotEmpty(message = "Is mandatory")
       //@Size(min = 4, message = "estimated Departure Time should be in YYYY-MM-DD hh:mm:ss")
        private Timestamp estimatedDepartureTime;
    }


