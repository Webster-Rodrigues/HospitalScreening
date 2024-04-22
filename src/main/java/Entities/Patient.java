
package Entities;
import DataEntities.StackArryList;
import DataEntities.Symptoms;
import Entities.enums.Status;


public class Patient {
    private String name;
    private String sex;
    private int age;
    private String phone;
    private String RG;
    private Status status;
    private StackArryList stackSymptoms;
    
    public Patient(){
        
    }
    
    public Patient(String name, String sex, int age, String phone, String RG, Status status, StackArryList stackSymptoms) {
    this.name = name;
    this.sex = sex;
    this.age = age;
    this.phone = phone;
    this.RG = RG;
    this.status = status;
    this.stackSymptoms = stackSymptoms; 
}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public StackArryList getStackSymptoms() {
        return stackSymptoms;
    }

    public void setStackSymptoms(StackArryList stackSymptoms) {
        this.stackSymptoms = stackSymptoms;
    }

    
    
    /*public void setPriority(Patient patient){
        
    }*/
    
    @Override
    public String toString(){
        return "Nome: " + name + ", Idade " + age + ", Status: " + status; 
    }
    
    
    
    
}
