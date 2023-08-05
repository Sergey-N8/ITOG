package lesson2;

public class Toy {
    private int id;
    private double weight;
    private String name;


    public Toy(int id, double weight, String name) {   
        this.id = id;
        this.weight = weight;
        this.name = name;
    }
    
    public int getId(){
        return id;
    }

    public double getWeight(){
        return weight;
    }

    public String getName(){
        return name;
    }

    public void displayInfo(){
        System.out.printf("id Игрушки: %d, Вес игрушки: %.2f, Назвение игрушки: %s,", 
        id, weight, name);
    }


}
