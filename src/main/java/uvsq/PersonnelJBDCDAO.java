package uvsq;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonnelJBDCDAO extends JDBC_DAO<Personnel> {

    @Override
    public Personnel create(Personnel obj) {

        this.connect();

        try (PreparedStatement pinsert =
                     this.connect.prepareStatement(
                             "INSERT INTO Personnel(name, surname, function, birth) values(?, ?, ?, ?)"))
        {
            pinsert.setString(1, obj.getNom());
            pinsert.setString(2, obj.getPrenom());
            pinsert.setString(3, obj.getFonction());
            pinsert.setDate(4, java.sql.Date.valueOf(obj.getNaissance()));
            pinsert.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.disconnect();
        return obj;
    }

    @Override
    public Personnel find(String id) {
        return null;
    }


    @Override
    public void delete(String id) {

        this.connect();
        try (PreparedStatement delete =
                     this.connect.prepareStatement("DELETE FROM Personnel P WHERE P.name = ?"); ) {
            delete.setString(1, id);
            delete.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
