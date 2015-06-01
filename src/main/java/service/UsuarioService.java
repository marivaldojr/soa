package service;

import model.Usuario;
import dao.UsuarioDAO;

public class UsuarioService extends BaseService<Usuario> {

	
private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	@Override
	public UsuarioDAO getDao() {
		return usuarioDAO;
	}

	@SuppressWarnings("unchecked")
	@Override
	Class<Usuario> tipo() {
		return Usuario.class;
	}
}
