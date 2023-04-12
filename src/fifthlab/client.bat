
set compute=C:\Lab5\compute\src\
set server=C:\Lab5\server\src\
set client=C:\Lab5\client\src\

set local_server_directory=C:\Lab5\work\
set network_folder=D:\work\

java -cp %network_folder%client\src\;%network_folder%compute.jar^
 -Djava.rmi.server.codebase=file:///D:/work/client/src/^
 -Djava.security.policy=%local_client_directory%client.policy^
 client.ComputeSum^
 192.168.51.70 1 2 3 4 5

pause >nul
