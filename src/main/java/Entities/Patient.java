package Entities;

import DataEntities.IntValue;
import DataEntities.StackArryList;
import Entities.enums.PriorityStatus;
import Entities.enums.Status;
import Entities.enums.SymptomsStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Patient implements IntValue {

    private String name;
    private String sex;
    private int age;
    private String phone;
    private boolean isPregnant;
    private String RG;
    private Status status;
    private PriorityStatus priorityStatus;
    private StackArryList stackSymptoms;

    public Patient() {

    }

    public Patient(String name, String sex, int age, String phone, String RG, Status status, PriorityStatus prioritystatus, StackArryList stackSymptoms) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.RG = RG;
        this.status = status;
        this.priorityStatus = prioritystatus;
        this.stackSymptoms = stackSymptoms;
    }

    public Patient(String name, String sex, int age, String phone, String RG, StackArryList stackSymptoms) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.RG = RG;
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

    public PriorityStatus getPriorityStatus() {
        return priorityStatus;
    }

    public void setPrioritystatus(PriorityStatus prioritystatus) {
        this.priorityStatus = prioritystatus;
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

    public boolean isIsPregnant() {
        return isPregnant;
    }

    public void setIsPregnant(boolean isPregnant) {
        this.isPregnant = isPregnant;
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

    @Override
    public String toString() {
        return "Nome: " + name + ", Idade " + age + ", Status: " + status + ", Status de Prioridade: " + priorityStatus;
    }

    public void displayStackPatient() {
        stackSymptoms.displayStack();

    }

    @Override
    public int getValue() {
        return priorityStatus.ordinal();
    }

    public void setPriority(Patient patient) {

    }

    public PriorityStatus calculatePriority() {
        if (age <= 12) {
            return PriorityStatus.CRIANCA;
        } else if (age >= 60) {
            return PriorityStatus.IDOSO;
        } else if (isPregnant) {
            return PriorityStatus.GRAVIDA;
        }
        return PriorityStatus.COMUM;
    }

    private static final Map<SymptomsStatus, Status> statusMap = new HashMap<>();

    static {
        statusMap.put(SymptomsStatus.GRAVISSIMO, Status.EMERGENCIA);
        statusMap.put(SymptomsStatus.GRAVE, Status.MUITO_URGENTE);
        statusMap.put(SymptomsStatus.NORMAL, Status.URGENTE);
        statusMap.put(SymptomsStatus.LEVE, Status.POUCO_URGENTE);
        statusMap.put(SymptomsStatus.MUITO_LEVE, Status.NAO_URGENTE);
    }

    public Status mapSymptomsToStatus(SymptomsStatus symptomsStatus) {
        return statusMap.get(symptomsStatus);
    }

    public void setStatusPatients(Patient patient) {
        SymptomsStatus symptomsFreq = patient.getStackSymptoms().showFrequentSymptom();
        int countFreqSymptoms = patient.getStackSymptoms().maxSymptomsStatus();
        Status patientStatus;
        if (patient.getStackSymptoms().checkSymptomsCritical()) {
            symptomsFreq = SymptomsStatus.GRAVISSIMO;
            patientStatus = mapSymptomsToStatus(symptomsFreq);
        } else if (patient.getStackSymptoms().checkSymptomsSerious()) {
            symptomsFreq = SymptomsStatus.GRAVE;
            patientStatus = mapSymptomsToStatus(symptomsFreq);
        } else if (countFreqSymptoms >= 3 && symptomsFreq == SymptomsStatus.GRAVE) {
            patientStatus = mapSymptomsToStatus(nextSymptomsStatus(symptomsFreq));
        } else {
            patientStatus = mapSymptomsToStatus(symptomsFreq);
        }
        patient.setStatus(patientStatus);
    }

    private SymptomsStatus nextSymptomsStatus(SymptomsStatus currentStatus) {
        int currentIndex = currentStatus.ordinal();
        int nextIndex = (currentIndex + 1) % SymptomsStatus.values().length;
        return SymptomsStatus.values()[nextIndex];
    }

}
