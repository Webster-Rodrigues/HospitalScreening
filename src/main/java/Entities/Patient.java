
package Entities;
import DataEntities.Queues;
import Entities.enums.Status;


public class Patient {
    private String nome;
    private String sexo;
    private int idade;
    private String telefone;
    private String RG;
    private Status status;
    private Queues  filaSintomas;
    
    public Patient(){
        
    }
    
    public Patient(String nome, String sexo, int idade, String telefone, String RG, Status status){
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.telefone = telefone;
        this.RG = RG;
        this.status = status;
        Queues filaSintomas = new Queues();
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
    
     public int getPriority(Status status) {
        return status.ordinal(); 
    }
    
    
    
    
     

    
    
    
    
    
}
