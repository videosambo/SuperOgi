package com.superogi.client.states;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.superogi.client.GameHandler;
import com.superogi.client.network.LoginPacket;
import com.superogi.client.renderEngine.Display;
import com.superogi.client.ui.UIManager;

public class MenuState extends State implements ActionListener {

	// menu play 520 200 ja 760 300
	private final UIManager uiManager;
	private final JButton button;
	private final JTextField ipField, portField, nameField;
	private final GameHandler handler;

	public MenuState(GameHandler handler) {
		super(handler);
		this.handler = handler;
		this.uiManager = new UIManager(handler);

		Display d = new Display();
		JFrame frame = d.getFrame();

		this.ipField = new JTextField("server ip");
		this.ipField.setBounds(50, 100, 200, 30);
		this.portField = new JTextField("server port");
		this.portField.setBounds(50, 150, 200, 30);
		this.nameField = new JTextField("username");
		this.nameField.setBounds(50, 200, 200, 30);
		this.button = new JButton("Join");
		this.button.setBounds(50, 300, 200, 30);
		this.button.addActionListener(this);

		frame.add(ipField);
		frame.add(portField);
		frame.add(nameField);
		frame.add(button);

		d.setFrame(frame);
	}

	public void actionPerformed(ActionEvent e) {
		if (!(e.getSource() == button))
			return;
		String ipString = ipField.getText();
		String portString = portField.getText();
		String username = nameField.getText();

		try {
			handler.getClientConnectionHandler().connect(ipString, Integer.parseInt(portString));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		handler.getClientConnectionHandler().sendLogicPacket(new LoginPacket(username));
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
	}

}
