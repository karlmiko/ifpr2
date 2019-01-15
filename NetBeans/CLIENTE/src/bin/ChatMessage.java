package bin;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ChatMessage implements Serializable
{
    
    private String nome;
    private String texto;
    private String nomeReservado;
    private Set<String> setOnlines = new HashSet<String>();
    private Action tipoAcao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getNomeReservado() {
        return nomeReservado;
    }

    public void setNomeReservado(String nomeReservado) {
        this.nomeReservado = nomeReservado;
    }

    public Set<String> getSetOnlines() {
        return setOnlines;
    }

    public void setSetOnlines(Set<String> setOnlines) {
        this.setOnlines = setOnlines;
    }

    public Action getTipoAcao() {
        return tipoAcao;
    }

    public void setTipoAcao(Action tipoAcao) {
        this.tipoAcao = tipoAcao;
    }
    
    public enum Action
    {
        CONECTAR, DESCONECTAR, MANDAR_UM, MANDAR_TODOS, USUARIOS_ONLINE
    }  
}
