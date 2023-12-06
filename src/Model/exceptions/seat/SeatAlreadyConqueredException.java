package Model.exceptions.seat;

public class SeatAlreadyConqueredException extends IllegalArgumentException {

    public SeatAlreadyConqueredException() {
        super("[ERROR] 이미 예약된 좌석입니다.");
    }
}
