public class ListaSimples {
private Node head ;

public ListaSimples () {
this . head = null ;
}

/** Insere ’item ’ no INICIO da lista (O (1) ). */
public void insertFirst ( Object item ) {
    // TODO : crie um novo Node cujo ’next ’ aponta para o head atual
    // TODO : atualize head para apontar para o novo Node
    Node novo = new Node(item,head);
    head = novo;
}

/** Retorna a referencia do primeiro no que contem ’item ’,
 ou null se nao encontrar . */
 public Node find(Object item) {
    Node atual = head;
    // TODO : percorra a lista comparando atual . item com ’item ’
    // Use . equals () para comparar objetos !
    // Retorne ’atual ’ quando encontrar .
    // Se chegar ao fim ( null ), retorne null .
    while(!(atual == null)) {
        if(atual.item.equals(item)){
            return atual;
        }
        atual = atual.next;
    }
    return null;
 }

/** Insere um novo no com ’item ’ APOS o no ’x ’. */
 public void insertAfter ( Node x , Object item ) {
 if ( x == null ) return ;
 // TODO 1: crie um novo Node com ’item ’
 // TODO 2: faca novo . next = x. next
 // TODO 3: faca x. next = novo
 Node novo = new Node(item);
 novo.next = x.next;
 x.next = novo;
 }


/** Percorre a lista e imprime todos os elementos . */
public void imprimir () {
Node atual = head ;
while ( atual != null ) {
System . out . print ( atual . item + " -> ") ;
atual = atual . next ;
}
System . out . println (" null ") ;

}

public static void main ( String [] args ) {
ListaSimples lista = new ListaSimples () ;
lista . insertFirst ("C") ;
lista . insertFirst ("B") ;
lista . insertFirst ("A") ;
lista . imprimir () ; // A -> B -> C -> null

 // ... continuacao do main do Exercicio 3 ...
Node noB = lista . find ("B") ;
if ( noB != null ) {
lista . insertAfter ( noB , "B2");
}
lista . imprimir () ; // A -> B -> B2 -> C -> null

Node noZ = lista . find ("Z") ;
System . out . println (" Busca por Z: " + noZ ) ; // null
}
}