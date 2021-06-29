package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;
    private int capacite;

    
    public Pile2(int taille) {
           if (taille <= 0){
            taille = CAPACITE_PAR_DEFAUT;
        }
        this.stk = new Stack<Object>();
        this.capacite = taille;
    }

    // constructeur fourni
    public Pile2() {
       this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
         if(estPleine()){
            throw new PilePleineException();
        }
        this.stk.push(o);//completer
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return this.stk.pop();
    }

    public Object sommet() throws PileVideException {
          if (estVide())
            throw new PileVideException();
        return this.stk.peek();// a completer
        
    }

   
    public boolean estVide() {
         return this.stk.empty();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
         return this.stk.size() == this.capacite;// a completer
        
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
        String s = "[";
        for (int i = this.stk.size() - 1; i >= 0; i--) {
            
             if(stk.get(i).equals(0)){s="entrer un nb autre que 0 ";}
            else{
            s+= this.stk.get(i).toString();
            if(i >0){
                s+= ", ";
            }       
        }}
        return s + "]"; 
    }

    public boolean equals(Object o) {
         if( this== o ){
            return true;
        }      
        if(!(o instanceof Pile2)){
            return false;
        }
        Pile2 p1 = (Pile2)o;

        if (p1.taille() == this.taille() && p1.capacite() == this.capacite()){
            boolean estEgale = false;
            for(int i= stk.size()-1; i>=0 ; i--){
                Object temp = this.stk.get(i);
                boolean existe = false;
                for(int j = this.stk.size() - 1; j >= 0; j--){
                    if((temp == p1.stk.get(i))){
                        existe = true;
                    }
                }
                if(existe){
                    estEgale = true;
                } else{
                    return false;
                }

            }
            return true;
        }
        return false;
    }

    
    public int hashCode() {
        return toString().hashCode();
    }

    
    public int taille() {
        return this.stk.size();// a completer
      
    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {
         return this.capacite;// a completer
        
    }

} 
