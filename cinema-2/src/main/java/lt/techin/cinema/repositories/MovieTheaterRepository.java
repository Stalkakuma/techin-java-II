package lt.techin.cinema.repositories;

import lt.techin.cinema.entities.MovieTheater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTheaterRepository extends JpaRepository<MovieTheater, Long> {
}
