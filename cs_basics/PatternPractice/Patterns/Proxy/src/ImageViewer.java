interface Displayable {
    void display();
}

class RealImage implements Displayable {
    private String imageURL;

    public RealImage(String imageURL) {
        this.imageURL = imageURL;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image from: " + imageURL);
        try {
            Thread.sleep(2000); // Simulate delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void display() {
        System.out.println("Displaying " + imageURL);
    }
}

class ProxyImage implements Displayable {
    private RealImage realImage;
    private String imageURL;

    public ProxyImage(String imageURL) {
        this.imageURL = imageURL;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(imageURL); // Load image only when needed
        }
        realImage.display();
    }
}

public class ImageViewer {
    public static void main(String[] args) {
        Displayable image = new ProxyImage("http://example.com/image.jpg");
        image.display(); // Image is loaded only at this point
    }
}
