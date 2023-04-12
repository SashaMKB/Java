: 12 110111
@echo off

set compute=C:\Lab5\compute\src\
set server=C:\Lab5\server\src\
set client=C:\Lab5\client\src\

set local_server_directory=C:\Lab5\work\
set network_folder=D:\work\

: 6. JAR-файл для compute
SET root="%~dp0"
cd %compute%
javac compute\*.java
"C:\Program Files\Java\jdk-19\bin\jar.exe" cvf compute.jar compute\*.class
cd %root%

: 7. Папка обмена для клиента
move %compute%compute.jar %network_folder%compute.jar

cd %compute%
javac compute\*.java
"C:\Program Files\Java\jdk-19\bin\jar.exe" cvf compute.jar compute\*.class
cd %root%

: 8. Локальная папка для сервера
move %compute%compute.jar %local_server_directory%compute.jar

: 9. Файл безопасности для клиента в папке обмена
echo grant { permission java.security.AllPermission; }; > %network_folder%client.policy

: 10. Файл безопасности для сервера в папке обмена
echo grant { permission java.security.AllPermission; }; > %network_folder%server.policy

: 11. Байт-код в сетевой папке 
javac -cp %compute% %client%client\*.java
mkdir %network_folder%client
mkdir %network_folder%client\src
xcopy /E /I /Y %client% %network_folder%client\src
del %client%client\*.class
del %network_folder%client\src\client\*.java

::
javac -cp %compute% %server%engine\*.java

pause >nul