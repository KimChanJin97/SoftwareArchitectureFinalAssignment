package Model.user;

public class Time {

    private long startStudyTime = 0L;
    private long endStudyTime = 0L;
    private long reservedTime = 0L;

    public Time(long startStudyTime, long endStudyTime, long reservedTime) {
        this.startStudyTime = startStudyTime;
        this.endStudyTime = endStudyTime;
        this.reservedTime = reservedTime;
    }

    public long getReservedTime() {
        return reservedTime;
    }

    public long addStudyTime(int pay) {
        long time = pay / 1000;
        return reservedTime += time;
    }

    public void setStartStudyTime() {
        startStudyTime = System.currentTimeMillis();
    }

    public void setEndStudyTime() {
        endStudyTime = System.currentTimeMillis();
    }

    public long getStudyTime() {
        return endStudyTime - startStudyTime;
    }


}
