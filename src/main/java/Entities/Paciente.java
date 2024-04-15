
package Entities;
import DataEntities.Queue;
import Entities.enums.Status;


public class Paciente {
    private String nome;
    private String sexo;
    private int idade;
    private String telefone;
    private String RG;
    private Status status;
    private Queue  filaSintomas;
    
    public Paciente(){
        
    }
    
    public Paciente(String nome, String sexo, int idade, String telefone, String RG, Status status){
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.telefone = telefone;
        this.RG = RG;
        this.status = status;
        Queue filaSintomas = new Queue();
        
        
    }
    
    
    
    
     

    
    
    
    
    
}
