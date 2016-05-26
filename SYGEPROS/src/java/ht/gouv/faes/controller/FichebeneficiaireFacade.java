/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.gouv.faes.controller;

import ht.gouv.faes.entity.Fichebeneficiaire;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Benucci
 */
@Stateless
public class FichebeneficiaireFacade extends AbstractFacade<Fichebeneficiaire> {
    @PersistenceContext(unitName = "SYGEPROSPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FichebeneficiaireFacade() {
        super(Fichebeneficiaire.class);
    }
    
}
