package mrzcom.example.simple_login.ruiyang.mode;


public class Brand {
    private String name;
    private String imageUrl;
    private String result;

    // 构造方法、getter和setter省略

    public Brand(String name, String imageUrl, String result) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getResult() {
        return result;
    }
}