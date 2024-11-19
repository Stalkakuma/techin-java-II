package lt.techin.cinema.entities;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MovieTheater {
    private int rows;
    private int columns;
    private List<Seat> seats;

    public MovieTheater(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        seats = new ArrayList<>();
    }
    public void addSeat(Seat seat) {
        seats.add(seat);
    }
}
