package dao;

import java.util.List;

import entities.Acc;


public interface AccDAO {
	public List<Acc> getAll();
	public boolean add(Acc acc);
	public boolean update(Acc acc);
	public boolean delete(int id);
	public Acc getById(int id);
}
