public class JosephusArray {
    //Constantes a serem utilizadas:
    static int [] participantes;
    static int tamanho; //quantos elementos existem.
    static int indiceAtual = 0;
    static int N = 20;
    static int M = 3;
   
    //Criando a classe do array:
    public JosephusArray (int capacidadeInicial) {
        this . participantes = new int [capacidadeInicial];
        this . tamanho = 0;
    }

    //função que remove o elemento e reorganiza o vetor
    public static void remover(int indice){
        if ( indice < 0 || indice >= tamanho ) {
            throw new IndexOutOfBoundsException (" Indice invalido : " + indice);
        }
        
        int i = indice; //variavel, de controle que vai servir como indice, ela recebe toda vez o indice o qual corresponde a participante onde parou a contagem.

        for(int contagem = 1; contagem <= M - 1; contagem++){//loop que vai encontrar o indice que corresponde ao elemento a ser eliminado 
            i++;
            if(i >= tamanho){        //condição para o indice recomeçar (circular)
                i = 0;
            }
        }

        System.out.println("Participante eliminado: " + participantes[i]); // print do participante que foi eliminado.

        for(int j = i; j < tamanho - 1; j++) { // loop que realoca todos os participantes e diminui o tamanho do vetor.
            participantes[j] = participantes[j + 1];
        }
        tamanho--;

      if(i >= tamanho) i = 0;
      indiceAtual = i; // atualização do indice atual para que o loop continue até atingir a condição do while da Main.
    }


    public static void main(String[] args){
        //Array;
        JosephusArray array = new JosephusArray(N);
        tamanho = N; //inicializando o tamanho do vetor.
        
        //preencher o vetor:
        for(int i = 0; i < N; i++){
            participantes[i] = i + 1;
        }

        //resolvendo problema de josephus:
        while(!(tamanho == 1)){
            remover(indiceAtual);
        }
        System.out.println("O lider é: " + participantes[0]);
    }


}
