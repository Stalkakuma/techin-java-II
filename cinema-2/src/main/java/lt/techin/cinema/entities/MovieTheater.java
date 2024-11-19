package lt.techin.cinema.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class MovieTheater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rows;
    private int columns;

    @OneToMany(mappedBy = "movieTheater", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Seat> seats = new ArrayList<>();

    public MovieTheater(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public void populateSeats() {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                Seat seat = new Seat(i, j, this);
                seats.add(seat);
            }
        }
    }

}
