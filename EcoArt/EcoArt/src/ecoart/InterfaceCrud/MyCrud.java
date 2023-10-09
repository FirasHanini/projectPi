/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecoart.InterfaceCrud;

import ecoart.Utilisateur.Utilisateur;

/**
 *
 * @author Utilisateur 2
 */
public interface MyCrud {
        public int ajouterUtilisateur(Utilisateur u);
    public int supprimerUtilisateur(Utilisateur u);
    public Utilisateur chercherUtilisateur (Utilisateur u);
    public Utilisateur updateUtilisateur (Utilisateur u);
    
}
