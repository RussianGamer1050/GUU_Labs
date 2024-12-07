public class MyCalculator {
    
    private class ResultClass implements MyResult {
        boolean valid;
        int result = 0;


        public ResultClass() {
            valid = false;
        }

        public ResultClass(int result) {
            this.result = result;
            valid = true;
        }

        
        public int getResult() {
            return result;
        }

        public boolean hasResult() {
            return valid;
        }
    }

    private char operation;

    public MyCalculator(char operation) {
        this.operation = operation;
    }

    public MyResult calculate(int a, int b) {
        MyResult res;

        switch (operation) {
            case '*':
                res = new ResultClass(a * b);
                break;
            case '/':
                if (b != 0) {
                    res = new ResultClass(a / b);
                }
                else {
                    res = new ResultClass();
                }
                break;
            case '+':
                res = new ResultClass(a + b);
                break;
            case '-':
                res = new ResultClass(a - b);
                break;
            default:
                res = new ResultClass();
                break;
        }
        return res;
    }
}
