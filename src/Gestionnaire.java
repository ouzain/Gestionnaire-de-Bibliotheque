
//import java.util.InputMismatchException;
import java.util.Scanner;

public class Gestionnaire {
    Bibliotheque bibliotheque = new Bibliotheque();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bibliotheque bibliotheque = new Bibliotheque();

        while (true) {
            afficherMenu();
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    ajouterLivre(scanner, bibliotheque);
                    break;
                case 2:
                    supprimerLivre(scanner, bibliotheque);
                    break;
                case 3:
                    rechercherLivre(scanner, bibliotheque);
                    break;
                case 4:
                    bibliotheque.afficherLivres();
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    System.exit(0);
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private static void afficherMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Ajouter un livre");
        System.out.println("2. Supprimer un livre");
        System.out.println("3. Rechercher un livre");
        System.out.println("4. Afficher tous les livres");
        System.out.println("5. Quitter");
        System.out.print("Choix: ");
    }

    private static void ajouterLivre(Scanner scanner, Bibliotheque bibliotheque) {
        System.out.print("Titre: ");
        String titre = scanner.nextLine();
        System.out.print("Auteur: ");
        String auteur = scanner.nextLine();
        System.out.print("Année de Publication: ");
        int anneePublication = scanner.nextInt();
        System.out.print("Identifiant: ");
        int identifiant = scanner.nextInt();

        //int identifiant = bibliotheque.afficherLivres().size() + 1;
        Livre livre = new Livre(titre, auteur, anneePublication, identifiant);
        bibliotheque.ajouterLivre(livre);

        System.out.println("Livre ajouté avec succès. Identifiant: " + identifiant);
    }

    private static void supprimerLivre(Scanner scanner, Bibliotheque bibliotheque) {
        System.out.print("Identifiant du livre à supprimer: ");
        int identifiant = scanner.nextInt();
        bibliotheque.supprimerLivre(identifiant);
    }

    private static void rechercherLivre(Scanner scanner, Bibliotheque bibliotheque) {
        System.out.print("Identifiant du livre à rechercher: ");
        int identifiant = scanner.nextInt();
        Livre livre = bibliotheque.rechercherLivre(identifiant);

        if (livre != null) {
            System.out.println("Livre trouvé:");
            System.out.println("Titre: " + livre.getTitre() +
                    ", Auteur: " + livre.getAuteur() +
                    ", Année de Publication: " + livre.getAnneePublication() +
                    ", Identifiant: " + livre.getIdentifiant());
        } else {
            System.out.println("Livre non trouvé dans la bibliothèque.");
        }
    }
}