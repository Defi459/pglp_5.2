package uvsq;

import java.io.Serializable;

public class Annuaire implements Serializable{

    GroupeIterator<Personnel> liste;

    public Annuaire(){
        this.liste = new GroupeIterator<Personnel>();
    }

    public void affiche(){

        int index = 0;
        Personnel tmp;

        while(this.liste.hasNext()){
            tmp=this.liste.getElem(index);
            tmp.print();
            this.liste.next();
            index++;
        }
    }


}
