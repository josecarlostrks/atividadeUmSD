/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jcarlos
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    
    private ServerSocket serverSocket;
    
    private void criarServerSocket (int porta) throws IOException{
      this.serverSocket = new ServerSocket(porta);  
    }
    
    private Socket esperarConcexao() throws IOException{
        Socket socket = this.serverSocket.accept();
        
        return socket;
    }
    
    private void tratarConexao(Socket socket){
        try{
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            
            String msg = input.readUTF();
            System.out.println("Mensagem recebida");
            output.writeUTF("Bem vindo");
            output.flush();
            
            input.close();
            output.close();
        }catch(IOException ex){
            System.out.println("Erro ao tratar a conexão");
            ex.printStackTrace();
        }finally{
            try {
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{
            Servidor servidor = new Servidor();
            servidor.criarServerSocket(5566);
            System.out.println("Servidor Iniciado na porta 5566");
            System.out.println("Aguardando conexão");
            Socket socket = servidor.esperarConcexao();
            System.out.println("Cliente"+socket.getInetAddress() +" conectado");
            servidor.tratarConexao(socket);
            System.out.println("Cliente finalizado");
        }catch(IOException ex){
            
        }
    }
    
}
