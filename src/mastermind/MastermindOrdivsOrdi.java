/**
 *  1=ROUGE
 *  2=BLEU
 *  3=JAUNE
 *  4=VERT
 *  5=ORANGE
 *  6=VIOLET
 */
package mastermind;

/**
 *
 * @author Moustapha Agack
 */
public class MastermindOrdivsOrdi {

    public static int[] getSecret() {
        return secret;
    }

    public static int[] getSolution() {
        return solution;
    }

    public static int[] getTab() {
        return tab;
    }

    static int secret[];
    static int solution[];
    static int tab[];
    
    /**
     * La methode "videtab" vide le tableau <b>tabavider</b> en le remplissant avec des  -1 et que l'on va renvoyer.
     * Cela revient à mettre des valeurs que l'on ne peut pas retrouver dans un Mastermind
     * @param int tabavider[] 
     * @return le tableau tabavider[] qui est vidé.
     */
    public static int[] videtab(int tabavider[]) {
        int i;
        for (i = 0; i < 4; i++) {
            tabavider[i] = -1;
        }
        return tabavider;
    }//vide le tableau
   /**
     * La methode remplitab rempli le tableau <b>tab</b> avec le nombre "chiffre" .
     * Les 4 cellules du tableau auront pour valeur "chiffre".
     * @param int chiffre
     * int tab 
     * 
     */
    public static void remplitab(int chiffre, int tab[]) {
        int i;
        for (i = 0; i < 4; i++) {
            tab[i] = chiffre;
        }
    }//rempli les 4 case du tableau avec "chiffre"
    
    /**
     * La methode affichetab affiche le tableau <b>tabCouleur</b> qui sera rempli à partir du tableau reçu en parametre <b>tab</b> .
     * On remplace les chiffres, qui sont contenus dans le tableau tab par des lettres correspondantes.
     * @param int tab[] 
     * 
     */
    public static void afficheTab(int tab[]){
        int i;
        String tabCouleur[] = new String[4];
        for (i=0;i<4;i++){
            if (tab[i]==-1) tabCouleur[i]="-";
            else if (tab[i]==1) tabCouleur[i]="a";
            else if (tab[i]==2) tabCouleur[i]="b";
            else if (tab[i]==3) tabCouleur[i]="c";
            else if (tab[i]==4) tabCouleur[i]="d";
            else if (tab[i]==5) tabCouleur[i]="e";
            else if (tab[i]==6) tabCouleur[i]="f";
        }
        for(int cpt=0;cpt<4;cpt++){
                        System.out.print(tabCouleur[cpt]);
                        System.out.print(" ");
                    }
                    System.out.print(" ");
       
    }
    
    /**
     * La methode verifcombinaison compare le tableau <b>proposition</b> avec le tableau <b>secret</b>.
     * Le tableau <b>retour</b> contient le nombre de bonnes valeurs biens placés et et le nombre de bonnes couleurs mal placés
     * @param int proposition[] 
     * @return int[]
     */
    
    public static int[] verifcombinaison(int proposition[]) {
        int pb = 0; //un point blanc pour une bonne couleur MAL placée
        int pn = 0;//un point noir  pour une bonne couleur BIEN placée
        int cpt =0;
        int retour[] = new int[2];
        
           boolean àLaMauvaisePlace, placé;
        for(int i=0; i<4; i++){
            àLaMauvaisePlace=false;
            placé=false;
            for(int j=0; j<4; j++){
                if(proposition[i]==secret[j]){
                    if(i==j){
                        pn++;
                        j=4;
                        àLaMauvaisePlace=false;
                        placé=true;    
                        
                    }else{
                        àLaMauvaisePlace=true;        
                    }
                }
            }
            if(àLaMauvaisePlace){
                pb++;                                   
            }
        }

        retour[0] = pb; // Bonne couleur mal placée
        retour[1] = pn;
        return retour;
    }//compare a la combinaison reponse

    /**
     * Constructeur MastermindOrdivsOrdi
     * <p>
     * A la construction du MastermindOrdivsOrdi, une solution est généré aléatoirement et qui sera 
     * stocké dans le tableau <b>secret</b>. Puis, il va utiliser les méthodes de la classe, pour résoudre
     * le mastermind. A chaque verification, on affichera la proposition ainsi que le nombres de bonne couleurs bien placés e mal placés.
     */
    public MastermindOrdivsOrdi() {
        int i;
        secret = new int[4]; //reponse a trouver
        solution = new int[4];// Taleau final ou se trouvera la solution
        tab = new int[4];
        for (i = 0; i < 4; i++) {
            secret[i] = (int) (Math.random() * 6 + 1);
        }
        @SuppressWarnings("UnusedAssignment")
        int point[] = new int[2];
        @SuppressWarnings("UnusedAssignment")
        int temppoint[] = new int[2];
        int temp[] = new int[4];
        int couleur;
        int tentative=0;
        for (couleur = 1; couleur <= 6; couleur++) {

            remplitab(couleur, tab);
            point = verifcombinaison(tab); tentative++;
            afficheTab(tab);
            System.out.print("  :   ");
            if (point[0]==0 || point[1]==0)System.out.print("----");
            for (int r=point[0]; r>0; r--) {
                System.out.print("x");
            }
            for (int r=point[1]; r>0; r--) {
                System.out.print("o");
            }    
            System.out.println(" ");
            
            if (point[1] > 0) {
                for (i = 0; i < 4; i++) {
                    videtab(temp);
                    temp[i] = couleur;
                    temppoint = verifcombinaison(temp); tentative++;
                    afficheTab(temp);
                    System.out.print("  :   ");
                    if (point[0]==0 && point[1]==0)System.out.print("----");
            for (int k=temppoint[0]; k>0; k--) {
                System.out.print("x");
            }
            for (int k=temppoint[1]; k>0; k--) {
                System.out.print("o");
            }    
            System.out.println(" ");
                    /*for (int r=0;r<=temppoint[0];r++) System.out.print("o");
                    for (int r=0;r<=temppoint[1];r++) System.out.print("x");*/
                    if (temppoint[1] == 1) {
                        solution[i] = couleur;
                    }
                }
            }
        }
        System.out.println("Combinaison secrete a trouver");    
        afficheTab(secret);
        System.out.println();
        /*for(i=0;i<4;i++)System.out.print(secret[i]);
        System.out.print("\n");*/
        System.out.println("Combinaison trouvée");       
        afficheTab(solution);
        System.out.println();
        System.out.println("nombre de tentatives");
        System.out.print(tentative);
        System.out.print("\n");





    }
}
