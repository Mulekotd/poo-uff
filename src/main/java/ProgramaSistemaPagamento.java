import java.util.Scanner;
import sistemapagamento.SistemaPagamento;

public class ProgramaSistemaPagamento {
    public static void main(String args[]) {
        try (Scanner reader = new Scanner(System.in)) {
            System.out.print("Insira o seu CPF: ");
            String cpf = reader.nextLine();
            System.out.print("\n");
            
            // Injeta a dependência do reader
            SistemaPagamento sistema = new SistemaPagamento(cpf, reader);
            
            sistema.rodar();
        }
    }
}
