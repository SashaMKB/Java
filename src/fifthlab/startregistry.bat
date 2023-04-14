@echo off

set compute=C:\Lab5\compute\src\
set server=C:\Lab5\server\src\
set client=C:\Lab5\client\src\

set local_server_directory=C:\Lab5\work\
set network_folder=D:\work\

cd %compute%
"C:\Program Files\Java\jdk-19\bin\rmiregistry.exe"

pause > nul