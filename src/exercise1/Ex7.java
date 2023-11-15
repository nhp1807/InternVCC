package exercise1;

public class Ex7 {
    public static void main(String[] args) {
        String url1 = "https://tiki.vn/dien-thoai-may-tinh-bang/c1789?src=mega-menu";
        String url2 = "http://tiki.vn/dien-thoai-may-tinh-bang/c1789?src=mega-menu";
        String url3 = "https://www.tiki.vn/dien-thoai-may-tinh-bang/c1789?src=mega-menu";
        String url4 = "https://tiki.vn/dien-thoai-may-tinh-bang/c1789?src=mega -menu";
        String regex = "^https?://(www.)?[a-zA-Z0-9-]+(\\.[a-z]{2,6})(/[^\\s]*)?$";

        System.out.println(url1.matches(regex));
        System.out.println(url2.matches(regex));
        System.out.println(url3.matches(regex));
        System.out.println(url4.matches(regex));
    }
}
