package Entities;

import DataEntities.QueueSymptoms;
import Entities.enums.PriorityStatus;
import Entities.enums.Status;
import java.awt.Image;
import java.util.Objects;

public class Patient {

    private String name;
    private String sex;
    private int age;
    private boolean isPregnant;
    private String RG;
    private Status status;
    private PriorityStatus priorityStatus;
    private QueueSymptoms listSymptoms;
    private int score;
    private Image photoPatient;

    public Patient() {
    }

    public Patient(String name, String sex, int age, boolean isPregnant, String RG, QueueSymptoms listSymptoms) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.isPregnant = isPregnant;
        this.RG = RG;
        this.listSymptoms = listSymptoms;
        this.score = listSymptoms.calculateTotalScore();
        priorityPatient();
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

    public PriorityStatus getPriorityStatus() {
        return priorityStatus;
    }

    public void setPriorityStatus(PriorityStatus priorityStatus) {
        this.priorityStatus = priorityStatus;
    }

    public QueueSymptoms getListSymptoms() {
        return listSymptoms;
    }

    public void setListSymptoms(QueueSymptoms listSymptoms) {
        this.listSymptoms = listSymptoms;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean IsPregnant() {
        return isPregnant;
    }

    public void setIsPregnant(boolean isPregnant) {
        this.isPregnant = isPregnant;
    }

    public Image getPhotoPatient() {
        return photoPatient;
    }

    public void setPhotoPatient(Image photoPatient) {
        this.photoPatient = photoPatient;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.RG);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Patient other = (Patient) obj;
        return Objects.equals(this.RG, other.RG);
    }

    /*@Override
    public String toString() {
        return "Nome: " + name + ", Idade " + age + ", Status: " + status + ", Status de Prioridade: " + priorityStatus;
    }*/
    
    @Override
    public String toString() {
        return "Patient{" + "name=" + name + ", sex=" + sex + ", age=" + age + ", isPregnant=" + isPregnant + ", RG=" + RG + ", status=" + status + ", priorityStatus=" + priorityStatus + ", listSymptoms=" + listSymptoms + ", score=" + score + '}';
    }

    public void displayStackPatient() {
        listSymptoms.displayQueue();

    }

    public void calculatePriority() {
        if (age <= 12) {
            setPriorityStatus(PriorityStatus.CRIANCA);
        } else if (age >= 60) {
            setPriorityStatus(PriorityStatus.IDOSO);
        } else if (isPregnant) {
            setPriorityStatus(PriorityStatus.GRAVIDA);
        } else {
            setPriorityStatus(PriorityStatus.COMUM);
        }
    }

    public void setStatusPatients() {
        if (score >= 1000) {
            setStatus(Status.EMERGENCIA);
        } 
        else if (score >= 400 && score < 1000) {
            setStatus(Status.MUITO_URGENTE);
        } 
        else if (score >= 100 && score < 400) {
            setStatus(Status.URGENTE);
        }
        else if (score >= 20 && score < 100) {
            setStatus(Status.POUCO_URGENTE);
        } 
        else {
            setStatus(Status.NAO_URGENTE);
        }
    }

    public void priorityPatient() {
        calculatePriority();
        setStatusPatients();
    }
    
    
}
