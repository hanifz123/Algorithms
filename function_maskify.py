# return masked string
def maskify(cc):
    ccs = [*cc]
    for i in range(0, len(ccs)-4):
        ccs[i] = "#"
    return ''.join(ccs)
    pass