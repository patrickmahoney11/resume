#
# CPSC-471 Assignment 1
# Patrick Mahoney
#

#import socket module
from socket import *
import sys                       # In order to terminate the program

# Create a TCP server socket
serverSocket = socket(AF_INET, SOCK_STREAM)
# AF_INET is used for IPv4 protocols
# SOCK_STREAM is used for TCP

#Prepare server socket
serverHost = 'localhost'

recvBuffer = 1024

serverPort = 80

serverSocket.bind(('',80))

serverSocket.listen(1)


while True:
    #Establish the connection
    print('Ready to serve...')
    connectionSocket, addr =  serverSocket.accept()

    try:
        #connection has recieved the messge from the client
        message =  connectionSocket.recv(1024)

        #parse the request to determine the specific file being requested
        filename = message.split()[1]

        #get the requested file from the server’s file system
        f = open(filename[1:])
        
        #read the file and store the contents
        outputdata = f.read()
        
        #Send one HTTP header line into socket
        connectionSocket.send("HTTP/1.1 200 OK \r\n\r\n".encode("UTF-8"))

        #Send the content of the requested file to the client
        for i in range(0, len(outputdata)):
            connectionSocket.send(outputdata[i].encode())

        connectionSocket.send("\r\n".encode("UTF-8"))

        connectionSocket.close()

    except IOError:
        #Send response message for file not found
        connectionSocket.send("404 Not Found \r\n\r\n".encode("UTF-8"))
		
        # Close the client connection socket
        connectionSocket.close()

        serverSocket.close()

sys.exit()        #Terminate the program after sending the corresponding data
