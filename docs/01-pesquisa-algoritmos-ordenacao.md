# Parte 1 — Pesquisa: Bubble Sort, Selection Sort, Insertion Sort e Quick Sort

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

## 2. Selection Sort

### 2.1 Como funciona

O Selection Sort divide o array em duas regiões conceituais: uma parte já ordenada (à esquerda) e uma parte não ordenada (à direita). Em cada passagem, o algoritmo **procura o menor elemento** dentro da região não ordenada e o troca de posição com o primeiro elemento dessa região, expandindo assim a parte ordenada em um elemento por vez.

### 2.2 Lógica de ordenação

O algoritmo também utiliza dois loops aninhados, mas com um papel diferente do Bubble Sort:

- **Loop externo:** percorre cada posição `i` do array, do início até o penúltimo elemento, representando a fronteira entre a região ordenada e a não ordenada.
- **Loop interno:** percorre a região não ordenada (de `i+1` até o final), apenas **comparando** valores para encontrar o índice do menor elemento — sem realizar nenhuma troca durante essa busca.
  Só depois que o loop interno termina é que ocorre **uma única troca** entre a posição `i` e a posição do menor elemento encontrado. Isso significa que o número de trocas é, no máximo, `n-1`, independentemente de quão desordenado o array esteja.

### 2.3 Complexidade

| Cenário | Complexidade | Condição |
|---|---|---|
| Melhor caso | **O(n²)** | Mesmo com o array já ordenado, o algoritmo ainda percorre toda a região não ordenada em cada passagem para confirmar qual é o menor elemento |
| Caso médio | **O(n²)** | O número de comparações é fixo e não depende da ordem inicial dos dados |
| Pior caso | **O(n²)** | Comportamento idêntico ao caso médio — o Selection Sort não tem otimização de parada antecipada |

### 2.4 Vantagens

- Número de trocas extremamente baixo — no máximo `n-1` trocas, o que é vantajoso quando a operação de escrita/troca é custosa (ex.: memórias com custo de escrita elevado).
- Simples de entender e implementar.
- *In-place* — O(1) de memória extra.
- Desempenho previsível: o número de comparações é sempre o mesmo, independentemente da ordem dos dados de entrada.
### 2.5 Limitações

- Sempre O(n²) em comparações, mesmo no melhor caso — não se beneficia de arrays já ordenados ou quase ordenados.
- Na implementação convencional, não é estável (pode alterar a ordem relativa de elementos iguais durante as trocas).
- Ineficiente para conjuntos de dados grandes, assim como o Bubble Sort.
### 2.6 Situações em que seu uso é adequado

- Cenários onde o custo de cada troca/escrita é muito maior que o custo de uma comparação.
- Arrays pequenos ou fins didáticos.
- Quando é importante ter um número previsível e mínimo de operações de escrita.
### 2.7 Situações em que seu uso não é recomendado

- Conjuntos de dados grandes.
- Dados já ordenados ou quase ordenados, onde outros algoritmos O(n²) (como o Insertion Sort) se beneficiariam da ordem parcial.
- Cenários em que a estabilidade da ordenação é um requisito.
---

## 3. Insertion Sort

### 3.1 Como funciona

O Insertion Sort constrói o array ordenado **um elemento por vez**, de forma parecida com organizar cartas de baralho na mão: cada novo elemento é comparado com os elementos já ordenados à sua esquerda e inserido na posição correta entre eles, deslocando os elementos maiores uma posição à frente para abrir espaço.

### 3.2 Lógica de ordenação

- **Loop externo:** percorre o array a partir do segundo elemento (índice 1) até o último, tratando cada elemento como a "carta" a ser inserida na sequência já ordenada.
- **Loop interno:** compara essa carta com os elementos já ordenados à sua esquerda, deslocando-os uma posição à direita enquanto forem maiores que ela, até encontrar a posição correta para inserção.
  Diferente do Selection Sort, aqui o número de comparações e deslocamentos varia bastante conforme o quão ordenado o array já está: em um array já ordenado, o loop interno praticamente não executa nenhum deslocamento.

