options(digits=9)

qnorm(0.95,mean = 60,sd = 20/(100)^.5)

1-pnorm(63.289707,61,20/(100)^.5)
1-pnorm(63.289707,63,20/(100)^.5)
1-pnorm(63.289707,65,20/(100)^.5)

curve(1-pnorm(63.289707,x,20/(100)^.5),from = 59,to = 70)

#############################

qnorm(.05,mean = .6,sd = (.6*.4/100)^.5)

pnorm(0.51941896,.58,(.58*(1-.58)/100)^.5)

power1=function(x){pnorm(0.51941896,x,(x*(1-x)/100)^.5)}
power1(.54)
pnorm(0.51941896,.54,(.54*(1-.54)/100)^.5)
power1(.5)
curve(power1(x),from = 0,to = 1)

####################

qnorm(.05,mean = .6,sd = (.6*.4/200)^.5)

power2=function(x){pnorm(qnorm(.05,mean = .6,sd = (.6*.4/200)^.5),x,(x*(1-x)/200)^.5)}

power1(c(.58,.54,.5))

power2(c(.58,.54,.5))

power3=function(x){pnorm(qnorm(.025,mean = .6,sd = (.6*.4/100)^.5),x,(x*(1-x)/100)^.5)}
power3(c(.58,.54,.5))

curve(power1(x),from = 0,to = 1,col="blue")
curve(power2(x),from = 0,to = 1,col="hot pink",add=T)
curve(power3(x),from = 0,to = 1,col="green",add=T)

###########

cv1=qnorm(.025,mean = .6,sd = (.6*.4/200)^.5)

cv2=qnorm(1-.025,mean = .6,sd = (.6*.4/200)^.5)

beta4=function(x){pnorm(cv2,x,(x*(1-x)/100)^.5)-pnorm(cv1,x,(x*(1-x)/100)^.5)}

beta4(c(.58,.54,.5))
1-beta4(c(.58,.54,.5))

curve(1-beta4(x),from = 0,to = 1)

##########
qnorm(.05)
qnorm(.95)
