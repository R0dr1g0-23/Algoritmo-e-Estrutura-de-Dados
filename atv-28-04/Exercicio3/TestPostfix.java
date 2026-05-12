public class TestPostfix {
    public static void main(String[] args) {
        eq(7,    Postfix.evaluate("3 4 +"),                "soma simples");
        eq(14,   Postfix.evaluate("5 1 2 + 4 * + 3 -"),    "expressao com -");
        eq(5,    Postfix.evaluate("10 2 /"),               "divisao");
        eq(2075, Postfix.evaluate("5 9 8 + 4 6 * * 7 + *"),"exemplo do livro");
        eq(-1,   Postfix.evaluate("10 11 -"),              "subtracao nao comutativa");
        eq(0,    Postfix.evaluate("10 3 / 3 -"),           "divisao inteira");
        System.out.println("OK -- Postfix passou em todos os testes");
    }
    static void eq(int esp, int obt, String msg) {
        if (esp != obt) throw new AssertionError(
            "FALHOU: esperado " + esp + ", obtido " + obt + " — " + msg);
    }
}