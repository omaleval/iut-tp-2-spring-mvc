package edu.lyon1;

public class User {

  private final String prenom;
  private final String nom;

  public User(String prenom, String nom) {
    this.prenom = prenom;
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public String getNom() {
    return nom;
  }
}
