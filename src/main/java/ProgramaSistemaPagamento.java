import sistemapagamento.SistemaPagamento;

import java.util.Scanner;

public class ProgramaSistemaPagamento {
    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Insira o seu CPF: ");
        String cpf = reader.nextLine();
        System.out.print("\n");

        // Injeta a dependência do reader
        SistemaPagamento sistema = new SistemaPagamento(cpf, reader);

        sistema.rodar();
        reader.close();
    }
}
