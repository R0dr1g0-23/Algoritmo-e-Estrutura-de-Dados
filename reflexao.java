public class reflexao {
    /*
    Exercicio 6:
    a)
    Na inserção no meio de um array, é custosa pois ele percorre todos os elementos subsequentes do elemento em que se quer remover para que eles possam ser realocados e com isso obtendo uma complexidade O(n). Enqunato a lista dinamica, por não precisar deslocar os elementos subsequente a eles tem complexidade O(1)    
    
    b)
    Para acessar o K-ésimo elemento a estrutura de dados do array é mais rápido, pois, tendo em vista que é possivel acessar diretamente o elemento em especifico tem complexidade O(1) e na lista encadeada, caso queira achar um um elemento em especifico, é preciso percorrer todos os nós, sendo assim tendo uma complexidade O(n)
    
    c)
    Sim, é possivel resolver o problema de Josephus por arrays, a resposta é essa:
    //--------------------------------------------------------------------------------------------------------------------------------------
    public class JosephusArray {
        //Constantes a serem utilizadas:
        static int [] participantes;
        static int tamanho; //quantos elementos existem.
        static int indiceAtual = 0;
        static int N = 6;
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
    //--------------------------------------------------------------------------------------------------------------------------------------
         Entretanto, comparando essa solução com a anterior, utilizando listas encadeada, nota - se o seguinte:
         . Como existe a ação de remover e reorganizar, o array ele precisa ser todo percorrido para que haja a remoção, sendo ela um algoritmo de complexidade O(N)
         . Outra analise, é verificar quantas vezes o loop de remoção acontece, com isso, podemos fazer uma analise simples, o elemento do vetor é removido n - 1 vezes até atingir um unico elemento que o estado final, sendo assim e ignorando a constante, esse loop tem complexidade O(N)
         . Então, já analisando a complexidade do algorimo completo, temos o resultado que ele tem complexidade O(n²), sendo inviavel para esse tipo de problema.
         . Mas qual a diferença dessa solução para a utilizando as listas encadeadas? Analisando o algoritmo de listas encadeadas, notamos que, para chegar ao elemento desejado a complexidade é O(N), já que, diferente do array, para acessar um determinado elemento especifico, ele percorre N fatores, entretanto, cada remoção de elemento dentro do algoritmo tem complexidade O(1).
         . Com isso, o algoritmo utilizando listas encadeadas tem complexidade O(n), tornandodo - o vialvel para esse problema.    
            */
        }
        