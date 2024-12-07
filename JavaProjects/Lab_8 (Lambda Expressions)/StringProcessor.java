class StringProcessor {

    public String processString(String str, StringOperation operation) {
        return operation.apply(str);
    }
}
