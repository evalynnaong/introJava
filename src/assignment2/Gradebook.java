package assignment2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Gradebook {
    Map<Student, Character> gradeBook;

    public Gradebook() {
        gradeBook= new HashMap<> ();
    }

    public boolean validGrade(char grade) {
        return grade == 'A' || grade == 'B' || grade == 'C' || grade == 'D' || grade == 'F' || grade == 'N';
    }

    public boolean addStudent(Student student, char grade) {
        if (!validGrade(grade)){
            grade = 'N';
        }

        if (gradeBook.containsKey(student)){ // student already exists in gradebook
            return false;
        } else {
            gradeBook.put(student, grade);
            return true;
        }
    }

    public boolean addStudent(Student student) {
        char grade = 'N';
        return addStudent(student, grade);
    }

    // rewrite below since code redundant...

    public boolean deleteStudent(int id) {
        for (Map.Entry<Student, Character> student : gradeBook.entrySet()) { // iterate thru gradebook
            int studentID = student.getKey().getId();
            if(studentID == id) {
                gradeBook.remove(student.getKey());
                return true;
            }
        } // iterated thru entire gradebook map
        return false;
    }

    public boolean updateStudent(int id, String newName) { // instead could create new student object to check and compare
        for (Map.Entry<Student, Character> student : gradeBook.entrySet()) { // iterate thru gradebook
            int studentID = student.getKey().getId();
            if(studentID == id) {
                student.getKey().setName(newName);
                return true;
            }
        } // iterated thru entire gradebook map
        return false;
    }

    public boolean updateGrade(int id, char newGrade) {
        for (Map.Entry<Student, Character> student : gradeBook.entrySet()) { // iterate thru gradebook
            int studentID = student.getKey().getId();
            if(studentID == id) {
                gradeBook.replace(student.getKey(), newGrade);
                return true;
            }
        } // iterated thru entire gradebook map
        return false;
    }

    public void printGrades(Comparator<Student> comparator) {
        for (Map.Entry<Student, Character> student : gradeBook.entrySet()) { // iterate thru gradebook
            System.out.println(student.getKey().getId() + "." + student.getKey().getName() + ": " + student.getValue());

        } // iterated thru entire gradebook map

    }
}
