package lesson2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {

        Map<Toy, Integer> toys = new HashMap<>();
        int count = 0;
        double resultWeight = 0;
        Random r = new Random();
        List<Toy> toysForwiners = new ArrayList<>();
        File f = new File("C:/Users/rezyn/Desktop/ITOG/lesson2/ListOfWiners.txt");
        PrintWriter pw = new PrintWriter(f);

        ArrayList<String> winers = new ArrayList<String>();
        winers.addAll(Arrays.asList("Миша", "Паша", "Маша", "Оля", "Игорь", "5", "6", "7", "8"));

        Toy constructor = new Toy(1, 3.0, "constructor");
        Toy robot = new Toy(2, 6.0, "robot");
        Toy doll = new Toy(3, 1.0, "doll");

        toys.put(constructor, 5);
        toys.put(robot, 5);
        toys.put(doll, 5);

        for (Map.Entry<Toy, Integer> entry : toys.entrySet()){
            entry.getKey().displayInfo();  
            System.out.println(" Колличество игрушек в автомате: " + entry.getValue());
        }

        for (Map.Entry<Toy, Integer> entry : toys.entrySet()){
            if (entry.getValue() > 0){
                count = count + entry.getValue();
            }
            else{
                System.out.println("Внимание! Игрушки " + entry.getKey().getName() + " закончились!");
            }
        }

        while (count > 0){
            for (Map.Entry<Toy, Integer> entry : toys.entrySet()){
                if (entry.getValue() > 0){
                    resultWeight = resultWeight + entry.getKey().getWeight();
                }
            }

            double rndRes = resultWeight * r.nextDouble();

            for (Map.Entry<Toy, Integer> entry : toys.entrySet()){
                if (rndRes - entry.getKey().getWeight() < 0 && entry.getValue() > 0){
                    //System.out.println("Поздравляю, вы выиграли: " + entry.getKey().getName());
                    toysForwiners.add(entry.getKey());
                    toys.put(entry.getKey(), toys.get(entry.getKey()) - 1);
                    break;
                }
                rndRes = rndRes - entry.getKey().getWeight();
            }
            resultWeight = 0;
            count = count - 1;
        }

        while (!(winers.isEmpty() | toysForwiners.isEmpty())){
            pw.println(winers.get(0) + " получил " + toysForwiners.get(0).getName());
            winers.remove(0);
            toysForwiners.remove(0);
        }
        pw.close();

        int addValue = 10;

        for (Map.Entry<Toy, Integer> entry : toys.entrySet()){
            if (entry.getKey().getId() == 2){
                toys.put(entry.getKey(), toys.get(entry.getKey()) + addValue);
                System.out.println("Поздравляю Вы успешно пополнили: " + entry.getKey().getName());
            }
            
            
        }

        for (Map.Entry<Toy, Integer> entry : toys.entrySet()){
            entry.getKey().displayInfo();  
            System.out.println(" Колличество игрушек в автомате: " + entry.getValue());
        }

    }

}
