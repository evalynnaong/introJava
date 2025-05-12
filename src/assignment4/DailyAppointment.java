package assignment4;

import java.time.LocalDate;

public class DailyAppointment extends Appointment {
    public DailyAppointment (String description, LocalDate startDate, LocalDate endDate) {
        super(description, startDate, endDate);
    }

    public boolean occursOn(LocalDate date) {
        return inBetween(date);
    }
}
