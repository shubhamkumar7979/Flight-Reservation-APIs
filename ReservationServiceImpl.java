package com.FlightAPI.Service.Impl;

import com.FlightAPI.Payload.ReservationDto;
import com.FlightAPI.Payload.ReservationRequest;
import com.FlightAPI.Repository.FlightRepo;
import com.FlightAPI.Repository.PassengerRepo;
import com.FlightAPI.Repository.ReservationRepo;
import com.FlightAPI.Service.ReservationService;
import com.FlightAPI.Utils.EmailUtil;
import com.FlightAPI.Utils.PdfGenerators;
import com.FlightAPI.entity.Flight;
import com.FlightAPI.entity.Passenger;
import com.FlightAPI.entity.Reservation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private FlightRepo flightRepo;
    @Autowired
    private ReservationRepo reservationRepo;

    @Autowired
    private PassengerRepo passengerRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    private PdfGenerators pdfGenerators;



    @Override
    public ReservationDto saveReser(long flightId, long passengerId,long rid, ReservationDto reservationDto) {

        Reservation reservation = mapToEntity(reservationDto);
        Flight flight = flightRepo.findById(flightId).orElseThrow(
                () -> new EntityNotFoundException("flight not found with flight id: " + flightId)
        );



        Passenger passenger = passengerRepo.findById(passengerId).orElseThrow(
                () -> new EntityNotFoundException("Passenger not fount with passengerId " + passengerId)
        );

        Reservation reservation1 = reservationRepo.findById(rid).orElseThrow(
                () -> new EntityNotFoundException("Passenger not fount with passengerId " + rid)
        );

//       passengerRepo.findById(passengerId).orElseThrow(
//                () -> new EntityNotFoundException("Passenger not fount with passengerId" + passengerId)
//        );
        reservation.setFlight(flight);
        reservation.setPassenger(passenger);

//       Passenger passenger=new Passenger();
//        passenger.setFirstName(request.getFirstName());
//        passenger.setLastName(request.getLastName());
//        passenger.setMiddleName(request.getMiddleName());
//        passenger.setEmail(request.getEmail());
//        passenger.setPhone(request.getPhone());
//
//        passengerRepo.save(passenger);
//        long flightId1 = request.getFlightId();
//        Optional<Flight> findById = flightRepo.findById(flightId1);
//        Flight flight1 = findById.get();
//
//
//        Reservation reservation=new Reservation();
//        reservation.setFlight(flight1);
//        reservation.setPassenger(passenger);
//        reservation.setCheckedIn(false);
//        reservation.setNumberOfBags(0);
//
//        String filePath="D:\\PROJECT_PSA\\FlightAPI\\tickets\\reservation"+reservation.getReservationId()+".pdf";
//        reservationRepo.save(reservation);
//
//
//        //pdfGenerator.generatePDF(reservation, filePath);
//        pdfGenerators.generateItinerary(reservation, filePath);
//        emailUtil.sendItinerary(passenger.getEmail(), filePath);

        Reservation newReservation = reservationRepo.save(reservation);
       // reservationDto.setFlight(newReservation.getFlight());
       // reservationDto.setPassenger(newReservation.getPassenger());


        ReservationDto dto = mapToDto(newReservation);


        return dto;
    }

    @Override
    public Reservation bookFlight(long id,ReservationRequest request) {

//		String firstName = request.getFirstName();
//		String lastName = request.getLastName();
//		String middleName = request.getMiddleName();
//		String email = request.getEmail();
//		String phone = request.getPhone();


        Flight flight1 = flightRepo.findById(id).orElseThrow(
                () -> new EntityNotFoundException("flight not found with flight id: " + id)
        );



        Passenger passenger=new Passenger();
        passenger.setFirstName(request.getFirstName());
        passenger.setLastName(request.getLastName());
        passenger.setMiddleName(request.getMiddleName());
        passenger.setEmail(request.getEmail());
        passenger.setPhone(request.getPhone());

        passengerRepo.save(passenger);


        long flightId = flight1.getId();
        Optional<Flight> findById = flightRepo.findById(id);
        Flight flight = findById.get();


        Reservation reservation=new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(passenger);
        reservation.setCheckedIn(false);
        reservation.setNumberOfBags(2);

       String filePath="D:\\project\\FlightAPI\\tickets"+reservation.getId()+".pdf";
        reservationRepo.save(reservation);


        //pdfGenerator.generatePDF(reservation, filePath);
       pdfGenerators.generateItinerary(reservation, filePath);
       emailUtil.sendItinerary(passenger.getEmail(), filePath);

      //  emailUtil.sendItinerary(passenger.getEmail());


        return reservation;
    }


    private Reservation mapToEntity(ReservationDto reservationDto){
        Reservation reservation= modelMapper.map(reservationDto , Reservation.class);
        return reservation;
    }

    private  ReservationDto mapToDto(Reservation reservation){
        ReservationDto dto = modelMapper.map(reservation, ReservationDto.class);
        return dto;
    }
}
