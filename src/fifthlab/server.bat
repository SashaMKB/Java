

set compute=C:\Lab5\compute\src\
set server=C:\Lab5\server\src\
set client=C:\Lab5\client\src\

set local_server_directory=C:\Lab5\work\
set network_folder=D:\work\


java -cp %server%;%network_folder%compute.jar^
 -Djava.rmi.server.codebase=file:///D:/work/client/src/^
 -Djava.security.policy=%network_folder%server.policy^
 -Djava.rmi.server.hostname=localhost^
 engine.ComputeEngine


pause >nul