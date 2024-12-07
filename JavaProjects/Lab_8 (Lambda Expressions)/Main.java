public class Main {
    public static void main(String[] args) {
        StringOperation toUpperCase = (str) -> str.toUpperCase();
        StringOperation toLowerCase = (str) -> str.toLowerCase();
        StringOperation deleteUselessSpaces = (str) -> {
            char[] charArray = str.toCharArray();
            int before = 0, after = str.length() - 1;

            for (int i = 0; i < str.length() - 1; i++) {
                if (charArray[i] == ' ') {
                    before += 1;
                }
                else
                    break;
                }
            for (int i = str.length() - 1; i > 0; i--) {
                if (charArray[i] == ' ') {
                    after -= 1;
                }
                else
                    break;
            }
            return str.substring(before, after + 1);
        };
        StringOperation reverse = (str) -> {
            return new StringBuilder(str).reverse().toString();
        };

        StringProcessor str_pr = new StringProcessor();

        System.out.println(str_pr.processString(" Hello, World!", toUpperCase));
        System.out.println(str_pr.processString(" Hello, World!", toLowerCase));
        System.out.println(str_pr.processString(" Hello, World!", deleteUselessSpaces));
        System.out.println(str_pr.processString(" Hello, World!", reverse));
    }
}
