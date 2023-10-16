public class Main {
    public static void main(String[] args) {
        // initialise char pour afficher le tableau
        char [][] tableau = {
                {'1','2','3'},
                {'4','5','6'},
                {'7','8','9'}
        };

        // initialisation d'un int pour le jouer
        int tour = 1;
        boolean victoire = false;

        while (!victoire) {
            afficheLaGrille(tableau);

            int choix;

            if (tour == 1) {
                choix = demandetour("Joueur X, choississez une case (1-9) : ");
            } else {
                choix = demandetour("Joueur O, choississez une case (1-9) : ");
            }

            if (placeCoup(tableau, choix, tour)) {
                victoire = verifiVictoire(tableau, tour);
                if (victoire) {
                    afficheLaGrille(tableau);
                    System.out.println("le joueur" + (tour == 1 ? "X" : "O") + " a gagner");
                } else if (tableauRemplie(tableau)) {
                    afficheLaGrille(tableau);
                    System.out.println("Egalité");
                    break;
                }
                tour = (tour == 1) ? 2 : 1;
            } else {
                System.out.println("case remplie, veuillez ressayer");
            }
        }
    }



    public static void afficheLaGrille(char[][] tableau) {}




    public static int demandetour(String message) {}




    public static boolean placeCoup(char[][] tableau, int choix, int tour) {}


    public static boolean verifiVictoire(char[][] tableau, int tour) {}




    public static boolean tableauRemplie(char[][] tableau) {}








}
