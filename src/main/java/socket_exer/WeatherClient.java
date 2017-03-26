package socket_exer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class WeatherClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
	    Socket socket = new Socket("127.0.0.1",12345);
	    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
	    dos.writeUTF("西安");
	    System.out.println("请求西安的天气：");
	    
	    DataInputStream dis = new DataInputStream(socket.getInputStream());
	    String result = dis.readUTF();
	    System.out.println("北京的天气是：" + result);
	    
	    dis.close();
	    dos.close();
	}
}
