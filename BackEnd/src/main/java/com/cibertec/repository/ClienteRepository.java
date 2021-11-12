package com.cibertec.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.entity.Cliente;
import com.cibertec.entity.FiltroCliente;
import com.cibertec.entity.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	public List<Cliente> findByidCliente(String idCliente );
	public List<Cliente> findByApellidosContaining(String apellidos);
	
	


	
	
	@Query("select d from Cliente d where "
			+ "( :p_idCliente is '' or d.idCliente = :p_idCliente ) and "
			+ "( :p_apellidos is '' or d.apellidos like :p_apellidos )")
		public abstract List<Cliente> listaClientePoridClienteApellidos(
							 	@Param("p_idCliente") String idCliente, 
							 	@Param("p_apellidos") String apellidos);


		@Query("select d from Cliente d where "
							+ "( :p_idCliente is '' or d.idCliente = :p_idCliente ) and "
							+ "( :p_apellidos is '' or d.apellidos like :p_apellidos ) and "
							+ "( :p_ubi is 0  or d.ubigeo.idUbigeo = :p_ubi ) ")
		
		public abstract List<Cliente> listaClientePoridClienteApellidosUbigeo(
					 	@Param("p_idCliente") String idCliente, 
					 	@Param("p_apellidos") String apellidos,
					 	@Param("p_ubi") int idUbigeo);


		@Query("select d from Cliente d where "
					+ "( :#{#fil.idCliente} is '' or d.idCliente = :#{#fil.idCliente} ) and "
					+ "( :#{#fil.apellidos} is '' or d.apellidos like :#{#fil.apellidos} ) and "
					+ "( :#{#fil.idUbigeo} is 0  or d.ubigeo.idUbigeo = :#{#fil.idUbigeo} ) ")
		
		public abstract List<Cliente> listaPorFiltro(@Param("fil")FiltroCliente filtro);
		
		
		
		@Query("Select c from Cliente c where ( :c_nom is '' or c.nombres like :c_nom) and " 
                + "(:c_ape is '' or c.apellidos like :c_ape) and " 
                + "(:c_ubi is 0 or c.ubigeo.idUbigeo = :c_ubi)")
        public List<Cliente> listaCliente(@Param("c_nom") String  nom, 
                                          @Param("c_ape") String ape, 
                                          @Param("c_ubi") int idUbigeo);



}