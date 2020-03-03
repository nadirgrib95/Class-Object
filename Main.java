import java.lang.Math;
import java.lang.*;
import javax.swing.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

class Main {
    public static void main(String[] args) {

    }
}

// Forme Onde (6.1.1)
private class FormeOnde {

  //Accesseur 1
  public getFrequence () {
    return frequence;
  }

  //Accesseur 1
  public getFrequenceEchantillonnage () {
    return frequenceEchantillonnage;
  }

  public double echantillon (){

    int i;

    double echantillon = (int) i;
    return i;
  }
}

// Forme Aleatoire (6.1.2)
public class FormeAleatoire {

    //Retourne -1 ou 1 aleatoirement
    public double echantillon (){
      return (2 * Mat.random()-1);
    }
}

// Forme carree (6.1.3)
public class FormeCarree {

  double i;
  double x = i/frequenceEchantillonnage;
  double resultat;
  double periode = 1/frequenceOnde;
  double r = Math.IEEEremainder (x,periode);

  if (r < 0 ){
    r+=periode;
  }

  if (r < (periode/2)){
    resultat = 1;
  }
  else {
    resultat = -1;
  }
  
  return resultat;
}

// Forme Triangulaire (6.1.5)
public class FormeTriangulaire {

  double i;
  double x = i/frequenceEchantillonnage;
  double resultat;
  double periode = 1/frequenceOnde;
  double r = Math.IEEEremainder (x,periode);

  if (r < 0.0 ){
    r+=periode;
  }

  if (r <= (periode/4.0)){
    resultat = (r*4.0)/periode;
  }
  else if (r <= 3*periode/4.0) {
    r-=periode/4.0;
    resultat = (1-r*4)/periode;
  }
  else{
    r-= 3*periode/4;
    resultat = (-1+r*4)/periode;
  }
  
  return resultat;
}

public class FormeSinusoidale {

  double i;
  double x = i/frequenceEchantillonnage;
  double resultat;
  double periode = 1/frequenceOnde;
  double r = Math.IEEEremainder (x,periode);

  if (r < 0.0 ){
    r+=periode;
  }
  
  return (Math.sin(2*PI*frequenceEchantillonnage*r));
}

public class TestSon {

  AudioFormat audioFmt = new AudioFormat(20500, 16, 1, true,true);

  try {

    ligne = AudioSystem.getSourceDataLine(audioFmt);
    ligne.open(audioFmt);

  }catch(LineUnavailableException lue){
  
    System.out.println("# Erreur : impossible de trouver une ligne de sortie audio au format :");
    System.out.println("#    "+audioFmt);
    System.exit(1);
  }
}

public class Thread {

  Thread t = new Thread (new Runnable() {

        @Override
        public void run() {

          // Démarre la production de son
          ligne.start();

          // Joue la gamme de do majeure à une intensité de
          // 30% pendant une demie seconde.  Le 4 signifie
          // la gamme au centre du piano.  C3 est plus grave et // C5 est plus aigu.
          jouer(ligne, "C4",.3, 500);
          jouer(ligne, "D4",.3, 500);
          jouer(ligne, "E4",.3, 500);
          jouer(ligne, "F4",.3, 500);
          jouer(ligne, "G4",.3, 500);
          jouer(ligne, "A4",.3, 500);
          jouer(ligne, "B4",.3, 500);
          jouer(ligne, "C5",.3, 1000); // do plus aigu, 1 seconde

        }
    });

		t.start();

public static Jouer (SourceDataLine, note, intensite, duree){
  Note n = new Note(note,duree);
  n.Jouer (line, intensite);
}