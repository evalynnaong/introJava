package assignment2;

public class Student implements Comparable<Student>{
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(int id) {
        this.id = id;
        this.name = "Unnamed";
    }

    public int getId() {return id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    //needed to implement an equals method here so that they could actually compare
    //here equals would have compared id
    //comparable is tree
    //equals is for hash


    //did not initially do this in assignment 2:
    public int compareTo(Student student2) {
        return Integer.compare(id, student2.getId());

        /*if(id < student2.getId()){
            return -1;
        } else if (id > student2.getId()){
            return 1;
        } else{
        return 0;
        }*/
    }
}
