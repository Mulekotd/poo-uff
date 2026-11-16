import java.util.List;
import utils.Color;
import utils.Mapa;
import utils.Point;
import utils.Polygon;

public class ExercicioHeranca {
    public static void exercicioMapa() {
        System.out.println("=== Questão 1 ===");
        System.out.println("=== Sistema de informações geográficas ===");

        Polygon brasil = new Polygon();

        brasil.add(List.of(
            new Point(-74, -34),
            new Point(-34, -34),
            new Point(-34, 5),
            new Point(-74, 5)
        ));

        Mapa mapa = new Mapa(
            "Brasil",
            new Color(0, 255, 0),
            brasil
        );

        Polygon rioDeJaneiro = new Polygon();

        rioDeJaneiro.add(List.of(
            new Point(-45, -24),
            new Point(-40, -24),
            new Point(-40, -20),
            new Point(-45, -20)
        ));

        Polygon saoPaulo = new Polygon();

        saoPaulo.add(List.of(
            new Point(-53, -25),
            new Point(-44, -25),
            new Point(-44, -20),
            new Point(-53, -20)
        ));

        Polygon minasGerais = new Polygon();

        minasGerais.add(List.of(
            new Point(-51, -23),
            new Point(-39, -23),
            new Point(-39, -14),
            new Point(-51, -14)
        ));

        Mapa rj = new Mapa(
            "Rio de Janeiro",
            new Color(0, 100, 255),
            rioDeJaneiro
        );

        Mapa sp = new Mapa(
            "São Paulo",
            new Color(255, 200, 0),
            saoPaulo
        );

        Mapa mg = new Mapa(
            "Minas Gerais",
            new Color(255, 100, 0),
            minasGerais
        );

        mapa.addEstado(rj);
        mapa.addEstado(sp);
        mapa.addEstado(mg);

        System.out.println(mapa);
    }

    public static void main(String[] args) {
        exercicioMapa();
    }
}
