package amazon_locker;

public class Package {
    private int length;
    private String package_name;
    private int width;
    private int height;
    private Size size;

    public  Package(int length, String package_name, int width, int height) {
        this.length = length;
        this.package_name = package_name;
        this.width = width;
        this.height = height;
    }

    public Size getSize() {
        return size;
    }
}
