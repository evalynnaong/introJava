package assignment4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class AppointmentEditor extends JFrame implements ActionListener {
    private AppointmentDisplayer displayer;
    private AppointmentManager manage;
    private JPanel controls;
    private JButton add, delete, update, on;
    public AppointmentEditor(AppointmentDisplayer displayer, AppointmentManager manage) {
        setTitle("Edit Appointments");
        this.displayer = displayer;
        this.manage = manage;
        setLayout(new GridLayout(0, 2));

        controls = new JPanel();
        add = new JButton("add");
        delete = new JButton("delete");
        update = new JButton("update");
        on = new JButton("Appointments on");

        controls.add(add);
        controls.add(delete);
        controls.add(update);
        controls.add(on);

        add(controls, "Center");
        setListeners();

        pack();
        setVisible(true);
    }

    public void setListeners() {
        add.addActionListener(this);
        delete.addActionListener(this);
        update.addActionListener(this);
        on.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        try {
            switch(cmmd) {
                case "add": {
                    String input1 = JOptionPane.showInputDialog("Enter description (Onetime, Daily, Monthly): ");
                    LocalDate input2 = LocalDate.parse(JOptionPane.showInputDialog("Enter start date (YYYY-MM-DD): "));
                    LocalDate input3;
                    if(!input1.equals("Onetime")) {
                        input3 = LocalDate.parse(JOptionPane.showInputDialog("Enter end date (same if onetime): "));
                    } else {
                        input3 = null;
                    }
                    Appointment addAppt;

                    switch(input1) {
                        case "Onetime": {
                            addAppt = new OnetimeAppointment(input1, input2);
                            manage.add(addAppt);
                            break;
                        }
                        case "Daily": {
                            addAppt = new DailyAppointment(input1, input2, input3);
                            manage.add(addAppt);
                            break;
                        }
                        case "Monthly": {
                            addAppt = new MonthlyAppointment(input1, input2, input3);
                            manage.add(addAppt);
                            break;
                        }
                    }
                    displayer.refreshDisplay();
                    break;
                }
                case "delete": {
                    String input1 = JOptionPane.showInputDialog("Enter description (Onetime, Daily, Monthly): ");
                    LocalDate input2 = LocalDate.parse(JOptionPane.showInputDialog("Enter start date (YYYY-MM-DD): "));
                    LocalDate input3;
                    if(!input1.equals("Onetime")) {
                        input3 = LocalDate.parse(JOptionPane.showInputDialog("Enter end date (same if onetime): "));
                    }
                    else {
                        input3 = null;
                    }
                    Appointment deleteAppt;

                    switch(input1) {
                        case "Onetime": {
                            deleteAppt = new OnetimeAppointment(input1, input2);
                            manage.delete(deleteAppt);
                            break;
                        }
                        case "Daily": {
                            deleteAppt = new DailyAppointment(input1, input2, input3);
                            manage.delete(deleteAppt);
                            break;
                        }
                        case "Monthly": {
                            deleteAppt = new MonthlyAppointment(input1, input2, input3);
                            manage.delete(deleteAppt);
                            break;
                        }
                    }
                    displayer.refreshDisplay();
                    break;
                }
                case "update": {
                    String input1 = JOptionPane.showInputDialog("Enter description of date to update(Onetime, Daily, Monthly): ");
                    LocalDate input2 = LocalDate.parse(JOptionPane.showInputDialog("Enter start date (YYYY-MM-DD): "));
                    LocalDate input3;
                    if(!input1.equals("Onetime")) {
                        input3 = LocalDate.parse(JOptionPane.showInputDialog("Enter end date (same if onetime): "));
                    }
                    else {
                        input3 = null;
                    }
                    String input4 = JOptionPane.showInputDialog("Enter description of new date(Onetime, Daily, Monthly): ");
                    LocalDate input5 = LocalDate.parse(JOptionPane.showInputDialog("Enter start date (YYYY-MM-DD): "));
                    LocalDate input6;
                    if(!input1.equals("Onetime")) {
                        input6 = LocalDate.parse(JOptionPane.showInputDialog("Enter end date (same if onetime): "));
                    }
                    else {
                        input6 = null;
                    }
                    Appointment old;
                    Appointment newAppt;

                    switch(input1) {
                        case "Onetime": {
                            old = new OnetimeAppointment(input1, input2);
                            newAppt = new OnetimeAppointment(input4, input5);
                            manage.update(old, newAppt);
                            break;
                        }
                        case "Daily": {
                            old = new DailyAppointment(input1, input2, input3);
                            newAppt = new DailyAppointment(input4, input5, input6);
                            manage.update(old, newAppt);
                            break;
                        }
                        case "Monthly": {
                            old = new MonthlyAppointment(input1, input2, input3);
                            newAppt = new MonthlyAppointment(input4, input5, input6);
                            manage.update(old, newAppt);
                            break;
                        }
                    }
                    displayer.refreshDisplay();
                    break;
                }
                case "Appointments on": {
                    LocalDate input1 = LocalDate.parse(JOptionPane.showInputDialog("What date? (YYYY-MM-DD"));
                    String input2 = JOptionPane.showInputDialog("Order preference?");
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