### 3.3 Complexidade

| Cenário | Complexidade | Condição |
|---|---|---|
| Melhor caso | **O(n)** | Array já ordenado — cada elemento exige apenas uma comparação para confirmar que já está na posição correta, sem deslocamentos |
| Caso médio | **O(n²)** | Em média, cada elemento precisa ser deslocado por aproximadamente metade da parte já ordenada |
| Pior caso | **O(n²)** | Array em ordem reversa, onde cada novo elemento precisa ser deslocado até o início do array |

### 3.4 Vantagens

- Muito eficiente para arrays pequenos ou já quase ordenados, aproveitando-se da ordem parcial dos dados.
- Estável (mantém a ordem relativa de elementos iguais).
- *In-place* — O(1) de memória extra.
- **Adaptativo**: seu desempenho melhora automaticamente conforme os dados de entrada já estão mais próximos da ordem final.
- **Online**: pode ordenar os dados conforme eles chegam, sem precisar do array completo de antemão — útil em streams de dados.
### 3.5 Limitações

- Ineficiente para conjuntos de dados grandes e desordenados, devido à complexidade O(n²) no caso médio e pior caso.
- Número de deslocamentos pode ser alto em arrays em ordem reversa.
### 3.6 Situações em que seu uso é adequado

- Arrays pequenos.
- Dados já ordenados ou quase ordenados (ex.: pequenas atualizações em uma lista já ordenada).
- Ordenação *online*, com dados chegando progressivamente.
- Como sub-rotina em algoritmos híbridos (por exemplo, é usado internamente por implementações de Quick Sort e Timsort para ordenar pequenas partições).
### 3.7 Situações em que seu uso não é recomendado

- Conjuntos de dados grandes e sem ordem prévia conhecida.
- Cenários com restrições estritas de desempenho em larga escala.
---

## 4. Quick Sort

### 4.1 Como funciona

O Quick Sort é um algoritmo de **divisão e conquista**. Escolhe-se um elemento como pivô, e o array é particionado de forma que todos os elementos menores que o pivô fiquem à esquerda, e os maiores à direita. Após o particionamento, o pivô está em sua posição final. O processo se repete recursivamente nas sub-partições esquerda e direita.

### 4.2 Lógica de ordenação

A função principal (`quickSort`) verifica o caso base — sub-array com 0 ou 1 elemento — e chama a função de particionamento. O particionamento usa ponteiros que percorrem o array a partir das extremidades, movendo elementos menores que o pivô para a esquerda e maiores para a direita, trocando-os quando necessário. Depois de particionar, a função chama recursivamente a si mesma nas duas metades resultantes.

### 4.3 Complexidade

| Cenário | Complexidade | Condição |
|---|---|---|
| Melhor caso | **O(n log n)** | O pivô escolhido sempre divide o array em duas partes aproximadamente iguais |
| Caso médio | **O(n log n)** | Comportamento típico na prática, mesmo com escolhas razoáveis de pivô |
| Pior caso | **O(n²)** | O pivô escolhido é sempre o menor ou maior elemento (ex.: arrays já ordenados com pivô fixo no primeiro ou último elemento), gerando partições extremamente desbalanceadas |

### 4.4 Vantagens

- Muito eficiente na prática, com bom desempenho médio de O(n log n).
- *In-place*, com baixo uso de memória extra — O(log n) para a pilha de recursão.
- Geralmente mais rápido que outros algoritmos O(n log n) devido a boas constantes e boa localidade de cache.
- Amplamente usado em bibliotecas padrão de diversas linguagens de programação.
### 4.5 Limitações

- Não é estável — pode alterar a ordem relativa de elementos iguais.
- Pior caso O(n²), que pode ocorrer em dados já ordenados ou adversariais, dependendo da estratégia de pivô adotada.
- Desempenho sensível à escolha do pivô.
- Recursão profunda pode causar *overflow* de pilha em casos patológicos, se não houver otimização.
### 4.6 Situações em que seu uso é adequado

