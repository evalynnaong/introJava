package assignment4;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.TreeSet;

public class AppointmentManager {
    TreeSet<Appointment> t;

    public AppointmentManager() {
        t = new TreeSet<>();
    }

    public void add(Appointment appointment) throws Exception {
        if(t.contains(appointment)) {
            throw new Exception("Appointment already exists");
        }
        t.add(appointment);

    }

    public void delete(Appointment appointment) throws Exception{
        if(!t.contains(appointment)){
            throw new Exception("Appointment does not exist, cannot delete");
        }
        t.remove(appointment);
    }

    public void update(Appointment current, Appointment modified) throws Exception {
        delete(current);
        add(modified);
    }

    public TreeSet<Appointment> getAppointments() {
        return t;
    }


    public Appointment[] getAppointmentsOn(LocalDate date, Comparator<Appointment> order) {
        TreeSet<Appointment> sortedAppointments;

        if(order != null) {
            sortedAppointments = new TreeSet<>(order);
        } else {
            sortedAppointments = new TreeSet<>();
        }

        for(Appointment appt : t) {
            if(date == null || appt.getStartDate().equals(date)) {
                sortedAppointments.add(appt);
            }
        }
        return sortedAppointments.toArray(new Appointment[0]);
    }

}
