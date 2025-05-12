package assignment4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class AppointmentDisplayer extends JPanel implements ActionListener {
    private AppointmentManager manage;
    private JPanel controls;
    private JList apptDates;
    private DefaultListModel<String> listModel;
    private JButton add, delete, update;

    public AppointmentDisplayer(AppointmentManager manage) {
        this.manage = manage;
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(600,250));
        setBackground(Color.LIGHT_GRAY);

        listModel = new DefaultListModel<>();
        apptDates = new JList<>(listModel);
        apptDates.setVisibleRowCount(10);
        apptDates.setFixedCellWidth(200);
        add(new JScrollPane(apptDates), BorderLayout.CENTER);


        for(Appointment apt : manage.getAppointments()) {
            listModel.addElement(apt.toString());
        }


        controls = new JPanel();
        add = new JButton("add");
        delete = new JButton("delete");
        update = new JButton("update");

        controls.add(add);
        controls.add(delete);
        controls.add(update);

        add(controls, "West");
        setListeners();
    }

    public void refreshDisplay() {
        listModel.clear();
        for(Appointment apt : manage.getAppointments()) {
            listModel.addElement(apt.toString());
        }
    }

    public void setListeners() {
        add.addActionListener(this);
        delete.addActionListener(this);
        update.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        try {
            switch(cmmd) {
                case "add": {
                    String input1 = JOptionPane.showInputDialog("Enter description (Onetime, Daily, Monthly): ");
                    LocalDate input2 = LocalDate.parse(JOptionPane.showInputDialog("Enter start date (YYYY-MM-DD): "));
                    LocalDate input3 = LocalDate.parse(JOptionPane.showInputDialog("Enter end date (same if onetime): "));

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
                    refreshDisplay();
                    break;
                }
                case "delete": {
                    String input1 = JOptionPane.showInputDialog("Enter description (Onetime, Daily, Monthly): ");
                    LocalDate input2 = LocalDate.parse(JOptionPane.showInputDialog("Enter start date (YYYY-MM-DD): "));
                    LocalDate input3 = LocalDate.parse(JOptionPane.showInputDialog("Enter end date (same if onetime): "));

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
                    refreshDisplay();
                    break;
                }
                case "update": {
                    String input1 = JOptionPane.showInputDialog("Enter description of date to update(Onetime, Daily, Monthly): ");
                    LocalDate input2 = LocalDate.parse(JOptionPane.showInputDialog("Enter start date (YYYY-MM-DD): "));
                    LocalDate input3 = LocalDate.parse(JOptionPane.showInputDialog("Enter end date (same if onetime): "));

                    String input4 = JOptionPane.showInputDialog("Enter description of new date(Onetime, Daily, Monthly): ");
                    LocalDate input5 = LocalDate.parse(JOptionPane.showInputDialog("Enter start date (YYYY-MM-DD): "));
                    LocalDate input6 = LocalDate.parse(JOptionPane.showInputDialog("Enter end date (same if onetime): "));

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
                    refreshDisplay();
                    break;
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


    public static void main(String[] args) {
        AppointmentManager manage = new AppointmentManager();
        AppointmentDisplayer gui = new AppointmentDisplayer(manage);

        JFrame frame = new JFrame("Appointments");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(gui);
        frame.pack();
        frame.setVisible(true);


    }


}
