# Parte 6 — Análise e Conclusão

[⬅ Voltar ao README principal](../README.md)

Conclusão geral comparando os experimentos realizados nas partes anteriores.

## 1. O aumento do tamanho da estrutura de dados influencia a quantidade de operações?

Sim, de forma bastante evidente em todos os experimentos realizados. Na ordenação ([Parte 2](02-experimento-ordenacao.md)), ao aumentar o array de 10 para 1.000 elementos (100 vezes maior), o Bubble Sort passou de 45 para 499.500 comparações e o Selection Sort teve exatamente o mesmo salto — um crescimento muito mais que proporcional ao aumento do tamanho da entrada. O Insertion Sort, embora também O(n²), cresceu de 26 para 254.105 comparações, um pouco menos que os outros dois por se beneficiar parcialmente da ordem parcial dos dados já processados. Na busca sequencial em matrizes ([Parte 3](03-busca-matrizes.md)), ao aumentar de uma matriz 2×2 (4 elementos) para uma 100×100 (10.000 elementos), o número de comparações no pior caso cresceu na mesma proporção do aumento de elementos, confirmando a relação O(m × n). Em ambos os casos, fica claro que o tamanho da estrutura de dados tem impacto direto e mensurável na quantidade de operações necessárias, e esse impacto não é uniforme entre os diferentes algoritmos, como discutido na próxima pergunta.

## 2. Bubble Sort, Selection Sort, Insertion Sort e Quick Sort crescem da mesma maneira quando o número de elementos aumenta?

Não, e essa é uma das conclusões centrais desta atividade. Embora os quatro algoritmos produzam exatamente o mesmo resultado final (um array ordenado), eles crescem de formas muito diferentes conforme o tamanho da entrada aumenta.

Bubble Sort, Selection Sort e Insertion Sort compartilham a complexidade O(n²), mas não crescem de forma idêntica entre si. Ao multiplicar o tamanho da entrada por 100 (de 10 para 1.000 elementos):

- As comparações do **Bubble Sort** cresceram por um fator de aproximadamente **11.100 vezes** (de 45 para 499.500).
- As comparações do **Selection Sort** cresceram exatamente na mesma proporção — **11.100 vezes** (de 45 para 499.500) —, já que sua implementação, assim como a do Bubble Sort, não possui otimização de parada antecipada e sempre executa `n·(n-1)/2` comparações, independentemente da ordem dos dados.
- As comparações do **Insertion Sort** cresceram por um fator um pouco menor, de aproximadamente **9.773 vezes** (de 26 para 254.105), refletindo o fato de que ele se adapta parcialmente à ordem já processada do array, mesmo em uma entrada aleatória.

Já o **Quick Sort**, com complexidade O(n log n), teve um crescimento muito mais controlado: no mesmo intervalo, suas comparações cresceram por um fator de apenas **374 vezes** (de 36 para 13.466). Essa diferença se tornou dramaticamente visível no array de 1.000 elementos, onde o Bubble Sort realizou quase 47 vezes mais operações que o Quick Sort para produzir o mesmo resultado — enquanto Selection Sort e Insertion Sort, apesar de também O(n²), ficaram numa faixa intermediária, ambos em torno de 500 mil operações totais.

Um detalhe que reforça como "mesma complexidade" não significa "mesmo comportamento": o número de trocas do Bubble Sort e o número de deslocamentos do Insertion Sort para 1.000 elementos foram **exatamente iguais** (253.113), pois ambos correspondem ao número de inversões do array original. O Selection Sort, por sua vez, mesmo sendo O(n²) como os outros dois, fez apenas 995 trocas nesse mesmo tamanho — uma ordem de grandeza menor —, porque nunca troca mais de uma vez por posição percorrida. Isso mostra que, dentro de uma mesma classe de complexidade, a forma como cada algoritmo distribui seu custo entre comparações e trocas pode variar bastante.

## 3. Por que analisar somente o resultado final da ordenação não é suficiente para comparar algoritmos?

Porque o resultado final, por si só, esconde completamente o custo computacional envolvido para chegar até ele. Se alguém observasse apenas os arrays ordenados produzidos pelo Bubble Sort, pelo Selection Sort, pelo Insertion Sort e pelo Quick Sort, eles seriam idênticos — não haveria nenhuma diferença visível entre eles. No entanto, como os experimentos desta atividade demonstraram, os quatro algoritmos podem levar a esse mesmo resultado através de quantidades radicalmente diferentes de operações internas, comparações e trocas — e até mesmo algoritmos da mesma classe de complexidade (como os três O(n²)) podem se comportar de maneiras bem distintas entre si, como visto na questão anterior. Em um cenário de dados pequenos, essa diferença é irrelevante na prática — inclusive, foi possível observar no experimento que, para apenas 10 elementos, o Insertion Sort chegou a realizar menos operações que o próprio Quick Sort. Mas em cenários de produção com grandes volumes de dados, a diferença entre algoritmos O(n²) e um O(n log n) pode significar a diferença entre um sistema responsivo e um sistema que trava ou demora minutos para processar uma operação que deveria levar milissegundos. Por isso, medir e comparar o número de operações realizadas, e não apenas verificar se o resultado está correto, é essencial para avaliar a real eficiência de um algoritmo e escolher a ferramenta certa para cada situação, relacionando sempre tamanho da entrada, número de operações, complexidade teórica e eficiência prática — exatamente como esta atividade se propôs a investigar.

---

## Síntese final

| Tamanho da entrada | → | Número de operações | → | Complexidade | → | Eficiência do algoritmo |
|---|---|---|---|---|---|---|

Essa cadeia de relações, evidenciada em todas as partes deste trabalho — da ordenação ([Parte 2](02-experimento-ordenacao.md)) à busca em matrizes ([Parte 3](03-busca-matrizes.md)) e aos Hands On aplicados ([Parte 4](04-handson1-array-temperaturas.md) e [Parte 5](05-handson2-matriz-sensores.md)) — é o principal aprendizado desta atividade: **algoritmos que produzem o mesmo resultado podem ter custos computacionais radicalmente diferentes, e até algoritmos da mesma classe de complexidade podem se comportar de formas bem distintas entre si**. É essa diferença que determina se uma solução escala bem ou se torna um gargalo à medida que os dados crescem.

---

[⬅ Voltar ao README principal](../README.md)