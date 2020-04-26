package uvsq;

import java.io.*;

public class PersonnelDAO implements DAO<Personnel> {

    @Override
    public Personnel create(Personnel p) {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Personnel")))) {
            out.writeObject(p);
        } catch(IOException ie) {
            ie.printStackTrace();
        }
        return p;
    }

    @Override
    public Personnel find(String id){
        Personnel p = null;
        try (ObjectInputStream in =
                     new ObjectInputStream(new BufferedInputStream(new FileInputStream(id)))) {
            p = (Personnel) in.readObject();

        } catch (ClassNotFoundException | IOException ie) {
            ie.printStackTrace();
        }

        return p;
    }

    @Override
    public void delete(String id){
        File f = new File(id);
        f.delete();
    }

    @Override
    public Personnel update(Personnel p) {
        p = create(p);
        return p;
    }
}
