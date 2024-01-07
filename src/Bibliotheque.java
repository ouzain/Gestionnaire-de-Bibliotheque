import java.util.ArrayList;
import java.util.Iterator;

class Bibliotheque {
    private ArrayList<Livre> livres = new ArrayList<>();

    public void ajouterLivre(Livre livre) {
        livres.add(livre);
    }

    public void supprimerLivre(int identifiant) {
        Iterator<Livre> iterator = livres.iterator();
        while (iterator.hasNext()) {
            Livre livre = iterator.next();
            if (livre.getIdentifiant() == identifiant) {
                iterator.remove();
                System.out.println("Livre supprimé avec succès.");
                
            }
        }
        System.out.println("Livre non trouvé dans la bibliothèque.");
    }

    public Livre rechercherLivre(int identifiant) {
        for (Livre livre : livres) {
            if (livre.getIdentifiant() == identifiant) {
                return livre;
            }
        }
        return null;
    }

    public void afficherLivres() {
        if (livres.isEmpty()) {
            System.out.println("La bibliothèque est vide.");
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