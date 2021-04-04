import os
import base64
os.chdir("C:/Users/ahmyk/Dosyalar/genel/kartaca_task/kartaca")
files = os.listdir()
files_2 = []
for i in files:
    files_2.append(int(i))


i = 0
for file in files:
    temp = int(base64.b64decode(files[i]))
    os.rename(file, str(temp))
    i += 1

file_2 = os.listdir()
a = "C:/Users/ahmyk/Dosyalar/genel/kartaca_task/kartaca"

for i in range(0, 494):
    temp = open(a + str(i), "r")
    print(temp.read())		# Çıktı unicode online dönüştürücü ile text formatına dönüştürüldü ve görev belirlendi.







