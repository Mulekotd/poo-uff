import sistemaboleto.SistemaBoleto;

public class ProgramaSistemaBoleto {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java ArquivoBoleto <fileName>");
            return;
        }

        String fileName = args[0];

        SistemaBoleto sistema = null;

        try {
            sistema = new SistemaBoleto(fileName);
            sistema.getIO().listen();
        } catch (Exception e) {
            System.err.println("Ocorreu um erro inesperado, contate o desenvolvedor!");
            e.printStackTrace(System.err);
        } finally {
            if (sistema != null) {
                sistema.close();
            }
        }
    }
}
