package GlobalSolution.BlueClean.dto.usuario;

import GlobalSolution.BlueClean.model.usuario.Usuario;

public record DetalhesUsuario(Long id, String nome, String email, String senha,
                              String tipo) {

    public DetalhesUsuario(Usuario usuario){
      this(usuario.getCodigo(), usuario.getNome(), usuario.getEmail(), usuario.getSenha(),
              usuario.getTipo());
    }
}

