package org.lviv.lgs.homework;

import javax.persistence.*;

@Entity
@Table(name = "universities")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "accreditation_level")
    private int accreditationLevel;
    @Column(name = "number_of_students")
    private int numberOfStudents;
    private String address;

    public University() {
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private int id;
        private String name;
        private int accreditationLevel;
        private int numberOfStudents;
        private String address;

        public Builder setId(int id){
            this.id = id;
            return this;
        }

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setAccreditationLevel(int accreditationLevel){
            this.accreditationLevel = accreditationLevel;
            return this;
        }

        public Builder setNumberOfStudents(int numberOfStudents){
            this.numberOfStudents = numberOfStudents;
            return this;
        }

        public Builder setAddress(String address){
            this.address = address;
            return this;
        }

        public University build(){
            University university = new University();
            university.setId(id);
            university.setName(name);
            university.setAccreditationLevel(accreditationLevel);
            university.setNumberOfStudents(numberOfStudents);
            university.setAddress(address);

            return university;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccreditationLevel() {
        return accreditationLevel;
    }

    public void setAccreditationLevel(int accreditationLevel) {
        this.accreditationLevel = accreditationLevel;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accreditationLevel=" + accreditationLevel +
                ", numberOfStudents=" + numberOfStudents +
                ", address='" + address + '\'' +
                '}';
    }
}
