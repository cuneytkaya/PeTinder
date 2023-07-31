package bau.petinder.service;

import java.util.List;

import bau.petinder.domain.BaseEntity;

public interface IService<TEntity extends BaseEntity> {
	
    TEntity GetById(int id);
    
    List<TEntity> GetAll();
    
    void Create(TEntity entity);
    
    void Update(TEntity entity);
    
    void Delete(int id);
}
