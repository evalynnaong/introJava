package assignment4;

import java.time.LocalDate;

public class OnetimeAppointment extends Appointment {

    public OnetimeAppointment(String description, LocalDate startDate) {
        super(description, startDate, startDate);
    }

    public boolean occursOn(LocalDate date) {
        if (date == getStartDate()) {
            return true;
        } else {
            return false;
        }
    }
}
