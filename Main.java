private static <T extends Comparable<? super T>> void exchange(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
}

public static void insertionSort(int[] a) {
    for (int i = 1; i < a.length; i++) {
        for (int j = i; j > 0 && a[j-1] > a[j]; j--) {
            exchange(a, j-1, j);
        }
    }
}

public static <T extends Comparable<? super T>> void selectionSort(int[] a) {
    for (int min, i = 0; i < a.length; i++) {
        min = i;
        for (int j = i + 1; j < a.length; j++) {
            if (a[j] < a[min]) {
                min = j;
            }
        }
        exchange(a, min, i);
    }
}


void main() {

    System.out.println("Hello :D");

    int[] Nros = new int[5];
    Nros[0] = 7;
    Nros[1] = 2;
    Nros[2] = 8;
    Nros[3] = 5;
    Nros[4] = 4;




    System.out.println("\nNumeros pré Sorting:");
    System.out.print(Nros[0]);
    System.out.print(Nros[1]);
    System.out.print(Nros[2]);
    System.out.print(Nros[3]);
    System.out.print(Nros[4]);

    //insertionSort(Nros);
    selectionSort(Nros);


    System.out.println("\n\nNumeros pós Sorting:");
    System.out.print(Nros[0]);
    System.out.print(Nros[1]);
    System.out.print(Nros[2]);
    System.out.print(Nros[3]);
    System.out.print(Nros[4]);

//Métodos Instáveis: a ordem relativa dos itens com chaves iguais é alterada durante o processo de ordenação

//Métodos Estaveis: se a ordem relativa dos itens com chaves iguais mantém-se inalterada durante o processo

    //Um algoritmo somente é estável se:
    //i < j e a[i] == a[j], implica que p(i) < p(j). Onde p é o movimento de permutação (move a[i] para a posição p[i]).

//Alguns dos métodos de ordenação mais eficientes não são estáveis.


//Ordenação Interna

    //Medidas de complexidade levam em conta:
    //O numero de comparação entre as chaves;
    //O numero de trocas entre os itens

    //São classificados em dois tipos:
    //Métodos Simples (elementares): mais recomendados para conjuntos pequenos de dados. Usam mais comparações, mas produzem códigos menores e mais simples
    //Métodos Eficientes (sofisticados): adequados para conjuntos maiores de dados. Usam menos comprarações, porém, produzem códigos mais complexos e com muitos detalhes


//Métodos Simples
    //Ex: Bubble Sort, Insertion Sort e Selection Sort;
    //Adequados para um volume pequeno de dados;
    //Normalment, requerem O(n²) comparações;
    //Porém, são simples e produzem pequenos programas

//Métodos Eficientes
    //Ex: Merge Sort, Quick Sort e Heap Sort;
    //Adequados para grandes volumes de dados;
    //Normalmente, requrem O(nlog(n)) comparações;
    //Usam menos comparações. Porém, são mais complexos;
    //Métodos sofisticados possuem mais eficiência;


//Bubble Sort
    // [=]
    // Se o Array a ser ordenado for colocado na vertical, com Item[n] em cima e Item[1] embaixo, durante cada passo o
    //  menor elemento "sobe" até en contrar um elemento maior ainda, como se uma bolha subisse dentro de um tubo de acordo com sua densidade
    // [=]

    //Funcionamento:
    // [=]
    // Neste algoritmo são efetuadas comparações entre os dados armazenados em um array de tamanho "n".
    //   Cada elemento de posição "i" será comparada com o elemento de posição i + 1, e quando a ordenação procurada é encontrada,
    //   uma troca de posições entre os elementos é feita. A execução finalizará quando não ocorrer mais trocas
    // [=]

}