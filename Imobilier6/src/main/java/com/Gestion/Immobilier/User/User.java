package com.Gestion.Immobilier.User;

import com.Gestion.Immobilier.Annoncements.Annonce.Announcements;
import com.Gestion.Immobilier.Annoncements.OtherAnnouncements.OtherAnnouncement;
import com.Gestion.Immobilier.Annoncements.OtherAnnouncements.OtherInfo.InfodeBases.*;
import com.Gestion.Immobilier.Annoncements.OtherAnnouncements.OtherInfo.InfoDetaillees.*;
import com.Gestion.Immobilier.Annoncements.ProjectAnnouncements.ProjectAnnouncement;

import com.Gestion.Immobilier.Annoncements.ProjectAnnouncements.ProjectInfo.InfoDetaillees.*;
import com.Gestion.Immobilier.Annoncements.ProjectAnnouncements.ProjectInfo.InfodeBase.*;
import com.Gestion.Immobilier.Annoncements.coordonnees;
import org.springframework.data.annotation.Id;

import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Data
public class User {

	@Id
	private UUID id;
	private String fullName;
    private String email;
    private String type;
    private long tel;
    private long whatsApp;
    private String gender;
    private Address address;
    private String password;
	private List<Announcements> announcements;
    private List<Announcements> saved;

	public User(String fullName, String email, long tel, long whatsApp, String gender, Address address, String password,String type) {
		this.id = UUID.randomUUID();
		this.fullName = fullName;
		this.email = email;
        this.type = type;
		this.tel = tel;
		this.whatsApp = whatsApp;
		this.gender = gender;
		this.address = address;
		this.password = password;
        announcements = new ArrayList<>();
        saved = new ArrayList<>();
	}

    public void addProjectAnnouncement(ProjectAnnouncement annonce) {
        announcements.add(new ProjectAnnouncement(annonce.getTitle(), annonce.getAddress(),
                annonce.getPrix(), annonce.getTypeDeBien(), annonce.getGeneral(), annonce.getParticularite(),
                annonce.getDescription(), annonce.getCoordonnees()));
    }

    public void addOtherAnnouncement(String typeAnnonce,OtherAnnouncement annonce) {
        announcements.add(new OtherAnnouncement(typeAnnonce, annonce.getTitle(), annonce.getAddress_O(),
                annonce.getPrix_O(), annonce.getTypeDeBien_O(), annonce.getInterieur_O(), annonce.getExterieur_O(),
                annonce.getGeneral_O(), annonce.getParticularite_O(),annonce.getDescription(), annonce.getCoordonnees()));
    }
	
    public Announcements findAnnonceById(UUID id) {
        for (Announcements A : announcements) {
            if (A.getId().equals(id))
                return A;
        }
        return null;
    }
	
