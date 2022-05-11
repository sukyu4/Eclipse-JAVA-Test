package k03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {

	public static void main(String[] args) {
		System.out.println("接続待ちです。");

		try (ServerSocket ss = new ServerSocket(5432);
				Socket sock = ss.accept();
				DataOutputStream os = new DataOutputStream(sock.getOutputStream());
				DataInputStream is = new DataInputStream(sock.getInputStream());) {
			String name = is.readUTF();
			System.out.println(name + "さんが接続しました");
			os.writeUTF("こんにちは " + name + " さん。");
			System.out.println(name + "さんが退出しました");
			os.writeUTF("さようなら " + name + " さん。");
		} catch (Exception ex) {
			System.err.println(ex);
		}
		System.out.println("通信終了です。");
	}

}
