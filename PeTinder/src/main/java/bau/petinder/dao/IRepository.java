package bau.petinder.dao;
import java.util.List;

import bau.petinder.domain.BaseEntity;

public interface IRepository<TEntity extends BaseEntity> {
	
    TEntity GetById(int id);
    
    List<TEntity> GetAll();
    
    void Create(TEntity entity);
    
    void Update(TEntity entity);
    
    void Delete(int id);
}
