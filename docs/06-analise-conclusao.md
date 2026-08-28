# Parte 6 — Análise e Conclusão

[⬅ Voltar ao README principal](../README.md)

Conclusão geral comparando os experimentos realizados nas partes anteriores.

## 1. O aumento do tamanho da estrutura de dados influencia a quantidade de operações?

Sim, de forma bastante evidente em todos os experimentos realizados. Na ordenação ([Parte 2](02-experimento-ordenacao.md)), ao aumentar o array de 10 para 1.000 elementos (100 vezes maior), o Bubble Sort passou de 45 para 499.500 comparações, um crescimento muito mais que proporcional ao aumento do tamanho da entrada. Na busca sequencial em matrizes ([Parte 3](03-busca-matrizes.md)), ao aumentar de uma matriz 2×2 (4 elementos) para uma 100×100 (10.000 elementos), o número de comparações no pior caso cresceu na mesma proporção do aumento de elementos, confirmando a relação O(m × n). Em ambos os casos, fica claro que o tamanho da estrutura de dados tem impacto direto e mensurável na quantidade de operações necessárias, e esse impacto não é uniforme entre os diferentes algoritmos, como discutido na próxima pergunta.

## 2. Bubble Sort e Quick Sort crescem da mesma maneira quando o número de elementos aumenta?

Não, e essa é uma das conclusões centrais desta atividade. Embora os dois algoritmos produzam exatamente o mesmo resultado final (um array ordenado), eles crescem de formas completamente diferentes conforme o tamanho da entrada aumenta. O Bubble Sort, com complexidade O(n²), teve um crescimento quadrático: ao multiplicar o tamanho da entrada por 100 (de 10 para 1.000 elementos), suas comparações cresceram por um fator de aproximadamente 11.100 vezes. Já o Quick Sort, com complexidade O(n log n), teve um crescimento muito mais controlado: no mesmo intervalo, suas comparações cresceram por um fator de aproximadamente 374 vezes. Essa diferença se tornou dramaticamente visível na matriz de 1.000 elementos, onde o Bubble Sort realizou quase 47 vezes mais operações que o Quick Sort para produzir o mesmo resultado.

## 3. Por que analisar somente o resultado final da ordenação não é suficiente para comparar algoritmos?

Porque o resultado final, por si só, esconde completamente o custo computacional envolvido para chegar até ele. Se alguém observasse apenas os arrays ordenados produzidos pelo Bubble Sort e pelo Quick Sort, eles seriam idênticos — não haveria nenhuma diferença visível entre os dois. No entanto, como os experimentos desta atividade demonstraram, os dois algoritmos podem levar a esse mesmo resultado através de quantidades radicalmente diferentes de operações internas, comparações e trocas. Em um cenário de dados pequenos, essa diferença é irrelevante na prática. Mas em cenários de produção com grandes volumes de dados, a diferença entre um algoritmo O(n²) e um O(n log n) pode significar a diferença entre um sistema responsivo e um sistema que trava ou demora minutos para processar uma operação que deveria levar milissegundos. Por isso, medir e comparar o número de operações realizadas, e não apenas verificar se o resultado está correto, é essencial para avaliar a real eficiência de um algoritmo e escolher a ferramenta certa para cada situação, relacionando sempre tamanho da entrada, número de operações, complexidade teórica e eficiência prática — exatamente como esta atividade se propôs a investigar.

---

## Síntese final

| Tamanho da entrada | → | Número de operações | → | Complexidade | → | Eficiência do algoritmo |
|---|---|---|---|---|---|---|

Essa cadeia de relações, evidenciada em todas as partes deste trabalho — da ordenação ([Parte 2](02-experimento-ordenacao.md)) à busca em matrizes ([Parte 3](03-busca-matrizes.md)) e aos Hands On aplicados ([Parte 4](04-handson1-array-temperaturas.md) e [Parte 5](05-handson2-matriz-sensores.md)) — é o principal aprendizado desta atividade: **algoritmos que produzem o mesmo resultado podem ter custos computacionais radicalmente diferentes**, e é essa diferença que determina se uma solução escala bem ou se torna um gargalo à medida que os dados crescem.

---

[⬅ Voltar ao README principal](../README.md)