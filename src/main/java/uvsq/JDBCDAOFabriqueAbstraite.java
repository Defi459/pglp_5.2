package uvsq;

public interface JDBCDAOFabriqueAbstraite {

    JDBC_DAO<Annuaire> creerAnnuaire();
    JDBC_DAO<GroupeIterator> creerGroupe();
    JDBC_DAO<Personnel> creerPersonnel();



}
