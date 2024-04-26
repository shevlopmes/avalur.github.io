class Image {
    private String imageURL;

    public Image(String imageURL) {
        this.imageURL = imageURL;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image from: " + imageURL);
        // Simulate the time taken to load the image
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

public class SimpleImageViewer {
    public static void main(String[] args) {
        Image image = new Image("http://example.com/image.jpg");
        image.display();
    }
}
