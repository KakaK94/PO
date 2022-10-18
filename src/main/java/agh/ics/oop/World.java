package agh.ics.oop;
import static java.lang.System.out;
import java.util.Scanner;

public class World {
    public static void run(String argument){

        String direction = switch(argument){
            case "f" -> "Do przodu";
            case "b" -> "Do tyłu";
            case "r" -> "W prawo";
            case "l" -> "W lewo";
            default -> "Nieznana komenda";
        };
        out.println(direction);
      /*  String[] ruch={"do przodu", "do tylu", "w prawo", "w lewo"};
        System.out.println("zwierzak idzie do przodu \n");
        for(int i=0; i< (ruch.length-1);i++){
        System.out.println(ruch[i]+",");
        }
        System.out.println(ruch[3]); */
    }


    public static void main(String[] args){
        out.println("Start");
        Scanner input = new Scanner(System.in);
        String where = input.nextLine();
        run(where);
        out.println("Stop");
    }
}
