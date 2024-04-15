
package DataEntities;

public class Stack { 
    private int [] array;
    private int top;
    private int capacity;
    
    
    public Stack(int size){
        this.array = new int [size];
        this.capacity = size;
        this.top = -1;
    }
    
    public void push(int value){
        if (isFull()){
            throw new IllegalStateException("Pilha cheia");
    }
        this.array[++this.top] = value;
    }
    
    public int pop(){
        if(isEmpty()){
            throw new IllegalStateException("Pilha vazia");
        }
        return this.array[this.top--];
    }
    
    public int peak(){
        if(this.top == -1){
            throw new IllegalStateException("Não foi possível mostrar item! Pilha vazia");
        }
        return this.array[this.top];
    }
     
    public boolean isEmpty(){
        return this.top == -1;
    }
    
    public boolean isFull(){
        return this.top == (this.capacity -1);
    }
    
    
    
}
