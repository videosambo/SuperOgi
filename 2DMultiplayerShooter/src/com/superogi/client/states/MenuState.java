package com.superogi.client.states;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.superogi.client.GameHandler;
import com.superogi.client.network.LoginPacket;
import com.superogi.client.ui.UIManager;

public class MenuState extends State implements ActionListener {

	// menu play 520 200 ja 760 300
	private final UIManager uiManager;
	private final JButton button;
	private final JTextField ip, port, name;
	private final GameHandler handler;

	public MenuState(GameHandler handler) {
		super(handler);
		this.handler = handler;
		uiManager = new UIManager(handler);

		JFrame frame = new JFrame("Join");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setSize(new Dimension(300, 500));
		frame.setMinimumSize(new Dimension(300, 500));
		frame.setMaximumSize(new Dimension(300, 500));

		ip = new JTextField("localhost");
		ip.setBounds(50, 100, 200, 30);
		port = new JTextField("25660");
		port.setBounds(50, 150, 200, 30);
		name = new JTextField("Username");
		name.setBounds(50, 200, 200, 30);
		button = new JButton("Join");
		button.setBounds(50, 300, 200, 30);
		button.addActionListener(this);

		frame.add(ip);
		frame.add(port);
		frame.add(name);
		frame.add(button);

		frame.setVisible(true);
		frame.pack();
	}

	public void actionPerformed(ActionEvent e) {
		if (!(e.getSource() == button))
			return;

		// System.out.println(ip.getText() + " " + port.getText() + " " +
		// name.getText());
		String ipString = ip.getText();
		String portString = port.getText();
		String username = name.getText();

		try {
			// handler.getClientConnectionHandler().connect(ipString,
			// Integer.parseInt(portString));
			handler.getClientConnectionHandler().connect("localhost", 25560);
			handler.getClientConnectionHandler().queuePacket(new LoginPacket(username));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
	}

}
