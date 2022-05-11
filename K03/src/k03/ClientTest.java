package k03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientTest {

	public static void main(String[] args) {
		int SERVER_PORT = 5432;
		try (Socket sock = new Socket("localhost", SERVER_PORT);
				DataOutputStream os = new DataOutputStream(sock.getOutputStream());
				DataInputStream is = new DataInputStream(sock.getInputStream());) {
			System.out.print("ª¢ªÊª¿ªÎÙ£îñ-->");
			Scanner sc = new Scanner(System.in);
			String name = sc.next();
			os.writeUTF(name);
			String data = is.readUTF();
			System.out.println(data);
			String data2 = is.readUTF();
			System.out.println(data2);
		} catch (UnknownHostException ex) {
			System.err.println(ex);
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
}
