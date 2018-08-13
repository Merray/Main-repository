package videoClubJpa.dao;

import java.util.List;

public interface DaoGeneric<T, K> {
	List<T> findAll();

	T findByKey(K key);

	void create(T obj);

	T update(T obj);

	void delete(T obj);

	void deleteByKey(K key);
}
