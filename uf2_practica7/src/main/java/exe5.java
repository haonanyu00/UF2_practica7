/*
Escriu un procediment anomenat “Titol” que donat un text, el mostri per
pantalla de forma centrada. Pots assumir que la pantalla té un ample de 80
caràcters.
*/

import java.util.Scanner;
import utils.Utils;

public class exe5 {
    
    static void titol(String title){
        final int ample = 80;
        String text = "";
        int longitudtext = title.length();
        for(int i=0; i< (ample - longitudtext) / 2; i++){
            text += " ";
        }
        text += title;
        System.out.println(text);
    }
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.println(" Introdueix un text : ");
        String text = scan.nextLine();

        titol(text);
        
    }
}
