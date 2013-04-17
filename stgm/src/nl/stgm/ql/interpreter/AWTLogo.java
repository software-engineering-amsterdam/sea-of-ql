package nl.stgm.ql.interpreter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class AWTLogo extends Panel{

	private BufferedImage image;

	public AWTLogo()
	{
		try
		{
			image = ImageIO.read(new File("logo.png"));
		}
		catch (IOException ex)
		{
			// handle exception...
		}
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension(800,139);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters            
	}

}
