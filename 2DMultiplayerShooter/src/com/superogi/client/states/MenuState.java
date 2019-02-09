package com.superogi.client.states;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.superogi.client.GameHandler;
import com.superogi.client.network.ClientConnectionHandler;
import com.superogi.client.network.ServerConnector;
import com.superogi.client.renderEngine.Display;
import com.superogi.client.ui.UIManager;

public class MenuState extends State implements ActionListener{
	
	//menu play 520 200 ja 760 300
	private UIManager uiManager;

		JButton button;
		JTextField ip, port, name;
		
	public MenuState(GameHandler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		
		Display d = new Display();
		JFrame frame = d.getFrame();
		
		ip = new JTextField("server ip");
		ip.setBounds(50, 100, 200, 30);
		port = new JTextField("server port");
		port.setBounds(50, 150, 200, 30);
		name = new JTextField("username");
		name.setBounds(50, 200, 200, 30);
		button = new JButton("Join");
		button.setBounds(50, 300, 200, 30);
		button.addActionListener(this);
		
		frame.add(ip);
		frame.add(port);
		frame.add(name);
		frame.add(button);
		
		d.setFrame(frame);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (!(e.getSource() == button)) 
			return;
		String ipString = ip.getText();
		String portString = port.getText();
		String username = name.getText();
		
		//asd
		ServerConnector sc = new ServerConnector(ipString, portString);
		handler.cch = new ClientConnectionHandler(handler.getPacketHandler(), handler);
	}

	@Override
	public void tick() {
	}

	@Override
	public void render(Graphics g) {
	}


}
