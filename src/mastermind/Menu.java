/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author p1203779
 */
public class Menu {

    public static void main(String[] args) throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(isr);

        int choix;
        do {
            System.out.println("==================MENU==================");
            System.out.println("|  1.Mode ordinateur vs ordinateur     |");
            System.out.println("|  2.Mode joueur vs Ordinateur         |");
            System.out.println("|  3.Mode joueur vs Joueur             |");
            System.out.println("|  4.Regles                            |");
            System.out.println("|  5.Quitter                           |");
            System.out.println("========================================");

            choix = Integer.parseInt(bf.readLine());
            
            switch (choix) {
                case 1 :
                          MastermindOrdivsOrdi mode1 = new MastermindOrdivsOrdi();
                    break;
                case 2 :  Mastermind1 mode2 = new Mastermind1();
                    break;
                case 3 :  JoueurVsJoueur mode3 = new JoueurVsJoueur();
                    break;
                case 4 : System.out.println(
                    "Regles du jeu:\n"
                    +"-une combinaison secrete de 4 couleurs distinctes (lettres\n" 
                    +" comprises entre a et f) est generee\n"
                    +"-a chaque tour l'utilisateur entre une proposition et lit un\n"
                    +" code en retour:\n"
                    +"-pour chaque couleur:\n"
                    +"        'o' indique que la couleur est a la bonne place\n"
                    +"        'x' indique que la couleur existe dans la combinaison\n"
                    +"        mais qu'elle est a la mauvaise place\n"
                    +"        '-' indique que la couleur n'existe pas dans la\n"
                    +"        combinaison secrete");
                    break;
                case 5 : 
                    break;   
                default : System.out.println("Vous ne respectez pas ce qu'on vous dit !");         
            }
            
           
        } while (choix != 4);
    }
}
