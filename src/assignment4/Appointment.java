package assignment4;

import java.time.LocalDate;

public abstract class Appointment implements Comparable<Appointment> {
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    public Appointment(String description, LocalDate startDate, LocalDate endDate) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public String getDescription() {return description;}
    public LocalDate getStartDate() {return startDate;}
    public LocalDate getEndDate() {return endDate;}
    public boolean inBetween(LocalDate date) {
        if (date.isBefore(startDate) || date.isAfter(endDate)) {
            return false;
        } else {
            return true;
        }
    }
    public abstract boolean occursOn(LocalDate date);

    @Override
    public String toString() {
        return description + " Start: " + startDate + " End: " + endDate + "\n";
    }

    @Override
    public int compareTo(Appointment appt2) {
        //when i went to the math help center and was working on this,
        //one of the other graduate students in the room told me to do this:
        //my compareTo being buggy was why update and delete were not working
        int startComp = this.startDate.compareTo(appt2.getStartDate());
        if (startComp != 0) return startComp;

        int endComp = this.endDate.compareTo(appt2.getEndDate());
        if (endComp != 0) return endComp;

        return this.description.compareTo(appt2.getDescription());
        /*if (this.startDate == appt2.getStartDate()) {
            if (this.endDate == appt2.getEndDate()) {
                if (this.description.equals(appt2.getDescription())) {
                    return 0;
                } else {
                    return -1;
                }
            } else if (this.endDate.isBefore(appt2.getEndDate())) {
                return -1;
            } else {
                return 1;
            }
        } else if (this.startDate.isBefore(appt2.getStartDate())) {
            return -1;
        } else {
            return 1;
        }*/
    }
}
