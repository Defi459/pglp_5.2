package uvsq;

import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;


public abstract class AnnuaireJDBCDAO extends JDBC_DAO<Annuaire> {

    Annuaire annu;
    Statement st;

    @Override
    public Annuaire create(Annuaire obj)
    {
        this.connect();
        try {
            st = connect.createStatement();
            st.execute("CREATE TABLE Groupe(id INTEGER primary key)");
            st.execute("CREATE TABLE Personnel(name varchar(20) PRIMARY KEY, "+" surname  varchar(20), function varchar(20), birth varchar(20)"+"id integer references Groupe(id))");
            st.close();

        } catch (SQLException e)
        {

            e.printStackTrace();
        }

        this.annu = obj;
        return obj;
    }

    @Override
    public Annuaire find(String id) {

        return this.annu;
    }

    @Override
    public void delete(String id) {


        try {
            this.st = connect.createStatement();
            this.st.execute("DELETE FROM Groupe");
            this.st.execute("DELETE FROM Personnel");
            this.st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
