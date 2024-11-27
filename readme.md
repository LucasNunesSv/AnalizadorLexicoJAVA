# Projeto de Análise Léxica

Este projeto é uma aplicação construída para análise léxica de arquivos em uma linguagem específica. Ele utiliza o **JFlex** para o reconhecimento e a análise da linguagem.

## Requisitos

- **Java** (versão 8 ou superior)
- **Make** (para automação de compilação)

## Como usar

### Compilando o projeto

Para compilar o projeto, utilize o comando:

```bash
$ make
```

### Executando com um arquivo de teste

Após compilar, você pode executar o analisador com o seguinte comando:

```bash
$ java Main  ./arquivos_de_teste/<nomeDoArquivo>
```

Substitua <nomeDoArquivo> pelo caminho do arquivo que deseja analisar.

### Limpando arquivos gerados

Para remover os arquivos gerados durante a execução ou compilação, utilize:

```bash
$ make clean
```
