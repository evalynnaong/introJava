package assignment2;

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
    public int compareTo(Appointment appt2) {
        if (this.startDate == appt2.getStartDate()) {
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
        }
    }
}
