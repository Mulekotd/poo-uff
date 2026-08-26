import sistemapagamento.SistemaPagamento;

import java.util.Scanner;


public class LabSistemaPagamento {
    public static void main(String args[]) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Insira o seu CPF: ");
        String cpf = reader.nextLine();

        SistemaPagamento sistema = new SistemaPagamento(cpf, reader);
        sistema.rodar();

        reader.close();
    }
}
