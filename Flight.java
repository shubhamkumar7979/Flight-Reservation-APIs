package com.FlightAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "flights")
@Entity
public class Flight extends AbstractEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "flight_id")
//    private long flightId;

    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "operating_airlines")
    private String operatingAirlines;

    @Column(name = "departure_city")
    private String departureCity;

    @Column(name = "arrival_city")
    private String arrivalCity;

    @Column(name = "date_of_departure")
    private Date dateOfDeparture;

    @Column(name = "estimated_departure_time")
    private Timestamp estimatedDepartureTime;

//    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Reservation> reservations= new HashSet<>();

}
