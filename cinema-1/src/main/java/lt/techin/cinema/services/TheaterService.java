package lt.techin.cinema.services;

import lt.techin.cinema.entities.MovieTheater;
import lt.techin.cinema.entities.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterService {

    public MovieTheater getSeats() {
        MovieTheater movieTheater = new MovieTheater(9, 9);
        for (int i = 1; i <= movieTheater.getRows(); i++) {
            for (int j = 1; j <= movieTheater.getColumns(); j++) {
                movieTheater.addSeat( new Seat(i, j));
            }
        }
        return movieTheater;
    }


}
