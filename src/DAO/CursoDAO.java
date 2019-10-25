package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import datos.Curso;

public class CursoDAO {
	public boolean existeCurso(String descripcion) throws SQLException {
		Connection cnx = null;
		ResultSet lector = null;
		boolean retorno = false;

		String sql = "select count(*) as cantidad from Curso" + " where descripcion = '" + descripcion + "'";
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

	public int traerIdCurso(String descripcion) throws SQLException {

		Connection cnx = null;
		ResultSet lector = null;

		int retorno = 0;

		String sql = "select idCurso from Curso " + "where descripcion = '" + descripcion + "'";
		System.out.println(sql);

		try {
			cnx = Conexion.getConnection();// open
			lector = cnx.prepareStatement(sql).executeQuery();
			while (lector.next()) {
				retorno = lector.getInt("idCurso");
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

	public Curso traerCurso(String descripcion) throws SQLException {
		Curso retorno = null;
		Connection cnx = null;
		ResultSet lector1 = null;

		String sql = "select idCurso, descripcion from Curso " + "where descripcion = '" + descripcion + "'";

		try {
			cnx = Conexion.getConnection();// open
			lector1 = cnx.prepareStatement(sql).executeQuery();
			int idCurso = 0;
			while (lector1.next()) {
				idCurso = lector1.getInt("idCurso");
				retorno = new Curso(idCurso, descripcion);
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


	public Curso traerCurso(int idCurso) throws SQLException {
		Curso retorno = null;
		Connection cnx = null;
		ResultSet lector1 = null;

		String sql = "select idCurso, descripcion from Curso " + "where idCurso="+idCurso;

		try {
			cnx = Conexion.getConnection();// open
			lector1 = cnx.prepareStatement(sql).executeQuery();
			while (lector1.next()) {
				idCurso = lector1.getInt("idCurso");
				String descripcion = lector1.getString("descripcion");
				retorno = new Curso(idCurso, descripcion);
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
	public int agregarCurso(Curso c) throws SQLException {
		Connection cnx = null;
		PreparedStatement ps = null;

		int retorno = 0;
		int idCurso= c.getIdCurso();
		String descripcion = c.getDescripcion();

		String sql = "insert into Curso (idCurso, descripcion) values ('"+descripcion+"')";
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
		retorno = traerIdCurso(descripcion);
		return retorno;
	}
}
