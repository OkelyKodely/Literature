package login;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.Copies;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

class BookReader_Martin_Luther_SHORTER_CATEKKISM {

    public int selChap = 1;
    
    public static void main(String[] args) {
        try {
            EventQueue.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    new BookReader_Martin_Luther_SHORTER_CATEKKISM().createComponents();
                }
            });
        } catch(Exception e) {
            
            e.printStackTrace();
        }
    }
    
    public void addGB(Component component, int x, int y) {
        constraints.gridx = x;
        constraints.gridy = y;
        if(component instanceof TextArea)
            constraints.gridheight = 1;
        p.add(component, constraints);
    }

    JPanel p = new JPanel();
    
    GridBagConstraints constraints = new GridBagConstraints();

    public void openBook() {

        int x, y;
        
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        
        JFrame j = new JFrame();
        p.setLayout(new GridBagLayout());
        p.setBounds(j.getBounds());
        j.add(p);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
        
        JTree jtree = new JTree(new Object[]{
            "Martin Luther's Shorter Catechism", 
            "Frankenstein", 
            "Of Mice and Men",
            "The Color Purple",
            "The Grapes of Wrath"
        });

        JRadioButton yesButton   = new JRadioButton("Martin Luther's Shorter Catechism", true);
        JRadioButton noButton    = new JRadioButton("Frankenstein");
        JRadioButton maybeButton = new JRadioButton("Of Mice and Men");

        JComboBox cb = new JComboBox();
        cb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                JComboBox cb = (JComboBox) evt.getSource();

                Object item = evt.getItem();

                if (evt.getStateChange() == ItemEvent.SELECTED) {
                  if(((String)item).equals("Martin Luther's Shorter Catechism")) {
                    openLiterature(1);
                    selChap = 1;
                    jtree.setSelectionRow(1-1);
                    yesButton.setSelected(true);
                  }
                  if(((String)item).equals("Frankenstein")) {
                    openLiterature(2);
                    selChap = 2;
                    jtree.setSelectionRow(2-1);
                    noButton.setSelected(true);
                  }
                  if(((String)item).equals("Of Mice and Men")) {
                    openLiterature(3);
                    selChap = 3;
                    jtree.setSelectionRow(3-1);
                    maybeButton.setSelected(true);
                  }
                  if(((String)item).equals("The Color Purple")) {
                    openLiterature(4);
                    selChap = 4;
                    jtree.setSelectionRow(4-1);
                  }
                  if(((String)item).equals("The Grapes of Wrath")) {
                    openLiterature(5);
                    selChap = 5;
                    jtree.setSelectionRow(5-1);
                  }
                }
            }
        });

        cb.addItem("Martin Luther's Shorter Catechism");
        cb.addItem("Frankenstein");
        cb.addItem("Of Mice and Men");
        cb.addItem("The Color Purple");
        cb.addItem("The Grapes of Wrath");
        cb.setSize(200, 80);
        JPanel pee = new JPanel();
        pee.setLayout(new GridLayout(4, 1));
        pee.add(cb);
        addGB(pee,  x = 0, y = 0);
        
        pee.add(jtree);
        jtree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        jtree.setSelectionRow(1-1);
        
        jtree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) jtree.getLastSelectedPathComponent();

                if (node == null)
                    return;

                TreeSelectionModel a = jtree.getSelectionModel();
                String b = a.getSelectionPath().toString();
                
                if(b.contains("Matin Luther's Shorter Catechism")) {
                    openLiterature(1);
                    selChap = 1;
                    cb.setSelectedItem("Martin Luther's Shorter Catechism");
                    jtree.setSelectionRow(1-1);
                    yesButton.setSelected(true);
                }
                else if(b.contains("Frankenstein")) {
                    openLiterature(2);
                    selChap = 2;
                    cb.setSelectedItem("Frankenstein");
                    jtree.setSelectionRow(1);
                    noButton.setSelected(true);
                }
                else if(b.contains("Of Mice and Men")) {
                    openLiterature(3);
                    selChap = 3;
                    cb.setSelectedItem("Of Mice and Men");
                    jtree.setSelectionRow(3-1);
                    maybeButton.setSelected(true);
                }
                else if(b.contains("The Color Purple")) {
                    openLiterature(4);
                    selChap = 4;
                    cb.setSelectedItem("The Color Purple");
                    jtree.setSelectionRow(4-1);
                }
                else if(b.contains("The Grapes of Wrath")) {
                    openLiterature(5);
                    selChap = 5;
                    cb.setSelectedItem("The Grapes of Wrath");
                    jtree.setSelectionRow(5-1);
                }
            }
        });
        
        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(yesButton);
        bgroup.add(noButton);
        bgroup.add(maybeButton);        
        pee.add(yesButton);
        pee.add(noButton);
        pee.add(maybeButton);
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openLiterature(1);
                selChap = 1;
                cb.setSelectedItem("Martin Luther's Shorter Catechism");
                jtree.setSelectionRow(1-1);
                yesButton.setSelected(true);
            }
        });
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openLiterature(2);
                selChap = 2;
                cb.setSelectedItem("Frankenstein");
                jtree.setSelectionRow(2-1);
                noButton.setSelected(true);
            }
        });
        maybeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openLiterature(3);
                selChap = 3;
                cb.setSelectedItem("Of Mice and Men");
                jtree.setSelectionRow(3-1);
                maybeButton.setSelected(true);
            }
        });
        
        j.setTitle("Books");
        
        jt.setBounds(0, 0, 300, 500);
        JPanel jp = new JPanel();
        jp.setLayout(null);
        jp.setSize(300, 500);
        jp.add(jt);
        addGB(jt,  x = 1, y = 0);

        JButton prevChapterBtn = new JButton("<");
        JPanel asdf = new JPanel();
        asdf.add(prevChapterBtn);
        addGB(asdf, x = 0, y = 1);

        prevChapterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(selChap == 1) {
                    openLiterature(3);
                    selChap = 3;
                    cb.setSelectedItem("Martin Luther's Shorter Catechism");
                    maybeButton.setSelected(true);
                    jtree.setSelectionRow(3-1);
                }

                else if(selChap == 3) {
                    openLiterature(2);
                    selChap = 2;
                    cb.setSelectedItem("Frankenstein");
                    noButton.setSelected(true);
                    jtree.setSelectionRow(2-1);
                }

                else if(selChap == 2) {
                    openLiterature(1);
                    selChap = 1;
                    cb.setSelectedItem("Of Mice and Men");
                    yesButton.setSelected(true);
                    jtree.setSelectionRow(3-1);
                }

                else if(selChap == 4) {
                    openLiterature(3);
                    selChap = 3;
                    cb.setSelectedItem("The Color Purple");
                    jtree.setSelectionRow(3-1);
                }

                else if(selChap == 5) {
                    openLiterature(4);
                    selChap = 4;
                    cb.setSelectedItem("The Grapes of Wrath");
                    jtree.setSelectionRow(4-1);
                }
            }
        });
        
        JButton nxtChapterBtn = new JButton(">");
        asdf.add(nxtChapterBtn);
        nxtChapterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(selChap == 1) {
                    openLiterature(2);
                    selChap = 2;
                    cb.setSelectedItem("Frankenstein");
                    jtree.setSelectionRow(2-1);
                    noButton.setSelected(true);
                }

                else if(selChap == 3) {
                    openLiterature(1);
                    selChap = 1;
                    cb.setSelectedItem("Martin Luther's Shorter Catechism");
                    jtree.setSelectionRow(1-1);
                    yesButton.setSelected(true);
                }

                else if(selChap == 2) {
                    openLiterature(3);
                    selChap = 3;
                    cb.setSelectedItem("Of Mice and Men");
                    jtree.setSelectionRow(3-1);
                    maybeButton.setSelected(true);
                }

                else if(selChap == 3) {
                    openLiterature(4);
                    selChap = 4;
                    cb.setSelectedItem("The Color Purple");
                    jtree.setSelectionRow(4-1);
                }

                else if(selChap == 4) {
                    openLiterature(5);
                    selChap = 5;
                    cb.setSelectedItem("The Grapes of Wrath");
                    jtree.setSelectionRow(5-1);
                }
            }
        });

        JButton prntABtn = new JButton("|PRINT|");
        //pi2.add(prntABtn);
        addGB(prntABtn, x = 0, y = 2);
        prntABtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileInputStream textStream = null;
                String FILE_NAME = "";
                if(selChap == 1)
                    FILE_NAME = "newfile";
                if(selChap == 2)
                    FILE_NAME = "newfile1";
                if(selChap == 3)
                    FILE_NAME = "newfile2";
                if(selChap == 4)
                    FILE_NAME = "newfile3";
                if(selChap == 5)
                    FILE_NAME = "newfile4";
                try {
                    textStream = new FileInputStream(FILE_NAME);
                } catch(Exception evt) {
                    evt.printStackTrace();
                }

                DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
                Doc mydoc = new SimpleDoc(textStream, flavor, null);

                PrintRequestAttributeSet  aset = new HashPrintRequestAttributeSet();
                aset.add(new Copies(1));
    
                PrintService[] services = PrintServiceLookup.lookupPrintServices(
                             flavor, aset);
                PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();

                if(services.length == 0) {
                    if(defaultService != null) {
                         DocPrintJob job = defaultService.createPrintJob();
                         try {
                            job.print(mydoc, aset);
                         } catch(Exception evt) {
                             evt.printStackTrace();
                         }
                    }
                 } else {

                    PrintService service = ServiceUI.printDialog(null, 200, 200, services, defaultService, flavor, aset);

                    if(service != null) {
                        DocPrintJob job = service.createPrintJob();
                        try {
                            job.print(mydoc, aset);
                        } catch(Exception evt) {
                            evt.printStackTrace();
                        }
                    }
                }
            }
        });

        JButton exportBtn = new JButton("|EXPORT|");
        addGB(exportBtn, x = 1, y = 2);
        exportBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		int returnValue = jfc.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = jfc.getSelectedFile();
                    try {
                        PrintWriter printWriter = new PrintWriter(selectedFile);
                        printWriter.print(jt.getText());
                    } catch(Exception evt) {
                        evt.printStackTrace();
                    }
		}
            }
        });

        j.pack();
    }

    public void openLiterature(int ch) {
        try {
          File myObj = null;
          if(ch == 1)
            myObj = new File("newfile");
          else if(ch == 2)
            myObj = new File("newfile1");
          else if(ch == 3)
            myObj = new File("newfile2");
          else if(ch == 4)
            myObj = new File("newfile3");
          else if(ch == 5)
            myObj = new File("newfile4");
          Scanner myReader = new Scanner(myObj);
          jt.setText("");
          while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            jt.setText(jt.getText() + data);
          }
          myReader.close();
        } catch (FileNotFoundException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
    }

    private JFrame myFrame;
    private JPanel contentPane;
    private JPanel myPanel;
    private JLabel username=null;
    private JLabel password=null;
    private JTextField usernameField=null;
    private JPasswordField passwordField=null;
    private Color myColor=new Color(200, 202, 204);
    private Font myFont11=new Font("Tahoma", 1, 11);
    private Font myFont12bold=new Font("Tahoma", Font.BOLD, 12);
    private Font myFont11bold=new Font("Tahoma", Font.BOLD, 11);
    private TextArea jt = new TextArea("", 35, 100, TextArea.SCROLLBARS_VERTICAL_ONLY);

    public void createComponents() {
        contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBackground(Color.WHITE);
        contentPane.setLayout(new GridBagLayout());
        contentPane.setBorder(BorderFactory.createTitledBorder("Martin Luther"));
        username=new JLabel("Username");
        username.setLabelFor(usernameField);
        username.setFont(myFont11);
        username.setForeground(Color.blue);
        password=new JLabel("Password");
        password.setLabelFor(passwordField);
        password.setFont(myFont11);
        password.setForeground(Color.CYAN);
        usernameField=new JTextField(10);
        usernameField.setBorder(new LineBorder(null, 0, false));
        passwordField=new JPasswordField(10);
        passwordField.setBorder(new LineBorder(null, 0, false));
        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = "Bob";
                String password = "Bob000";
                if(usernameField.getText().equals(username) &&
                        passwordField.getText().equals(password)) {
                    openBook();
                }
            }
        });
        myPanel = new JPanel();
        myPanel.setOpaque(true);
        myPanel.setBorder(BorderFactory.createTitledBorder("Login"));
        myPanel.setBackground(myColor);
        myPanel.setLayout(new GridLayout(2, 2, 2, 2));
        myPanel.add(username);
        myPanel.add(usernameField);
        myPanel.add(password);
        myPanel.add(passwordField);
        contentPane.add(myPanel);
        myFrame = new JFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);
        myFrame.setTitle("Martin Luther");
        myFrame.setContentPane(contentPane);
        myFrame.setVisible(true);
        myFrame.pack();
    }   
}