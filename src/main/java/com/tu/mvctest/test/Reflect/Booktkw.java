package com.tu.mvctest.test.Reflect;

/**
 * 需要被反射的实体类
 */
public class Booktkw {

    private final static String TAG = "BookTag";

    private String bookName;

    private String author;

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Booktkw{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

//    private Booktkw(String bookName, String author) {
//        this.bookName = bookName;
//        this.author = author;
//    }

    private String declaredMethod(int index){

        String string = null;
        switch (index) {
            case 0:
                string = "I am declaredMethod 0 !";
                break;
            case 1:
                string = "I am declaredMethod 1 !";
                break;
            default:
                string = "I am declaredMethod -1 !";
        }

        return string;

    }


}
