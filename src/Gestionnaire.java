
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Gestionnaire {
    static ArrayList<Livre> livres = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        while (true) {
            try {
                afficherMenu();
                int choix = scanner.nextInt();
                scanner.nextLine();
                switch (choix) {
                case 1:
                    ajouterLivre();
                    break;
                case 2:
                    supprimerLivre();
                    break;
                case 3:
                    rechercherLivre();
                    break;
                case 4:
                    afficherLivres();
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    System.exit(0);
                default:
                    System.out.println("\nChoix invalide. Veuillez réessayer.");
            }
                
            } catch (InputMismatchException e) {
                System.out.println("Veillez saisir un entier !");
                break;
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

    private static void ajouterLivre() {
        System.out.print("Titre: ");
        String titre = scanner.nextLine();
        System.out.print("Auteur: ");
        String auteur = scanner.nextLine();
        System.out.print("Année de Publication: ");
        int anneePublication = scanner.nextInt();
        int identifiant = livres.size() +1;
        Livre livre = new Livre(titre, auteur, anneePublication, identifiant);
        livres.add(livre);
        System.out.println("Livre ajouté avec succès. Identifiant: " + identifiant);
    }

    private static void supprimerLivre() {
        System.out.print("Identifiant du livre à supprimer: ");
        int identifiant = scanner.nextInt();
        
        Iterator<Livre> iterator = livres.iterator();
        while (iterator.hasNext()) {
            Livre livre = iterator.next();
            if (livre.getIdentifiant() == identifiant) {
                iterator.remove();
                System.out.println("Livre supprimé avec succès.");
                
            }
        }
        System.out.println("\nLivre non trouvé dans la bibliothèque.");
    }

    private static void rechercherLivre() {
        System.out.print("Identifiant du livre à rechercher: ");
        int identifiant = scanner.nextInt();
        for (Livre livre : livres) {
            if (livre.getIdentifiant() == identifiant) {
                
                 System.out.println("Livre trouvé:");
                 System.out.println("Titre: " + livre.getTitre() +
                    ", Auteur: " + livre.getAuteur() +
                    ", Année de Publication: " + livre.getAnneePublication() +
                    ", Identifiant: " + livre.getIdentifiant());
            }
            
        } System.out.println("\nLivre non trouvé dans la bibliothèque.");
        

        
    }

    public static void afficherLivres() {
        if (livres.isEmpty()) {
            System.out.println("\nLa bibliothèque est vide.");
        } else {
            for (Livre livre : livres) {
                System.out.println("Titre: " + livre.getTitre() +
                        ", Auteur: " + livre.getAuteur() +
                        ", Année de Publication: " + livre.getAnneePublication() +
                        ", Identifiant: " + livre.getIdentifiant());
            }
        }
    }
}