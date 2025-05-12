package assignment4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Comparator;

public class AppointmentDisplayer extends JFrame implements ActionListener {
    private AppointmentManager manage;
    private JList apptDates;
    private DefaultListModel<String> listModel;

    private JPanel controls;
    private JButton filter, showAllButton, nat, desc;

    public AppointmentDisplayer(AppointmentManager manager) {
        this.manage = manager;
        setTitle("Appointments");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        listModel = new DefaultListModel<>();
        apptDates = new JList<>(listModel);
        apptDates.setVisibleRowCount(10);
        apptDates.setFixedCellWidth(250);
        add(new JScrollPane(apptDates), BorderLayout.CENTER);


        for(Appointment apt : manage.getAppointments()) {
            listModel.addElement(apt.toString());
        }

         controls = new JPanel();
         filter = new JButton("Filter by Date");
         showAllButton = new JButton("Show All");
         nat = new JButton("Disp by Date");
         desc = new JButton("Disp by Description");


         filter.addActionListener(this);
         showAllButton.addActionListener(this);

         controls.add(filter);
         controls.add(showAllButton);
         controls.add(nat);
         controls.add(desc);

         add(controls, BorderLayout.NORTH);

        JButton editButton = new JButton("Edit Appointments");
        editButton.addActionListener(e -> new AppointmentEditor(this, manager));
        add(editButton, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public void refreshDisplay() {
        listModel.clear();
        for(Appointment apt : manage.getAppointments()) {
            listModel.addElement(apt.toString());
        }
    }


    public void refreshDisplay(Appointment[] appointments) {
        listModel.clear();
        for(Appointment apt : manage.getAppointments()) {
            listModel.addElement(apt.toString());
        }
    }

    public void actionPerformed(ActionEvent e) {
        String cmmd = e.getActionCommand();
        try {
            switch(cmmd) {
                case "Show All": {
                    refreshDisplay(manage.getAppointmentsOn(null, null));
                    break;
                }
                case "Filter by Date": {
                    try {
                        LocalDate date = LocalDate.parse(JOptionPane.showInputDialog("Enter start date (YYYY-MM-DD): "));
                            Appointment[] filtered = manage.getAppointmentsOn(date, null); // natural order
                            refreshDisplay(filtered);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Invalid date format. Use yyyy-mm-dd.");
                    }
                    break;
                }
                case "Disp by Date": {
                    Comparator<Appointment> byDate = Comparator.comparing(Appointment::getStartDate);
                    refreshDisplay(manage.getAppointmentsOn(null, byDate));
                    break;
                }
                case "Disp by Description": {
                    Comparator<Appointment> byDescription = Comparator.comparing(Appointment::getDescription);
                    refreshDisplay(manage.getAppointmentsOn(null, byDescription));
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
