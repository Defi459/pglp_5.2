package uvsq;

public interface DAO<T> {

    T create(T obj);

    T find(String id);

    T update(T obj);

    void delete(String file);
}
