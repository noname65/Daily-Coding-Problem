def function1(s):
    result=0
    if int(s[0])>0:
        if len(s)==1:
            return 1
        else:
            result+=function1(s[1:])
    elif len(s)==1:
        return 0
    if int(s[0:2])>0 and int(s[0:2])<=26:
        if len(s)==2:
            result+=1
        else:
            result+=function1(s[2:])
    return result
print(function1("111"))
