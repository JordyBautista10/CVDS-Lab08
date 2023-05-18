package edu.eci.cvds.servlet.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
import javax.faces.bean.*;

@Component
@ManagedBean(name = "guessBean")
@ApplicationScoped

public class GuessBean {
    @Autowired
    ConfigurationService configurationService;
    private int numeroAdivinar;
    private int numeroIntentos;
    private int numeroUsuario;
    private int premio;
    private String estadoJuego;
    private String intentosFallidos;

    public GuessBean(){
        restart();
    }

    public void guess(int numero){
        if (estadoJuego == "Gano" || estadoJuego == "Juega de nuevo") {
            estadoJuego="Juega de nuevo";
        }
        else if(numero>=0 && numero <=20 && premio > 0){
            numeroIntentos++;
            if(numero==numeroAdivinar){
                estadoJuego="Gano";
            }else{
                estadoJuego="Fallo";
                premio -= configurationService.getConfiguration("error").getValor();
                intentosFallidos += " " + String.valueOf(numero)+",";
            }
        } 
    }

    public void restart(){
        Random rand = new Random();
        numeroAdivinar = rand.nextInt(20);
        premio = 1000;
        numeroIntentos = 0;
        estadoJuego = "Adivine el numero menor a 20";
        intentosFallidos= "";
    }

    public void start(){
        Random rand = new Random();
        numeroAdivinar = rand.nextInt(20);
        premio = configurationService.getConfiguration("premio").getValor();
        numeroIntentos = 0;
        estadoJuego = "Adivine el numero menor a 20";
        intentosFallidos= "";
    }

    public String getIntentosFallidos(){
        return intentosFallidos;
    }

    public void setIntentosFallidos(String intentosF){
        intentosFallidos=intentosF;
    }

    public int getNumeroAdivinar(){
        return numeroAdivinar;
    }

    public int getNumeroIntentos(){
        return numeroIntentos;
    }

    public int getPremio(){
        return premio;
    }

    public String getEstadoJuego(){
        return estadoJuego;
    }

    public void setNumeroAdivinar(int numero){
        numeroAdivinar = numero;
    }

    public void setNumeroIntentos(int intentos){
        this.numeroIntentos= intentos;
    }

    public void setPremio(int premio){
        this.premio = premio;
    }

    public void setEstadoJuego(String estado){
        this.estadoJuego = estado;
    }

    public void setNumeroUsuario(int numero){
        numeroUsuario = numero;
    }
    public int getNumeroUsuario(){
        return numeroUsuario;
    }

}
