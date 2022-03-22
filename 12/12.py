'''
[Hard]This problem was asked by Amazon.
There exists a staircase with N steps, and you can climb up either 
1 or 2 steps at a time. Given N, write a function that returns the 
number of unique ways you can climb the staircase. The order of the 
steps matters.

For example, if N is 4, then there are 5 unique ways:

1, 1, 1, 1
2, 1, 1
1, 2, 1
1, 1, 2
2, 2
What if, instead of being able to climb 1 or 2 steps at a time, you 
could climb any number from a set of positive integers X? 
For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at 
a time.
'''
#This time the topic is similar to the content of Daily Coding 
#Problem #7, so change the code of Daily Coding Problem #7 and use 
#it.
steps=[]
def function1(n,s):
    if n==1:
        steps.append(s+"1")
        return
    else:
        function1(n-1,s+"1")
    if n==2:
        steps.append(s+"2")
    else:
        function1(n-2,s+"2")
function1(7,"")
print("Steps:",len(steps))
print(steps)
#The second requirement is equivalent to finding regularities in function1.
steps=[]
arr=[1,3,5]
def function2(n,s):
    for i in arr:
        if n==i:
            steps.append(s+str(i))
        elif i<n:
            function2(n-i,s+str(i))
function2(7,"")
print("Steps:",len(steps))
print(steps)
