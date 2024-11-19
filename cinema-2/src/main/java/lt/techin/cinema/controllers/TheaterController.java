package lt.techin.cinema.controllers;

import lt.techin.cinema.dto.SeatCreationDTO;
import lt.techin.cinema.entities.MovieTheater;
import lt.techin.cinema.entities.Seat;
import lt.techin.cinema.services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class TheaterController {
    private final TheaterService theaterService;

    @Autowired
    public TheaterController(TheaterService theaterService) {

        this.theaterService = theaterService;
    }

    @GetMapping("/seats")
    public MovieTheater getTheater() {

        return theaterService.getTheater();
    }

    @PostMapping("/purchase")
    public Seat purchaseSeat(@RequestBody SeatCreationDTO seatCreationDTO) {
        return theaterService.purchaseSeat(seatCreationDTO);
    }
}
