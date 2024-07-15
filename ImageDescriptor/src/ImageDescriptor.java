import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageDescriptor {

    /**
     * Extracts a color histogram descriptor from the given image.
     * The histogram has 256 bins for each of the RGB color channels.
     *
     * @param image The input image.
     * @return An array representing the color histogram.
     */
    public static int[] extractColorDescriptor(BufferedImage image) {
        int[] histogram = new int[256 * 3];  // 256 bins for each of R, G, B

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color color = new Color(image.getRGB(x, y));
                histogram[color.getRed()]++;
                histogram[256 + color.getGreen()]++;
                histogram[512 + color.getBlue()]++;
            }
        }

        return histogram;
    }

    /**
     * Placeholder method to extract texture descriptor from the given image.
     *
     * @param image The input image.
     * @return An array representing the texture descriptor.
     */
    public static int[] extractTextureDescriptor(BufferedImage image) {
        // Implement a texture descriptor extraction method
        return new int[8];  // Placeholder
    }

    /**
     * Extracts a Local Binary Pattern (LBP) descriptor from the given image.
     *
     * @param image The input image.
     * @return A 2D array representing the LBP descriptor.
     */
    public static int[][] extractLBPDescriptor(BufferedImage image) {
        int height = image.getHeight();
        int width = image.getWidth();
        int[][] lbpDescriptor = new int[height][width];

        for (int i = 1; i < height - 1; i++) {
            for (int j = 1; j < width - 1; j++) {
                int center = new Color(image.getRGB(j, i)).getRed();
                int code = 0;

                // Compute LBP code by comparing the center pixel with its neighbors
                code |= (new Color(image.getRGB(j - 1, i - 1)).getRed() >= center ? 1 : 0) << 7;
                code |= (new Color(image.getRGB(j - 1, i)).getRed() >= center ? 1 : 0) << 6;
                code |= (new Color(image.getRGB(j - 1, i + 1)).getRed() >= center ? 1 : 0) << 5;
                code |= (new Color(image.getRGB(j, i + 1)).getRed() >= center ? 1 : 0) << 4;
                code |= (new Color(image.getRGB(j + 1, i + 1)).getRed() >= center ? 1 : 0) << 3;
                code |= (new Color(image.getRGB(j + 1, i)).getRed() >= center ? 1 : 0) << 2;
                code |= (new Color(image.getRGB(j + 1, i - 1)).getRed() >= center ? 1 : 0) << 1;
                code |= (new Color(image.getRGB(j, i - 1)).getRed() >= center ? 1 : 0);

                lbpDescriptor[i][j] = code;
            }
        }

        return lbpDescriptor;
    }

    public static void main(String[] args) {
        // Project Information
        System.out.println("=================================");
        System.out.println("Welcome to the Image Descriptor Project");
        System.out.println("Created by Oussama Missaoui");
        System.out.println("=================================");
        System.out.println();

        // Open a file chooser dialog to select the image directory
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setDialogTitle("Select Directory Containing Images");

        int result = fileChooser.showOpenDialog(null);
        if (result != JFileChooser.APPROVE_OPTION) {
            System.out.println("No directory selected. Exiting program.");
            return;
        }

        File directory = fileChooser.getSelectedFile();

        File[] files = directory.listFiles();

        // Check if there are any files in the directory
        if (files == null) {
            System.out.println("No files found in the directory: " + directory.getPath());
            return;
        }

        // Process each file in the directory
        for (File file : files) {
            if (file.isFile()) {
                BufferedImage image;
                try {
                    image = ImageIO.read(file);
                    if (image == null) {
                        System.out.println("Error reading image: " + file.getName());
                        continue;
                    }
                } catch (IOException e) {
                    System.out.println("IOException while reading file: " + file.getName());
                    e.printStackTrace();
                    continue;
                }

                // Extract descriptors
                int[] colorDescriptor = extractColorDescriptor(image);
                int[] textureDescriptor = extractTextureDescriptor(image);
                int[][] lbpDescriptor = extractLBPDescriptor(image);

                // Print color descriptor
                System.out.println("Color descriptor for image " + file.getName() + ":");
                for (int value : colorDescriptor) {
                    System.out.print(value + " ");
                }
                System.out.println();

                // Print texture descriptor
                System.out.println("Texture descriptor for image " + file.getName() + ":");
                for (int value : textureDescriptor) {
                    System.out.print(value + " ");
                }
                System.out.println();

                // Print LBP descriptor
                System.out.println("LBP descriptor for image " + file.getName() + ":");
                for (int[] row : lbpDescriptor) {
                    for (int value : row) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
