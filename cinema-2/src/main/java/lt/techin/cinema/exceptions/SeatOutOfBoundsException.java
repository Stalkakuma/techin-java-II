package lt.techin.cinema.exceptions;

public class SeatOutOfBoundsException extends RuntimeException {
    public SeatOutOfBoundsException(String message) {
        super(message);
    }
}
