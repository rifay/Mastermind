/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;
import java.awt.*;  
import java.io.Console;
import java.util.Scanner;
/**
 *
 * @author p1203779
 */
public class Mastermind1 {
    
     private static Scanner scanner = new Scanner(System.in);
    
     public  Mastermind1(){
        Combinaison combiSecrète = new Combinaison();
        String combiDuJoueur, codeRésultat;
        
        for(int i=10; i>0; i--){
            System.out.println("Vous avez encore "+i+" chances, entrez une"
                              +" combinaison svp:");
            
            do{
                combiDuJoueur=scanner.next();
                if (combiDuJoueur.equals("Q"))System.exit(0);
                

               if(!entréeLueValide(combiDuJoueur)){
                    System.out.println("Vous devez entrer une chaine de 4\n"
                                      +"caracteres (compris entre 'a' et 'f')");    
                }    
            }while(!entréeLueValide(combiDuJoueur));
            codeRésultat=combiSecrète.comparer(combiDuJoueur);
            System.out.println("Voici le resultat de votre proposition:"
                                +codeRésultat);
            if(combiSecrète.trouvée){
                System.out.println("Bravo, vous avez trouver la combinaison\n"
                                  +"secrete!!!!");
                i=0;    
            }    
        }
        if(!combiSecrète.trouvée){
            System.out.println("Perdu, la combinaison secrete etait:");
            combiSecrète.afficher();    
        }
        System.out.println("Programme termine");
    }
    
    public static boolean entréeLueValide(String chaine){
        
        if(chaine.length()!=4){
            return false;    
        }
        
        
        for(int i=0; i<4; i++){
            if(chaine.charAt(i)<'a' || chaine.charAt(i)>'f'){
                return false;    
            }    
        }
        return true;    
    }    
}

