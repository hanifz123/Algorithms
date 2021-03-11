def get_sum(a,b):
    if a == b:
        return a
    
    elif a < b:
        b+=1
        c = range(a, b)
        return sum(c)
    
    elif a > b:
        b-=1
        c = range(a, b, -1)
        return sum(c)