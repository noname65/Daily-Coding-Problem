'''
[Medium]This problem was asked by Google.

The area of a circle is defined as πr^2. Estimate π to 3 decimal places using a Monte Carlo method.

Hint: The basic equation of a circle is x2 + y2 = r2.
'''
import random as r
total=100000000
c=0
for i in range(total):
    if r.random()**2+r.random()**2<=1:
        c+=1
print(c*4/total)
