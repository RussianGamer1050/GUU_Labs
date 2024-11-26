class Book {
    private String name; // название
    private String author; // автор
    private int year; // год издания
    private String genre; // жанр

    
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setInfo(String info) {
        String[] info_array = new String[4];
        info_array = info.split(";");
        this.name = info_array[0];
        this.author = info_array[1];
        this.year = Integer.parseInt(info_array[2]);
        this.genre = info_array[3];
    }


    public String getName() {
        return name;
    }

    public String getInfo() {
        return (String)(name + ';' + author + ';'
         + year + ';' + genre);
    }

    public boolean equals(Book book) {
        if (this.getInfo().equals(book.getInfo())) {
            return true;
        }
        else {
            return false;
        }
    }
}