- Conjuntos de dados grandes, onde a performance é importante.
- Ordenação *in-place* com uso limitado de memória.
- Aplicações de propósito geral, quando a estabilidade não é um requisito.
- Quando se pode escolher boas estratégias de pivô (mediana de três, pivô aleatório) para evitar o pior caso.
### 4.7 Situações em que seu uso não é recomendado

- Quando a estabilidade da ordenação é um requisito do sistema.
- Dados com alta probabilidade de já estarem ordenados ou quase ordenados, sem uma boa estratégia de pivô (risco de pior caso).
- Sistemas com garantias estritas de tempo de execução no pior caso — nesses cenários, Merge Sort ou Heap Sort, que garantem O(n log n) sempre, são preferíveis.
---

## 5. Tabela Comparativa

| Característica | Bubble Sort | Selection Sort | Insertion Sort | Quick Sort |
|---|---|---|---|---|
| **Princípio de funcionamento** | Comparação e troca de elementos vizinhos | Busca do menor elemento da região não ordenada, com uma troca por passagem | Inserção de cada elemento na posição correta entre os já ordenados | Divisão e conquista: particionamento em torno de um pivô |
| **Melhor caso** | O(n) | O(n²) | O(n) | O(n log n) |
| **Caso médio** | O(n²) | O(n²) | O(n²) | O(n log n) |
| **Pior caso** | O(n²) | O(n²) | O(n²) | O(n²) |
| **Número de trocas/escritas** | Alto — uma troca por par fora de ordem encontrado | Muito baixo — no máximo `n-1` trocas | Alto em dados desordenados — deslocamentos por posição | Baixo em relação ao volume de dados, mas variável |
| **Estável?** | Sim | Não (na implementação convencional) | Sim | Não |
| **Uso de memória** | O(1), *in-place* | O(1), *in-place* | O(1), *in-place* | O(log n), pela pilha de recursão |
| **Vantagem principal** | Simplicidade de implementação e estabilidade | Número mínimo e previsível de trocas | Excelente em dados quase ordenados; estável e *online* | Alta eficiência prática em conjuntos grandes de dados |
| **Limitação principal** | Ineficiente para conjuntos grandes de dados | Sempre O(n²) em comparações, mesmo já ordenado | Ineficiente para grandes volumes desordenados | Pior caso O(n²) e instabilidade na ordenação |
| **Aplicação recomendada** | Fins didáticos, arrays pequenos ou quase ordenados | Quando trocas são mais custosas que comparações | Arrays pequenos, quase ordenados ou ordenação *online* | Conjuntos de dados grandes, uso geral em produção |
 
---

## 6. Conclusão da pesquisa

Apesar de resolverem o mesmo problema — ordenar um conjunto de dados —, os quatro algoritmos investigados partem de estratégias fundamentalmente diferentes. Bubble Sort, Selection Sort e Insertion Sort compartilham a complexidade O(n²) no caso médio e pior caso, mas chegam a esse custo por caminhos distintos: o Bubble Sort troca pares vizinhos repetidamente, o Selection Sort concentra a busca em comparações e minimiza as trocas, e o Insertion Sort desloca elementos para abrir espaço, aproveitando-se bem de dados já parcialmente ordenados. Já o Quick Sort se apoia em divisão e conquista via particionamento por pivô, o que lhe garante complexidade O(n log n) no caso médio — uma ordem de grandeza mais eficiente para conjuntos de dados grandes.

Essa diferença estrutural se reflete diretamente na quantidade de operações realizadas por cada algoritmo, tornando o Quick Sort a escolha preferencial para a maioria dos cenários práticos com grandes volumes de dados. Entre os três algoritmos O(n²), a escolha depende do contexto: o Insertion Sort se destaca em dados quase ordenados ou em ordenação *online*, o Selection Sort é preferível quando o custo de cada troca é alto, e o Bubble Sort mantém seu valor principalmente em contextos didáticos.

Esses fundamentos teóricos são validados experimentalmente na [Parte 2](02-experimento-ordenacao.md).