package assignment4;

import java.time.LocalDate;

public class MonthlyAppointment extends Appointment {

    public MonthlyAppointment (String description, LocalDate startDate, LocalDate endDate) {
        super(description, startDate, endDate);
    }

    public boolean occursOn(LocalDate date) {
        if(inBetween(date) && date.getDayOfMonth() == getStartDate().getDayOfMonth()) {
            return true;
        } else {
            return false;
        }
    }
}
