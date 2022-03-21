#[Medium]This problem was asked by Facebook.
#Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
#For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
#You can assume that the messages are decodable. For example, '001' is not allowed.

#The process of decoding a message is similar to binary tree traversal.
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
