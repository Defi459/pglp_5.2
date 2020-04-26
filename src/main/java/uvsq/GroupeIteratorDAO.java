package uvsq;

import java.io.*;

public class GroupeIteratorDAO implements DAO<Groupe> {

    @Override
    public Groupe create(Groupe g) {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Groupe")))) {
            out.writeObject(g);
        } catch(IOException ie) {
            ie.printStackTrace();
        }
        return g;
    }

    @Override
    public Groupe find(String id){
        Groupe g = null;
        try (ObjectInputStream in =
                     new ObjectInputStream(new BufferedInputStream(new FileInputStream(id)))) {
            g = (Groupe) in.readObject();

        } catch (ClassNotFoundException | IOException ie) {
            ie.printStackTrace();
        }

        return g;
    }

    @Override
    public void delete(String id){
        File f = new File(id);
        f.delete();
    }

    @Override
    public Groupe update(Groupe g) {
        g = create(g);
        return g;
    }
}
