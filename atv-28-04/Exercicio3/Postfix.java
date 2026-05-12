

public class Postfix {

    public static int evaluate(String expr) {
        Stack<Integer> s = new ArrayStack<>(1000);
        // TODO: percorrer cada token (use expr.split("\\s+"))
        //   - se for um numero: s.push(Integer.parseInt(t))
        //   - se for operador: pop b, pop a, push do resultado de (a op b)
        //   - cuidado com a ordem em '-' e '/'
        
        //criando a listas
        String[] expressao = expr.split("\\s+");

        //algoritmos logico:
        for(int i = 0; i < expressao.length; i++) {
            if(expressao[i].equals("+")) {
               s.push(s.pop() + s.pop());
            }
            else if(expressao[i].equals("*")) {
               s.push(s.pop() *s.pop());
            }
            else if(expressao[i].equals("-")) {
                int b = s.pop();
                int a = s.pop();
               s.push(a - b);
            }
            else if(expressao[i].equals("/")) {
                int b = s.pop();
                if(b == 0) {
                   s.push(0);
                }
                int a = s.pop();
               s.push(a / b);
            }
            else {
               s.push(Integer.parseInt(expressao[i]));
            }


            
        }
        

        return s.pop();
    }

    public static void main(String[] args) {
        System.out.println(evaluate("5 9 8 + 4 6 * * 7 + *"));
    }
}