package fila;


import java.util.Scanner;

class nodafila {
    int dado;
    nodafila proximo;

    public nodafila(int dado) {
        this.dado = dado;
        this.proximo = null;
    }
}

public class Fila {
    private nodafila primeiro;
    private nodafila ultimo;

    public Fila() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public void enfileirar(int elemento) {
        nodafila novoNo = new nodafila(elemento);
        if (estaVazia()) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            ultimo.proximo = novoNo;
            ultimo = novoNo;
        }
    }

    public int desenfileirar() {
        if (estaVazia()) {
            System.out.println("A fila esta vazia. Nao e possivel desenfileirar elementos.");
            return -1; // Valor de erro
        }

        int elementoRemovido = primeiro.dado;
        primeiro = primeiro.proximo;
        if (primeiro == null) {
            ultimo = null;
        }
        return elementoRemovido;
    }

    public void imprimirFila() {
    if (estaVazia()) {
        System.out.println("fila vazia");
        return;
    }

    System.out.print("Fila: ");
    nodafila atual = primeiro;
    while (atual != null) {
        System.out.print(atual.dado + " ");
        atual = atual.proximo;
    }
    System.out.println();
}

    public static void main(String[] args) {
        Fila fila = new Fila();
        Scanner scanner = new Scanner(System.in);      
        
        int escolha = -1; // Inicializa escolha com um valor que não seja 0 (Sair)

	       while (escolha != 0) {
	           System.out.println("...........................................");
	           System.out.println("1 - Inserir elemento");
	           System.out.println("2 - Remover elemento");
	           System.out.println("3 - Imprimir pilha");
	           System.out.println("0 - Sair");
	           System.out.println("...........................................");
	
	           escolha = scanner.nextInt();
	
	           switch (escolha) {
	               case 1:
	                   System.out.println("Digite os numeros a serem inseridos (digite 0 para parar):");
	                   int numeroInserir;
	                   while ((numeroInserir = scanner.nextInt()) != 0) {
	                       fila.enfileirar(numeroInserir);
	                   }
	                   fila.imprimirFila(); // Imprime a fila inteira após a inclusão
	                   System.out.println("----------------------------------------------");
	                   break;
	               case 2:
	                   int numeroRemovido = fila.desenfileirar();
	                   if (numeroRemovido != -1) {
	                       System.out.println("Removido: " + numeroRemovido);
	                   }
	                   fila.imprimirFila(); // Imprime a fila após a remoção
	                   System.out.println("----------------------------------------------");
	                   break;
	               case 3:
	            	   fila.imprimirFila();
	                   break;
	               case 0:
	                   scanner.close();
	                   break;
	               
	           }
       }
    }
}
