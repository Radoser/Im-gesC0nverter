package uiDesigner;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import listener.jListener;

public class mainWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel;
	private JPanel panelTitle;
	private JPanel panelDone;
	private JPanel panelErrorMessage;
	private JLabel lblError;
	private JPanel panelFirst;
	jListener listener = new jListener();
	private JTextField NewImagePath;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow window = new mainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 415, 279);
		frame.setTitle("| Images Converter | v0.1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		panelFirst = new JPanel();
		frame.getContentPane().add(panelFirst, "name_29079421753140");
		panelFirst.setLayout(null);

		JTextArea txtrTextOnFirst = new JTextArea();
		txtrTextOnFirst.setFont(new Font("Arial", Font.PLAIN, 13));
		txtrTextOnFirst.setText("This program was developed only for testing \r\npurposes. In cases when you need to test \r\nupload images with different sizes and format.");
		//		txtrTesttestTestTest.setEnabled(false);
		txtrTextOnFirst.setEditable(false);
		txtrTextOnFirst.setBounds(63, 83, 268, 49);
		panelFirst.add(txtrTextOnFirst);

		JLabel lblImagesConverter_1 = new JLabel("Images Converter");
		lblImagesConverter_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagesConverter_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblImagesConverter_1.setBounds(122, 26, 148, 30);
		panelFirst.add(lblImagesConverter_1);

		JLabel lblVersion = new JLabel("version: 0.1");
		lblVersion.setHorizontalAlignment(SwingConstants.CENTER);
		lblVersion.setFont(new Font("Arial", Font.PLAIN, 11));
		lblVersion.setBounds(160, 46, 65, 20);
		panelFirst.add(lblVersion);

		JLabel lblBy = new JLabel("Made by: Roman Mykytenko");
		lblBy.setFont(new Font("Arial", Font.PLAIN, 11));
		lblBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblBy.setBounds(91, 138, 200, 30);
		panelFirst.add(lblBy);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelFirst.setVisible(false);
				panelTitle.setVisible(true);
			}
		});
		btnOk.setBounds(149, 190, 89, 23);
		panelFirst.add(btnOk);

		panelTitle = new JPanel();
		frame.getContentPane().add(panelTitle, "name_4716532513011");
		panelTitle.setLayout(null);

		JLabel lblImagesConverter = new JLabel("Images Converter");
		lblImagesConverter.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblImagesConverter.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagesConverter.setBounds(123, 11, 156, 17);
		panelTitle.add(lblImagesConverter);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 41, 379, 2);
		panelTitle.add(separator);

		JLabel lblTakeYourPicture = new JLabel("Take your picture");
		lblTakeYourPicture.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTakeYourPicture.setBounds(95, 144, 107, 14);
		panelTitle.add(lblTakeYourPicture);

		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(32, 165, 330, 14);
		panelTitle.add(lblNewLabel);

		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.btnBrowseActionPerformed(e, lblNewLabel);
			}
		});
		btnOpen.setBounds(207, 139, 73, 23);
		panelTitle.add(btnOpen);

		JLabel lblSetHeight = new JLabel("Set height");
		lblSetHeight.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSetHeight.setBounds(33, 70, 73, 14);
		panelTitle.add(lblSetHeight);

		textField = new JTextField();
		textField.setBounds(116, 68, 49, 20);
		panelTitle.add(textField);
		textField.setColumns(10);

		JLabel lblSetWeight = new JLabel("Set width");
		lblSetWeight.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSetWeight.setBounds(33, 98, 73, 14);
		panelTitle.add(lblSetWeight);

		textField_1 = new JTextField();
		textField_1.setBounds(116, 95, 49, 20);
		panelTitle.add(textField_1);
		textField_1.setColumns(10);

		final JRadioButton rdbtnJpg = new JRadioButton("jpg");
		rdbtnJpg.setBounds(188, 96, 49, 23);
		panelTitle.add(rdbtnJpg);

		final JRadioButton rdbtnPng = new JRadioButton("png");
		rdbtnPng.setBounds(249, 96, 52, 23);
		panelTitle.add(rdbtnPng);

		final JRadioButton rdbtnGif = new JRadioButton("gif");
		rdbtnGif.setBounds(312, 96, 48, 23);
		panelTitle.add(rdbtnGif);

		JLabel lblChoosePictureFormat = new JLabel("Choose picture format");
		lblChoosePictureFormat.setHorizontalAlignment(SwingConstants.CENTER);
		lblChoosePictureFormat.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblChoosePictureFormat.setBounds(191, 70, 169, 14);
		panelTitle.add(lblChoosePictureFormat);

		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int height = Integer.parseInt(textField.getText().toString());
					int width = Integer.parseInt(textField_1.getText().toString());

					if (rdbtnJpg.isSelected()){
						try {
							try {
								listener.btnConvertActionPerformed(e, height, width, rdbtnJpg);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							panelTitle.setVisible(false);
							panelDone.setVisible(true);
							NewImagePath.setText(listener.getImagePath());
						} catch (NullPointerException ne) {
							panelTitle.setVisible(false);
							panelErrorMessage.setVisible(true);
							lblError.setText("PLease choose image to convert!");
						}
					} else if (rdbtnPng.isSelected()){
						try {
							try {
								listener.btnConvertActionPerformed(e, height, width, rdbtnPng);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							panelTitle.setVisible(false);
							panelDone.setVisible(true);
							NewImagePath.setText(listener.getImagePath());
						} catch (NullPointerException ne) {
							panelTitle.setVisible(false);
							panelErrorMessage.setVisible(true);
							lblError.setText("PLease choose image to convert!");
						}
					} else if (rdbtnGif.isSelected()){
						try {
							try {
								listener.btnConvertActionPerformed(e, height, width, rdbtnGif);
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							panelTitle.setVisible(false);
							panelDone.setVisible(true);
							NewImagePath.setText(listener.getImagePath());
						} catch (NullPointerException ne) {
							panelTitle.setVisible(false);
							panelErrorMessage.setVisible(true);
							lblError.setText("PLease choose image to convert!");
						}
					} else {
						panelTitle.setVisible(false);
						panelErrorMessage.setVisible(true);
						lblError.setText("PLease choose one of the formats!");
					}
				}catch (NumberFormatException ex){
					panelTitle.setVisible(false);
					panelErrorMessage.setVisible(true);
					lblError.setText("Please set height and/or width!");
				}

			}
		});
		btnConvert.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConvert.setBounds(125, 201, 147, 23);
		panelTitle.add(btnConvert);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(33, 132, 327, 10);
		panelTitle.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(33, 182, 327, 10);
		panelTitle.add(separator_2);

		JLabel lblchooseOnlyOne = new JLabel("(choose only one)");
		lblchooseOnlyOne.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblchooseOnlyOne.setBounds(227, 83, 133, 14);
		panelTitle.add(lblchooseOnlyOne);

		panelDone = new JPanel();
		frame.getContentPane().add(panelDone, "name_26044961374244");
		panelDone.setLayout(null);

		JLabel lblDone = new JLabel("DONE");
		lblDone.setForeground(Color.GREEN);
		lblDone.setHorizontalAlignment(SwingConstants.CENTER);
		lblDone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDone.setBounds(159, 32, 66, 36);
		panelDone.add(lblDone);

		JButton btnGiveMeMore = new JButton("Give me more");
		btnGiveMeMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTitle.setVisible(true);
				panelDone.setVisible(false);
			}
		});
		btnGiveMeMore.setBounds(53, 166, 117, 38);
		panelDone.add(btnGiveMeMore);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
		btnClose.setBounds(224, 167, 117, 36);
		panelDone.add(btnClose);

		JLabel lblYourNewImage = new JLabel("Your new image location:");
		lblYourNewImage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblYourNewImage.setHorizontalAlignment(SwingConstants.LEFT);
		lblYourNewImage.setBounds(20, 90, 191, 14);
		panelDone.add(lblYourNewImage);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(53, 153, 288, 2);
		panelDone.add(separator_3);

		NewImagePath = new JTextField();
		NewImagePath.setBounds(20, 117, 369, 25);
		panelDone.add(NewImagePath);
		NewImagePath.setColumns(10);

		panelErrorMessage = new JPanel();
		frame.getContentPane().add(panelErrorMessage, "name_727691696164");
		panelErrorMessage.setLayout(null);

		lblError = new JLabel("");
		lblError.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblError.setVerticalAlignment(SwingConstants.TOP);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(10, 95, 379, 38);
		panelErrorMessage.add(lblError);

		JLabel lblError_1 = new JLabel("Error!");
		lblError_1.setForeground(Color.RED);
		lblError_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblError_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblError_1.setBounds(10, 51, 379, 33);
		panelErrorMessage.add(lblError_1);

		JButton btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelErrorMessage.setVisible(false);
				panelTitle.setVisible(true);
			}
		});
		btnGoBack.setBounds(147, 177, 97, 23);
		panelErrorMessage.add(btnGoBack);

	}
}
