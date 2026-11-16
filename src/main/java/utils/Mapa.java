package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Mapa {
    private final String titulo;
    private final Color cor;
    private final Polygon poligono;
    private final List<Mapa> estados;

    public Mapa(String titulo, Color cor, Polygon poligono) {
        this.titulo = titulo;
        this.cor = cor;
        this.poligono = poligono;
        this.estados = new ArrayList<>();
    }

    // Methods

    public void addEstado(Mapa estado) {
        this.estados.add(estado);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Título: ")
              .append(this.titulo)
              .append("\nCor: ")
              .append(this.cor)
              .append("\nPolígono: ")
              .append(this.poligono);

        if (!this.estados.isEmpty()) {
            String estadosFormatados = this.estados
                .stream()
                .map(Mapa::toString)
                .map(estado -> estado.indent(4))
                .collect(Collectors.joining("\n\n"));

            result.append("\nEstados:\n")
                  .append(estadosFormatados);
        }

        return result.toString();
    }

    // Getters

    public String getTitulo() {
        return this.titulo;
    }

    public Color getCor() {
        return this.cor;
    }

    public Polygon getPoligono() {
        return this.poligono;
    }

    public List<Mapa> getEstados() {
        return Collections.unmodifiableList(this.estados);
    }
}
