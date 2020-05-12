# coding:utf-8

import os

os.chdir("..")
print(os.popen("git pull").read())
print(os.popen("mvn clean install").read())
