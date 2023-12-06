package Model.studyCafe;

import Model.user.User;

public class Seat {

    private int seatNumber = 0;
    private boolean isConquered = false;
    private User user;

    public Seat(int seatNumber, boolean isConquered) {
        this.seatNumber = seatNumber;
        this.isConquered = isConquered;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean getIsConquered() {
        return isConquered;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setIsConquered(boolean isConquered) {
        this.isConquered = isConquered;
    }

    private void validate() {

    }


}
