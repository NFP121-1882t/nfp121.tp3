package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;
public class Pile4 implements PileI, Cloneable {
      private Maillon stk;
    private int capacite;
    private int nombre;

    private static class Maillon implements Cloneable {
        private Object element;
        private Maillon suivant;

        public Maillon(Object element, Maillon suivant) {
            this.element = element;
            this.suivant = suivant;
        }

        public Maillon suivant() {
            return this.suivant;
        }
   
        public boolean hasNext(){
            return this.suivant != null;
        }

        public Object element() {
            return this.element;
        }

        public Object clone() throws CloneNotSupportedException {
            Maillon m = (Maillon) super.clone();
            m.element = element;
            return m;
        }
    }


    public Pile4(int taille) {
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.stk = null;
        this.capacite = taille;
    }

    public Pile4() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        stk = new Maillon (o,stk);     
        this.nombre++;            
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        Maillon tmp = this.stk;
        this.stk = this.stk.suivant;
        nombre--;
        return tmp.element;
    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return stk.element ;
    }

    public boolean estVide() {
        return stk == null; 
    }

    public boolean estPleine() {
        return this.taille() >= capacite; 
    }

    public String toString() {
        String s = "[";
        Maillon tmp = stk;
        while (tmp != null){
            if(tmp.equals(0)){s="entrer un nb autre que 0";}
            else{
            s = s + tmp.element() ;
            tmp = tmp.suivant();
            if (tmp !=null) {s = s + ", ";}  
        }  }
        return s + "]"; 
    }

   
    public boolean equals(Object o) {
        boolean b = true;
        Pile4 p1;
        if (o instanceof Pile4) {
            p1 = (Pile4)o;
            Maillon m1;
            Maillon m2;
            try{
                if (p1.taille() == this.taille() && p1.capacite() == this.capacite()){
                m1 = stk;
                m2 = p1.stk;
                    for (int i = this.nombre - 1; i >= 0; i--) {
                        if(!(m1.element() == m2.element())){
                            b = false;
                        }
                        m1 = m1.suivant();
                        m2 = m2.suivant();
                    }
                }
                else{
                    b = false;
                }
            }catch (Exception e){
                b = false;
            }
            
        }else{
            b = false;
        }
        return b;
    }


    public int capacite() {
        return this.capacite;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public int taille() {
        return nombre;
    }
}