package Model.exceptions.seat;

public class SeatNotNumericException extends IllegalArgumentException {
    public SeatNotNumericException() {
        super("[ERROR] 좌석 예약은 숫자만 입력해야 합니다.");
    }
}
