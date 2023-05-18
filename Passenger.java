package com.FlightAPI.entity;

import com.FlightAPI.Payload.ReservationRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "passengers")
public class Passenger  extends  AbstractEntity{

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long passengerId;

    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phone;




//    @OneToOne(mappedBy = "passenger" ,cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "flight_id", referencedColumnName = "flight_id")
//    private Flight flight;

}
