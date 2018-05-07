package com.cgi.poei.mediatheque;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pret {
	
	public static final int NB_PRETS_AUTORISES = 6;
	
	private final Exemplaire exemplaire;
	private final Usager usager;
	private final LocalDate dateEmprunt;
	private final LocalDate dateRetour;
	
    public Pret(Exemplaire exemplaire, Usager usager, int dureePretEnJour) throws ExemplaireDejaEmprunteException {
        this.exemplaire = exemplaire;
        this.usager = usager;
        this.dateEmprunt = LocalDate.now();
        this.dateRetour = this.dateEmprunt.plusDays(dureePretEnJour);
        this.exemplaire.setPret(this);
    }
    
    public boolean isDepasse() {
    	return this.dateRetour.isBefore(LocalDate.now());
    }
    
    public Exemplaire getExemplaire() {
		return exemplaire;
	}

    @Override
	public String toString() {
    	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM YYYY");
		return usager.getNomComplet() + " emprunte " + 
			   exemplaire.getDocument().getTitre() + 
			   " jusqu'au " + dateTimeFormatter.format(dateRetour);
	}

	
}
