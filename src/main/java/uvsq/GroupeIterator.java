package uvsq;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class GroupeIterator<Groupe> implements Iterator<Groupe>, Serializable {

    private int index;
    private ArrayList<Groupe> liste;

    @Override
    public boolean hasNext(){
        if (this.liste.get(this.index+1) == null){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public Groupe next(){
        if (!this.hasNext()) {
            return null;
        }
        else{
            this.index = this.index + 1;
            return this.liste.get(this.index-1);
        }
    }

    public void add(Groupe element){

        if (this.liste == null){
            this.liste = new ArrayList<Groupe>();
        }
        this.liste.add(element);
        this.index++;
    }

    public void remove(int index){
        this.liste.remove(index);
    }

    public int get_index(){
        return this.index;
    }

    public Groupe getElem(int index){
        return this.liste.get(index);
    }

}
