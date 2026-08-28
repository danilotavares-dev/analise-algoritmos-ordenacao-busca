# Parte 1 — Pesquisa: Bubble Sort e Quick Sort

[⬅ Voltar ao README principal](../README.md)

## 1. Bubble Sort

### 1.1 Como funciona

O Bubble Sort percorre o array múltiplas vezes, comparando pares de elementos adjacentes. Sempre que um par está fora de ordem, os elementos são trocados de posição. A cada passagem completa, o maior elemento ainda não posicionado "borbulha" até sua posição final, no final do array — daí o nome do algoritmo.

### 1.2 Lógica de ordenação

O algoritmo utiliza dois loops aninhados:

- **Loop externo:** controla o número de passagens realizadas sobre o array.
- **Loop interno:** percorre os pares de elementos vizinhos, comparando-os e trocando-os quando necessário.
  A cada passagem, o intervalo de comparação diminui, já que os últimos elementos do array já estão garantidamente ordenados. Uma otimização comum é interromper a execução antecipadamente com uma *flag* booleana, caso nenhuma troca ocorra em uma passagem completa — sinal de que o array já está totalmente ordenado.

### 1.3 Complexidade

| Cenário | Complexidade | Condição |
|---|---|---|
| Melhor caso | **O(n)** | Array já ordenado, com otimização de parada antecipada (apenas uma passagem sem trocas é necessária) |
| Caso médio | **O(n²)** | Em média, são necessárias múltiplas passagens com muitas comparações e trocas |
| Pior caso | **O(n²)** | Array em ordem reversa, exigindo o número máximo de comparações e trocas |

### 1.4 Vantagens

- Extremamente simples de entender e implementar.
- Estável (mantém a ordem relativa de elementos iguais).
- *In-place* — não requer memória extra significativa, O(1).
- Bom desempenho didático para ensinar lógica de ordenação.
- Eficiente em arrays quase ordenados, graças à otimização de parada antecipada.
### 1.5 Limitações

- Extremamente ineficiente para arrays grandes, devido à complexidade O(n²).
- Realiza muitas trocas desnecessárias em comparação com outros algoritmos O(n²), como o Selection Sort.
- Não é competitivo com algoritmos mais avançados na prática.
### 1.6 Situações em que seu uso é adequado

- Fins educacionais, para ensinar conceitos de algoritmos e complexidade.
- Arrays muito pequenos, onde a diferença de desempenho é irrelevante.
- Arrays quase ordenados, aproveitando a otimização de parada antecipada.
- Quando a simplicidade do código importa mais do que a performance.
### 1.7 Situações em que seu uso não é recomendado

- Conjuntos de dados grandes ou em ambientes de produção.
- Aplicações com restrição de tempo de execução.
- Qualquer cenário onde a performance seja crítica.
---

## 2. Quick Sort

### 2.1 Como funciona

O Quick Sort é um algoritmo de **divisão e conquista**. Escolhe-se um elemento como pivô, e o array é particionado de forma que todos os elementos menores que o pivô fiquem à esquerda, e os maiores à direita. Após o particionamento, o pivô está em sua posição final. O processo se repete recursivamente nas sub-partições esquerda e direita.

### 2.2 Lógica de ordenação

A função principal (`quickSort`) verifica o caso base — sub-array com 0 ou 1 elemento — e chama a função de particionamento. O particionamento usa ponteiros que percorrem o array a partir das extremidades, movendo elementos menores que o pivô para a esquerda e maiores para a direita, trocando-os quando necessário. Depois de particionar, a função chama recursivamente a si mesma nas duas metades resultantes.

### 2.3 Complexidade

| Cenário | Complexidade | Condição |
|---|---|---|
| Melhor caso | **O(n log n)** | O pivô escolhido sempre divide o array em duas partes aproximadamente iguais |
| Caso médio | **O(n log n)** | Comportamento típico na prática, mesmo com escolhas razoáveis de pivô |
| Pior caso | **O(n²)** | O pivô escolhido é sempre o menor ou maior elemento (ex.: arrays já ordenados com pivô fixo no primeiro ou último elemento), gerando partições extremamente desbalanceadas |

### 2.4 Vantagens

- Muito eficiente na prática, com bom desempenho médio de O(n log n).
- *In-place*, com baixo uso de memória extra — O(log n) para a pilha de recursão.
- Geralmente mais rápido que outros algoritmos O(n log n) devido a boas constantes e boa localidade de cache.
- Amplamente usado em bibliotecas padrão de diversas linguagens de programação.
### 2.5 Limitações

- Não é estável — pode alterar a ordem relativa de elementos iguais.
- Pior caso O(n²), que pode ocorrer em dados já ordenados ou adversariais, dependendo da estratégia de pivô adotada.
- Desempenho sensível à escolha do pivô.
- Recursão profunda pode causar *overflow* de pilha em casos patológicos, se não houver otimização.
### 2.6 Situações em que seu uso é adequado

- Conjuntos de dados grandes, onde a performance é importante.
- Ordenação *in-place* com uso limitado de memória.
- Aplicações de propósito geral, quando a estabilidade não é um requisito.
- Quando se pode escolher boas estratégias de pivô (mediana de três, pivô aleatório) para evitar o pior caso.
### 2.7 Situações em que seu uso não é recomendado

- Quando a estabilidade da ordenação é um requisito do sistema.
- Dados com alta probabilidade de já estarem ordenados ou quase ordenados, sem uma boa estratégia de pivô (risco de pior caso).
- Sistemas com garantias estritas de tempo de execução no pior caso — nesses cenários, Merge Sort ou Heap Sort, que garantem O(n log n) sempre, são preferíveis.
---

## 3. Tabela Comparativa

| Característica | Bubble Sort | Quick Sort |
|---|---|---|
| **Princípio de funcionamento** | Comparação e troca de elementos vizinhos | Divisão e conquista: particionamento em torno de um pivô |
| **Melhor caso** | O(n) | O(n log n) |
| **Caso médio** | O(n²) | O(n log n) |
| **Pior caso** | O(n²) | O(n²) |
| **Uso de memória** | O(1), *in-place* | O(log n), pela pilha de recursão |
| **Vantagem principal** | Simplicidade de implementação e estabilidade | Alta eficiência prática em conjuntos grandes de dados |
| **Limitação principal** | Ineficiente para conjuntos grandes de dados | Pior caso O(n²) e instabilidade na ordenação |
| **Aplicação recomendada** | Fins didáticos, arrays pequenos ou quase ordenados | Conjuntos de dados grandes, uso geral em produção |
 
---

## 4. Conclusão da pesquisa

Apesar de resolverem o mesmo problema — ordenar um conjunto de dados —, Bubble Sort e Quick Sort partem de estratégias fundamentalmente diferentes: o primeiro se baseia em comparações e trocas sucessivas entre vizinhos, enquanto o segundo se apoia em divisão e conquista via particionamento por pivô. Essa diferença estrutural se reflete diretamente na complexidade assintótica de cada um, tornando o Quick Sort a escolha preferencial para a maioria dos cenários práticos com grandes volumes de dados, enquanto o Bubble Sort mantém seu valor em contextos didáticos e em casos específicos de arrays pequenos ou quase ordenados.

Esses fundamentos teóricos são validados experimentalmente na [Parte 2](02-experimento-ordenacao.md).