'''
This problem was asked by Google.

Suppose we represent our file system by a string in the following manner:

The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our file system. For example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

Given a string representing the file system in the above format, return the length of the longest absolute path to a file in the abstracted file system. If there is no file in the system, return 0.
'''
import random as r
import string
s=string.ascii_letters+string.digits#Available characters for filenames
def randomStr(names=[]):#Randomly generate unique filenames
  result=''.join(r.choice(s) for i in range(r.randrange(1,11)))
  while result in names:
    result=''.join(r.choice(s) for i in range(r.randrange(1,11)))
  return result
def randomFiles(maxFilesNum=10):#Randomly generate a specified number of files
  result=''
  depth=0
  names=[]
  for i in range(maxFilesNum):
    if i!=0:
      result+="\n"
    result+='\t'*depth+randomStr(names)
    depth=r.randrange(0,depth+2)
  return result
def maxLengthPath(files):#Receive a files string and return the longest address
  files=files.split('\n')
  path=[files[0]]
  maxLen=0
  maxPath=''
  for i in files[1:]:
    temp=i.count('\t')
    if temp>=len(path):
      path.append(i[temp:])
    elif temp==len(path):
      path[-1]=i[temp:]
    else:
      path=path[:temp]
      path.append(i[temp:])
    temp='\\'.join(path)
    if len(temp)>maxLen:
      maxLen=len(temp)
      maxPath=temp
  return maxPath
f=randomFiles(100)#Generate 100 random files
print(f,"\n\n")
print("Max length path is:",maxLengthPath(f))
