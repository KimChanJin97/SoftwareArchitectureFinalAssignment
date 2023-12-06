package Model.user;

import Model.studyCafe.Seat;

public class User {

    private Info info;
    private Seat seat;
    private Time time;

    public User(Info info, Seat seat, Time time) {
        this.info = info;
        this.seat = seat;
        this.time = time;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
