package lt.techin.cinema.services;

import lt.techin.cinema.dto.SeatCreationDTO;
import lt.techin.cinema.entities.MovieTheater;
import lt.techin.cinema.entities.Seat;
import lt.techin.cinema.exceptions.SeatAlreadyPurchasedException;
import lt.techin.cinema.exceptions.SeatOutOfBoundsException;
import lt.techin.cinema.repositories.MovieTheaterRepository;
import org.springframework.stereotype.Service;


@Service
public class TheaterService {

    private MovieTheaterRepository movieTheaterRepository;

    public TheaterService(MovieTheaterRepository movieTheaterRepository) {
        this.movieTheaterRepository = movieTheaterRepository;
    }

    public MovieTheater createTheater(int rows, int columns){
        MovieTheater movieTheater = new MovieTheater(rows, columns);
        movieTheater.populateSeats();
        return movieTheaterRepository.save(movieTheater);
    }

    public MovieTheater getTheater() {
        createTheater(9,9);
        return movieTheaterRepository.findById(Long.valueOf(1)).orElse(null);
    }

    public Seat purchaseSeat(SeatCreationDTO seatCreationDTO) {
        MovieTheater movieTheater = getTheater();
        if (seatCreationDTO.getColumn() > movieTheater.getColumns() || seatCreationDTO.getRow() > movieTheater.getRows()) {
            throw new SeatOutOfBoundsException("Try a different seat");
        }
        return movieTheater.getSeats()
                .stream()
                .filter(seat -> seat.getRow() == seatCreationDTO.getRow() && seat.getColumn() == seatCreationDTO.getColumn())
                .findFirst()
                .map(seat -> {
                    if (seat.isTaken()) {
                        throw new SeatAlreadyPurchasedException("Try a different seat");
                    }
                    seat.setTaken(true);
                    movieTheaterRepository.save(movieTheater);
                    return seat;
                })
                .orElseThrow(() -> new RuntimeException("Seat not found"));
    }

    }