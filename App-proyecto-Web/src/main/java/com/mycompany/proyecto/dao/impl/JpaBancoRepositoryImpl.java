package com.mycompany.proyecto.dao.impl;

import java.io.Serializable;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.dao.BancoRepository;
import com.mycompany.proyecto.model.Banco;
/**
 * Implementacion de JPA de la interfaz {@link BancoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaBancoRepositoryImpl extends BaseDao<Banco, Serializable> implements BancoRepository {
	

}