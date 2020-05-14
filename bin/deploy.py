# coding:utf-8

import os
import sys
import re
import shutil

if len(sys.argv) < 2:
    print('missing version')
    exit()

version = sys.argv[1]

if len(sys.argv) < 3:
    print('missing local maven repository path')
    exit()

project_repository_path = sys.argv[2]

if not os.path.exists(project_repository_path):
    print('local maven repository path not found')
    exit()

# 更新版本

os.chdir('..')
with open('pom.xml', 'r+', encoding='utf-8') as fr:
    content = fr.read()

with open('pom.xml', 'w+', encoding='utf-8') as fw:
    replaced = re.sub('<project.version>.*?</project.version>',
                      version.join(['<project.version>', '</project.version>']), content, 1)
    fw.write(replaced)

# 安装至本地maven仓库
print(os.popen('git pull').read())
print(os.popen('mvn clean deploy').read())

validator_mvn_home = os.sep.join([os.path.expanduser('~'), '.m2',
                                  'repository', 'org', 'code4everything', 'validator', version])
target_path = os.sep.join(
    [project_repository_path, 'org', 'code4everything', 'validator', version])

shutil.copytree(validator_mvn_home, target_path)

print(os.popen('git add .').read())
print(os.popen('git commit -m "shell release v%s"' % version).read())

os.chdir(project_repository_path)
print(os.popen('git add .').read())
print(os.popen('git commit -m "shell release %s v%s"' %
               ('validator', version)).read())
