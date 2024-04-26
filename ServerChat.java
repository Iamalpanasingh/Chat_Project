import java.io.*;
import java.net.*;
public class ServerChat 
{
    public static void main(String[] args) throws Exception
	{
        // create server socket
        ServerSocket ss=new ServerSocket(8888);

        //connect to client socket
        Socket s=ss.accept();
        System.out.println("Connection established");

        //to send data to the client
        PrintStream ps=new PrintStream(s.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));

        //to read data comming from the client
        BufferedReader kb=new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            String str,str1;
            while((str=br.readLine())!=null)
            {
                System.out.println(str);
                str1=kb.readLine();
                ps.println(str1);
            }
            ps.close();
            br.close();
            kb.close();
            ss.close();
            s.close();
            System.exit(0);
     }
    }
    
}
