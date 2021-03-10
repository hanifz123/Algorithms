def likes(names):
    if len(names) == 0:
        return('no one likes this')
    
    elif len(names) == 1:
        names.append('likes this')
        return ' '.join(names)
    
    elif 1 < len(names) <= 2:
        s1 = names[0]
        s2 = names[1]
        s3 = s1,'and', s2,'like this'
        return ' '.join(s3)
    
    elif len(names) == 3:
        s1 = names[0]+","
        s2 = names[1]
        s3 = names[2]
        s4 = s1, s2, 'and', s3, 'like this'
        
        return ' '.join(s4)
    
    elif len(names) > 3:
        s1 = names[0]+","
        s2 = names[1]
        s3 = len(names)-2
        s3 = str(s3)
        s4 =  s1, s2, 'and', s3, 'others like this'
        
        return ' '.join(s4)
    pass
