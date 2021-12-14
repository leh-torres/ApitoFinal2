package classes;

public class Usuario {
    private static int    id_usuario;
    private static String nome;
    private static String sobrenome;
    private static String email;
    private static String senha;

    public Usuario(){

    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        Usuario.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Usuario.email = email;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        Usuario.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        Usuario.nome = nome;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        Usuario.id_usuario = id_usuario;
    }

    
}
