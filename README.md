# Programação Orientada a Objetos

Repositório com exercícios e trabalhos da disciplina de Programação Orientada a Objetos da UFF, desenvolvidos em Java.

## Compilação e execução

O projeto não utiliza um gerenciador de dependências. Para compilar todos os arquivos Java, execute:

```sh
mkdir -p build/classes
javac -d build/classes $(find src/main/java -name "*.java")
```

Depois, execute um dos programas principais:

```sh
java -cp build/classes LabLista
java -cp build/classes LabArvoreBinaria
java -cp build/classes LabSistemaPagamento
```

## Requisitos

- Java JDK 8 ou superior.
- Terminal compatível com os comandos usados na compilação.
