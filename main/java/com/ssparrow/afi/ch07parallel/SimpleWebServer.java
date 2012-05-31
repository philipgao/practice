package com.ssparrow.afi.ch07parallel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SimpleWebServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket=new ServerSocket(8080);
			
			while(true){
				Socket socket = serverSocket.accept();
		
				new Thread(new ServerProcessor(socket)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static class ServerProcessor implements Runnable{
		private Socket socket;
		
		public ServerProcessor(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			System.out.println("ServerProcessor for Socket["+socket+"]");
			this.ProcessSocket();
		}
		
		private void ProcessSocket(){
			try {
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String inputLine, outputLine;

				while ((inputLine = in.readLine()) != null) {  
					System.out.println(inputLine);
				    out.println("RE:"+inputLine);
				    if (inputLine.equals("exit"))
				    break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
