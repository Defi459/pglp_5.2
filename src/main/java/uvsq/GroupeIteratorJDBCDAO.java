package uvsq;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupeIteratorJDBCDAO extends JDBC_DAO<GroupeIterator>{


    @Override
    public GroupeIterator create(GroupeIterator obj) {

        this.connect();

        try (PreparedStatement pinsert = this.connect.prepareStatement("INSERT INTO Groupe(name) values(?)"))
        {
            this.connect.createStatement();
            pinsert.setString(1, (String)obj.getElem(obj.get_index()));
            pinsert.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.disconnect();

        return obj;
    }

    @Override
    public GroupeIterator find(String id) {

        return null;
    }

    @Override
    public void delete(String id) {

        this.connect();

        try (PreparedStatement delete =
                     this.connect.prepareStatement("DELETE FROM Groupe G WHERE G.name = ?"); ) {
            delete.setString(1, id);
            delete.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.disconnect();
    }

}