    public boolean deleteAnnouncement(UUID id) {
        Iterator<Announcements> iterator = announcements.iterator();
        while (iterator.hasNext()) {
            Announcements A = iterator.next();
            if (A.getId().equals(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public ProjectAnnouncement updateProjectAnnouncement(UUID id, ProjectAnnouncement project) {
        ProjectAnnouncement annonce = (ProjectAnnouncement) findAnnonceById(id);
        if(annonce!=null){
            if (project.getTitle()!= null) {
                annonce.setTitle(project.getTitle());
            }
            if (project.getAddress()!= null) {
                com.Gestion.Immobilier.Annoncements.ProjectAnnouncements.ProjectInfo.InfodeBase.address address1 = new address();
                address1.setAddress(project.getAddress().getAddress());
                address1.setCodePostal(project.getAddress().getCodePostal());
                address1.setVille(project.getAddress().getVille());

                annonce.setAddress(address1);
            }
            if (project.getPrix()!= null) {
                prix prix1 = new prix();
                prix1.setPrixAuM2A(project.getPrix().getPrixAuM2A());
                prix1.setPrixDemandeA(project.getPrix().getPrixDemandeA());
                prix1.setPrixDemandeDe(project.getPrix().getPrixDemandeDe());
                prix1.setPrixAuM2De(project.getPrix().getPrixAuM2De());

                annonce.setPrix(prix1);
            }
            if (project.getTypeDeBien()!= null) {
                typeDeBien typedebien1 = new typeDeBien();
                typedebien1.setTitle(project.getTypeDeBien().getTitle());
                typedebien1.setFinition(project.getTypeDeBien().getFinition());
                typedebien1.setTypeDuProjet(project.getTypeDeBien().getTypeDuProjet());

                annonce.setTypeDeBien(typedebien1);
            }
            if (project.getGeneral()!= null) {
                general general1 = new general();
                general1.setTypeDeBien(project.getGeneral().getTypeDeBien());
                general1.setDisponible(project.getGeneral().getDisponible());
                general1.setAnneeConstruction(project.getGeneral().getAnneeConstruction());
                general1.setSuperficieDe(project.getGeneral().getSuperficieDe());
                general1.setSuperficieA(project.getGeneral().getSuperficieA());
                general1.setNombreDuBien(project.getGeneral().getNombreDuBien());
                general1.setTypeEnvirenemnt(project.getGeneral().getTypeEnvirenemnt());

                annonce.setGeneral(general1);
            }
            if (project.getParticularite()!= null) {
                particularite particulerite1 = new particularite();
                particulerite1.setParticularite(project.getParticularite().getParticularite());

                annonce.setParticularite(particulerite1);
            }
            if (project.getDescription()!= null) {
                annonce.setDescription(project.getDescription());
            }
            if (project.getCoordonnees()!= null) {
                coordonnees coordonnees1 = new coordonnees();
                coordonnees1.setAddress(project.getCoordonnees().getAddress());
                coordonnees1.setVille(project.getCoordonnees().getVille());
                coordonnees1.setCodePostal(project.getCoordonnees().getCodePostal());
                coordonnees1.setTel(project.getCoordonnees().getTel());
                coordonnees1.setEmail(project.getCoordonnees().getEmail());
                coordonnees1.setNomComplet(project.getCoordonnees().getNomComplet());
                coordonnees1.setWhatsApp(project.getCoordonnees().getWhatsApp());

                annonce.setCoordonnees(coordonnees1);
            }
            if (project.getPhoto()!= null) {
                annonce.setPhoto(project.getPhoto());
            }
            return annonce;
        }
        return null;
    }

    public OtherAnnouncement updateOtherAnnouncement(UUID id,OtherAnnouncement other) {
        OtherAnnouncement annonce = (OtherAnnouncement) findAnnonceById(id);
        if(annonce!=null){
            if (other.getTitle()!= null) {
                annonce.setTitle(other.getTitle());
            }
            if (other.getAddress_O()!= null) {
                address_O A = new address_O();
                A.setAddress(other.getAddress_O().getAddress());
                A.setCodePostal(other.getAddress_O().getCodePostal());
                A.setVille(other.getAddress_O().getVille());
                A.setVille(other.getAddress_O().getVille());

                annonce.setAddress_O(A);
            }
            if (other.getPrix_O()!= null) {
                prix_O P = new prix_O();
                P.setPrixDemande(other.getPrix_O().getPrixDemande());
                P.setFraisDeSyndic(other.getPrix_O().getFraisDeSyndic());
                P.setPrixAuM2(other.getPrix_O().getPrixAuM2());
                P.setSelectionner(other.getPrix_O().getSelectionner());

                annonce.setPrix_O(P);
            }
            if (other.getTypeDeBien_O() != null) {
                typeDeBien_O T = new typeDeBien_O();
                T.setDisponibilite(other.getTypeDeBien_O().getDisponibilite());
                T.setDisponibleLe(other.getTypeDeBien_O().getDisponibleLe());
                T.setNomProject(other.getTypeDeBien_O().getNomProject());
                T.setTypeDeBien(other.getTypeDeBien_O().getTypeDeBien());
                T.setSousType(other.getTypeDeBien_O().getSousType());
                T.setMarche(other.getTypeDeBien_O().getMarche());

                annonce.setTypeDeBien_O(T);
            }
            if (other.getGeneral_O() != null) {
                general_O G = new general_O();
                G.setAscenseur(other.getGeneral_O().getAscenseur());
                G.setTypeAppartement(other.getGeneral_O().getTypeAppartement());
                G.setAnneeDeConstruction(other.getGeneral_O().getAnneeDeConstruction());
                G.setVue(other.getGeneral_O().getVue());
                G.setOriontation(other.getGeneral_O().getOriontation());
                G.setFacadeDeAppartement(other.getGeneral_O().getFacadeDeAppartement());
                G.setTypeDeBatiment(other.getGeneral_O().getTypeDeBatiment());
                G.setEtageDeBatiment(other.getGeneral_O().getEtageDeBatiment());
                G.setFacadesDeBatiment(other.getGeneral_O().getFacadesDeBatiment());
                G.setEtatDuBatiment(other.getGeneral_O().getEtatDuBatiment());
                G.setTypeEnvirenement(other.getGeneral_O().getTypeEnvirenement());

                annonce.setGeneral_O(G);
            }
            if (other.getInterieur_O() != null) {
                interieur_O I = new interieur_O();
                I.setBalcon(other.getInterieur_O().getBalcon());
                I.setTerrasse(other.getInterieur_O().getTerrasse());
                I.setRevetementSol(other.getInterieur_O().getRevetementSol());
                I.setClimatisation(other.getInterieur_O().getClimatisation());
                I.setCheuffage(other.getInterieur_O().getCheuffage());
                I.setPlacardEncastre(other.getInterieur_O().getPlacardEncastre());
                I.setChemineSanitaire(other.getInterieur_O().getChemineSanitaire());
                I.setDoubleVitrage(other.getInterieur_O().getDoubleVitrage());
                I.setPortes(other.getInterieur_O().getPortes());
                I.setRideauxElectriques(other.getInterieur_O().getRideauxElectriques());
                I.setDetecteurDeGaz(other.getInterieur_O().getDetecteurDeGaz());
                I.setDetecteurDeFumer(other.getInterieur_O().getDetecteurDeFumer());
                I.setInstallationReseau(other.getInterieur_O().getInstallationReseau());
                I.setDressing(other.getInterieur_O().getDressing());
                I.setCuisine(other.getInterieur_O().getCuisine());

                annonce.setInterieur_O(I);
            }
            if (other.getExterieur_O() != null) {
                exterieur_O E = new exterieur_O();
                E.setJardin(other.getExterieur_O().getJardin());
                E.setPiscine(other.getExterieur_O().getPiscine());
                E.setEspaceDeJeux(other.getExterieur_O().getEspaceDeJeux());
                E.setTerain(other.getExterieur_O().getTerain());
                E.setMosquee(other.getExterieur_O().getMosquee());

                annonce.setExterieur_O(E);
            }
            if (other.getParticularite_O() != null) {
                particularite_O P = new particularite_O();
                P.setAscenseur(other.getParticularite_O().getAscenseur());
                P.setAccesHandicape(other.getParticularite_O().getAccesHandicape());
                P.setIsolationThermique(other.getParticularite_O().getIsolationThermique());
                P.setGarantiePlomberie(other.getParticularite_O().getGarantiePlomberie());
                P.setVideophone(other.getParticularite_O().getVideophone());
                P.setSmartHome(other.getParticularite_O().getSmartHome());
                P.setGarage(other.getParticularite_O().getGarage());
                P.setAccestoit(other.getParticularite_O().getAccestoit());
                P.setBox(other.getParticularite_O().getBox());
                P.setCogemmelConcierge(other.getParticularite_O().getCogemmelConcierge());
                P.setPorteEntreeBlinetee(other.getParticularite_O().getPorteEntreeBlinetee());
                P.setParaboleCollectif(other.getParticularite_O().getParaboleCollectif());
                P.setParkingTitree(other.getParticularite_O().getParkingTitree());
                P.setSystemDeDesengermage(other.getParticularite_O().getSystemDeDesengermage());
                P.setConciegeDeNuit(other.getParticularite_O().getConciegeDeNuit());
                P.setSystemeIncendie(other.getParticularite_O().getSystemeIncendie());
                P.setCameraServeillant(other.getParticularite_O().getCameraServeillant());

                annonce.setParticularite_O(P);
            }
            if (other.getDescription()!= null) {
                annonce.setDescription(other.getDescription());
            }
            if (other.getCoordonnees()!= null) {
                coordonnees coordonnees1 = new coordonnees();
                coordonnees1.setAddress(other.getCoordonnees().getAddress());
                coordonnees1.setVille(other.getCoordonnees().getVille());
                coordonnees1.setCodePostal(other.getCoordonnees().getCodePostal());
                coordonnees1.setTel(other.getCoordonnees().getTel());
                coordonnees1.setEmail(other.getCoordonnees().getEmail());
                coordonnees1.setNomComplet(other.getCoordonnees().getNomComplet());
                coordonnees1.setWhatsApp(other.getCoordonnees().getWhatsApp());

                annonce.setCoordonnees(coordonnees1);
            }
            if (other.getPhoto()!= null) {
                annonce.setPhoto(other.getPhoto());
            }
            return annonce;
        }
        return null;
    }

    public List<Announcements> getFavorites() {
        return getSaved();
    }

    public void saveAnnonce(Announcements save) {
        saved.add(save);
    }

    public void deleteAnnonce(UUID id) {
        saved.removeIf(A -> A.getId().equals(id));
    }
    public List<Announcements> getAllAnnonces() {
        return getAnnouncements();
    }

}