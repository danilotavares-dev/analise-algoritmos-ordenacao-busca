# Atividade Avaliativa — Estruturas de Dados

**Curso:** Engenharia de Software — Centro Universitário do Distrito Federal (UDF) </br>
**Disciplina:** Estruturas de Dados </br>
**Autores:** Danilo Tavares Lima e Pedro Artur </br>
**Ano:** 2026 </br>

## Objetivo

Investigar experimentalmente o comportamento de estruturas de dados e algoritmos fundamentais, relacionando **arrays, matrizes, ordenação, busca, índices, loops e complexidade computacional**. Além de desenvolver os códigos, a atividade exige **medir, comparar e interpretar** a quantidade de operações realizadas pelos algoritmos, evidenciando que resultados iguais podem esconder custos computacionais muito diferentes.

## Estrutura do repositório

```
project-root/
├── README.md                                  ← este arquivo
├── docs/
│   ├── 01-pesquisa-bubble-quick.md             ← Parte 1: pesquisa e comparação teórica
│   ├── 02-experimento-ordenacao.md             ← Parte 2: experimento Bubble vs Quick Sort
│   ├── 03-busca-matrizes.md                    ← Parte 3: busca sequencial em matrizes
│   ├── 04-handson1-array-temperaturas.md       ← Parte 4: Hands On 1 (array de temperaturas)
│   ├── 05-handson2-matriz-sensores.md          ← Parte 5: Hands On 2 (matriz de sensores)
│   └── 06-analise-conclusao.md                 ← Parte 6: análise crítica e conclusão
└── src/
    ├── ordenacao/
    │   ├── SortingUtils.java                   ← package ordenacao;
    │   └── Main.java                           ← package ordenacao;
    ├── busca/
    │   └── BuscaSequencial.java                ← package busca;
    ├── handson1/
    │   └── HandsOn1.java                       ← package handson1;
    └── handson2/
        └── HandsOn2.java                       ← package handson2;
```

## Sumário da entrega

| Parte | Conteúdo | Peso |
|---|---|---|
| [Parte 1](docs/01-pesquisa-bubble-quick.md) | Pesquisa e comparação entre Bubble Sort e Quick Sort | 0,20 |
| [Parte 2](docs/02-experimento-ordenacao.md) | Experimento de ordenação com arrays de 10, 20 e 1.000 elementos | 0,25 |
| [Parte 3](docs/03-busca-matrizes.md) | Busca sequencial em matrizes 2×2, 10×10 e 100×100 | 0,20 |
| [Parte 4](docs/04-handson1-array-temperaturas.md) | Hands On 1 — Investigação do array de temperaturas | 0,15 |
| [Parte 5](docs/05-handson2-matriz-sensores.md) | Hands On 2 — Matriz aplicada a sensores | 0,15 |
| [Parte 6](docs/06-analise-conclusao.md) | Análise crítica e conclusão geral | 0,05 |
| **Total** | | **1,00** |

## Como obter o projeto

Antes de executar qualquer código, você precisa ter os arquivos deste repositório na sua máquina. Existem duas formas de fazer isso — escolha a que for mais confortável.

### Opção A — Baixar como ZIP (mais simples, não exige nenhuma ferramenta instalada)

