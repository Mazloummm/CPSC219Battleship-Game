x=rnorm(100)
hist(x,freq = F,xlim = c(-3,5),ylim=c(0,.6))
curve(dnorm(x),add=T,col="hot pink")
q=x^2
hist(q,freq=F,add=T,col="golden rod")
curve(dchisq(x,1),add=T,col="blue")

hist(q,freq=F,col="golden rod")
curve(dchisq(x,1),add=T,col="blue")
#################################


qchisq(.95,21)
  pchisq(32.6705733409,21)
  #library(mosaic)
  qdist(dist = "chisq",df=21,p = .95)
  pdist(dist = "chisq",df=21,q = 32.6705733409)
  
  
qchisq(.95,50)
  pchisq(67.5048065495,50)
  #library(mosaic)
  qdist(dist = "chisq",df=50,p = .95)
  pdist(dist = "chisq",df=50,q = 67.5048065495)
  
qchisq(.05,21)
  pchisq(11.5913052088,21)
  #library(mosaic)
  qdist(dist = "chisq",df=21,p = .05)
  pdist(dist = "chisq",df=21,q = 11.5913052088)
  
qchisq(.05,50)
  pchisq(34.7642516835,50)
  #library(mosaic)
  qdist(dist = "chisq",df=50,p = .05)
  pdist(dist = "chisq",df=50,q = 34.7642516835)

  
qchisq(c(.025,1-.025),21)
  pchisq(c(10.2828977825,35.4788759057),21)
  #library(mosaic)
  qdist(dist = "chisq",df=21,p = c(.025,1-.025))
  pdist(dist = "chisq",df=21,q = c(10.2828977825,35.4788759057))
  
qchisq(c(.025,1-.025),50)
  pchisq(c(32.3573636957 ,71.4201951875),50)
  #library(mosaic)
  qdist(dist = "chisq",df=50,p = c(.025,1-.025))
  pdist(dist = "chisq",df=50,q = c(32.3573636957 ,71.4201951875))
  
  
###############
  
ts=(11*2.3^2)/(5)

  pchisq(ts,11)  
  1-pchisq(ts,11)
  
  2*(1-pchisq(ts,11))
#######################
  
  ts=(17*4175)/(3600)
  
  1-pchisq(ts,17)
  
#######################
  
  ts=(14*450)/(250)
  
  pchisq(ts,14)
  
  
#########################
  
#data <- read.csv("~/Desktop/3.1 dataset.csv")
#install.packages("EnvStats")
#library(EnvStats)
 
mean(data$calories)
sd(data$calories)  
var(data$calories)

ts=17*64.6163388148^2/60^2
pchisq(ts,17)  
1-pchisq(ts,17)

2*(min(1-pchisq(ts,17),pchisq(ts,17)))


varTest(x = data$calories,alternative = "two.sided",sigma.squared = 60^2)


#############
  
qchisq(c(.01,.99),12)

#############
qchisq(c(.025,.975),19)

c(19*1.6^2/32.85232686173,19*1.6^2/8.90651648199)
c(19*1.6^2/32.85232686173,19*1.6^2/8.90651648199)^.5

#install.packages("asbio")
#library(asbio)
ci=ci.sigma(summarized = T,S.sq = 1.6^2,n = 20,conf = .95)
ci
ci$ci
ci$ci^.5
####################################

ci=ci.sigma(summarized = T,S.sq = 1.6^2,n = 20,conf = .90)
ci
ci$ci
ci$ci^.5

################################

#data <- read.csv("~/Desktop/3.1 dataset.csv")
#install.packages("EnvStats")
#library(EnvStats)
#install.packages("asbio")
#library(asbio)

data$ski
#sd(data$ski)
sd(data$ski,na.rm = T)
mean(data$ski,na.rm = T)

varTest(x = data$ski,alternative = "two.sided",conf.level = .9)

store=varTest(x = data$ski,alternative = "two.sided",conf.level = .9)
store$conf.int^.5

mean(data$ski,na.rm = T)-store$conf.int^.5
mean(data$ski,na.rm = T)+store$conf.int^.5

