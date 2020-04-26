package uvsq;

public class DAOFabrique {

    public static DAO<Annuaire> initAnnuaireDAO() {

        return new AnnuaireDAO();
    }

    public static DAO<Groupe> initGroupeIteratorDAO() {

        return new GroupeIteratorDAO();
    }

    public static DAO<Personnel> initPersonnelDAO() {

        return new PersonnelDAO();
    }
}
