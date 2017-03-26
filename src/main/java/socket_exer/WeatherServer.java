package socket_exer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.NonWritableChannelException;

public class WeatherServer {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(12345);
		while(true){
			final Socket socket =  serverSocket.accept();
			Runnable runnable = new Runnable() {
				
				public void run() {
					// TODO Auto-generated method stub
					try {
						DataInputStream dis = new DataInputStream(socket.getInputStream());
						String cityName = dis.readUTF();
						System.out.println("收到客户端请求的城市是：" + cityName);
						Thread.sleep(1000);
						String result = "今天天气很热";
						System.out.println("返回天气信息：" + result);
						DataOutputStream dos  =  new DataOutputStream(socket.getOutputStream());
						dos.writeUTF(result);
						dis.close();
						dos.close();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			};
			new Thread(runnable).start();
		}
	}

}
