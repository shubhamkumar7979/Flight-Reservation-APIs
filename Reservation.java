package com.FlightAPI.entity;

import com.FlightAPI.Payload.ReservationRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "reservations")
public class Reservation extends AbstractEntity {


//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long reservationId;

    private boolean checkedIn;

    private int numberOfBags;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passenger_id", nullable = false, referencedColumnName = "id")
    private Passenger passenger;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id", referencedColumnName = "id")
    private Flight flight;


}
