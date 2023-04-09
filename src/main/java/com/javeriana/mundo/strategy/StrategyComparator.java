package com.javeriana.mundo.strategy;

import com.javeriana.mundo.NaveJugador;


import java.util.ArrayList;
import java.util.Comparator;

public class StrategyComparator {

        public ArrayList<NaveJugador> ordenarPor(Comparator<NaveJugador> comparador, ArrayList<NaveJugador> jugadores) {
            ArrayList<NaveJugador> jugadoresOrdenados = new ArrayList<NaveJugador>(jugadores);
            jugadoresOrdenados.sort(comparador);
            return jugadoresOrdenados;
        }

        public ArrayList<NaveJugador> ordenarPorNickname(ArrayList<NaveJugador> jugadores) {
            Comparator<NaveJugador> comparador = Comparator.comparing(NaveJugador::getNickname);
            return ordenarPor(comparador, jugadores);
        }
}

