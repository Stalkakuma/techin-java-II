package lt.techin.cinema.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatNo;

    @Column(name = "`row`")
    private int row;
    @Column(name = "`column`")
    private int column;
    private int price;

    private boolean taken = false;



    @ManyToOne
    @JoinColumn(name = "movie_theater_id", nullable = false)
    @JsonBackReference
    private  MovieTheater movieTheater;


    public Seat(int rowNumber, int columnNumber, MovieTheater movieTheater) {
        this.row = rowNumber;
        this.column = columnNumber;
        this.movieTheater = movieTheater;
        price = rowNumber <= 4 ? 10 : 8;
    }
}
