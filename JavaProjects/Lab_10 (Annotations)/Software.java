class Software {
    @Version(version_number = "1.0", author_name = "Alice")
    public void featureOne() {
        System.out.println("Feature One");
    }

    @Version(version_number = "1.1", author_name = "Bob")
    public void featureTwo() {
        System.out.println("Feature Two");
    }
}
