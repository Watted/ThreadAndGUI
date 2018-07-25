/*Name: Mohammed Watted
 *ID : 308238187
 *Name: abedallah wattawda
 *ID:  203913595
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class AquaFrame extends JFrame implements ActionListener
{
   private static final long serialVersionUID = 1L;
   private AquaPanel panel;
   private String[] names = {"Exit","Image","Blue","None","Help","Save Object State","Restore Object State"};
   private JMenu m1, m2, m3,m4;
   private JMenuItem[] mi;
   private JLabel imageBackGround;
   private JMenuBar mb;
   private MementoDialog memento;

   public static void main(String[]args)
   {
	   AquaFrame aqua = new AquaFrame();
	   aqua.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	   aqua.setSize(1400,800);
	   aqua.setVisible(true);
	   
   }
//ctor
   public AquaFrame()
   {
	    super("my Aquarium");
	    panel = new AquaPanel();
	    add(panel);
	    panel.setVisible(true);

		mb = new JMenuBar();
		m1 = new JMenu("File");
		m2 = new JMenu("Background");
		m3 = new JMenu("Help");
		m4 = new JMenu("Momento");
		mi = new JMenuItem[names.length];

		for(int i=0;i<names.length;i++)
		{
		    mi[i]=new JMenuItem(names[i]);
		    mi[i].addActionListener(this);
		}

		m1.add(mi[0]);

		m2.add(mi[1]);
		m2.addSeparator();
		m2.add(mi[2]);
		m2.addSeparator();
		m2.add(mi[3]);

		m3.add(mi[4]);
		m4.add(mi[5]);
		m4.add(mi[6]);
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		setJMenuBar(mb);
   }

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mi[0])
			destroy();
		else if(e.getSource() == mi[1])
		{
			if(imageBackGround!=null)
	            panel.removeAll();
	 
	        FileDialog fd=new FileDialog(new Frame(),"please choose a file:",FileDialog.LOAD);
	        fd.setVisible(true);
	        File f;
	        if(fd.getFile()!=null)
	        {
	            f=new File(fd.getDirectory(),fd.getFile());
	            try{
	                ImageIcon a = new ImageIcon(ImageIO.read(f));
	                panel.image = ImageIO.read(f);
	                panel.repaint();
	              
	                setVisible(true);
	            }
	            catch(IOException w)
	            {
	                w.printStackTrace();
	            }
	        }
		}
		else if(e.getSource() == mi[2])
		{
			panel.setBackground(Color.BLUE);
			this.panel.image = null;
		}
		else if(e.getSource() == mi[3])
		{
			panel.setBackground(null);
			this.panel.image = null;
		}
		else if(e.getSource() == mi[4])
			printHelp();
		else if(e.getSource() == mi[5])
		{
			this.memento = new MementoDialog(this.panel,"Save");
		}
		else if(e.getSource() == mi[6])
		{
			this.memento = new MementoDialog(this.panel,"Restore");
		}
	}
	
	public void destroy() {
		System.exit(0);
	}
	
	public void printHelp() {
		JOptionPane.showMessageDialog(this, "Home Work 4\nGUI @ Threads");
	}

}
