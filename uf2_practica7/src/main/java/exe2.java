/*
Escriu una funció anomenada “CalcularIVA” a la que se li passa un preu, un
tipus d’IVA i la data de la compra i retorna el preu amb l’IVA aplicat. El tipus
d’IVA pot ser General, Reduït, Superreduït o Exempt. El percentatge a aplicar
és el vigent en la data de compra
 */

import java.util.Scanner;
import utils.Utils;

public class exe2 {
    
    static double calcularIVA(double preu, int iva, String date){
        double resultat = 0;
        
        String[] datesplit = date.split("-");
        
        int dia =  Integer.parseInt(datesplit[0]);
        int mes =  Integer.parseInt(datesplit[1]);
        int any =  Integer.parseInt(datesplit[2]);
        
        switch(iva){
            case 1: // General
                resultat = calcularGeneral(preu, dia, mes, any);
                break;
            case 2: // Reduit
                resultat = calcularReduit(preu, dia, mes, any);
                break;
            case 3: // SuperReduit
                resultat = calcularSuperReduit(preu, dia, mes, any);
                break;
            case 4: // Exempt
            default:
                resultat = preu;
                break;
        }

        return resultat;
    }
    
    static double calcularGeneral(double preu, int dia, int mes, int any){
        double resultat;
      
        if(any < 1992){
            resultat = preu * 1.12;          
        }else if(any < 1995){
            resultat = preu * 1.15; 
        }else if(any < 2010){
            resultat = preu * 1.16; 
        }else if(any < 2012 || (any == 2012 && (mes < 7 || (mes == 7 && dia < 15)))) {
            resultat = preu * 1.18; 
        }else{
            resultat = preu * 1.21; 
        }
        
        return resultat;
    }
    
    static double calcularReduit(double preu, int dia, int mes, int any){
        double resultat;

        if(any < 1995){
            resultat = preu * 1.06;          
        }else if(any < 2010){
            resultat = preu * 1.07; 
        }else if(any < 2012 || (any == 2012 && (mes < 7 || (mes == 7 && dia < 15)))) {
            resultat = preu * 1.08; 
        }else{
            resultat = preu * 1.10; 
        }
        
        return resultat;
    }
    
    static double calcularSuperReduit(double preu, int dia, int mes, int any){
        double resultat;
        
        if(any < 1993){
            resultat = preu;          
        }else if(any < 1995){
            resultat = preu * 1.03; 
        }else{
            resultat = preu * 1.04; 
        }
        
        return resultat;
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        
        System.out.println(" Introdueix el preu : "); 
        double preu = utils.Utils.LlegirDouble();
        System.out.println(" Introdueix la data : ");
        String date = scan.nextLine();
        System.out.println(" Introdueix un tipus d'IVA ; ");
        int iva = utils.Utils.LlegirInt();
        
        double resultat = calcularIVA(preu, iva, date);
        
        System.out.println("El preu amb iva es: " + resultat);
    }
}
