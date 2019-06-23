package pages;

public abstract class Animal {
    private String name;

    public Animal(){
        name = "nameless";
    }

    public void walk(){
        System.out.println(getClass() + " is walking");
    }

    public void sleep(){
        System.out.println(getClass() + "is sleeping");
    }

    public void eat (String food){
        System.out.println(getClass() + " is eating " + food);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
