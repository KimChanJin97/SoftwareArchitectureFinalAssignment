package Model.studyCafe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeatRepository {

    private static final Map<Long, Seat> store = new HashMap<>();

    private static final int MAX_SEAT_SIZE = 20;

    private static final boolean INITIAL_SEAT_IS_CONQUERED = false;

    private List<Seat> seats = new ArrayList<>(20);

    public SeatRepository() {
        for (int i = 1; i <= MAX_SEAT_SIZE; i++) {
            seats.add(new Seat(i, INITIAL_SEAT_IS_CONQUERED));
        }
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public Seat findSeatBySeatNumber(int seatNumber) {
        return seats.stream()
                .filter(seat -> seat.getSeatNumber() == seatNumber)
                .findFirst()
                .orElse(null);
    }
}
