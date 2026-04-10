 public class Node {
   public Object item ; // dado armazenado ( generico )
   public Node next ; // referencia ao proximo no
   
 // TODO : crie um construtor Node ( Object item ) que
 // inicializa this . item e coloca next = null
   Node(Object v) {
    item = v;
    next = null;
   }
 // TODO : crie um segundo construtor Node ( Object item , Node next )
 // que permite ja encadear na criacao
   Node(Object v, Node next){
    this.item = v;
    this.next = next;
   }

}
