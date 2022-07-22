import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GenerateOfStickers {

    public void create(InputStream inputStream, String nameSticker) throws IOException {
       // leitura da imagem 
        BufferedImage originalImage = ImageIO.read(inputStream);

        // criar uma nova imagem com transparência e com tamanho novo
        int height = originalImage.getHeight();
        int width = originalImage.getWidth();
        int newHeight = height + 120;

        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        // copiar a imagem original pra nova imagem (em memória)

        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, null, 0, 0);

        // escrever uma frase nova na imagem

        String text = "FIGURINHA";
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 72));
        graphics.setColor(Color.ORANGE);
        graphics.drawString(text, ((width - (text.length() * 36)) / 2), newHeight - 32);

        // copiar a imagem original em um arquivo
        ImageIO.write(newImage, "png", new File("media/"+ nameSticker + ".png"));
    }

}
