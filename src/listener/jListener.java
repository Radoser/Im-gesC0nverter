package listener;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.filechooser.FileNameExtensionFilter;

public class jListener extends JFrame{

	private JFileChooser fc;
	private String imageFormat;
	private String filePath;
	private String path;

	public void btnBrowseActionPerformed(ActionEvent evt, JLabel label) {                                               
		if (fc == null) {
			fc = new JFileChooser(".");
		}

		//Filter images
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG, GIF Images", "jpg", "png", "gif");
		fc.setFileFilter(filter);

		// Show the dialog window
		int returnVal = fc.showOpenDialog(this);

		// Process the results
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			label.setText(fc.getSelectedFile().getName());
			filePath = fc.getSelectedFile().getPath();
		} else {
			label.setText("OOPPS");
		}
		// Reset the file chooser for the next time it's shown.
		fc.setSelectedFile(null);

	}  

	public void btnConvertActionPerformed(ActionEvent evt, int height, int width, JRadioButton rbtn) throws IOException{

		imageFormat = rbtn.getText();
		int position = filePath.lastIndexOf('.');
		if (position == -1) return;
		path = filePath.substring(0, position);
		//Read image			
		BufferedImage image = ImageIO.read(new File(filePath));

		double aspectRatio = (double) image.getWidth(null)/(double) image.getHeight(null);
		//			double aspectRatio2 = (double) image.getHeight(null)/(double) image.getWidth(null);

		BufferedImage resizedImage = resizeImage(image, (int)(width/aspectRatio), (int)(height/aspectRatio));
		//create new image with the same name
		ImageIO.write(resizedImage, imageFormat, new File(path + "." + imageFormat));
	}

	private static BufferedImage resizeImage(BufferedImage originalImage, int setWidth, int setHeight){		
		BufferedImage resizedImage;
		//Some images may have type - 0 and this is error for converter
		if (originalImage.getType() == 0){
			resizedImage = new BufferedImage(setWidth, setHeight, BufferedImage.TYPE_INT_RGB);
		}else {
			resizedImage = new BufferedImage(setWidth, setHeight, originalImage.getType());
		}

		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, setWidth, setHeight, null);
		g.dispose();

		g.setComposite(AlphaComposite.Src);

		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		return resizedImage;
	}

	public String getImagePath(){
		return path + "." + imageFormat; 
	}

}
