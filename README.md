# atividadeUmSD

Protocolo Request-Reply implementado em linguagem Java utilizando Socket, Java oferece suporte para Socket desde o JDK 1.0.
Os sockets são compostos por um conjunto de primitivas do sistema operacional.

São duas aplicações, uma aplicação servidor e uma aplicação cliente que se através do protocolo TCP (Transmission Control Protocol).

Passos para a comunicação entre as aplicações.

    Servidor:
        
        1 criar o ServerSocket que irá esperar conexões na porta 5566 através de new ServerSocket(5566).
        2 quando a aplicação cliente solicitar a conexão, criar o objeto Socket que irá tratar da comunicação com o cliente através de serverSocket.accept().
        3 tratar a conexão, receber a requisição e enviar a resposta dentro do método "tratarConexao" através das classes ObjectOutputStream e ObjectInputStream.
        4 encerrar a conexão.


    Cliente:

        1 solicitar uma conexão à porta 5566 e criar o Sócket através de new Socket("localhost", 5566).
        2 enviar uma mensagem ao servidor atavés da classe e método ObjectOutputStream.writeUTF(msg);
        3 esperar e receber resposta do servidor através da classe e método ObjectInputStream.readUTF();
        4 encerrar conexão.


Para executar, inicar primiero o servidor.

