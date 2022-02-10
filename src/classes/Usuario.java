package classes;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javafx.scene.image.Image;

public class Usuario {
    private static int id_usuario;
    private static String nome;
    private static String sobrenome;
    private static String email;
    private static String senha;
    private static Image imagem;

    public Usuario(){

    }

    public String getSenha() {
        return senha;
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

    public Image getImagem() {
        return imagem;
    }

    public void setImagem(Image imagem) {
        Usuario.imagem = imagem;
    }
    
    public static void criptografaSenha(String senha) throws NoSuchAlgorithmException, 
    UnsupportedEncodingException {
        
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for(byte b:  messageDigest){
            hexString.append(String.format("%02X", 0xFF & b));
        }

        String senhaHex = hexString.toString();
        Usuario.senha = senhaHex;
    }

    /**
     * Método para limpar as informações do usuário
     */
    public void limpaUsuario(){
        Usuario.id_usuario = 0;
        Usuario.nome = null;
        Usuario.email = null;
        Usuario.sobrenome = null;
        Usuario.senha = null;
    }
    
}
