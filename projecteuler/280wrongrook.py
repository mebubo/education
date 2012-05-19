import numpy
from numpy import linalg

def euler280(sx,sy,upper,lower,D):
   key=(sx,sy,upper,lower)
   if key in D: return D[key]
   M=numpy.zeros((25,25))
   b=numpy.zeros(25)
   for x in range(5):
      for y in range(5):
         p=x+y*5
         M[p,p]=1
         if y==0 and lower&(1<<x):
            lower2=lower-(1<<x)
            if upper==0: continue
            b[p]=euler280(x,4-y,lower2,upper,D)
            continue
         t=0
         if x<4: t+=1
         if x>0: t+=1
         if y<4: t+=1
         if y>0: t+=1
         f=1./t
         b[p]=1
         if x<4: M[p,x+1+y*5]=-f
         if x>0: M[p,x-1+y*5]=-f
         if y<4: M[p,x+y*5+5]=-f
         if y>0: M[p,x+y*5-5]=-f
   c=numpy.dot(linalg.inv(M),b)
   ret=c[sx+sy*5]
   D[key]=ret
   return ret

if __name__=="__main__":
    print euler280(2,2,31,31,{})
