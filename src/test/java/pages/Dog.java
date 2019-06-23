package pages;

public class Dog extends Animal{

    public Dog(String dogName){
        setName(dogName);
    }
    public void bark(){
        System.out.println(getName() + " is barking!");
    }
}
