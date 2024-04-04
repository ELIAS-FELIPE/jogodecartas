import java.util.Scanner;


public class JogoDeCartas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] cartas = new int[7];
        boolean valoresInseridos = false;

        System.out.println("Bem vindo ao teste de métodos");
        System.out.println("\nEscolha 7 cartas e selecione o método desejado");

        while (true) {
            System.out.println("\nMenu: ");
            System.out.println("1 - valores das cartas");
            System.out.println("2 - Método Selectionsort");
            System.out.println("3 - Método de Heapsort");
            System.out.println("4 - Método Bubblesort");
            System.out.println("5 - Método Quicksort");
            System.out.println("6 - Método Mergesort");
            System.out.println("7 - Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    valoresInseridos = true;
                    System.out.println("Digite os valores das cartas (de 1 a 9):");
                    for (int i = 0; i < 7; i++) {
                        System.out.print("Carta " + (i + 1) + ":");
                        cartas[i] = scanner.nextInt();
                    }
                    System.out.println("Valores das cartas inseridos com sucesso!");
                    break;
                case 2:
                    if (!valoresInseridos) {
                        System.out.println("Antes de ordenar, insira os valores das cartas!");
                        break;
                    }
                    System.out.println("\nOrdenando usando Selection Sort:");
                    selectionSort(cartas.clone());
                    break;
                case 3:
                    if (!valoresInseridos) {
                        System.out.println("Antes de ordenar, insira os valores das cartas!");
                        break;
                    }
                    System.out.println("\nOrdenando usando Heap Sort:");
                    heapSort(cartas.clone());
                    break;
                case 4:
                    if (!valoresInseridos) {
                        System.out.println("Antes de ordenar, insira os valores das cartas!");
                        break;
                    }
                    System.out.println("\nOrdenando usando Bubble Sort:");
                    bubbleSort(cartas.clone());
                    break;
                case 5:
                    if (!valoresInseridos) {
                        System.out.println("Antes de ordenar, insira os valores das cartas!");
                        break;
                    }
                    System.out.println("\nOrdenando usando Quick Sort:");
                    quickSort(cartas.clone());
                    break;
                case 6:
                    if (!valoresInseridos) {
                        System.out.println("Antes de ordenar, insira os valores das cartas!");
                        break;
                    }
                    System.out.println("\nOrdenando usando Merge Sort:");
                    mergeSort(cartas.clone());
                    break;
                case 7:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

  // Implementação do Selection Sort
    public static void selectionSort(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n - 1; i++) {
        System.out.println("Passo " + (i + 1) + ":");
        imprimirCartas(arr);

        int minIdex = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIdex]) {
                minIdex = j;
            }
        }
        int temp = arr[minIdex];
        arr[minIdex] = arr[i];
        arr[i] = temp;
    }
    System.out.println("\nCartas ordenadas!");
    imprimirCartas(arr);
    }


    // Implementação do Heap Sort
    public static void heapSort(int arr[]) {
    int n = arr.length;

    for (int i = n / 2 - 1; i >= 0; i--) {
        heapfy(arr, n, i);

    }

    for (int i = n - 1; i > 0; i--) {
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
        System.out.println("Passo " + ((n - 1) + 1) + ":");
        imprimirCartas(arr);

        heapfy(arr, i, 0);
    }

    System.out.println("\ncartas ordenadas:");
    imprimirCartas(arr);
    }

    public static void heapify(int arr[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapfy(arr, n, largest);
        }
    }

    // Implementação do Bubble Sort

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.println("\nPasso " + (i+1) + ":");
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }
    }

    // Implementação do Quick Sort

    public static void sort(int[] cartas) {quickSort(cartas, 0, cartas.length - 1, 1);}

    private static void quickSort(int[] cartas, int esquerda, int direita, int passo) {
        if (esquerda < direita) {
            int pi = passo(cartas, esquerda, direita);
            System.out.println("\nPasso " + passo + ":");
            imprimirArray(cartas);
            quickSort(cartas, esquerda, pi - 1, passo + 1);
            quickSort(cartas, pi + 1, direita, passo + 1);
        }
    }

    private static int passo(int[] cartas, int esquerda, int direita) {
        int pivo = cartas[direita];
        int i = (esquerda - 1);
        for (int j = esquerda; j < direita; j++) {
            if (cartas[j] < pivo) {
              i++;
              int temp = cartas[i];
              cartas[i] = cartas[j];
              cartas[j] = temp;
            }
        }
        int temp = cartas[i + 1];
        cartas[i + 1] = cartas[direita];
        cartas[direita] = temp;
        return i + 1;
    }

    // Implementação do Merge Sort



    // Imprimir as cartas na tela
    public static void imprimirCartas(int[] cartas) {
     for (int carta : cartas) {
         System.out.print(carta + " ");
     }
     System.out.println();
    }
























    
    private static void heapfy(int[] arr, int n, int i) {
    }


    private static void mergeSort(int[] clone) {
    }

    private static void quickSort(int[] clone) {
    }




    private static void imprimirArray(int[] cartas) {
    }


    }

