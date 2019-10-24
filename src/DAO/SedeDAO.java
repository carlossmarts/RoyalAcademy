package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import datos.Sede;

public class SedeDAO {
	public boolean existeSede(String calle, int numero) throws SQLException {
		Connection cnx = null;
		ResultSet lector = null;
		boolean retorno = false;

		String sql = "select count(*) as cantidad from Sede" + " where calle = '" + calle + "' and numero = " + numero;
		System.out.println(sql);

		try {
			cnx = Conexion.getConnection();// open
			lector = cnx.prepareStatement(sql).executeQuery();
			while (lector.next()) {
				int cantidad = lector.getInt("cantidad");
				if (cantidad != 0) {
					retorno = true;
				}
			}
			lector.close();
			cnx.close();
		} catch (SQLException ex) {
			throw new SQLException(ex);
		} finally {
			if (cnx != null) {
				if (lector != null && !lector.isClosed())
					lector.close();
				if (!cnx.isClosed())
					cnx.close();
			}
		}
		return retorno;
	}

	public int traerIdSede(String calle, int numero) throws SQLException {

		Connection cnx = null;
		ResultSet lector = null;

		int retorno = 0;

		String sql = "select idSede from Sede " + "where calle = '" + calle + "' and numero =" + numero;
		System.out.println(sql);

		try {
			cnx = Conexion.getConnection();// open
			lector = cnx.prepareStatement(sql).executeQuery();
			while (lector.next()) {
				retorno = lector.getInt("idSede");
			}
			lector.close();
			cnx.close();
		} catch (SQLException ex) {
			throw new SQLException(ex);
		} finally {
			if (cnx != null) {
				if (lector != null && !lector.isClosed())
					lector.close();
				if (!cnx.isClosed())
					cnx.close();
			}
		}
		return retorno;
	}

	public Sede traerSede(String calle, int numero) throws SQLException {
		Sede retorno = null;
		Connection cnx = null;
		ResultSet lector1 = null;

		String sql = "select idSede, idPais, idProvincia, idLocalidad, codigoPostal from Sede " + "where calle = '"
				+ calle + "' and numero = " + numero;

		try {
			cnx = Conexion.getConnection();// open
			lector1 = cnx.prepareStatement(sql).executeQuery();
			int idSede = 0;
			while (lector1.next()) {
				idSede = lector1.getInt("idSede");
				int idPais = lector1.getInt("idPais");
				int idProvincia = lector1.getInt("idProvincia");
				int idLocalidad = lector1.getInt("idLocalidad");
				String codigoPostal = lector1.getString("codigoPostal");
				retorno = new Sede(idSede, idPais, idProvincia, idLocalidad, codigoPostal, calle, numero);
			}
			lector1.close();
			cnx.close();
		} catch (SQLException ex) {
			throw new SQLException(ex);
		} finally {
			if (cnx != null) {
				if (lector1 != null && !lector1.isClosed())
					lector1.close();
				if (!cnx.isClosed())
					cnx.close();
			}
		}
		return retorno;
	}

	public int agregarSede(Sede s) throws SQLException {
		Connection cnx = null;
		PreparedStatement ps = null;

		int retorno = 0;
		int idPais = s.getIdPais();
		int idProvincia = s.getIdProvincia();
		int idLocalidad = s.getIdLocalidad();
		String codigoPostal = s.getCodigoPostal();
		String calle = s.getCalle();
		int numero = s.getNumero();

		String sql = "insert into Sede (idPais, idProvincia,idLocalidad,codigoPostal, calle, numero )" + "values ("
				+ idPais + "," + idProvincia + "," + idLocalidad + "," + codigoPostal + ",'" + calle + "'," + numero
				+ ")";
		System.out.println(sql);
		try {
			cnx = Conexion.getConnection();// open
			ps = cnx.prepareStatement(sql);

			ps.executeUpdate();
			ps.close();
			cnx.close();
		} catch (SQLException ex) {
			throw new SQLException(ex);
		} finally {
			if (cnx != null) {
				if (ps != null && !ps.isClosed())
					ps.close();
				if (!cnx.isClosed())
					cnx.close();
			}
		}
		retorno = traerIdSede(calle, numero);
		return retorno;
	}
}
