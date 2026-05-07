# Lista Simplesmente Encadeada em Java
### Material Didático — Estruturas de Dados e Linguagens

---

## Sumário

1. [O que é uma lista encadeada?](#1-o-que-é-uma-lista-encadeada)
2. [O Nó: a unidade da lista](#2-o-nó-a-unidade-da-lista)
3. [Passo a passo: construindo a lista do zero](#3-passo-a-passo-construindo-a-lista-do-zero)
4. [Definindo um contrato com interfaces](#4-definindo-um-contrato-com-interfaces)
5. [Análise de cada método](#5-análise-de-cada-método)
6. [Bugs clássicos e como evitá-los](#6-bugs-clássicos-e-como-evitá-los)
7. [Retornos seguros com Optional](#7-retornos-seguros-com-optional)
8. [Boas práticas consolidadas](#8-boas-práticas-consolidadas)

---

## 1. O que é uma lista encadeada?

Uma **lista simplesmente encadeada** é uma estrutura de dados linear onde cada elemento
(chamado de **nó**) guarda dois dados:

- o **valor** armazenado naquela posição
- uma **referência** (ponteiro) para o próximo nó da sequência

O último nó aponta para `null`, indicando o fim da lista.

```
início
  │
  ▼
┌──────────┐    ┌──────────┐    ┌──────────┐
│ dado: 10 │───▶│ dado: 20 │───▶│ dado: 30 │───▶ null
└──────────┘    └──────────┘    └──────────┘
```

Diferente de um array, a lista encadeada **não ocupa posições contíguas** na memória.
Cada nó pode estar em qualquer lugar: o que os conecta é a referência `proximo`.

### Comparativo rápido

| Característica        | Array          | Lista Encadeada     |
|-----------------------|----------------|---------------------|
| Tamanho               | Fixo           | Dinâmico            |
| Acesso por índice     | O(1) — direto  | O(n) — precisa percorrer |
| Inserção/remoção      | O(n) — desloca | O(1) no início, O(n) no meio/fim |
| Uso de memória        | Contíguo       | Fragmentado         |

---

## 2. O Nó: a unidade da lista

O nó é a peça fundamental. Antes de criar a lista, é preciso criar o nó.

```java
public class No<T> {
    private T dado;
    private No<T> proximo;
}
```

### Por que `<T>` (Generics)?

O `<T>` é um **tipo genérico**. Ele permite que o nó guarde qualquer tipo de dado:
`Integer`, `String`, `Aluno`, etc., sem precisar criar uma classe diferente para cada tipo.

```java
No<Integer> noInteiro = new No<>(42);
No<String>  noTexto   = new No<>("Olá");
```

Se não usássemos generics, precisaríamos de `NoInteger`, `NoString`, `NoAluno`... — inviável.

### Por que os atributos são `private`?

Encapsulamento: ninguém acessa ou modifica `dado` e `proximo` diretamente.
Todo acesso passa pelos métodos `get` e `set`, que você controla.

```java
// Errado — acesso direto quebraria o encapsulamento
no.dado = 10;

// Correto — acesso controlado
no.setDado(10);
int valor = no.getDado();
```

### Dois construtores: por quê?

```java
public No(T dado) { ... }                    // cria nó sem próximo (null)
public No(T dado, No<T> proximo) { ... }     // cria nó já conectado ao próximo
```

O segundo construtor evita código repetido na lista. Ao inserir no início, por exemplo:

```java
// Sem o segundo construtor — duas linhas
No<T> novo = new No<>(dado);
novo.setProximo(this.inicio);

// Com o segundo construtor — uma linha, mais claro
No<T> novo = new No<>(dado, this.inicio);
```

---

## 3. Passo a passo: construindo a lista do zero

A seguir, cada etapa de construção da lista descrita em linguagem natural,
seguida pelo código correspondente.

---

### Etapa 1 — Estrutura inicial

**Em linguagem natural:**
> A lista precisa saber onde começa. Crie um atributo `inicio` que aponta para o
> primeiro nó. No começo, a lista está vazia, então `inicio` vale `null`.
> Mantenha também um contador `tamanho` para saber quantos elementos existem
> sem precisar percorrer a lista toda.

```java
public class ListaEncadeada<T> {
    private No<T> inicio;
    private int tamanho;

    public ListaEncadeada() {
        this.inicio = null;
        this.tamanho = 0;
    }
}
```

---

### Etapa 2 — Adicionar ao final

**Em linguagem natural:**
> Para adicionar ao final, existem dois casos:
> 1. A lista está vazia: o novo nó vira o `inicio`.
> 2. A lista tem elementos: percorra do início até o nó cujo `proximo` seja `null`
>    (esse é o último). Faça esse nó apontar para o novo.
> Em ambos os casos, incremente o `tamanho`.

```java
public void adicionar(T dado) {
    if (this.inicio == null) {
        this.inicio = new No<>(dado);
        tamanho++;
        return;
    }
    No<T> noAux = this.inicio;
    while (noAux.getProximo() != null) {
        noAux = noAux.getProximo();
    }
    noAux.setProximo(new No<>(dado));
    tamanho++;
}
```

**Visualização do percurso:**
```
[10] → [20] → [30] → null    adicionar(40)

noAux começa em [10]
  [10].proximo != null → avança
  [20].proximo != null → avança
  [30].proximo == null → parou aqui
[30].proximo = novo No(40)

[10] → [20] → [30] → [40] → null  ✓
```

---

### Etapa 3 — Adicionar em posição específica

**Em linguagem natural:**
> Para inserir na posição `p`, encontre o nó que está em `p-1` (o anterior).
> Faça o novo nó apontar para o que estava em `p`, e o nó anterior apontar
> para o novo. Se `p == 0`, o novo nó vira o início.
> Valide antes: posição negativa ou maior que o tamanho é inválida.

```java
public boolean adicionar(int posicao, T dado) {
    if (posicao < 0 || posicao > tamanho) return false;

    if (posicao == 0) {
        this.inicio = new No<>(dado, this.inicio);
        tamanho++;
        return true;
    }

    No<T> noAux = this.inicio;
    for (int i = 0; i < posicao - 1; i++) {
        noAux = noAux.getProximo();
    }
    noAux.setProximo(new No<>(dado, noAux.getProximo()));
    tamanho++;
    return true;
}
```

**Visualização — inserir 25 na posição 2:**
```
[10] → [20] → [30] → [40] → null

Percorre até pos[1] (i < 2-1, ou seja, i < 1):
  noAux para em [20]

Novo nó(25) aponta para [30]  (noAux.getProximo())
[20] aponta para nó(25)

[10] → [20] → [25] → [30] → [40] → null  ✓
```

> **Por que retornar `boolean`?**
> O chamador precisa saber se a operação funcionou. Retornar `void` obriga
> o chamador a adivinhar ou checar o estado da lista depois.

---

### Etapa 4 — Remover por posição

**Em linguagem natural:**
> Para remover o nó na posição `p`, encontre o nó em `p-1` (o anterior).
> Faça o anterior apontar para o nó em `p+1`, "pulando" o nó em `p`.
> Se `p == 0`, basta mover o `inicio` para o segundo nó.
> Valide: lista vazia, posição negativa ou maior/igual ao tamanho → retorne `false`.

```java
public boolean remover(int posicao) {
    if (this.inicio == null || posicao < 0 || posicao >= tamanho) return false;

    if (posicao == 0) {
        this.inicio = this.inicio.getProximo();
        tamanho--;
        return true;
    }

    No<T> noAux = this.inicio;
    for (int i = 0; i < posicao - 1; i++) {
        noAux = noAux.getProximo();
    }
    noAux.setProximo(noAux.getProximo().getProximo());
    tamanho--;
    return true;
}
```

**Visualização — remover posição 2:**
```
[10] → [20] → [30] → [40] → null

Percorre até pos[1] (i < 2-1, ou seja, i < 1):
  noAux para em [20]

[20].setProximo([20].getProximo().getProximo())
  = [20].setProximo([30].getProximo())
  = [20].setProximo([40])

[10] → [20] → [40] → null  ✓  (nó [30] foi removido)
```

---

### Etapa 5 — Remover por valor

**Em linguagem natural:**
> Percorra a lista comparando cada valor com `equals`. Quando encontrar, faça
> o nó anterior apontar para o próximo do encontrado. Se for o primeiro nó,
> mova o `inicio`.

```java
public boolean remover(T dado) {
    if (this.inicio == null) return false;

    if (this.inicio.getDado().equals(dado)) {
        this.inicio = this.inicio.getProximo();
        tamanho--;
        return true;
    }

    No<T> noAux = this.inicio;
    while (noAux.getProximo() != null) {
        if (noAux.getProximo().getDado().equals(dado)) {
            noAux.setProximo(noAux.getProximo().getProximo());
            tamanho--;
            return true;
        }
        noAux = noAux.getProximo();
    }
    return false;
}
```

> **Por que `equals` e não `==`?**
> O operador `==` compara **referências de memória** (se são o mesmo objeto).
> O `equals` compara **conteúdo**. Para tipos como `Integer` e `String`,
> dois objetos diferentes podem ter o mesmo valor — use sempre `equals`.

```java
Integer a = new Integer(10);
Integer b = new Integer(10);
a == b       // false  — objetos diferentes na memória
a.equals(b)  // true   — mesmo valor
```

---

### Etapa 6 — Buscar por posição

**Em linguagem natural:**
> Percorra até a posição desejada e retorne o dado. Valide a posição antes.
> Use `Optional<T>` para indicar ao chamador que o resultado pode estar ausente,
> sem precisar retornar `null`.

```java
public Optional<T> obter(int posicao) {
    if (posicao < 0 || posicao >= tamanho) return Optional.empty();

    No<T> noAux = this.inicio;
    for (int i = 0; i < posicao; i++) {
        noAux = noAux.getProximo();
    }
    return Optional.of(noAux.getDado());
}
```

---

### Etapa 7 — Métodos de consulta de estado

**Em linguagem natural:**
> Uma lista precisa responder perguntas simples: está vazia? quantos elementos tem?
> Esses métodos evitam que o código externo acesse os atributos internos diretamente.

```java
public int getTamanho() {
    return tamanho;
}

public boolean estaVazia() {
    return this.inicio == null;
}

public void limpar() {
    this.inicio = null;
    this.tamanho = 0;
}
```

> **Por que `limpar()` em vez de `this.inicio = null` diretamente?**
> Encapsulamento: o chamador não precisa saber como a lista é implementada internamente.
> Além disso, se no futuro a lista ganhar outros atributos (como `fim`), o `limpar()`
> garante que todos sejam zerados em um único lugar.

---

### Etapa 8 — `toString()` no lugar de `mostrarTodosElementos()`

**Em linguagem natural:**
> Em vez de um método que imprime diretamente no console, sobrescreva `toString()`.
> Assim a representação textual da lista pode ser usada em qualquer contexto:
> impressão, logs, comparações, testes.

```java
@Override
public String toString() {
    if (estaVazia()) return "[]";

    StringBuilder sb = new StringBuilder("[");
    No<T> noAux = this.inicio;
    while (noAux != null) {
        sb.append(noAux.getDado());
        if (noAux.getProximo() != null) sb.append(" -> ");
        noAux = noAux.getProximo();
    }
    sb.append("]");
    return sb.toString();
}
```

```java
// Com mostrarTodosElementos() — só funciona no console
lista.mostrarTodosElementos();

// Com toString() — funciona em qualquer contexto
System.out.println(lista);       // imprime
String s = lista.toString();     // armazena
log.info("Estado: " + lista);    // loga
assertEquals("[10 -> 20]", lista.toString()); // testa
```

> **`StringBuilder` em vez de concatenação com `+`?**
> Concatenar strings com `+` dentro de um loop cria um novo objeto `String`
> a cada iteração — ineficiente. `StringBuilder` monta o resultado em um
> buffer e gera a string final uma única vez.

---

## 4. Definindo um contrato com interfaces

### O que é uma interface?

Uma **interface** define **o que** uma classe deve fazer, sem dizer **como** ela faz.
É um contrato: qualquer classe que implemente `ILista<T>` garante ter todos os métodos.

```java
public interface ILista<T> {
    void adicionar(T dado);
    boolean adicionar(int posicao, T dado);
    Optional<T> obter(int posicao);
    boolean remover(int posicao);
    boolean remover(T dado);
    boolean contemNaLista(T dado);
    int getTamanho();
    boolean estaVazia();
    void limpar();
}
```

```java
public class ListaEncadeada<T> implements ILista<T> {
    // obrigada a implementar todos os métodos da interface
}
```

### Por que usar interface aqui?

**1. Clareza de contrato:** o leitor do código sabe exatamente o que a lista oferece
apenas lendo a interface — sem precisar explorar a implementação.

**2. Substituição fácil:** se amanhã você criar `ListaDuplamenteEncadeada<T>`,
basta implementar `ILista<T>`. O código que usa a lista não muda:

```java
ILista<Integer> lista = new ListaEncadeada<>();    // hoje
ILista<Integer> lista = new ListaDuplamente<>();   // amanhã — sem alterar o resto
```

**3. Facilita testes:** é possível criar uma implementação falsa (`mock`) da interface
para testar código que depende da lista, sem precisar da implementação real.

---

## 5. Análise de cada método

### `contemNaLista` — de `void` para `boolean`

**Antes:**
```java
public void contemNaLista(T dado) {}   // vazio e sem retorno útil
```

**Depois:**
```java
public boolean contemNaLista(T dado) {
    No<T> noAux = this.inicio;
    while (noAux != null) {
        if (noAux.getDado().equals(dado)) return true;
        noAux = noAux.getProximo();
    }
    return false;
}
```

**Por quê?** Um método chamado `contemNa...` é uma **pergunta**: sua resposta natural
é sim ou não. Retornar `void` não comunica nada ao chamador. Com `boolean`:

```java
if (lista.contemNaLista(25)) {
    System.out.println("Encontrado!");
}
```

---

## 6. Bugs clássicos e como evitá-los

### Bug 1 — Verificação de limite incorreta em `remover`

**Código com bug:**
```java
if (posicao <= this.tamanho) { ... }
```

**Por que é bug?**
Uma lista de 5 elementos tem posições válidas: `0, 1, 2, 3, 4` (índice até `tamanho - 1`).
Com `posicao <= tamanho`, a posição `5` passaria pela verificação e causaria
`NullPointerException` ao percorrer além do fim.

**Correto:**
```java
if (posicao < 0 || posicao >= tamanho) return false;
```

---

### Bug 2 — Travessia que remove o nó errado

Este é o bug mais sutil. Considere remover a posição `2` de `[10 → 20 → 30 → 40]`.

**Código com bug:**
```java
while (pos_atual < posicao - 1) {  // para quando pos_atual == 1
    no_ant = no_aux;
    no_aux = no_aux.getProximo();
    pos_atual++;
}
no_ant.setProximo(no_aux.getProximo());
```

**Trace do bug (posicao = 2):**
```
Início: noAux = [10](pos0), noAnt = null, pos_atual = 0
Loop:   pos_atual < 1 → entra
  noAnt = [10], noAux = [20], pos_atual = 1
Loop:   1 < 1 → sai

noAnt.setProximo(noAux.getProximo())
  = [10].setProximo([20].getProximo())
  = [10].setProximo([30])

Resultado: [10] → [30] → [40]   ← removeu [20], não [30]! ERRADO
```

**Para posicao = 1:** o loop nem executa, `noAnt` continua `null` → **NullPointerException**.

**Código correto:**
```java
for (int i = 0; i < posicao - 1; i++) {   // para em posicao-1
    noAux = noAux.getProximo();
}
noAux.setProximo(noAux.getProximo().getProximo());
```

**Trace correto (posicao = 2):**
```
Início: noAux = [10](pos0)
Loop:   i < 1 → entra
  noAux = [20](pos1), i = 1
Loop:   1 < 1 → sai

noAux.setProximo(noAux.getProximo().getProximo())
  = [20].setProximo([30].getProximo())
  = [20].setProximo([40])

Resultado: [10] → [20] → [40]   ← removeu [30] corretamente ✓
```

**Lição:** ao percorrer a lista para remoção, o ponteiro auxiliar deve parar
no nó **anterior** ao que será removido — não dois antes.

---

## 7. Retornos seguros com Optional

### O problema do `null`

Quando um método pode não encontrar um resultado, a saída "natural" costuma ser `null`:

```java
public T obter(int posicao) {
    if (posicao < 0 || posicao >= tamanho) return null;  // perigoso
    ...
}
```

O problema: quem chama o método pode esquecer de verificar `null`:

```java
Integer valor = lista.obter(10);
System.out.println(valor + 1);   // NullPointerException em tempo de execução!
```

### A solução: `Optional<T>`

`Optional<T>` é um **contêiner** que pode ou não conter um valor.
Ele força o chamador a lidar com a ausência de valor em tempo de compilação.

```java
public Optional<T> obter(int posicao) {
    if (posicao < 0 || posicao >= tamanho) return Optional.empty();
    ...
    return Optional.of(noAux.getDado());
}
```

**Formas de consumir:**
```java
// 1. Executar apenas se presente
lista.obter(2).ifPresent(v -> System.out.println(v));

// 2. Fornecer valor padrão se ausente
int valor = lista.obter(10).orElse(-1);

// 3. Verificar existência explicitamente
if (lista.obter(2).isPresent()) { ... }

// 4. Obter o valor (lança exceção se vazio — use quando tiver certeza)
int valor = lista.obter(2).get();
```

> `Optional` não é para usar em todo lugar — apenas em retornos onde
> a ausência é um cenário esperado e válido.

---

## 8. Boas práticas consolidadas

| Prática | Aplicação no código |
|---|---|
| **Encapsulamento** | Todos os atributos são `private`; acesso via métodos |
| **Generics `<T>`** | Lista funciona para qualquer tipo sem duplicação de código |
| **Interface como contrato** | `ILista<T>` separa o que a lista faz de como faz |
| **Retorno `boolean`** | Métodos que podem falhar comunicam o resultado ao chamador |
| **`Optional<T>`** | Elimina retornos `null` em buscas por posição |
| **`equals` para comparação** | Evita comparar referências onde o conteúdo é o que importa |
| **`toString()` padrão Java** | Representação textual reutilizável em qualquer contexto |
| **`StringBuilder` em loops** | Concatenação eficiente de strings |
| **Validação de entrada** | Posições inválidas são rejeitadas antes de qualquer percurso |
| **`tamanho` como contador** | Evita percorrer a lista inteira para saber o tamanho — O(1) vs O(n) |

---

## Estrutura final dos arquivos

```
aula5/
├── No/
│   └── No.java              — Nó genérico (dado + referência para próximo)
├── Lista/
│   ├── ILista.java          — Interface: contrato da lista
│   └── ListaEncadeada.java  — Implementação: lista simplesmente encadeada
└── aula5.java               — Programa principal com exemplos de uso
```

---

*Material de apoio — Estruturas de Dados e Linguagens*
