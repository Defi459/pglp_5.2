package uvsq;

import java.io.*;

public class AnnuaireDAO implements DAO<Annuaire> {

    @Override
    public Annuaire create(Annuaire a) {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Annuaire")))) {
            out.writeObject(a);
        } catch(IOException ie) {
            ie.printStackTrace();
        }
        return a;
    }

    @Override
    public Annuaire find(String id){
        Annuaire a = null;
        try (ObjectInputStream in =
                     new ObjectInputStream(new BufferedInputStream(new FileInputStream(id)))) {
            a = (Annuaire) in.readObject();

        } catch (ClassNotFoundException | IOException ie) {
            ie.printStackTrace();
        }

        return a;
    }

    @Override
    public void delete(String id){
        File f = new File(id);
        f.delete();
    }

    @Override
    public Annuaire update(Annuaire a) {
        a = create(a);
        return a;
    }
}
