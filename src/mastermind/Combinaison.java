/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

/**
 *
 * @author p1203779
 */
 public class Combinaison{
    
    private static String combinaisonSecrète;
    public static boolean trouvée;
    
    public Combinaison(){
        combinaisonSecrète="";
        trouvée=false;    
        combinaisonSecrète=générerUneCombinaison();
    }
    
    public Combinaison(String solution){
        combinaisonSecrète=solution;
        trouvée=false;          
    }
    
    private static String générerUneCombinaison(){
        String combinaisonGénérée="";
        char couleur;
        int entier;
        int[] tableau=new int[6];
        
        for(int i=0; i<6; i++){
            tableau[i]=i;    
        }    
        for(int i=0; i<4; i++){
            couleur='a';
            entier=unEntierAuHasardEntre(0, 5-i);
            couleur+=tableau[entier];
            combinaisonGénérée+=couleur;
            for(int j=entier; j<(5-i); j++){
                tableau[j]=tableau[j+1];    
            }    
        }
        return combinaisonGénérée;
    }
    
    public static String comparer(String combinaisonDuJoueur){
        String résultat="";
        boolean àLaMauvaisePlace, placé;
        for(int i=0; i<4; i++){
            àLaMauvaisePlace=false;
            placé=false;
            for(int j=0; j<4; j++){
                if(combinaisonDuJoueur.charAt(i)==
                    combinaisonSecrète.charAt(j)){
                    if(i==j){
                        résultat+='o';
                        j=4;
                        àLaMauvaisePlace=false;
                        placé=true;    
                    }else{
                        àLaMauvaisePlace=true;        
                    }
                }
            }
            if(àLaMauvaisePlace){
                résultat+='x';    
            }else{
                if(!placé) résultat+='-';    
            }    
        }
        if(résultat.equals("oooo")){
                trouvée=true;    
        }
        return résultat;    
    }
    
    public static void afficher(){
        System.out.println(combinaisonSecrète);    
    }
    
    private static int unEntierAuHasardEntre(int valeurMinimale,
                                                int valeurMaximale){
        double nombreRéel;
        int résultat;
        nombreRéel= Math.random();
        résultat=(int) (nombreRéel*(valeurMaximale-valeurMinimale+1))
                        +valeurMinimale;                                                
        return résultat;
    }
}

