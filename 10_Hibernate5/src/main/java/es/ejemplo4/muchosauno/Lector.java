/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.ejemplo4.muchosauno;

import es.ejemplo2.unoauno.Persona;

public class Lector extends Persona{
    Periodico periodicoFavorito;

    public Periodico getPeriodicoFavorito() {
        return periodicoFavorito;
    }

    public void setPeriodicoFavorito(Periodico periodicoFavorito) {
        this.periodicoFavorito = periodicoFavorito;
    }   
}
