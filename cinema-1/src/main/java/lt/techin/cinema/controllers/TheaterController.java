package lt.techin.cinema.controllers;

import lt.techin.cinema.entities.MovieTheater;
import lt.techin.cinema.services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seats")
public class TheaterController {
    private final TheaterService theaterService;

    @Autowired
    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping
    public MovieTheater getSeats() {
        return theaterService.getSeats();
    }
}