1. Acesse a página do repositório: [github.com/danilotavares-dev/analise-algoritmos-ordenacao-busca](https://github.com/danilotavares-dev/analise-algoritmos-ordenacao-busca)
2. Clique no botão verde **`<> Code`**, no canto superior direito da lista de arquivos.
3. Clique em **"Download ZIP"**.
4. Localize o arquivo baixado (geralmente na pasta "Downloads") e **extraia** o ZIP — no Windows, clique com o botão direito no arquivo → "Extrair tudo"; no macOS, basta dar duplo clique; no Linux, botão direito → "Extract Here" (ou `unzip nome-do-arquivo.zip` no terminal).
5. Pronto — a pasta extraída é o projeto completo, pronto para abrir no IntelliJ ou no terminal.

### Opção B — Clonar com Git (recomendado se você já usa Git)

Se tiver o **Git** instalado (confira digitando `git --version` no terminal), pode copiar o repositório inteiro com um único comando, mantendo o histórico de versões:

```bash
git clone https://github.com/danilotavares-dev/analise-algoritmos-ordenacao-busca.git
```

Esse comando cria uma pasta chamada `analise-algoritmos-ordenacao-busca` no diretório onde você rodou o comando, com todos os arquivos já dentro. Depois é só entrar nela:

```bash
cd analise-algoritmos-ordenacao-busca
```

> Não tem Git instalado? Baixe em [git-scm.com](https://git-scm.com/downloads) (Windows, macOS e Linux) ou simplesmente use a **Opção A** acima, que não exige instalar nada.

### Abrindo o projeto no IntelliJ

Depois de baixar (por qualquer uma das duas opções), abra o IntelliJ IDEA e:

1. Clique em **"Open"** (ou "File → Open" se já houver outro projeto aberto).
2. Selecione a pasta do projeto que você acabou de baixar/extrair (a que contém a pasta `src`).
3. Aguarde o IntelliJ indexar os arquivos. Se aparecer um aviso perguntando se você confia no projeto, clique em **"Trust Project"**.

---

## Como executar os códigos

Esta seção foi escrita para funcionar em **qualquer sistema operacional** (Windows, macOS ou Linux) e **sem exigir experiência prévia com terminal**. Se você nunca usou terminal antes, siga com calma — cada passo é explicado.

### Pré-requisito: ter o Java instalado

Antes de tudo, seu computador precisa ter o **JDK (Java Development Kit)** instalado — é o pacote que contém as ferramentas para compilar (`javac`) e executar (`java`) programas Java.

Para verificar se já está instalado, abra um terminal (Prompt de Comando/PowerShell no Windows, ou Terminal no macOS/Linux) e digite:

```bash
java -version
javac -version
```

Se aparecer um número de versão (ex.: `21.0.2`) para os dois comandos, está tudo certo. Se aparecer erro de "comando não encontrado", será necessário instalar o JDK antes de continuar (baixe em [adoptium.net](https://adoptium.net), que oferece instaladores para Windows, macOS e Linux).

> Se você for usar o **IntelliJ IDEA** (recomendado, veja a seção abaixo), o JDK já vem configurado automaticamente pela IDE — não é necessário instalar nada manualmente.

### O que significa "compilar" e "executar"

Java é uma linguagem que precisa ser **traduzida** antes de rodar. Esse processo tem dois passos:

1. **Compilar** (`javac`): transforma o código-fonte (`.java`, que é texto legível por humanos) em bytecode (`.class`, que a máquina entende). É como "traduzir" o programa.
2. **Executar** (`java`): roda o bytecode já traduzido.

Cada comando abaixo faz sempre esses dois passos, um atrás do outro: primeiro compila, depois executa.

---

### Opção 1 — Pelo IntelliJ IDEA (mais simples, recomendada)

Se você está usando o IntelliJ (como no desenvolvimento deste projeto), não precisa digitar nenhum comando:

1. Abra o projeto no IntelliJ.
2. No painel à esquerda, navegue até o arquivo desejado (ex.: `src/ordenacao/Main.java`).
3. Clique no botão verde ▶️ que aparece ao lado do nome da classe (ou clique com o botão direito no arquivo → **Run**).
4. A saída aparece automaticamente na aba **Run**, na parte inferior da tela. Se o programa pedir alguma informação (como no `BuscaSequencial` ou `HandsOn1`), digite as respostas ali mesmo.

Isso funciona **igual em Windows, macOS e Linux**, já que o IntelliJ lida com toda a configuração por trás.

---

### Opção 2 — Pelo terminal (qualquer sistema operacional)

Se preferir usar o terminal, os comandos abaixo funcionam **sem alterações** em Windows (Prompt de Comando ou PowerShell), macOS e Linux — não é necessário adaptar nada entre sistemas.

Antes de rodar qualquer comando, abra o terminal **na pasta raiz do projeto** (a pasta que contém a pasta `src`).

#### Parte 2 — Ordenação (Bubble Sort e Quick Sort)

```bash
javac -d out src/ordenacao/SortingUtils.java src/ordenacao/Main.java
java -cp out ordenacao.Main
```

#### Parte 3 — Busca em matrizes

```bash
javac -d out src/busca/BuscaSequencial.java
java -cp out busca.BuscaSequencial
```
*(o programa vai pedir a quantidade de linhas, colunas e o valor a ser buscado — digite e pressione Enter após cada um)*

#### Parte 4 — Hands On 1 (array de temperaturas)

```bash
javac -d out src/handson1/HandsOn1.java
java -cp out handson1.HandsOn1
```
*(o programa vai pedir 10 temperaturas, uma por vez)*

#### Parte 5 — Hands On 2 (matriz de sensores)

```bash
javac -d out src/handson2/HandsOn2.java
java -cp out handson2.HandsOn2
```
*(o programa vai pedir um valor de limite de temperatura)*

#### Entendendo o comando

- `javac -d out ...`: compila os arquivos `.java` listados e coloca os arquivos traduzidos (`.class`) dentro de uma pasta chamada `out`, mantendo a organização dos pacotes (`ordenacao`, `busca`, etc.). Essa pasta é criada automaticamente na primeira vez — não precisa criá-la manualmente.
- `java -cp out nome.DaClasse`: executa o programa já compilado. O `-cp out` diz ao Java "procure os arquivos compilados dentro da pasta `out`". O `nome.DaClasse` é o **pacote + nome da classe** (por exemplo, `ordenacao.Main` significa "a classe `Main`, que está dentro do pacote `ordenacao`").

> **Por que listar os arquivos em vez de usar `*.java`?** Alguns terminais do Windows não expandem automaticamente o `*` para "todos os arquivos" como o terminal do Linux/macOS faz. Por isso, listamos os arquivos um por um — assim o mesmo comando funciona sem alterações em qualquer sistema.

---

## Ideia central da atividade

> Dois algoritmos podem produzir exatamente o mesmo resultado e, ainda assim, realizar quantidades completamente diferentes de operações.

Por isso, em todos os experimentos deste repositório, buscou-se relacionar:

**Tamanho da entrada → Número de operações → Complexidade → Eficiência do algoritmo.**

## Comparação visual — crescimento das operações

![Bubble Sort vs Quick Sort — total de operações por tamanho de entrada](assets/grafico-comparativo-ordenacao.png)

*Escala logarítmica em ambos os eixos. Dados reais do experimento da [Parte 2](docs/02-experimento-ordenacao.md): com 1.000 elementos, o Bubble Sort realiza quase 47 vezes mais operações que o Quick Sort para produzir exatamente o mesmo resultado.*
