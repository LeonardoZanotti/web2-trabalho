/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package database;

import java.util.List;

/**
 *
 * @author leonardozanotti
 */
public interface DAO<T> {
    T buscar(long id) throws DAOException;
    List<T> buscarTodos() throws DAOException;
    void inserir(T t) throws DAOException;
    void atualizar(T t) throws DAOException;
    void remover(T t) throws DAOException;
}
