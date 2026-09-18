import java.util.ArrayList;
import java.util.List;

interface Tributavel {
    double calcularTributo();
}
abstract class Item {
    int codigo;
    double precoBase;

    public Item(int codigo, double precoBase) {
        this.codigo = codigo;
        this.precoBase = precoBase;
    }
}
class Eletronico extends Item implements Tributavel {

    public Eletronico(int codigo, double precoBase) {
        super(codigo, precoBase);
    }

    public double calcularTributo() {
        return precoBase * 0.15;
    }
}
class Alimento extends Item {

    public Alimento(int codigo, double precoBase) {
        super(codigo, precoBase);
    }
}
public class ClasseItem {
    public static double calcularTotalImpostos(List<Tributavel> itensTributaveis) {

        double total = 0;

        for (Tributavel item : itensTributaveis) {
            total = total + item.calcularTributo();
        }
        return total;
    }
    public static void main(String[] args) {

        List<Tributavel> itens = new ArrayList<>();

        itens.add(new Eletronico(1, 1000));
        itens.add(new Eletronico(2, 500));

        double total = calcularTotalImpostos(itens);
        System.out.println("Total de impostos: R$ " + total);
    }
}
